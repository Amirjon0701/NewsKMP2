package com.example.newskmp.presentatation.store

import com.example.newskmp.data.model.Article

sealed class ArticlesScreenState {
    data object Initial: ArticlesScreenState()
    class Success(val articles: List<Article>): ArticlesScreenState()
}