package com.example.newskmp.presentatation.store

import com.example.newskmp.data.model.Article

sealed class FavoriteScreenState {
    data object Init: FavoriteScreenState()
    data class Success(val articles: List<Article>): FavoriteScreenState()
}