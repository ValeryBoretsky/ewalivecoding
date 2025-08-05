package com.ewa.ewalivecoding.presentation.reader

import androidx.lifecycle.ViewModel
import com.ewa.analytics.Event
import com.ewa.analytics.Tracker
import com.ewa.api.Book
import com.ewa.ewalivecoding.presentation.reader.domain.ReaderState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ReaderViewModel(
    val tracker: Tracker,
    val book: Book
) : ViewModel() {

    private val _state = MutableStateFlow<ReaderState>(
        ReaderState(book, null)
    )
    val state: StateFlow<ReaderState> = _state

    init {
        tracker.trackEvent(Event.OpenBook(bookId = book.id))
        splitBook(book)
    }


    private fun splitBook(book: Book) {
        val paragraphs = book.text.split("\n")
        _state.value = ReaderState(book, paragraphs)
    }

} 