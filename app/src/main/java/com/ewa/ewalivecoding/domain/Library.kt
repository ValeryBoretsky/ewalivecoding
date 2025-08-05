package com.ewa.ewalivecoding.domain

import com.ewa.api.Book
import com.ewa.ewalivecoding.data.BookRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Library @Inject constructor(
    val repository: BookRepository
) {
    private var cache: List<Book> = emptyList()

    suspend fun getBooks(): List<Book> {
        if (cache.isEmpty()) {
            cache = repository.getBooks()
        }
        return cache
    }

    fun librarySize() = cache.size
}