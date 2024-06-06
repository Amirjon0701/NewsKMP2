package com.example.newskmp.presentatation.store

sealed class ArticlesScreenEvent {
    data object GetArticles: ArticlesScreenEvent()
}