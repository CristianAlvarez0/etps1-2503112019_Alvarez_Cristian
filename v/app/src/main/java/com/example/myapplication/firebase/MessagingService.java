package com.example.myapplication.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        // Este método se llama cuando se genera un nuevo token de registro en Firebase Cloud Messaging (FCM).
        // Se utiliza para actualizar el token del dispositivo en el servidor, por ejemplo, cuando se instala
        // la aplicación por primera vez o cuando se restablece el token.
        // Aquí se realizan las acciones necesarias para enviar o almacenar el token.
        Log.d("FCM", "Token:"+ token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // Este método se llama cuando se recibe un mensaje de notificación push desde FCM.
        // Aquí se realizan las acciones necesarias para mostrar la notificación o procesar los datos recibidos.
        // En este caso, se imprime en el registro el cuerpo del mensaje de notificación recibido.
        Log.d("FCM", "Messaage_"+ remoteMessage.getNotification().getBody());
    }
}
