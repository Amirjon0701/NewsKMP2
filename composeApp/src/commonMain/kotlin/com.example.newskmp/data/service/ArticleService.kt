package com.example.newskmp.data.service

import com.example.newskmp.data.model.MetaData

interface ArticleService {
    suspend fun getArticles(): MetaData
}