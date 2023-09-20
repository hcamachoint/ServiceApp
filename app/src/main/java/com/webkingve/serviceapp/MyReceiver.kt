package com.webkingve.serviceapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // BOOT_COMPLETED” start Service
        if (intent.action == ACTION) {
            Log.i("Handlers", "Starting receiver from boot")
            val serviceIntent = Intent(context, MyService::class.java)
            context.startService(serviceIntent)
        }
    }

    companion object {
        const val ACTION = "android.intent.action.BOOT_COMPLETED"
    }
}