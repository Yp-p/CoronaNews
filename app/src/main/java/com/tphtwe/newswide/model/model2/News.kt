package com.tphtwe.newswide.model.model2

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)