package com.ewa.api

interface BookApi {
    suspend fun loadBooksApi(key: String, language: String): List<Book>
}