package spirit.freewill.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FreewillReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("123", "FreewillReceiver--intent.getAction()"+intent.getAction());
    }

}
