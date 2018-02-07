package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;

public class ClockView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 6000;
	private int petals = 81;
	private String  tag = "";
	public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public ClockView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
//		setAnimation();
	}
	public ClockView(Context context) {
		this(context,null);
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
			p.setStyle(Paint.Style.STROKE);
			p.setColor(Color.WHITE);
			p.setStrokeWidth(0.5f);
		p.setTextSize(PXUtil.dip2px(5));
		int measuredWidth = getMeasuredWidth();
		int measuredHeight = getMeasuredHeight();
		width = measuredWidth;
		height = measuredHeight;

		canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f- PXUtil.dip2px(5), p);

//		setBackgroundColor(Color.parseColor("#44888888"));

		for (int i = 1; i <13; i++) {
			canvas.rotate(360f/12,width/2,height/2);
//			canvas.drawLine(width*0.5f,0,width*0.5f,PXUtil.dip2px(5),p);
			if(i<10){
				canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(1),PXUtil.dip2px(4),p);
			}else{
				canvas.drawText(i+"",width*0.5f-PXUtil.dip2px(3),PXUtil.dip2px(4),p);
			}
		}

	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
//		Log.i("123","width/2-"+width/2);
//		setMeasuredDimension((int)(Constant.width/2), (int)(Constant.width/2));
//		setMeasuredDimension((int)(width), (int)(height));
	}
	
	public void setAnimation(){
		Animation animation = new RotateAnimation(0f, -360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(durationMillis);
		animation.setRepeatCount(-1);
		 LinearInterpolator lir = new LinearInterpolator();    
		 animation.setInterpolator(lir);
		startAnimation(animation);
	}
	

}
