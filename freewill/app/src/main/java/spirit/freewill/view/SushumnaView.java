package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import spirit.freewill.util.Constant;


public class SushumnaView extends View{

	private float width;
	private float height;
	private float f;
	private long durationMillis;

	public SushumnaView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		width = Constant.width;
		height = Constant.height;
		f = Constant.f1;
		setAnimation();
	}
	public SushumnaView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public SushumnaView(Context context) {
		this(context,null);
	}
	
	public SushumnaView(Context context,long durationMillis) {
		this(context);
		this.durationMillis = durationMillis;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		setAlpha(0.5f);
		Paint p = new Paint();
		p.setAntiAlias(true);
		p.setStyle(Paint.Style.STROKE);
//		Shader mShader = new RadialGradient(width*0.5f,width*0.5f, width*0.5f,Constant.mGradientColors, null, TileMode.MIRROR) ;
//		p.setShader(mShader);
		p.setColor(Color.WHITE);
		/********************************************/
		p.setStrokeWidth(1);
		canvas.drawLine(width*0.5f-width*f,0, width*0.5f-width*f, height, p);
		canvas.drawLine(width*0.5f+width*f,0, width*0.5f+width*f, height, p);
		canvas.drawLine(width*0.5f,0, width*0.5f, height, p);
		canvas.drawLine(width*0.5f+width*f*0.5f,0, width*0.5f+width*f*0.5f, height, p);
		canvas.drawLine(width*0.5f-width*f*0.5f,0, width*0.5f-width*f*0.5f, height, p);
		canvas.drawLine(width*0.5f+width*f*0.25f,0, width*0.5f+width*f*0.25f, height, p);
		canvas.drawLine(width*0.5f-width*f*0.25f,0, width*0.5f-width*f*0.25f, height, p);
		canvas.drawLine(width*0.5f+width*f*0.75f,0, width*0.5f+width*f*0.75f, height, p);
		canvas.drawLine(width*0.5f-width*f*0.75f,0, width*0.5f-width*f*0.75f, height, p);
	}
	
	private void setAnimation(){
		 
		TranslateAnimation translateAnimation1 = new TranslateAnimation(0f,0f,-Constant.height,Constant.height);
		translateAnimation1.setDuration(7000);//设置动画持续时间 
		translateAnimation1.setRepeatCount(-1);//设置重复次数 
		translateAnimation1.setRepeatMode(Animation.REVERSE);//设置反方向执行 
		startAnimation(translateAnimation1);
		 
	}
	
}
