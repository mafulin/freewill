package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import spirit.freewill.util.Constant;


public class CenterView extends View{

	private int width;
	private int height;
	private static int petals = 12;
	private static long duration = 12000;
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			setAlpha(getAlpha()+f);
			Log.i("123", "start="+start);
		}
		
	};
	public CenterView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		width = Constant.width/2;
		height = Constant.width/2;
//		alphaLoop();
		setAnimation();
	}
	
	public CenterView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public CenterView(Context context) {
		this(context,null);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		setAlpha(0.5f);
		Paint p = new Paint();
		p.setAntiAlias(true);
		p.setStyle(Paint.Style.STROKE);
//		p.setColor(Color.rgb(160, 32, 240));
		Shader mShader = new RadialGradient(width*0.5f,height*0.5f, width*0.5f,Constant.mGradientColors, null, TileMode.MIRROR) ;
//		 public RadialGradient(float centerX, float centerY, float radius,
//	               @NonNull int colors[], @Nullable float stops[], @NonNull TileMode tileMode) {
		p.setShader(mShader);
		/*******************************************/
		/********************************************/
		p.setColor(Color.WHITE);
		p.setStrokeWidth(1);
		canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f, p);
//		RectF oval  = new RectF(width*0.25f-width*0.5f, height*0.5f-width*0.433f-width*0.5f, width*0.25f+width*0.5f, height*0.5f-width*0.433f+width*0.5f) ;
//		canvas.drawArc(oval, 0, 120, false, p);
//		RectF oval2  = new RectF(width*0.75f-width*0.5f, height*0.5f-width*0.433f-width*0.5f, width*0.75f+width*0.5f, height*0.5f-width*0.433f+width*0.5f) ;
//		canvas.drawArc(oval2, 60, 120, false, p);
//		RectF oval3  = new RectF(width-width*0.5f, height*0.5f-width*0.5f, width+width*0.5f, height*0.5f+width*0.5f) ;
//		canvas.drawArc(oval3, 120, 120, false, p);
//		RectF oval4  = new RectF(width*0.75f-width*0.5f, height*0.5f+width*0.433f-width*0.5f, width*0.75f+width*0.5f, height*0.5f+width*0.433f+width*0.5f) ;
//		canvas.drawArc(oval4, 180, 120, false, p);
//		RectF oval5  = new RectF(width*0.25f-width*0.5f, height*0.5f+width*0.433f-width*0.5f, width*0.25f+width*0.5f, height*0.5f+width*0.433f+width*0.5f) ;
//		canvas.drawArc(oval5, 240, 120, false, p);
//		RectF oval6  = new RectF(0-width*0.5f, height*0.5f-width*0.5f, 0+width*0.5f, height*0.5f+width*0.5f) ;
//		canvas.drawArc(oval6, 300, 120, false, p);
		
		RectF oval2  = new RectF(width*0.75f-width*0.5f, height*0.5f-width*0.433f-width*0.5f, width*0.75f+width*0.5f, height*0.5f-width*0.433f+width*0.5f) ;
		canvas.drawArc(oval2, 60, 60, false, p);
		RectF oval4  = new RectF(width*0.75f-width*0.5f, height*0.5f+width*0.433f-width*0.5f, width*0.75f+width*0.5f, height*0.5f+width*0.433f+width*0.5f) ;
		canvas.drawArc(oval4, 240, 60, false, p);
		for (int i = 0; i <petals; i++) {
			canvas.rotate(360f/petals,width/2,height/2);
			canvas.drawArc(oval2, 60, 60, false, p);
			canvas.drawArc(oval4, 240, 60, false, p);
		}
		
		
		/**************************************/
//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.433f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.2165f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f-width*0.433f, width*0.067f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f-width*0.2165f, width*0.067f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.067f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.433f, p);
//		canvas.drawLine(0, height*0.5f, width, height*0.5f, p);
//		canvas.drawLine(width*0.5f, 0,width*0.5f, height, p);
		/****************线条***************/
//		canvas.drawLine(0, height*0.5f,width*0.25f, height*0.5f-width*0.433f, p);
//		canvas.drawLine(width*0.25f, height*0.5f-width*0.433f, width*0.75f, height*0.5f-width*0.433f, p);
//		canvas.drawLine(width*0.75f, height*0.5f-width*0.433f,width, height*0.5f,  p);
//		canvas.drawLine(width, height*0.5f, width*0.75f, height*0.5f+width*0.433f, p);
//		canvas.drawLine(width*0.75f, height*0.5f+width*0.433f,width*0.25f,height*0.5f+width*0.433f,p);
//		canvas.drawLine(width*0.25f,height*0.5f+width*0.433f,0, height*0.5f,p);
//		canvas.drawLine(0, height*0.5f,width*0.5f, height*0.5f, p);
//		canvas.drawLine(width*0.25f, height*0.5f-width*0.433f,width*0.5f, height*0.5f, p);
//		canvas.drawLine(width*0.75f, height*0.5f-width*0.433f,width*0.5f, height*0.5f,  p);
//		canvas.drawLine(width, height*0.5f,width*0.5f, height*0.5f, p);
//		canvas.drawLine(width*0.75f, height*0.5f+width*0.433f,width*0.5f, height*0.5f,p);
//		canvas.drawLine(width*0.25f,height*0.5f+width*0.433f,width*0.5f, height*0.5f,p);
		
	}
	
	private float f;
	private int start = 1000;
	private AnimationSet animationSet;
	private AnimationSet animationSet2;
	private Animation animation;
	private void alphaLoop() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(1);
					if(getAlpha()>=1.0){
						f = -0.0001f;
					}else if(getAlpha()<=0){
						f = 0.0001f;
					}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					handler.sendEmptyMessage(1);
				}
			}
		});
		setAlpha(0);
		thread.start();
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension((int)(width), (int)(width));
	}
	
	
	private void setAnimation(){
		animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//		animation.setDuration(duration);
//		animation.setRepeatCount(-1);
//		 LinearInterpolator lir = new LinearInterpolator();    
//		 animation.setInterpolator(lir);
//		 startAnimation(animation);
		ScaleAnimation animation1 =new ScaleAnimation(0.25f, 1f, 0.25f, 1f, 
				 Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); 
		ScaleAnimation animation2 =new ScaleAnimation(1f, 0.25f, 1f, 0.25f, 
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f); 
		 AlphaAnimation alphaAnimation = new AlphaAnimation(0.7f, 0.3f);
		 AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.3f, 0.7f);
		 animationSet = new AnimationSet(true);
		 animationSet.addAnimation(animation);
		 animationSet.addAnimation(animation1);
		 animationSet.addAnimation(alphaAnimation);
		 animationSet.setDuration(duration);
		 animationSet.setInterpolator(new LinearInterpolator());
		 animationSet2 = new AnimationSet(true);
		 animationSet2.addAnimation(animation);
		 animationSet2.addAnimation(animation2);
		 animationSet2.addAnimation(alphaAnimation2);
		 animationSet2.setDuration(duration);
		 animationSet2.setInterpolator(new LinearInterpolator());
//		 animationSet.setRepeatMode(Animation.REVERSE);
		 animationSet.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				startAnimation(animationSet2);
			}
		});
		 animationSet2.setAnimationListener(new AnimationListener() {
			 @Override
			 public void onAnimationStart(Animation animation) {
			 }
			 @Override
			 public void onAnimationRepeat(Animation animation) {
			 }
			 @Override
			 public void onAnimationEnd(Animation animation) {
				 startAnimation(animationSet);
			 }
		 });
		startAnimation(animationSet);
		
	}
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		
//		switch (event.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			float x = event.getX();
//			float y = event.getY();
//			if(0<x & x<Constant.width/4 & 0<y & y<Constant.height/2 ){
//				duration = duration + 1000;
//				if(duration<= 1000){
//					duration = 1000;
//				}
////				animation.setDuration(duration);
//				animationSet.setDuration(duration);
//				animationSet2.setDuration(duration);
//				
//			}
//			else if(Constant.width*3/4<x & x<Constant.width & 0<y & y<Constant.height/2 ){
//				duration = duration - 1000;
//				if(duration<= 1000){
//					duration = 1000;
//				}
////				animation.setDuration(duration);
//				animationSet.setDuration(duration);
//				animationSet2.setDuration(duration);
//			}
//			else if(0<x & x<Constant.width/4 & Constant.height/2<y & y<Constant.height ){
//				petals --;
//			}
//			else if(Constant.width*3/4<x & x<Constant.width & Constant.height/2<y & y<Constant.height ){
//				petals++;
//			}
////			else if(Constant.width*1/4<x & x<Constant.width*3/4){
////				ViewGroup parent = (ViewGroup) getParent();
////				clearAnimation();
////				parent.removeView(this);
////			}
//			if(petals<= 0){
//				petals = 6;
//			}
//			
//			invalidate();
//			break;
//
//		}
//		
//		return false;
//	}
}
