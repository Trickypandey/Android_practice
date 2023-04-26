package com.sst.practiceapp

import android.Manifest
import android.R
import android.app.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.databinding.ActivityPushBinding
import java.util.*


class PushActivity : AppCompatActivity() {


    var per_post_noti= false
    var permission = Manifest.permission.POST_NOTIFICATIONS
    private lateinit var binding: ActivityPushBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,com.sst.practiseapp.R.layout.activity_push)
//        binding = DataBindingUtil.setContentView(this,R.layout.activity_push)
        binding.actionBarBack.setOnClickListener {
            finish()
        }
        binding.pushNotification.setOnClickListener {
            pushNotification()
        }
    }

    fun pushNotification( ){
         var i=Random().nextInt(10000)
        val str = "Hello my name is Sourabh Pandey $i"
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O && Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU){

            val channel = NotificationChannel(
                "channel_id",
                "Main",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description="Test Channel for Notification"
            val notificationmanager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val intent = Intent(this,NotificationViewActivity::class.java)
            intent.putExtra("body",str)
            intent.putExtra("noti_id",i)
            notificationmanager.createNotificationChannel(channel)
            val pendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
                // Add the intent, which inflates the back stack
                addNextIntentWithParentStack(intent)
                // Get the PendingIntent containing the entire back stack
                getPendingIntent(0,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            }
            val  notification = NotificationCompat.Builder(applicationContext,"channel_id")
                .setColor(resources.getColor(R.color.holo_green_dark))
                .setContentText(str)
                .setAutoCancel(true)
                .setContentTitle("Sourabh")
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_secure)
                .build()
            /*val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )*/

            notificationmanager.notify(i,notification)
            i++
        }else if(Build.VERSION.SDK_INT==Build.VERSION_CODES.TIRAMISU){
            if (!per_post_noti ){
                requestPermission()
            }
            else{
                val channel = NotificationChannel(
                    "channel_id",
                    "Main",
                    NotificationManager.IMPORTANCE_HIGH
                )
                channel.description="Test Channel for Notification"
                val notificationmanager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                val intent = Intent(this,NotificationViewActivity::class.java)
                intent.putExtra("body",str)
                intent.putExtra("noti_id",i)
                notificationmanager.createNotificationChannel(channel)
                val pendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
                    // Add the intent, which inflates the back stack
                    addNextIntentWithParentStack(intent)
                    // Get the PendingIntent containing the entire back stack
                    getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
                }
                /*val pendingIntent = PendingIntent.getActivity(
                    this,
                    0,
                    intent,
                    PendingIntent.FLAG_IMMUTABLE
                )*/
                val  notification = NotificationCompat.Builder(applicationContext,"channel_id")
                    .setColor(resources.getColor(R.color.holo_green_dark))
                    .setContentText(str)
                    .setAutoCancel(true)
                    .setContentTitle("Sourabh")
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_secure)
                    .build()

                notificationmanager.notify(i,notification)
            }
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            Log.e("are notification enabled", "${notificationManager.areNotificationsEnabled()}")
            Log.e("are notification enabled", "${Manifest.permission.POST_NOTIFICATIONS}")
//            val requestPermissionLauncher = registerForActivityResult(
//                ActivityResultContracts.RequestPermission()
//            ) { isGranted: Boolean ->
//                if (isGranted) {
//
//
//                } else {
//
//                }
//            }
        }else{

        }
//            } else {
//                val pendingIntent = PendingIntent.getActivity(
//                    this,
//                    0,
//                    Intent(this,NotificationViewActivity::class.java).apply {
//                        this.putExtra("body","hellow i am notification")
//                    },
//                    PendingIntent.FLAG_IMMUTABLE
//                )
//                val  notification = NotificationCompat.Builder(applicationContext,"channel_id")
//                    .setColor(resources.getColor(R.color.holo_green_dark))
//                    .setContentText("hellow i am notification")
//                    .setContentTitle("Hello World"+Random().nextInt(10000))
//                    .setContentIntent(pendingIntent)
//                    .setSmallIcon(R.drawable.ic_secure)
//                    .build()
//                notification-manager.notify(1,notification)
//            }
    }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(this,permission)== PackageManager.PERMISSION_GRANTED){
            per_post_noti=true
        }
        else{
            activityResultLauncher.launch(permission)
        }
    }
    private val activityResultLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()){isGranted ->
            // Handle Permission granted/rejected
            if (isGranted) {
                // Permission is granted
            } else {
                // Permission is denied
                pushNotification()
            }
        }

}