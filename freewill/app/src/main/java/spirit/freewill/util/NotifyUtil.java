package spirit.freewill.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import spirit.freewill.R;
import spirit.freewill.main.FreewillActivity;
import spirit.freewill.service.NotifyService;

/**
 * Created by mafulin on 2018/1/17.
 */

public class NotifyUtil {
    public static void start(Context context){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
        RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.notify);


        Intent intent_silent = new Intent(context, NotifyService.class);
        intent_silent.putExtra("type",TypeUtil.SILENT);
        intent_silent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendIntent_silent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(),
                intent_silent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteView.setOnClickPendingIntent(R.id.silent, pendIntent_silent);

        Intent intent_action = new Intent(context, NotifyService.class);
        intent_action.putExtra("type",TypeUtil.ACTION);
        intent_action.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendIntent_action = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(),
                intent_action, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteView.setOnClickPendingIntent(R.id.action, pendIntent_action);



        mBuilder.setOngoing(true);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setContent(remoteView);
        NotificationManager mNotifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyManager.notify(1, mBuilder.build());
    }
}
