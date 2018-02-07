package spirit.freewill.number;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import spirit.freewill.R;
import spirit.freewill.util.Constant;

/**
 * Created by mafulin on 2017/9/12.
 */

public class EightActivity extends AppCompatActivity {

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

    public void addChakra1(){
        DotView chakra1 = new  DotView(EightActivity.this,6000,12);
        root.addView(chakra1);//
        ViewGroup.MarginLayoutParams margin7=new ViewGroup.MarginLayoutParams(chakra1.getLayoutParams());
        margin7.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f*0.5),
                (int)(Constant.height*0.5f-Constant.width*0.0625f*0.5),
                (int)(Constant.width*0.5f+Constant.width*0.0625f*0.5),
                (int)(Constant.height*0.5f+Constant.width*0.0625f*0.5));
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(margin7);
        chakra1.setLayoutParams(layoutParams7);
        chakra1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });
    }

    public void addNine(){
//        NineView nineView = new  NineView(NineActivity.this);
//        root.addView(nineView);//
        for(int i = 1; i < 10 ; i++){
            OneView oneView = new  OneView(EightActivity.this,durations[i-1],i);
            root.addView(oneView);//
        }
    }

    public void addBG(){
        BGView bgView = new  BGView(EightActivity.this);
        menu.addView(bgView);//
        TJView tjView = new  TJView(EightActivity.this);
        menu.addView(tjView);//
//        YJView yjView = new  YJView(EightActivity.this);
//        menu.addView(yjView);//
    }
}























