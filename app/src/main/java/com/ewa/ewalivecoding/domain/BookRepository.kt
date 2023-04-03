package com.ewa.ewalivecoding.domain

import com.ewa.api.Book

interface BookRepository {
    fun getBooks(): List<Book>
}