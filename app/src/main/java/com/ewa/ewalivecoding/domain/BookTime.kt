package com.ewa.ewalivecoding.domain

import com.ewa.api.Book

data class BookTime(
    val book: Book,
    var openTime: Long = -1L //local time in ms
)
