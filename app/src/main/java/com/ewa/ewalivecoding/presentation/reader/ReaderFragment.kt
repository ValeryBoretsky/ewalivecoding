package com.ewa.ewalivecoding.presentation.reader

import android.os.Bundle
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.ewa.api.Book
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ReaderFragment(val book: Book) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ReaderViewModelFactory
    
    private val viewModel: ReaderViewModel by lazy { viewModelFactory.create(book) }

    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View {
        return ComposeView(requireContext()).apply {
            setContent {
                val reader by viewModel.state.collectAsState()
                ReaderScreen(
                    reader = reader,
                    onBackPressed = { requireActivity().onBackPressed() }
                )
            }
        }
    }

}