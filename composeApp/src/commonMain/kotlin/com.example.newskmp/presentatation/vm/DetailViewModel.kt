package com.example.newskmp.presentatation.vm

import com.adeo.kviewmodel.BaseSharedViewModel
import com.example.newskmp.data.model.Article
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.presentatation.store.DetailScreenAction
import com.example.newskmp.presentatation.store.DetailScreenEvent
import com.example.newskmp.presentatation.store.DetailScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.jetbrains.skia.skottie.Logger

class DetailViewModel(private val articleRepository: ArticleRepository): BaseSharedViewModel<DetailScreenState,DetailScreenAction, DetailScreenEvent>(DetailScreenState.Initial) {
    override fun obtainEvent(viewEvent: DetailScreenEvent) {
        when(viewEvent){
            is DetailScreenEvent.AddArticleToFavorite ->{
                addArticleToFavorite(viewEvent.article)
            }
        }
    }

    private fun addArticleToFavorite(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        articleRepository.insertArticleToFavorite(article)
    }

}