package com.sst.practiceapp

import android.content.BroadcastReceiver
import android.net.ConnectivityManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class NetworkChangeReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
//
        if (isOnline(context)) {
            Toast.makeText(context, "Connected", Toast.LENGTH_LONG).show()
        } else {
            val eintent = Intent(context, NointernetActivity::class.java)
            startActivity(context,eintent,null)
            Toast.makeText(context, "Not Connected", Toast.LENGTH_LONG).show()
        }
    }
    private fun isOnline(context: Context): Boolean {
        try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo =cm.activeNetworkInfo
            return (((networkInfo != null) && networkInfo.isConnected))
        }
        catch (e :java.lang.Exception){
            return false
        }
    }

}