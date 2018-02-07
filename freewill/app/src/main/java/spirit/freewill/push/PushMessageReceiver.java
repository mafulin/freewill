package spirit.freewill.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import spirit.freewill.R;
import spirit.freewill.number.NineActivity;

/**
 * Created by mafulin on 2018/1/16.
 */

public class PushMessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("123", "intent.getAction()"+intent.getAction());
        // TODO Auto-generated method stub


        String message = intent.getStringExtra("msg");
        Intent i = new Intent();
        i.setClass(context, NineActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0);

        PendingIntent pi = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("消息")
                .setContentText(message)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pi);
        // 发送通知
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification n = mBuilder.build();
        nm.notify(0, n);
    }

}
