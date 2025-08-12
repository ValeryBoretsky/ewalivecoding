package com.ewa.api

import android.content.Context
import com.ewa.api.mock.RetrofitClient

object BooksApiBuilder {

    fun build(context: Context): BooksApi {
        val retrofit = RetrofitClient(context)
        return retrofit.createBooksService()
    }

}