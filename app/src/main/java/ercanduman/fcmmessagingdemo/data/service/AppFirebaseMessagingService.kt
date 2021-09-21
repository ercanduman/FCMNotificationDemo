package ercanduman.fcmmessagingdemo.data.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ercanduman.fcmmessagingdemo.util.logger

/**
 * Handles Firebase FCM operations such as receiving new token or sending tokens to backend server.
 *
 * @author ercanduman
 * @since  21.09.2021
 */
class AppFirebaseMessagingService : FirebaseMessagingService() {

    /**
     * Called when the FCM token is updated.
     *
     * @param newToken Newly generated token string
     */
    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)

        // If you want to send messages to only this application instance from the server side, then send
        // the FCM registration token to you app server.
        sendRegistrationToServer(newToken)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        logger(remoteMessage.notification?.title)
        logger(remoteMessage.notification?.body)
    }

    private fun sendRegistrationToServer(token: String) {
        // TODO: 21.09.2021 Add retrofit implementation here to send the token to backend server.
        logger(token)
    }
}