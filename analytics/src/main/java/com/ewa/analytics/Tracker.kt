package com.ewa.analytics

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

object Tracker {

    private var pref: SharedPreferences? = null


    fun initTracker(context: Context) {
        pref = context.getSharedPreferences("TrackerPreferences", Context.MODE_PRIVATE)
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
        val key = System.currentTimeMillis().toString()
        pref?.edit(commit = true) { putString(key, message) }
        sendEvent()
    }

    private fun sendEvent() {
        if (pref != null && pref!!.all.size > 2) {
            val messages = pref!!.all.map { entry -> entry.key + "_" + entry.value }
            CoroutineScope(Dispatchers.IO).launch {
                AnalyticsApi.sendEventsToCloud(messages) {
                    Log.i("BookLiveCoding", "Send event to cloud: ${messages.joinToString(", ")}}")
                }
            }
            pref!!.edit(commit = false) { this.clear() }
        }
    }

}