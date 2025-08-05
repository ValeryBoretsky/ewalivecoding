package com.ewa.ewalivecoding.data

import com.ewa.api.Book

interface BookRepository {
    suspend fun getBooks(): List<Book>
}