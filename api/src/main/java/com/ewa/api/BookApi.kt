package com.ewa.api

interface BookApi {
    fun loadBooksApi(key: String, language: String): List<Book>
}