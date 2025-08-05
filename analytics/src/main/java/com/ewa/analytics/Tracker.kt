package com.ewa.analytics

import android.content.Context
import android.util.Log
import com.ewa.analytics.mock.AnalyticsMockService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Tracker {

    private val service = AnalyticsMockService()

    fun initTracker(context: Context) {
        service.init(context = context)
    }

    fun trackEvent(event: Event) {
        val message = when (event) {
            is Event.StartApp -> event.name

            is Event.OpenLibrary -> {
                event.name
            }

            is Event.OpenBook -> {
                "${event.name}_${event.bookId}"
            }
        }

        Log.i("BookLiveCoding", "Track event: $message")
        CoroutineScope(Dispatchers.Default).launch {
            service.sendEvent(event = message) { time ->
                Log.i("BookLiveCoding", "Event was sent: $message, time: $time")
            }
        }
    }
}