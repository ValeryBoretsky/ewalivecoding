package com.ewa.analytics

sealed class Event {
    abstract val name: String

    object StartApp: Event() {
        override val name: String = "start_app"
    }

    object OpenLibrary: Event() {
        override val name: String = "open_library"
    }

    class OpenBook(val bookId: String): Event() {
        override val name: String = "open_book"
    }
}