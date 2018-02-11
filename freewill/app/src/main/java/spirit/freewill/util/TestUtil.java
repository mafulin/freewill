package spirit.freewill.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import spirit.freewill.R;
import spirit.freewill.data.FreewillItem;

/**
 * Created by mafulin on 2018/2/8.
 */

public class TestUtil {
    public static void makeData(){
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twenty_four=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        long twelve=zero+12*60*60*1000;//今天12点0分0秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数

        LogUtil.i("current--"+current+"--"+new Date(current));
        LogUtil.i("current--"+TimeUtil.isyesterday(current));

        LogUtil.i("zero--"+zero+"--"+new Date(zero));
        LogUtil.i("twelve--"+TimeUtil.getZero()+"--"+new Date(TimeUtil.getZero()));
        LogUtil.i("twelve--"+TimeUtil.getTwelve()+"--"+new Date(TimeUtil.getTwelve()));
        LogUtil.i("zero--"+TimeUtil.isyesterday(zero));
        LogUtil.i("yesterday--"+yesterday+"--"+new Date(yesterday));
        LogUtil.i("yesterday--"+TimeUtil.isyesterday(yesterday));
        getTimesmorning();
    }
    public static void getTimesmorning(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        LogUtil.i("cal.getTimeInMillis()--"+cal.getTimeInMillis()+"--"+new Date(cal.getTimeInMillis()));
//        return (int) (cal.getTimeInMillis());
    }

    public static void makeD(){
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
        String[] kinds = Constant.context.getResources().getStringArray(R.array.kind);
        String[] colors = Constant.context.getResources().getStringArray(R.array.color);
        List<FreewillItem> list = new ArrayList<>();

        for(int i = 0;i<50; i++){
            list.add(new FreewillItem(i,yesterday+=1000*60,kinds[i%kinds.length],colors[i%colors.length]));
        }

        List<FreewillItem> readlist = FileUtil.readlist(Constant.context);
        list.addAll(readlist);
        FileUtil.writeList(Constant.context,list);
    }
}
