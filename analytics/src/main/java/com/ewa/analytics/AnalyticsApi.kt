package com.ewa.analytics

internal object AnalyticsApi {
    fun sendEventsToCloud(events: List<String>, callback: (success: Boolean) -> Unit) {
        //send events to cloud
        Thread.sleep(2000L)
        events
        callback.invoke(true)
    }
}