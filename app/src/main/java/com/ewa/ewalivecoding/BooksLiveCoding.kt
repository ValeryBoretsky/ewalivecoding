package com.ewa.ewalivecoding

import android.app.Application
import com.ewa.analytics.Event
import com.ewa.analytics.Tracker
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BooksLiveCoding : Application() {
    
    @Inject
    lateinit var tracker: Tracker
    
    override fun onCreate() {
        super.onCreate()
        tracker.initTracker(this)
        tracker.trackEvent(Event.StartApp)
    }

}