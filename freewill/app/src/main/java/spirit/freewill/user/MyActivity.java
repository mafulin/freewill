package spirit.freewill.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import spirit.freewill.R;

/**
 * Created by mafulin on 2017/9/12.
 */

public class MyActivity extends AppCompatActivity {

    private RelativeLayout menu;
    private RelativeLayout root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initview();
    }


    private void initview() {
        root = (RelativeLayout) findViewById(R.id.root);
        menu = (RelativeLayout) findViewById(R.id.menu);
    }


//    public void click(View v){
//        switch (v.getId()){
//            case R.id.action:
//                break;
//        }
//    }

}























