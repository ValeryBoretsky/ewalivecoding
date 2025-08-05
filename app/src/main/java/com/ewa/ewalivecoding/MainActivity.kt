package com.ewa.ewalivecoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.ewa.api.Book
import com.ewa.ewalivecoding.presentation.list.ListFragment
import com.ewa.ewalivecoding.presentation.reader.ReaderFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var containerId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
        containerId = findViewById<FragmentContainerView>(R.id.fragment_container).id
        openFirstListFragment()
    }

    private fun openFirstListFragment() {
        supportFragmentManager.commit {
            val fragment = ListFragment()
            setPrimaryNavigationFragment(fragment)
            replace(containerId, fragment, "main_fragment")
        }
    }

    fun openReader(book: Book) {
        supportFragmentManager.commit {
            val fragment = ReaderFragment(book)
            addToBackStack("reader_fragment")
            add(containerId, fragment, "reader_fragment")
        }
    }
}