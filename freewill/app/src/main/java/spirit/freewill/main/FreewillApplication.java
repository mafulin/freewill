package spirit.freewill.main;

import android.app.Application;
import android.util.Log;
import android.view.WindowManager;

import com.tencent.bugly.Bugly;

import java.util.ArrayList;

import spirit.freewill.R;
import spirit.freewill.data.ConsciousnKind;
import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;
import spirit.freewill.util.FileUtil;
import spirit.freewill.util.TestUtil;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FreewillApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        initConstant();
        firstStart();
        Bugly.init(getApplicationContext(), "436f7b9c8b", true);

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

    private void initConsciousnKindList() {
        String[] kinds = getResources().getStringArray(R.array.kind);
        String[] colors = getResources().getStringArray(R.array.color);
        ArrayList<ConsciousnKind>  consciousnKinds = new ArrayList<>();
        Log.i("123","kinds--"+kinds.length);
        Log.i("123","colors--"+colors.length);
        for(int i =0; i < kinds.length; i++ ){
            consciousnKinds.add(new ConsciousnKind(i,kinds[i],colors[i%colors.length]));
        }
        FileUtil.writeKindList(this,consciousnKinds);
    }

    /**
     * 初次启动app时需要初始化的数据
     */
    private void firstStart() {
        initConsciousnKindList();
    }
}
