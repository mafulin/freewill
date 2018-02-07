package spirit.freewill.all;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import spirit.freewill.R;

/**
 * Created by mafulin on 2017/9/12.
 */

public class TodayActivity extends AppCompatActivity {

    private RelativeLayout menu;
    private RelativeLayout root;

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























