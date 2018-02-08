package spirit.freewill.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import spirit.freewill.R;
import spirit.freewill.data.FreewillItem;

/**
 * Created by mafulin on 2018/2/8.
 */

public class TestUtil {
    public static void makeData(){
        List<FreewillItem> data = FileUtil.readlist(Constant.context);
        List<FreewillItem> list = FileUtil.readlist(Constant.context);
        if(data == null){
            data = new ArrayList<FreewillItem>();
        }
        for(FreewillItem item : data){
            list.add(new FreewillItem(item.getType(),item.getTime()-Constant.seconds,item.getKind(),item.getColor()));
        }
        list.addAll(data);
        FileUtil.writeList(Constant.context,list);
    }
    public static void makeD(){
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        String[] kinds = Constant.context.getResources().getStringArray(R.array.kind);
        String[] colors = Constant.context.getResources().getStringArray(R.array.color);
        List<FreewillItem> list = new ArrayList<>();

        for(int i = 0;i<100; i++){
            list.add(new FreewillItem(i,zero+=1000*600,kinds[i%kinds.length],colors[i%colors.length]));
        }
        FileUtil.writeList(Constant.context,list);
    }
}
