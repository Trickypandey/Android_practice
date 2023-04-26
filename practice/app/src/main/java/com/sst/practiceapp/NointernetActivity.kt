package com.sst.practiceapp

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityNointernetBinding

class NointernetActivity : AppCompatActivity() {
    lateinit var binding: ActivityNointernetBinding
    lateinit var broadcastReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nointernet)
        binding.retry.setOnClickListener {
            broadcastReceiver = NetworkChangeReciever()
            IntentFilter(CONNECTIVITY_SERVICE).also {

                // registering the receiver
                // it parameter which is passed in  registerReceiver() function
                // is the intent filter that we have just created
                registerNetworkBroadCast()
            }
        }
    }
    fun registerNetworkBroadCast(){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
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