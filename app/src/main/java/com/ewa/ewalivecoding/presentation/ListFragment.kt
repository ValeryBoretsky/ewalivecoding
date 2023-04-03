package com.ewa.ewalivecoding.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.ewa.ewalivecoding.R

class ListFragment : Fragment(R.layout.listfragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view
            .findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener { requireActivity().onBackPressed() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireView()
            .findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener(null)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}