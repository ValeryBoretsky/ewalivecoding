package com.ewa.ewalivecoding

import android.app.Application
import com.ewa.analytics.Event
import com.ewa.analytics.Tracker
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BooksLiveCoding : Application() {
    override fun onCreate() {
        super.onCreate()
        Tracker.initTracker(this)
        Tracker.trackEvent(Event.StartApp)
    }

}