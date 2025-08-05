package com.ewa.analytics.mock

import android.content.Context
import java.util.Date

internal class AnalyticsMockService {
    private var pack: String? = null

    fun init(context: Context) {
        this.pack = context.packageName
    }

    fun sendEvent(event: String, callback: (time: Date) -> Unit) {
        Thread.sleep(2000L)
        event
        pack!!
        callback.invoke(Date())
    }
}