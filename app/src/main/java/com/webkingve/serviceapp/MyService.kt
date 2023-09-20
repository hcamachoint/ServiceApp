package com.webkingve.serviceapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        performLongTask()
        return START_STICKY // If the service is killed, it will be automatically restarted
    }

    private fun performLongTask() {
        // Imagine doing something that takes a long time here
        Log.i("TEST", "BackgroundTaskService is performing a task! Don't disturb, please!")
        Thread.sleep(5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        isServiceStarted = false
        Log.i("TEST", "BackgroundTaskService says goodbye!")
    }

    companion object {
        var isServiceStarted = false
    }
}