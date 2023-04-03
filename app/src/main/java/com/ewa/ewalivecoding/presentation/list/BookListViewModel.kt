package com.ewa.ewalivecoding.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewa.ewalivecoding.domain.BookRepository
import com.ewa.ewalivecoding.domain.BookTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    var repository : BookRepository
) : ViewModel() {

    private val _bookList = MutableLiveData<List<BookTime>>()
    val bookList: LiveData<List<BookTime>> = _bookList

    init {
        loadBooks()
    }

    //загрузка книг из репозитория
    private fun loadBooks() {
        viewModelScope.launch {
            var i = 1
            val books = repository
                .getBooks().map {
                    val newI = i++
                    it.copy(title = "$newI. ${it.title}", author = it.author?.let { "${newI}. $it" })
                }
            _bookList.value = books.map { BookTime(it) }
        }
    }

    fun updateBookTime(bookTime: BookTime) {
        _bookList.value = _bookList
            .value
            ?.map {
                if (it.book.id == bookTime.book.id) {
                    bookTime
                } else it
            }
    }
}