package com.ewa.ewalivecoding.data

import android.content.Context
import android.util.Log
import com.ewa.api.Book
import com.ewa.api.BooksApi
import com.ewa.ewalivecoding.R

class BookRepositoryImpl(
    val booksApi: BooksApi,
    val context: Context,
) : BookRepository {

    override suspend fun getBooks(): List<Book> {
        return booksApi
            .getBooks(
                key = context.getString(R.string.api_secret_key),
                language = "EN"
            ).also { books ->
                Log.d(
                    "BookLiveCoding",
                    "Books loaded. Books[${books.size}]: ${books.map { it.id }}"
                )
                books
            }
    }

//    fun markFavorite(bookId: String) {
//        return bookApi.markFavorite(
//            context.getString(R.string.api_secret_key),
//            bookId
//        )
//    }

}