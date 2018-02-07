package spirit.freewill.main;

import android.app.Application;
import android.util.Log;
import android.view.WindowManager;

import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FreewillApplication extends Application {

    public static String APPID = "d8c188799a8946d85b91b5c6c569031f";

    @Override
    public void onCreate() {
        super.onCreate();
        initConstant();
    }

    private void initConstant(){
        Constant.context = getApplicationContext();
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Constant.context = getApplicationContext();
        Constant.height = windowManager.getDefaultDisplay().getHeight()-PXUtil.dip2px(90);
        Constant.width = windowManager.getDefaultDisplay().getWidth()-PXUtil.dip2px(60);
        Log.i("123","height--"+Constant.height);
        Log.i("123","width"+Constant.width);
        int i = PXUtil.px2dip(Constant.width);
        int i2 = PXUtil.px2dip(Constant.height);
        Log.i("123","i"+i);
        Log.i("123","i2"+i2);

    }
}
