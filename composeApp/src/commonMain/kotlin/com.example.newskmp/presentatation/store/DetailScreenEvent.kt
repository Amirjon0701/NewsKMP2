package com.example.newskmp.presentatation.store

sealed class DetailScreenEvent {
    data class AddArticleToFavorite(val article: com.example.newskmp.data.model.Article): DetailScreenEvent()
}