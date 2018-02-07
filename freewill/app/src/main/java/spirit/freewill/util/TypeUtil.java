package spirit.freewill.util;

import spirit.freewill.main.FreewillActivity;

/**
 * Created by mafulin on 2018/1/17.
 */

public class TypeUtil {
    public static final int TYPE_start = 0x00000000;
    public static final int TYPE_end = 0x00000001;
    public static final int TYPE_jing = 0x00000002;
    public static final int TYPE_dong = 0x00000003;

    public static String typeToStr(int type){
        String str = "";
        switch (type){
            case TypeUtil.TYPE_start:
                str = "开始";
                break;
            case TypeUtil.TYPE_end:
                str = "结束";
                break;
            case TypeUtil.TYPE_jing:
                str = "静";
                break;
            case TypeUtil.TYPE_dong:
                str = "动";
                break;
        }
        return str;
    }
}
