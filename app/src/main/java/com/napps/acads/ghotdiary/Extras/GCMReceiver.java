package com.napps.acads.ghotdiary.Extras;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.napps.acads.ghotdiary.R;


public class GCMReceiver extends WakefulBroadcastReceiver {
    int UNIQUE_ID=6969784;

    String title="default";
    String content="lol";
    String picUrl;
    String date="6/9/69";
    String time;
    String venue;
    String contact;
    String number;

    @Override
    public void onReceive(Context context, Intent intent) {

        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        picUrl = intent.getStringExtra("picUrl");
        date = intent.getStringExtra("date");
        time = intent.getStringExtra("time");
        venue = intent.getStringExtra("venue");
        contact = intent.getStringExtra("contact");
        number = intent.getStringExtra("number");

        if (title !=null) {

            //Putting the notification
            NotificationCompat.Builder notification;

            notification = new NotificationCompat.Builder(context);
            notification.setAutoCancel(true);
            notification.setSmallIcon(R.drawable.gdlogo);
            notification.setTicker("This is the ticker");
            notification.setContentTitle(title);
            notification.setContentText(content);

            Uri alarm = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            notification.setSound(alarm);

            notification.setWhen(System.currentTimeMillis());
            int color =0xcc0072bc;

            notification.setColor(color);
            Intent notif = new Intent(context, Notice.class);

            //Extra info to send to the notification page
            notif.putExtra("content", content);
            notif.putExtra("picUrl", picUrl);
            notif.putExtra("time", time);
            notif.putExtra("date", date);
            notif.putExtra("venue", venue);
            notif.putExtra("number", number);
            notif.putExtra("contact", contact);

            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notif, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);

            NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            nm.notify(UNIQUE_ID, notification.build());
        }

    }

}
