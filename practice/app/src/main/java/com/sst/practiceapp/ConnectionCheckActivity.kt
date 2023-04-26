package com.sst.practiceapp

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityConnectionCheckBinding


class ConnectionCheckActivity : AppCompatActivity() {
    lateinit var binding: ActivityConnectionCheckBinding
    lateinit var broadcastReceiver: BroadcastReceiver
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_connection_check)
        broadcastReceiver = NetworkChangeReciever()
        IntentFilter(Context.CONNECTIVITY_SERVICE).also {

            // registering the receiver
            // it parameter which is passed in  registerReceiver() function
            // is the intent filter that we have just created
            registerNetworkBroadCast()
        }
    }
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!
            .isConnected
    }
    fun registerNetworkBroadCast(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }
    fun unRegisterNetworkBroadCast(){
        try {
            unregisterReceiver(broadcastReceiver)
        }
        catch (e :Exception)
        {

        }
    }
    override fun onDestroy(){
        super.onDestroy()
        unRegisterNetworkBroadCast()

    }
}