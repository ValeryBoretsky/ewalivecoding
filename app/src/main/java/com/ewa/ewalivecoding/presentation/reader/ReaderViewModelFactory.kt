package com.ewa.ewalivecoding.presentation.reader

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ewa.analytics.Tracker
import com.ewa.api.Book
import javax.inject.Inject

class ReaderViewModelFactory @Inject constructor(
    private val tracker: Tracker,
) : ViewModelProvider.Factory {

    fun create(book: Book): ReaderViewModel {
        return ReaderViewModel(tracker, book)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        throw UnsupportedOperationException("Use create(book: Book) instead")
    }
}
