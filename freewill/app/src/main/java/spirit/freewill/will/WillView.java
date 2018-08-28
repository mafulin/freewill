package spirit.freewill.will;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import spirit.freewill.util.Constant;

public class WillView extends View{

	private float width = Constant.width;
	private float height = Constant.width;
	private long durationMillis = 36000;
	public WillView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public WillView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public WillView(Context context) {
		this(context,null);
//		setAnimation();
	}


	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		
		/********************************************/
		

			Paint p = new Paint();
			p.setAntiAlias(true);
			p.setStyle(Paint.Style.STROKE);
			p.setColor(Color.WHITE);
		p.setStrokeWidth(0.7f);


		canvas.drawLine(0,height*0.5f-width*0.5f,width,height*0.5f-width*0.5f,p);
		canvas.drawLine(0,height*0.5f+width*0.5f,width,height*0.5f+width*0.5f,p);
		canvas.drawLine(0,height*0.5f-width*0.5f/3,width,height*0.5f-width*0.5f/3,p);
		canvas.drawLine(0,height*0.5f+width*0.5f/3,width,height*0.5f+width*0.5f/3,p);
//
//
		canvas.drawLine(0,height*0.5f-width*0.5f,0,height*0.5f+width*0.5f,p);
		canvas.drawLine(width,height*0.5f-width*0.5f,width,height*0.5f+width*0.5f,p);
		canvas.drawLine(width*1f/3,height*0.5f-width*0.5f,width*1f/3,height*0.5f+width*0.5f,p);
		canvas.drawLine(width*2f/3,height*0.5f-width*0.5f,width*2f/3,height*0.5f+width*0.5f,p);
//		p.setStrokeWidth(0.5f);
//		for(int i = 0;i<10;i++){
//			canvas.drawLine(width*i/9f,height*0.5f-width*0.5f,width*i/9f,height*0.5f+width*0.5f,p);
//		}
//		for(int i = 0;i<10;i++){
//			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/9,width,height*0.5f+width*0.5f-width*i/9,p);
//		}
		p.setStrokeWidth(0.3f);
		for(int i = 0;i<=48;i++){
			canvas.drawLine(width*i/48,height*0.5f-width*0.5f,width*i/48,height*0.5f+width*0.5f,p);
		}
		for(int i = 0;i<=48;i++){
			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/48,width,height*0.5f+width*0.5f-width*i/48,p);
		}

//		p.setStrokeWidth(0.1f);
//		for(int i = 0;i<81;i++){
//			canvas.drawLine(width*i/81f,height*0.5f-width*0.5f,width*i/81f,height*0.5f+width*0.5f,p);
//		}
//		for(int i = 0;i<81;i++){
//			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/81,width,height*0.5f+width*0.5f-width*i/81,p);
//		}

		p.setStrokeWidth(0.3f);

		canvas.drawLine(0,height/2-width/2, width, height/2+width/2, p);
		canvas.drawLine(0,height/2+width/2, width, height/2-width/2, p);
//		canvas.drawLine(0,height/2, width, height/2, p);
//		canvas.drawLine(width/2,height/2-width/2, width/2, height/2+width/2, p);




	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension((int)(Constant.width), (int)(Constant.width));
//		setMeasuredDimension((int)(width), (int)(width));
	}
	
	public void setAnimation(){
		Animation animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(durationMillis);
		animation.setRepeatCount(-1);
		 LinearInterpolator lir = new LinearInterpolator();    
		 animation.setInterpolator(lir);
		startAnimation(animation);
	}
	

}
