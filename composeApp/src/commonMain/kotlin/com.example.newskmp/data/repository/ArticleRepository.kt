package com.example.newskmp.data.repository

import com.example.newskmp.data.model.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>

    suspend fun insertArticleToFavorite(article: Article)

    suspend fun getArticlesFromFavorite(): List<Article>
}