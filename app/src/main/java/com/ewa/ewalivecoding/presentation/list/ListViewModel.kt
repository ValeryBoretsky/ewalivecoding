package com.ewa.ewalivecoding.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewa.analytics.Event
import com.ewa.analytics.Tracker
import com.ewa.ewalivecoding.domain.BookTime
import com.ewa.ewalivecoding.domain.Library
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    val library: Library,
    val tracker: Tracker
) : ViewModel() {

    private val _bookList = MutableStateFlow<List<BookTime>>(emptyList())
    val bookList: StateFlow<List<BookTime>> = _bookList

    init {
        tracker.trackEvent(Event.OpenLibrary)
        loadBooks()
    }

    // загрузка книг из репозитория
    private fun loadBooks() {
        viewModelScope.launch {
            val books = library
                .getBooks().map {
                    it.copy(
                        title = it.title.trim().replaceFirstChar { it.uppercase() },
                    )
                }
            _bookList.value = books.map { BookTime(it) }
        }
    }

    fun updateBookTime(bookTime: BookTime) {
        _bookList.value = _bookList
            .value
            .map {
                if (it.book.id == bookTime.book.id) {
                    bookTime.openTime = System.currentTimeMillis()
                    bookTime
                } else {
                    it
                }
            }
    }
}