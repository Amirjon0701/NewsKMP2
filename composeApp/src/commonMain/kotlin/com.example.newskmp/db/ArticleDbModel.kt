package com.example.newskmp.db

import com.example.newskmp.data.model.Source
import kotlinx.serialization.SerialName

data class ArticleDbModel(
    val author: String? = null,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String? = null,
    val publishedAt: String,
    val content: String,
    val sourceId: String? = null,
    val name: String
)