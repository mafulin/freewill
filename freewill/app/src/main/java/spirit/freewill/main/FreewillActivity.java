package spirit.freewill.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import spirit.freewill.R;

/**
 * Created by mafulin on 2017/9/12.
 */

public class FreewillActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freewill);
        initview();
        initList();

    }

    private void initList() {
    }

    private void initview() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void click(View v){
    }


}























