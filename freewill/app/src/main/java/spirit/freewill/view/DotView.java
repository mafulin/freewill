package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;


public class DotView extends View{

	private float width;
	private float height;
	private long durationMillis;
	private int petals = 6;
	private String  tag = "";

	public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		width = Constant.width*0.125f;
		height = Constant.width*0.125f;
//		setAnimation();
	}
	public DotView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public DotView(Context context) {
		this(context,null);
	}
	
	public DotView(Context context,long durationMillis) {
		this(context);
		this.durationMillis = durationMillis;
		setAnimation();
	}
	
	public DotView(Context context,long durationMillis,int petals) {
		this(context);
		this.durationMillis = durationMillis;
		this.petals = petals;
		setAnimation();
	}
	
	public DotView(Context context,long durationMillis,int petals,String tag) {
		this(context);
		this.durationMillis = durationMillis;
		this.petals = petals;
		this.tag = tag;
		setAnimation();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		
		/********************************************/
		
//		canvas.drawCircle(width*0.5f, width*0.0625f, width*0.0625f, p);
//		canvas.drawCircle(width*0.0625f, width*0.0625f, width*0.0625f, p);
		
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
		
		
		
		
		if(!TextUtils.isEmpty(tag)){
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setStyle(Paint.Style.STROKE);
			paint.setColor(Color.WHITE);
			paint.setTextSize(PXUtil.dip2px(21));
			canvas.drawText(tag,0f, height*2/3, paint);
//			canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f-0.5f, paint);
		}else{
			Paint p = new Paint();
			p.setAntiAlias(true);
			p.setStyle(Paint.Style.STROKE);
			Shader mShader = new RadialGradient(width*0.5f,width*0.5f, width*0.5f,Constant.mGradientColors, null, TileMode.MIRROR) ;
			p.setShader(mShader);
//			p.setColor(Color.WHITE);
			p.setStrokeWidth(1);
			canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f-0.5f, p);
			RectF oval2  = new RectF(width*0.75f-width*0.5f, height*0.5f-width*0.433f-width*0.5f, width*0.75f+width*0.5f, height*0.5f-width*0.433f+width*0.5f) ;
			RectF oval4  = new RectF(width*0.75f-width*0.5f, height*0.5f+width*0.433f-width*0.5f, width*0.75f+width*0.5f, height*0.5f+width*0.433f+width*0.5f) ;
			for (int i = 0; i <petals; i++) {
				canvas.rotate(360f/petals,width/2,height/2);
				canvas.drawArc(oval2, 60, 60, false, p);
				canvas.drawArc(oval4, 240, 60, false, p);
			}
		}
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension((int)(width), (int)(width));
	}
	
	public void setAnimation(){
		Animation animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(durationMillis);
		animation.setRepeatCount(-1);
		 LinearInterpolator lir = new LinearInterpolator();    
		 animation.setInterpolator(lir);
		startAnimation(animation);
	}
	
	private AnimationSet animationSet;
	private AnimationSet animationSet2;
	private Animation animation;
	private void setAnimation2(){
		animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(durationMillis);
		animation.setRepeatCount(-1);
		 LinearInterpolator lir = new LinearInterpolator();    
		 animation.setInterpolator(lir);
		 AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
		 animationSet = new AnimationSet(true);
		 animationSet.addAnimation(animation);
		 if(Constant.ChakraCounts<7){
			 animationSet.addAnimation(alphaAnimation);
			 Constant.ChakraCounts++;
		 }
		 animationSet.setDuration(durationMillis);
		 animationSet.setInterpolator(new LinearInterpolator());
		 animationSet.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				startAnimation(animation);
			}
		});
		startAnimation(animationSet);
		
	}
	public void setPetals(int petals) {
		this.petals = petals;
	}
	
}
