package ercanduman.fcmmessagingdemo.data.internal

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import ercanduman.fcmmessagingdemo.R
import ercanduman.fcmmessagingdemo.ui.main.MainActivity

/**
 * Responsible for generating a notification and displaying it.
 *
 * @author ercanduman
 * @since  24.09.2021
 */
object NotificationHelper {

    private const val JOB_ID = 101
    private const val CHANNEL_ID = "ercanduman.fcmmessagingdemo.CHANNEL_ID"

    fun displayNotification(context: Context, title: String = "", message: String = "") {
        val appContext = context.applicationContext

        // Start MainActivity if notification clicked.
        val pendingIntent =
            PendingIntent.getActivity(
                appContext, 0, Intent(appContext, MainActivity::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        val builder = NotificationCompat.Builder(appContext, CHANNEL_ID)
            .setContentTitle(title)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)

        if (message.isNotEmpty()) builder.setContentText(message)
        val manager = appContext.getSystemService(NotificationManager::class.java)

        // If app API level is greater than 26, then display notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, title, NotificationManager.IMPORTANCE_DEFAULT
            )

            manager.createNotificationChannel(channel)
        }

        manager.notify(JOB_ID, builder.build())
    }
}