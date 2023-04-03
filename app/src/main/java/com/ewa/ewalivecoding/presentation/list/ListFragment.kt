package com.ewa.ewalivecoding.presentation.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ewa.analytics.Event
import com.ewa.analytics.Tracker
import com.ewa.ewalivecoding.MainActivity
import com.ewa.ewalivecoding.R
import com.ewa.ewalivecoding.domain.BookTime
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.listfragment) {

    val viewModel: BookListViewModel by viewModels()

    private val callback: (BookTime) -> Unit = {
        it.openTime = System.currentTimeMillis()
        viewModel.updateBookTime(it)
        (activity as? MainActivity)?.openReader(it.book)
    }

    private val adapter = ListAdapter(callback) //adapter for recycler view

    override fun onCreate(savedInstanceState: Bundle?) {
        Tracker.trackEvent(Event.OpenLibrary)
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view
            .findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener { requireActivity().onBackPressed() }

        initRecyclerView()

        viewModel.bookList.observe(viewLifecycleOwner) {
            adapter.setBooks(it)
            adapter.notifyDataSetChanged()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        requireView()
            .findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener(null)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //init recycler view for show books
    fun initRecyclerView() {
        val recycler = view?.findViewById<RecyclerView>(R.id.recycler)
        recycler?.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = this@ListFragment.adapter
            setHasFixedSize(false)
        }
    }

}