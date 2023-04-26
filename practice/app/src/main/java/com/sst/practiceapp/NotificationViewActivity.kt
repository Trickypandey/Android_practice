package com.sst.practiceapp

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityNotificationViewBinding


class NotificationViewActivity : AppCompatActivity() {
    lateinit var binding : ActivityNotificationViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notification_view)
//       dumpIntent(intent)
//        Log.e("DATA", bundle.toString())
        val intent=intent.extras

            val extraBody = intent?.getString("body")

            val notiId = intent?.getInt("noti_id")
            Log.e("LOG_TAG", "$extraBody")
            Log.e("LOG_TAG", "$notiId")

        if (notiId != null) {
            removeNotification(this,notiId)
        }
        binding.textView.text=extraBody

    }
    fun removeNotification(context: Context, notificationId: Int) {
        val nMgr = context.getApplicationContext()
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        nMgr.cancel(notificationId)
    }
    fun dumpIntent(i: Intent) {
        val bundle = i.extras
        if (bundle != null) {
            val keys = bundle.keySet()
            val it: Iterator<String> = keys.iterator()
            Log.e("LOG_TAG", "Dumping Intent start")
            while (it.hasNext()) {
                val key = it.next()
                Log.e("LOG_TAG", "[" + key + "=" + bundle[key] + "]")
            }
            Log.e("LOG_TAG", "Dumping Intent end")
        }
    }

}