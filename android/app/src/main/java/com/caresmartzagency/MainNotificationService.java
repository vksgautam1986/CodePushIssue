// package com.caresmartzagency;

// import android.content.Context;
// import android.util.Log;

// import java.util.logging.Logger;

// import com.google.firebase.messaging.FirebaseMessagingService;
// import com.google.firebase.messaging.RemoteMessage;
// import com.intercom.reactnative.IntercomModule;

// public class MainNotificationService  extends FirebaseMessagingService {

//     @Override
//     public void onNewToken(String refreshedToken) {
//         IntercomModule.sendTokenToIntercom(getApplication(), refreshedToken);
//         Log.d("onNewToken-FCM-",refreshedToken);
//         getSharedPreferences("_", MODE_PRIVATE).edit().putString("fb", refreshedToken).apply();
//         //getPreferences(Context.MODE_PRIVATE).edit().putString("fb", refreshedToken).apply();
//         //DO LOGIC HERE
//     }

//     public void onMessageReceived(RemoteMessage remoteMessage) {
//         if (IntercomModule.isIntercomPush(remoteMessage)) {
//             IntercomModule.handleRemotePushMessage(getApplication(), remoteMessage);
//         } else {
//             // HANDLE NON-INTERCOM MESSAGE
//             Log.d("onMessageReceived-FCM-",remoteMessage.getMessageType());
//         }
//     }
// }

