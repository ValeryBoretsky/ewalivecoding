package com.ewa.ewalivecoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.ewa.ewalivecoding.presentation.ListFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var containerId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WindowCompat.setDecorFitsSystemWindows(window, false)
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
}