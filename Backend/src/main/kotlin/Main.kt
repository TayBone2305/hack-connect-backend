package default

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.*
import com.google.firebase.messaging.Notification
import org.springframework.boot.runApplication
import java.io.InputStream


fun main(args: Array<String>) {
    runApplication<MyApplication>(*args)
}

public fun firebase(credentials: InputStream) {
    val options: FirebaseOptions = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(credentials))
        .build()

    val app = FirebaseApp.initializeApp(options)
    val message = com.google.firebase.messaging.Message.builder().putData("data", "test")
        .setNotification(Notification.builder().setBody("IMPORTANT").setTitle("Hello").build()).build();
    val messaging = com.google.firebase.messaging.FirebaseMessaging.getInstance(app)
    messaging.send(message)
}