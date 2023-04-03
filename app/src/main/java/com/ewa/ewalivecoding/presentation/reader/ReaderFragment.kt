package com.ewa.ewalivecoding.presentation.reader

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewa.analytics.Event
import com.ewa.analytics.Tracker
import com.ewa.api.Book
import com.ewa.ewalivecoding.R
import kotlinx.coroutines.launch

class ReaderFragment(val book: Book) : Fragment(R.layout.reader) {

    override fun onCreate(savedInstanceState: Bundle?) {
        Tracker.trackEvent(Event.OpenBook(book.title))
        super.onCreate(savedInstanceState)
    }

    private val toolbar by lazy { view?.findViewById<Toolbar>(R.id.toolbar) }

    private val bookText by lazy { view?.findViewById<TextView>(R.id.book_text) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar?.setNavigationOnClickListener { requireActivity().onBackPressed() }

        toolbar?.title = book.title
        bookText?.text = book.text
        bookText?.movementMethod = ScrollingMovementMethod()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}