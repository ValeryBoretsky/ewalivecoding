package com.ewa.api

data class Book(
    val id: String,
    val title: String,
    val author: String?,
    val image: Int,
    val text: String
)