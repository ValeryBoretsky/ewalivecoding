package com.ewa.ewalivecoding.presentation.list

import android.os.Bundle
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ewa.ewalivecoding.MainActivity
import com.ewa.ewalivecoding.domain.BookTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    val viewModel: ListViewModel by viewModels()

    private val callback: (BookTime) -> Unit = {
        viewModel.updateBookTime(it)
        (activity as? MainActivity)?.openReader(it.book)
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        return androidx.compose.ui.platform.ComposeView(requireContext()).apply {
            setContent {
                val books by viewModel.bookList.collectAsState(initial = emptyList())

                ListScreen(
                    books = books,
                    onBookClick = callback,
                )
            }
        }
    }
}