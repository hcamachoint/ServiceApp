package com.webkingve.serviceapp

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    var handler: Handler = Handler()
    private val runnableCode: Runnable = object : Runnable {
        override fun run() {
            Log.d("Handlers", "Called on main thread")
            handler.postDelayed(this, 2000)
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("Handlers", "Starting service on start command")
        handler.post(runnableCode);
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        isServiceStarted = false
        handler.removeCallbacks(runnableCode);
        Log.i("Handlers", "Ending service")
    }

    companion object {
        var isServiceStarted = false
    }
}