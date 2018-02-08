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
    private ArrayList<Per> ampers = new ArrayList<Per>();
    private ArrayList<Per> pmpers = new ArrayList<Per>();
    private float all = 270f ;
    private float amall = 270f ;
    private float pmall = 270f ;
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
        p.setStrokeWidth(1f);
        p.setTextSize(PXUtil.dip2px(12));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        width = measuredWidth;
        height = measuredHeight;

        //外环外经
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f-0.5f, p);
        //外环时间
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.parseColor("#88ffffff"));
//        for (int i = 13; i <25; i++) {
//            canvas.rotate(360f/12,width/2,height/2);
////			canvas.drawLine(width*0.5f,width*0.5f*0.25f,width*0.5f,width*0.5f*0.125f,p);
//            if(i<10){
//                canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(1),PXUtil.dip2px(4),p);
//            }else{
//                canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(6),PXUtil.dip2px(12),p);
//            }
//        }
        //外环标尺
        for (int i = 1; i <61; i++) {
            if(i%5 == 0){
                p.setStrokeWidth(3f);
            }else{
                p.setStrokeWidth(1f);
            }
            canvas.rotate(360f/60,width/2,height/2);
			canvas.drawLine(width*0.5f,width*0.5f*0.25f,width*0.5f,width*0.5f*0.25f*0.75f,p);
        }
        p.setStrokeWidth(1f);
        //外环颜色填充
        p.setStyle(Paint.Style.FILL);
        RectF rectF = new RectF(0, 0, width, height);
        for (Per per : pmpers){
//            Log.i("123","onDraw--"+per);
//            Log.i("123","all--"+all);

            p.setColor(Color.parseColor(per.color));
            canvas.drawArc(rectF, per.start, per.percent, true, p);
        }
        //外环内径
        p.setColor(Color.BLACK);
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.75f, p);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.WHITE);
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.75f, p);

        //内环外经
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.625f, p);
        //内环时间
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.parseColor("#88ffffff"));
        p.setTextSize(PXUtil.dip2px(12));
//        for (int i = 1; i <13; i++) {
//            canvas.rotate(360f/12,width/2,height/2);
////            canvas.drawLine(width*0.5f,height*0.5f*0.5f,width*0.5f,height*0.5f*0.375f,p);
//            if(i<10){
//                canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(3),height*0.5f*0.625f-PXUtil.dip2px(6),p);
//            }else{
//                canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(6),height*0.5f*0.625f-PXUtil.dip2px(6),p);
//            }
//        }
        //内环标尺
        for (int i = 1; i <61; i++) {
            if(i%5 == 0){
                p.setStrokeWidth(3f);
            }else{
                p.setStrokeWidth(1f);
            }
            canvas.rotate(360f/60,width/2,height/2);
            canvas.drawLine(width*0.5f,width*0.5f*0.4375f,width*0.5f,width*0.5f*0.375f,p);
        }
        p.setStrokeWidth(1f);
        //内环颜色填充
        p.setStyle(Paint.Style.FILL);
        RectF rectf = new RectF(width*0.5f*0.375f, height*0.5f*0.375f, width*0.5f*1.625f, height*0.5f*1.625f);
        for (Per per : ampers){
            p.setColor(Color.parseColor(per.color));
            canvas.drawArc(rectf, per.start, per.percent, true, p);
        }
        //内环内径
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.375f, p);
        p.setStyle(Paint.Style.STROKE);
        p.setColor(Color.WHITE);
        canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f*0.375f, p);
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
        Log.i("123","setData--"+data.size());
        makeAMData(data);
        invalidate();
    }
    private void makeAMData(List<FreewillItem> data) {
        ampers.clear();
        pmpers.clear();
        Log.i("123","setData--"+data.size());
        amall = 270f;
        pmall = 270f;
        float percent = 0f;
        for(int i = 0; i< data.size();i++){
//            Log.i("123",i+"--TimeUtil.isAM(data.get(i).getTime())--"+TimeUtil.isAM(data.get(i).getTime()));
            if(TimeUtil.isAM(data.get(i).getTime())){
                if(ampers.isEmpty()){
                    percent = TimeUtil.beforeseconds(data.get(i).getTime())*360.0f/Constant.seconds;
                    ampers.add(new Per(amall,percent,"#FF888888"));
                }else{
                    percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds;
//                percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds*10f;
                    ampers.add(new Per(amall,percent,data.get(i).getColor()));
                }

                amall += percent;
            }else{
                if(pmpers.isEmpty()){
                    percent = TimeUtil.beforeseconds(data.get(i).getTime())*360.0f/Constant.seconds;
                    pmpers.add(new Per(pmall,percent,"#FF888888"));
                }else{
                    percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds;
//                percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds*10f;
                    pmpers.add(new Per(pmall,percent,data.get(i).getColor()));
                }

                pmall += percent;
            }
            Log.i("123","percent--"+percent);
        }

        if(ampers.isEmpty()){
            if(TimeUtil.isAM(System.currentTimeMillis())){
                ampers.add(new Per(amall,(TimeUtil.beforeseconds(0)*360.0f/Constant.seconds),"#FF888888"));
            }else{
                ampers.add(new Per(amall,360.0f,"#FF888888"));
            }
        }
        if(pmpers.isEmpty()){
            pmpers.add(new Per(pmall,(TimeUtil.beforeseconds(0)*360.0f/Constant.seconds),"#FF888888"));
        }

    }
    private void makeData(List<FreewillItem> data) {
        Log.i("123","setData--"+data);
        pers.clear();
        all = 270f;
        float percent = 0f;
        for(int i = 0; i< data.size();i++){
            Log.i("123","data--"+data.get(i));
            Log.i("123","TimeUtil.isAM(data.get(i).getTime())--"+TimeUtil.isAM(data.get(i).getTime()));

            if(i == 0){
                percent = TimeUtil.beforeseconds(data.get(0).getTime())*360.0f/Constant.seconds;
                pers.add(new Per(all,percent,"#FF888888"));
            }else{
//                percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds;
                percent = (data.get(i).getTime()-data.get(i-1).getTime())*360.0f/Constant.seconds*10f;
                pers.add(new Per(all,percent,data.get(i).getColor()));
            }
            Log.i("123","percent--"+percent);
            all += percent;
            Log.i("123","all--"+all);

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
