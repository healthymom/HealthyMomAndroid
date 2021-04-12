package kz.healthymom.presentation.notification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * created by: Makhanov Madiyar
 * on: 12.04.2021
 */
class FirebaseService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }
}