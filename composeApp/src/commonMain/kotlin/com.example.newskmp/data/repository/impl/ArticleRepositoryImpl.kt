package com.example.newskmp.data.repository.impl

import com.example.newskmp.data.mapper.ArticleMapper
import com.example.newskmp.data.model.Article
import com.example.newskmp.data.repository.ArticleRepository
import com.example.newskmp.data.service.ArticleService
import com.example.newskmp.db.Database

class ArticleRepositoryImpl(private val articleService: ArticleService,
    private val localDatabase: Database,
    private val articleMapper: ArticleMapper): ArticleRepository {
        private var remoteCashedArticles = emptyList<Article>()
    override suspend fun getArticles(): List<Article> {
        if(remoteCashedArticles.isEmpty()){
            remoteCashedArticles = articleService.getArticles().articles
        }
        return remoteCashedArticles
    }

    override suspend fun insertArticleToFavorite(article: Article) {
        localDatabase.insertArticle(articleMapper.toArticleDB(article))
    }

    override suspend fun getArticlesFromFavorite(): List<Article> {
        return localDatabase.getArticles().map(articleMapper::fromArticleDB)
    }

    override suspend fun searchRemoteArticles(searchText: String): List<Article> {
        return remoteCashedArticles.filter {
            (it.title.contains(searchText, ignoreCase = true)
                    && it.description.contains(searchText, ignoreCase = true)
                    && it.content.contains(searchText, ignoreCase = true))
        }.toList()
    }
}