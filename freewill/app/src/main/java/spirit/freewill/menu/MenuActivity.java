package spirit.freewill.menu;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import spirit.freewill.R;
import spirit.freewill.qa.QAFragment;
import spirit.freewill.train.TrainFragment;
import spirit.freewill.train.WatchFragment;
import spirit.freewill.user.MyFragment;


public class MenuActivity extends AppCompatActivity {


    private FragmentTabHost mTabHost;
    private String[] tags = new String[]{"train","study","exchange","my"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(),
                android.R.id.tabcontent);
        init();
        int index = getIntent().getIntExtra("index", -1);
        if (index > 0) {
            mTabHost.setCurrentTab(index - 1);
        } else {
            mTabHost.setCurrentTab(0);
        }
    }

    private void init() {


        mTabHost.addTab(
                mTabHost.newTabSpec("train").setIndicator(getTabView("练习",R.drawable.eight)),
                WatchFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("study").setIndicator(getTabView("学习",R.drawable.nine)),
                ArticleFragment.class, null);
        mTabHost.addTab(
                mTabHost.newTabSpec("exchange").setIndicator(getTabView("交流",R.drawable.eleven)),
                QAFragment.class, null);
//        mTabHost.addTab(
//                mTabHost.newTabSpec("my").setIndicator(getTabView("我的",R.drawable.he)),
//                MyFragment.class, null);

    }

    private View getTabView(String name, int id) {
        View v = getLayoutInflater().inflate(R.layout.menu_tab_main, null);
        ImageView iv = (ImageView) v.findViewById(R.id.tabIV);
        iv.setImageResource(id);
        TextView tabText = (TextView) v.findViewById(R.id.tabText);
        tabText.setText(name);
        return v;
    }
	public boolean onKeyUp(int keyCode, KeyEvent event) {
//		if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Log.i("123","KEYCODE_BACK--");

            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            BaseFragment fragmentByTag = (BaseFragment) fragmentManager.findFragmentByTag(tags[mTabHost.getCurrentTab()]);
            if(fragmentByTag.onKeyUp(keyCode,event)){
                return true;
            }else{
                return super.onKeyUp(keyCode, event);
            }

//		}
//		return super.onKeyUp(keyCode, event);
	}
}

















