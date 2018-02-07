package spirit.freewill.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mafulin on 2018/1/16.
 */

public class SPUtil {
    public static void saveLast(Context context,long last){
        SharedPreferences preferences=context.getSharedPreferences("list",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putLong("last", last);
        editor.commit();
    }
    public static  long getLast(Context context){
        SharedPreferences preferences=context.getSharedPreferences("list", Context.MODE_PRIVATE);
        long last = preferences.getLong("last", 0);
        return last;
    }
    public static void setStart_End(Context context,boolean start_end){
        SharedPreferences preferences=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("start_end", start_end);
        editor.commit();
    }
    public static  boolean getStart_End(Context context){
        SharedPreferences preferences=context.getSharedPreferences("data", Context.MODE_PRIVATE);
        boolean last = preferences.getBoolean("start_end",false);
        return last;
    }
    public static String get(Context context,String key){
        SharedPreferences preferences=context.getSharedPreferences("data", Context.MODE_PRIVATE);
        String value = preferences.getString(key,"");
        return value;
    }
    public static void set(Context context,String key,String value){
        SharedPreferences preferences=context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
