package com.example.taskapp

import android.app.Application
import android.content.Context

class AppApplication: Application() {
    companion object {
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}