package com.example.newskmp.db

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = ArticleDB(databaseDriverFactory.createDriver())
    private val dbQuery = database.articleDBQueries

    internal fun getArticles(): List<Article>{
        return dbQuery.getArticles().executeAsList()
    }


    internal fun insertArticle(article: Article){
        dbQuery.insertArtcile(
            article.author,
            article.title,
            article.description,
            article.url,
            article.url_to_image,
            article.content,
            article.published_at,
            article.source_id,
            article.source_name
        )
    }
}