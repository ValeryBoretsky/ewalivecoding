package com.ewa.ewalivecoding.presentation.reader.domain

import com.ewa.api.Book

data class ReaderState(
    val book: Book,
    val paragraphs: List<String>?,
)