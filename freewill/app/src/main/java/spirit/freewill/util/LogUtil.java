package spirit.freewill.util;

import android.util.Log;

/**
 * Created by mafulin on 2018/2/10.
 */

public class LogUtil {
    public static boolean isDebug = true;
    public static final  String LOG = "123";
    public static void i(String msg){
        if(isDebug){
            Log.i(LOG,msg);
        }
    }
}
