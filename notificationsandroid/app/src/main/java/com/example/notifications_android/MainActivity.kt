package com.example.notifications_android

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    private var channelId = "com.example.notifications_android.channel1"
    var notificationManager: NotificationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelId, "Channel 1", "This is channel 1")
        findViewById<Button>(R.id.button).setOnClickListener {
            showNotification()
        }
    }

    fun showNotification(){
        val tapResultIntent = Intent(this, SecondActivity::class.java)
        val tapResultPendingIntent = PendingIntent.getActivity(this, 0, tapResultIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//        val remoteInput = RemoteInput.Builder("key_text_reply")
//            .setLabel("Reply")
//            .build()
//        val replyAction: NotificationCompat.Action = NotificationCompat.Action.Builder(0, "Reply", tapResultPendingIntent)
//            .addRemoteInput(remoteInput)
//            .build()
        val notification = Notification.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Notification")
            .setContentText("This is a notification")
            .setStyle(
                NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
//            .setContentIntent(tapResultPendingIntent)
            .setActions(
                Notification.Action(R.drawable.ic_launcher_foreground, "Action 1", tapResultPendingIntent),
                Notification.Action(R.drawable.ic_launcher_foreground, "Action 2", null)
            )
            .build()
        notificationManager?.notify(1, notification)
    }

    fun createNotificationChannel( channelId:String, channelName:String, channelDescription:String){
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            channel.description = channelDescription
            notificationManager?.createNotificationChannel(channel)
        }
    }


}