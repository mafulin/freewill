package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.data.FreewillItem;
import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;
import spirit.freewill.util.TimeUtil;

public class ClockMapView extends View {

    private float width = Constant.width;
    private float height = Constant.height;
    private float x = 1f;
    private float y = 1f;
    private long durationMillis = 6000;
    private long seconds = 12*60*60*1000;
    private ArrayList<Float> entries = new ArrayList<Float>();
    private ArrayList<String> colors = new ArrayList<String>();
    private float all = 270f ;
    private float amall = 270f ;
    private float pmall = 270f ;
    private List<FreewillItem> data;
    public ClockMapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ClockMapView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//		setAnimation();
    }

    public ClockMapView(Context context) {
        this(context, null);
//		setAnimation();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);

        /********************************************/
        setBackgroundColor(Color.TRANSPARENT);

        Paint p = new Paint();
        p.setAntiAlias(true);
//        p.setStyle(Paint.Style.STROKE);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.WHITE);
        p.setStrokeWidth(1f);
        p.setTextSize(PXUtil.dip2px(12));
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        width = measuredWidth;
        height = measuredHeight;
        canvas.drawLine(0,height,width,height,p);
        canvas.drawLine(0,0,0,height,p);

        canvas.drawText("24",width*23f/24,height,p);
        canvas.drawText("0",0,height,p);
        canvas.drawText("12",width*11.5f/24,height,p);

        p.setStrokeWidth(0.3f);
        for(int i = 0;i<=24;i++){
            canvas.drawLine(0,height*i/24,width,height*i/24,p);
        }
        for(int i = 0;i<=24;i++){
            canvas.drawLine(width*i/24,0,width*i/24,height,p);
        }
//        p.setStrokeWidth(0.1f);
//        for(int i = 0;i<=60;i++){
//            canvas.drawLine(0,height*i/60,width,height*i/60,p);
//        }
        p.setStyle(Paint.Style.FILL);
        p.setTextSize(PXUtil.dip2px(6));
        Log.i("123","data.size--"+ data.size());
        for(FreewillItem item:data){
            p.setColor(Color.parseColor(item.getColor()));
            x=width*(item.getTime()-TimeUtil.getZero())*1.0f/(24*60*60*1000);
            y=height*(1-((item.getTime()-TimeUtil.getZero())%900000)*1.0f/900000);
            canvas.drawCircle(x, y, width/144f, p);
//            canvas.drawText(item.getKind().charAt(0)+"",x-PXUtil.dip2px(3),y+PXUtil.dip2px(3),p);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
//        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
//		Log.i("123","width/2-"+width/2);
//		setMeasuredDimension((int)(Constant.width/2), (int)(Constant.width/2));
//		setMeasuredDimension((int)(width), (int)(height));
    }


    public void setData(List<FreewillItem> data) {
        Log.i("123","setData--"+data.size());
        this.data = data;
        invalidate();
    }


}
