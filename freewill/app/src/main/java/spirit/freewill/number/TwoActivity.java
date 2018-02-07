package spirit.freewill.number;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import spirit.freewill.R;
import spirit.freewill.util.Constant;

/**
 * Created by mafulin on 2017/9/12.
 */

public class TwoActivity extends AppCompatActivity {

    private RelativeLayout menu;
    private RelativeLayout root;

    private static int[] petals =  {9,8,7,6,5,4,3,2,1};
    private static long[] durations =  {1000,2000,3000,4000,5000,6000,7000,8000,9000};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nine);
        root = (RelativeLayout) findViewById(R.id.root);
        menu = (RelativeLayout) findViewById(R.id.menu);
//        addChakra1();
//        addNine();

    }

    @Override
    protected void onResume() {
        super.onResume();
        addBG();
    }



    public void addBG(){
//        ImageView
//        BGView bgView = new  BGView(TwoActivity.this);
//        menu.addView(bgView);//
//        TJView tjView = new  TJView(TwoActivity.this);
//        menu.addView(tjView);//
    }
}























