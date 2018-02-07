package spirit.freewill.number;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import spirit.freewill.R;

/**
 * Created by mafulin on 2017/9/12.
 */

public class FiveActivity extends AppCompatActivity {

    private RelativeLayout menu;
    private RelativeLayout root;

    private static int[] petals =  {9,8,7,6,5,4,3,2,1};
    private static long[] durations =  {1000,2000,3000,4000,5000,6000,7000,8000,9000};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        root = (RelativeLayout) findViewById(R.id.root);
        menu = (RelativeLayout) findViewById(R.id.menu);
//        addChakra1();
//        addNine();
        addBG();
    }



    public void addBG(){
        FiveView fiveView = new  FiveView(FiveActivity.this);
        menu.addView(fiveView);//
    }
}























