package spirit.freewill.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.data.FreewillItem;
import spirit.freewill.util.FileUtil;

/**
 * Created by mafulin on 2018/1/17.
 */

public class NotifyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        int type = intent.getIntExtra("type",0);
        Log.i("123","type--"+type);

        List<FreewillItem> data = FileUtil.readlist(this);
        if(data == null){
            data = new ArrayList<FreewillItem>();
        }
        FreewillItem freewillItem = new FreewillItem();
        freewillItem.setTime(System.currentTimeMillis());
        freewillItem.setType(type);
        data.add(freewillItem);
        Log.i("123","freewillItem--"+freewillItem);
        FileUtil.writeList(this,data);

        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
