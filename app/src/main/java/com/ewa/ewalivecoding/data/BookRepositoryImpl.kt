package com.ewa.ewalivecoding.data

import android.content.Context
import android.util.Log
import com.ewa.api.Book
import com.ewa.api.BookApi
import com.ewa.ewalivecoding.R
import com.ewa.ewalivecoding.domain.BookRepository

class BookRepositoryImpl(
    private val bookApi: BookApi,
    private val context: Context,
) : BookRepository {

    companion object {
        const val BOOK_LANGUAGE = "EN"
    }

    override fun getBooks(): List<Book> {
        return bookApi
            .loadBooksApi(
                context.getString(R.string.api_secret_key),
                BOOK_LANGUAGE
            ).let { books ->
                Log.d(
                    "BookLiveCoding",
                    "Books loaded. Size: ${books.size}, Books: ${books.map { it.id }}"
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