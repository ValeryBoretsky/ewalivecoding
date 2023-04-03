package com.ewa.ewalivecoding.domain

data class Book(
    val id: String,
    val text: String,
    val image: Int,
    var read: Boolean
)