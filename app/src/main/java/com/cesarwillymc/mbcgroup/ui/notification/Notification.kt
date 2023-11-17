package com.cesarwillymc.mbcgroup.ui.notification

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.cesarwillymc.mbcgroup.R

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

private const val CHANNEL_ID = "MGTest_id"
private const val CHANNEL_NAME = "MGAPPtest Channel"
private const val NOTIFY_ID = 1
fun Context.createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_HIGH
        )
        channel.lightColor = Color.BLACK
        channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

fun Context.showNotification() {
    val builder = NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.baseline_notifications_24)
        .setContentTitle(getString(R.string.lbl_check_email))
        .setContentText(getString(R.string.desc_check_email))
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setCategory(NotificationCompat.CATEGORY_CALL)
        .setColor(Color.BLACK)
        .setAutoCancel(true)

    val notificationManager = NotificationManagerCompat.from(this)
    if (ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        return
    }
    notificationManager.notify(NOTIFY_ID, builder.build())
}
