package com.example.newskmp.data.repository

import com.example.newskmp.data.model.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}