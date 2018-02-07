package spirit.freewill.all;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import spirit.freewill.R;

/**
 * Created by mafulin on 2017/9/12.
 */

public class AllActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_all);
        TabHost tab = (TabHost) findViewById(android.R.id.tabhost);
//        tab.setup(this.getLocalActivityManager());

        TabHost.TabSpec tabSpec_today = tab.newTabSpec("today");
        tabSpec_today.setIndicator("今天");

        Intent intent_today = new Intent(this,TodayActivity.class);
        tabSpec_today.setContent(intent_today);
        tab.addTab(tabSpec_today);
        TabHost.TabSpec tabSpec_history = tab.newTabSpec("history");
        tabSpec_history.setIndicator("今天");

        Intent intent = new Intent(this,HistoryActivity.class);
        tabSpec_history.setContent(intent);
        tab.addTab(tabSpec_history);
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























