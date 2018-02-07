package spirit.freewill.number;

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

public class FourView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 6000;
	private int petals = 81;
	private String  tag = "";
	private String[] str = {"坤","兑","乾","坎","艮","震","巽","离"};
	public FourView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public FourView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
//		setAnimation();
	}
	public FourView(Context context) {
		this(context,null);
//		setAnimation();
	}

	public FourView(Context context, long durationMillis, int petals) {
		this(context);
		this.durationMillis = durationMillis;
		this.petals = petals;
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
			p.setStrokeWidth(1f);


		canvas.drawLine(0,height*0.5f-width*0.5f,width,height*0.5f-width*0.5f,p);
		canvas.drawLine(0,height*0.5f+width*0.5f,width,height*0.5f+width*0.5f,p);
		canvas.drawLine(0,height*0.5f-width*0.5f/3,width,height*0.5f-width*0.5f/3,p);
		canvas.drawLine(0,height*0.5f+width*0.5f/3,width,height*0.5f+width*0.5f/3,p);


		canvas.drawLine(0,height*0.5f-width*0.5f,0,height*0.5f+width*0.5f,p);
		canvas.drawLine(width/3f,height*0.5f-width*0.5f,width/3f,height*0.5f+width*0.5f,p);
		canvas.drawLine(width*2/3f,height*0.5f-width*0.5f,width*2/3f,height*0.5f+width*0.5f,p);
		canvas.drawLine(width,height*0.5f-width*0.5f,width,height*0.5f+width*0.5f,p);
//		p.setColor(0x80FFFFFF);
		p.setStrokeWidth(0.6f);
		for(int i = 0;i<10;i++){
			canvas.drawLine(width*i/9f,height*0.5f-width*0.5f,width*i/9f,height*0.5f+width*0.5f,p);
		}
		for(int i = 0;i<10;i++){
			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/9,width,height*0.5f+width*0.5f-width*i/9,p);
		}
//		p.setColor(0x40FFFFFF);
		p.setStrokeWidth(0.3f);
		for(int i = 0;i<27;i++){
			canvas.drawLine(width*i/27f,height*0.5f-width*0.5f,width*i/27f,height*0.5f+width*0.5f,p);
		}
		for(int i = 0;i<27;i++){
			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/27,width,height*0.5f+width*0.5f-width*i/27,p);
		}

//		p.setColor(0x10FFFFFF);
		p.setStrokeWidth(0.1f);
		for(int i = 0;i<81;i++){
			canvas.drawLine(width*i/81f,height*0.5f-width*0.5f,width*i/81f,height*0.5f+width*0.5f,p);
		}
		for(int i = 0;i<81;i++){
			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/81,width,height*0.5f+width*0.5f-width*i/81,p);
		}
//		p.setStrokeWidth(0.05f);
//		for(int i = 0;i<243;i++){
//			canvas.drawLine(width*i/243f,height*0.5f-width*0.5f,width*i/243f,height*0.5f+width*0.5f,p);
//		}
//		for(int i = 0;i<243;i++){
//			canvas.drawLine(0,height*0.5f+width*0.5f-width*i/243f,width,height*0.5f+width*0.5f-width*i/243f,p);
//		}

//		p.setColor(0x80FFFFFF);
//		RectF oval1  = new RectF(width/3, height*0.5f+width*0.5f-width/6, width*2/3, height*0.5f+width*0.5f+width/6) ;
//		canvas.drawArc(oval1, 0, 180, false, p);

	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension((int)(Constant.width), (int)(Constant.height));
//		setMeasuredDimension((int)(width), (int)(width));
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
