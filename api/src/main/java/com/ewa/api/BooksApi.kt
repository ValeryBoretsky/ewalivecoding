package com.ewa.api

import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {
    @GET("books")
    suspend fun getBooks(
        @Query("key") key: String,
        @Query("language") language: String
    ): List<Book>
}
