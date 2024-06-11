package com.example.newskmp.data.mapper

import com.example.newskmp.data.model.Article
import com.example.newskmp.data.model.Source

class ArticleMapper {
    fun fromArticleDB(articleDb: com.example.newskmp.db.Article): Article{
        return Article(
            Source(articleDb.source_id, articleDb.source_name),
            articleDb.author,
            articleDb.title,
            articleDb.description,
            articleDb.url,
            articleDb.url_to_image,
            articleDb.published_at,
            articleDb.content
        )
    }

    fun toArticleDB(article: Article): com.example.newskmp.db.Article{
        return com.example.newskmp.db.Article(
            article.author,
            article.title,
            article.description,
            article.url,
            article.urlToImage,
            article.content,
            article.publishedAt,
            article.source.id,
            article.source.name
        )
    }
}