package com.example.newskmp.presentatation.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.adeo.kviewmodel.BaseSharedViewModel
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.store.FavoriteScreenAction
import com.example.newskmp.presentatation.store.FavoriteScreenEvent
import com.example.newskmp.presentatation.store.FavoriteScreenState
import com.example.newskmp.presentatation.ui.component.state.SearchWidgetState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val articleRepository: ArticleRepository): BaseSharedViewModel<FavoriteScreenState, FavoriteScreenAction, FavoriteScreenEvent>(FavoriteScreenState.Init) {
    private val _state = MutableStateFlow<FavoriteScreenState>(FavoriteScreenState.Init)
    val state: StateFlow<FavoriteScreenState> = _state

    private val _searchAppBarState = mutableStateOf(SearchWidgetState.CLOSED)
    val searchAppBarState: State<SearchWidgetState> = _searchAppBarState

    private val _searchText = mutableStateOf("")
    val searchText: State<String> = _searchText

    init {
        obtainEvent(FavoriteScreenEvent.GetFavoriteArticles)
    }

    override fun obtainEvent(viewEvent: FavoriteScreenEvent) {
        when(viewEvent){
            FavoriteScreenEvent.GetFavoriteArticles -> {
                getFavoritesArticles()
            }

            is FavoriteScreenEvent.SearchArticles -> {
                searchArticlesFromFavorite(viewEvent.searchText)
            }

            is FavoriteScreenEvent.UpdateAppBarState -> {
                updateAppBarState(viewEvent.searchWidgetState)
            }
            is FavoriteScreenEvent.UpdateSearchText -> {
                updateSearchText(viewEvent.text)
            }
        }
    }

    private fun getFavoritesArticles() = viewModelScope.launch(Dispatchers.IO){
        val articles = articleRepository.getArticlesFromFavorite()
        _state.emit(FavoriteScreenState.Success(articles))
    }

    private fun searchArticlesFromFavorite(text: String) = viewModelScope.launch(Dispatchers.IO) {
        val articles = articleRepository.searchArticlesFromFavorite(text)
        _state.emit(FavoriteScreenState.Success(articles))
    }

    private fun updateAppBarState(widgetState: SearchWidgetState){
        _searchAppBarState.value = widgetState
    }

    private fun updateSearchText(text: String){
        _searchText.value = text
    }
}