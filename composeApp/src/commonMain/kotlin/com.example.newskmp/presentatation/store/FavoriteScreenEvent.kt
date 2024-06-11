package com.example.newskmp.presentatation.store

sealed class FavoriteScreenEvent {
    data object GetFavoriteArticles: FavoriteScreenEvent()
}