package com.example.newskmp.data.repository.impl

import com.example.newskmp.data.model.Article
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.data.service.ArticleService

class ArticleRepositoryImpl(private val articleService: ArticleService): ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return articleService.getArticles().articles
    }
}