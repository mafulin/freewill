package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.data.FreewillItem;
import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;
import spirit.freewill.util.TimeUtil;

public class ClockPerView extends View {

    private float width = Constant.width;
    private float height = Constant.height;
    private long durationMillis = 6000;
    private long seconds = 12*60*60*1000;
    private ArrayList<Float> entries = new ArrayList<Float>();
    private ArrayList<String> colors = new ArrayList<String>();
    private ArrayList<Per> pers = new ArrayList<Per>();
    private float all = 270f ;
    public ClockPerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ClockPerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//		setAnimation();
    }

    public ClockPerView(Context context) {
        this(context, null);
//		setAnimation();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        Log.i("123","onDraw--");
        /********************************************/
        setBackgroundColor(Color.TRANSPARENT);

        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.WHITE);
        p.setStrokeWidth(0.5f);
        p.setTextSize(PXUtil.dip2px(12));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        width = measuredWidth;
        height = measuredHeight;
        for (int i = 13; i <25; i++) {
            canvas.rotate(360f/12,width/2,height/2);
			canvas.drawLine(width*0.5f,0,width*0.5f,width*0.5f*0.25f,p);
            if(i<10){
                canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(1),PXUtil.dip2px(4),p);
            }else{
                canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(6),PXUtil.dip2px(12),p);
            }
        }
		canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f, p);
        p.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(0, 0, width, height);
        for (Per per : pers){
            Log.i("123","onDraw--"+per);
            Log.i("123","all--"+all);

            p.setColor(Color.parseColor(per.color));
            canvas.drawArc(rectF, per.start, per.percent, true, p);
            all += per.percent;
        }

        p.setColor(Color.BLACK);
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.75f, p);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.WHITE);
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.75f, p);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
//		Log.i("123","width/2-"+width/2);
//		setMeasuredDimension((int)(Constant.width/2), (int)(Constant.width/2));
//		setMeasuredDimension((int)(width), (int)(height));
    }

    public void setAnimation() {
        Animation animation = new RotateAnimation(0f, -360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(durationMillis);
        animation.setRepeatCount(-1);
        LinearInterpolator lir = new LinearInterpolator();
        animation.setInterpolator(lir);
        startAnimation(animation);
    }

    public void setData(List<FreewillItem> data) {
        Log.i("123","setData--"+data);
        makeData(data);
        invalidate();
    }
    private void makeData(List<FreewillItem> data) {
        Log.i("123","setData--"+data);
        pers.clear();
        all = 270f;
        float percent = 0f;
        for(int i = 0; i< data.size();i++){
            Log.i("123","data--"+data.get(i));

            if(i == 0){
                percent = TimeUtil.beforeseconds(data.get(0).getTime())*360.0f/Constant.seconds;
                pers.add(new Per(all,percent,"#FF888888"));
            }else{
                percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds;
//                percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds*10f;
                pers.add(new Per(all,percent,data.get(i).getColor()));
            }
            all += percent;

        }

        if(pers.isEmpty()){
            pers.add(new Per(all,(TimeUtil.beforeseconds(0)*360.0f/Constant.seconds),"#FF888888"));
        }

    }

    class Per{
        public Per(float start,float percent, String color) {
            this.start = start;
            this.percent = percent;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Per{" +
                    "percent=" + percent +
                    ", color='" + color + '\'' +
                    '}';
        }

        public float start;
        public float percent;
        public String color;
    }

}
