package com.example.newskmp.presentatation.vm

import com.adeo.kviewmodel.BaseSharedViewModel
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.presentatation.store.ArticlesScreenState
import com.example.newskmp.presentatation.store.FavoriteScreenAction
import com.example.newskmp.presentatation.store.FavoriteScreenEvent
import com.example.newskmp.presentatation.store.FavoriteScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val articleRepository: ArticleRepository): BaseSharedViewModel<FavoriteScreenState, FavoriteScreenAction, FavoriteScreenEvent>(FavoriteScreenState.Init) {
    private val _state = MutableStateFlow<FavoriteScreenState>(FavoriteScreenState.Init)
    val state: StateFlow<FavoriteScreenState> = _state

    init {
        obtainEvent(FavoriteScreenEvent.GetFavoriteArticles)
    }

    override fun obtainEvent(viewEvent: FavoriteScreenEvent) {
        when(viewEvent){
            FavoriteScreenEvent.GetFavoriteArticles -> {
                getFavoritesArticles()
            }
        }
    }

    private fun getFavoritesArticles() = viewModelScope.launch(Dispatchers.IO){
        val articles = articleRepository.getArticlesFromFavorite()
        _state.emit(FavoriteScreenState.Success(articles))
    }
}