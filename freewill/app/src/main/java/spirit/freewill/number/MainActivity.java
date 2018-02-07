package spirit.freewill.number;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;

import spirit.freewill.R;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;

    private SharedPreferences.Editor edit;

    private int pb11;
    private int pb22;
    private int pb33;
    private int pb44;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    private ProgressBar pb1;
    private ProgressBar pb2;
    private ProgressBar pb3;
    private ProgressBar pb4;

    private View progress_group;


    private Handler pbHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            update("pb1",tv1,pb1,100);
            update("pb2",tv2,pb2,300);
            update("pb3",tv3,pb3,1000);
            update("pb4",tv4,pb4,3000);
            pbHandler.sendEmptyMessageDelayed(1,1);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        progress_group = findViewById(R.id.progress_group);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb2 = (ProgressBar) findViewById(R.id.pb2);
        pb3 = (ProgressBar) findViewById(R.id.pb3);
        pb4 = (ProgressBar) findViewById(R.id.pb4);

        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);

        edit = sp.edit();

        pb11 = sp.getInt("pb1", 0);
        pb22 = sp.getInt("pb2", 0);
        pb33 = sp.getInt("pb3", 0);
        pb44 = sp.getInt("pb4", 0);

        tv1.setText(pb11+"/100");
        tv2.setText(pb22+"/300");
        tv3.setText(pb33+"/1000");
        tv4.setText(pb44+"/3000");

        pb1.setProgress(pb11);
        pb2.setProgress(pb22);
        pb3.setProgress(pb33);
        pb4.setProgress(pb44);

    }

    public void up(View v){
        switch (v.getId()){
            case R.id.up1:
                update("pb1",tv1,pb1,100);
                break;
            case R.id.up2:
                update("pb2",tv2,pb2,300);
                break;
            case R.id.up3:
                update("pb3",tv3,pb3,1000);
                break;
            case R.id.up4:
                pbHandler.sendEmptyMessageDelayed(1,100);
                break;

        }
    }
    public void click(View v){
        switch (v.getId()){
            case R.id.progress_tx:
                if(progress_group.getVisibility() == View.GONE){

                    TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                            -1.0f, Animation.RELATIVE_TO_SELF, -0.0f);
//                    mShowAction.setRepeatMode(Animation.REVERSE);
                    mShowAction.setDuration(500);
                    progress_group.startAnimation(mShowAction);//开始动画
                    progress_group.setVisibility(View.VISIBLE);


                }else{

                    TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                            0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                            -1.0f);
//                    mHiddenAction.setRepeatMode(Animation.REVERSE);
                    mHiddenAction.setDuration(500);
                    mHiddenAction.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            progress_group.setVisibility(View.GONE);

                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    progress_group.startAnimation(mHiddenAction);//开始动画
                }
                break;
            case R.id.two_tx:

//                startActivity(new Intent(MainActivity.this,TwoActivity.class));


                break;
            case R.id.four_tx:
                startActivity(new Intent(MainActivity.this,FourActivity.class));
                break;
            case R.id.five_tx:
                startActivity(new Intent(MainActivity.this,FiveActivity.class));
                break;
            case R.id.six_tx:
                startActivity(new Intent(MainActivity.this,SixActivity.class));
                break;
            case R.id.seven_tx:
                startActivity(new Intent(MainActivity.this,SevenActivity.class));
                break;
            case R.id.eight_tx:
                startActivity(new Intent(MainActivity.this,EightActivity.class));
                break;
            case R.id.nine_tx:
                startActivity(new Intent(MainActivity.this,NineActivity.class));
                break;
            case R.id.three_tx:
                startActivity(new Intent(MainActivity.this,ThreeActivity.class));
                break;
            case R.id.one_tx:
                startActivity(new Intent(MainActivity.this,OneActivity.class));
                break;

        }
    }
    private void update(String key,TextView tv,ProgressBar pb,int max){
        int value = sp.getInt(key, 0);
        value = value + 1;
//        if(value > max){
//            return;
//        }
        edit.putInt(key,value);
        edit.commit();
        pb.setProgress(value);
        tv.setText(value+"/"+max);
    }
}

























