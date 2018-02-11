package spirit.freewill.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import spirit.freewill.data.FreewillItem;

/**
 * Created by mafulin on 2018/1/16.
 */

public class TimeUtil {

    public static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = String.valueOf(df.format(new Date()));
        return time;
    }
    public static String getTimeBy(long millis) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = String.valueOf(df.format(new Date(millis)));
        return time;
    }
    public static String getTimeByM(long millis) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");
        String time = String.valueOf(df.format(new Date(millis)));
        return time;
    }

    public static String getTodayZero() {
        Date date = new Date();
        long l = 24*60*60*1000; //每天的毫秒数
        //date.getTime()是现在的毫秒数，它 减去 当天零点到现在的毫秒数（ 现在的毫秒数%一天总的毫秒数，取余。），理论上等于零点的毫秒数，不过这个毫秒数是UTC+0时区的。
        //减8个小时的毫秒值是为了解决时区的问题。
        long time = date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=new Date(time);
        return format.format(d1);
    }

    public static boolean isyesterday(long last) {


        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数

//        LogUtil.i("zero--"+new Date(zero));
//        LogUtil.i("isyesterday;"+"getZero()--"+getZero()+";last--"+last+";last < zero--"+(last < getZero()));
        return last < getZero();
    }

    public static long getZero(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
//        LogUtil.i("cal.getTimeInMillis()--"+cal.getTimeInMillis()+"--"+new Date(cal.getTimeInMillis()));
        return cal.getTimeInMillis();
    }
    public static long getTwelve(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        LogUtil.i("cal.getTwelve()--"+cal.getTimeInMillis()+"--"+new Date(cal.getTimeInMillis()));
        return cal.getTimeInMillis();
    }
    public static long leftseconds(long time) {

        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twenty_four=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        long twelve=zero+12*60*60*1000;//今天12点0分0秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
//        System.out.println(new Date(current));//当前时间
//        System.out.println(new Date(yesterday));//昨天这一时间点
//        System.out.println(new Date(zero));//今天零点零分零秒
//        System.out.println(new Date(twelve));//今天23点59分59秒
//        Log.i("123","leftseconds--"+(twelve-current)/1000/60);

        if(time < zero){
            time = current;
        }

        if(time < twelve){
            return twelve - time;
        }else{
            return twenty_four - time;
        }
    }
    public static long beforeseconds(long time) {

        long current=System.currentTimeMillis();//当前时间毫秒数
        //        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long zero=getZero();//今天零点零分零秒的毫秒数
        long twenty_four=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
//        long twelve=zero+12*60*60*1000;//今天12点0分0秒的毫秒数
        long twelve=getTwelve();//今天12点0分0秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
//        System.out.println(new Date(current));//当前时间
//        System.out.println(new Date(yesterday));//昨天这一时间点
//        System.out.println(new Date(zero));//今天零点零分零秒
//        System.out.println(new Date(twelve));//今天23点59分59秒
//        Log.i("123","leftseconds--"+(twelve-current)/1000/60);
        if(time < zero){
            time = current;
        }

        if(time < twelve){
            return time-zero;
        }else{
            return time-twelve;
        }
    }
    public static boolean isAM(long time) {

        long current=System.currentTimeMillis();//当前时间毫秒数
//        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long zero=getZero();//今天零点零分零秒的毫秒数
        long twenty_four=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
//        long twelve=zero+12*60*60*1000;//今天12点0分0秒的毫秒数
        long twelve=getTwelve();//今天12点0分0秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
//        System.out.println(new Date(current));//当前时间
//        System.out.println(new Date(yesterday));//昨天这一时间点
//        System.out.println(new Date(zero));//今天零点零分零秒
//        System.out.println(new Date(twelve));//今天23点59分59秒
//        Log.i("123","leftseconds--"+(twelve-current)/1000/60);
        if(time < zero){
            time = current;
        }

        return  time < twelve;
    }
}
