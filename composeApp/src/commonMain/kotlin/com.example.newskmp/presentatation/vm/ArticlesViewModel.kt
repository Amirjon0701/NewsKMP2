package com.example.newskmp.presentatation.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.adeo.kviewmodel.BaseSharedViewModel
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.data.service.ArticleService
import com.example.newskmp.presentatation.store.ArticlesScreenAction
import com.example.newskmp.presentatation.store.ArticlesScreenEvent
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.ui.component.state.SearchWidgetState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(private val articleRepository: ArticleRepository): BaseSharedViewModel<ArticlesScreenState, ArticlesScreenAction, ArticlesScreenEvent>(ArticlesScreenState.Initial){
    private val _state = MutableStateFlow<ArticlesScreenState>(ArticlesScreenState.Initial)
    val state: StateFlow<ArticlesScreenState> = _state

    private val _searchAppBarState = mutableStateOf(SearchWidgetState.CLOSED)
    val searchAppBarState: State<SearchWidgetState> = _searchAppBarState

    private val _searchText = mutableStateOf("")
    val searchText: State<String> = _searchText
    init {
        obtainEvent(ArticlesScreenEvent.GetArticles)
    }

    override fun obtainEvent(viewEvent: ArticlesScreenEvent) {
        when(viewEvent){
            is ArticlesScreenEvent.GetArticles->{
                getArticles()
            }

            is ArticlesScreenEvent.UpdateAppBarState -> {
                updateAppBarState(viewEvent.searchWidgetState)
            }

            is ArticlesScreenEvent.SearchArticle -> {
                searchArticles(viewEvent.searchText)
            }

            is ArticlesScreenEvent.UpdateSearchText -> {
                updateSearchText(viewEvent.text)
            }
        }
    }

    private fun getArticles() = viewModelScope.launch(Dispatchers.IO) {
        val articles = articleRepository.getArticles()
        _state.emit(ArticlesScreenState.Success(articles))
    }

    private fun updateAppBarState(widgetState: SearchWidgetState){
        _searchAppBarState.value = widgetState
    }

    private fun updateSearchText(text: String){
        _searchText.value = text
    }

    private fun searchArticles(searchText: String) = viewModelScope.launch(Dispatchers.IO) {
        val articles = articleRepository.searchRemoteArticles(searchText)
        _state.emit(ArticlesScreenState.Success(articles))
    }
}