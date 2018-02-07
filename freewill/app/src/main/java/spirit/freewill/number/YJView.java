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

public class YJView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 36000;
	private int petals = 81;
	private String  tag = "";
	private String[] str = {"坤","兑","乾","坎","艮","震","巽","离"};
	public YJView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public YJView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		setAnimation();
	}
	public YJView(Context context) {
		this(context,null);
//		setAnimation();
	}

	public YJView(Context context, long durationMillis, int petals) {
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
			p.setStrokeWidth(1);


//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.49f, p);

//		for (int i = 0; i < 64; i++) {
//			canvas.rotate(360f/(64),width/2,height/2);
//			canvas.drawLine(width*0.5f-width*0.49f,height*0.5f, width*0.5f-width*0.49f+PXUtil.dip2px(6), height*0.5f, p);
//		}
		for (int i = 0; i <(64); i++) {
			p.setColor(Color.WHITE);
			canvas.rotate(360f/(64),width/2,height/2);
				drawbg(canvas,p,i);
		}

	}

	private void drawbg(Canvas canvas,Paint p,int model){
		for(int i = 0; i < 6;i++){
			if(((int)(Math.pow(2,i))  & model) == 0){
				canvas.drawLine(width*0.5f-PXUtil.dip2px(4),height*0.5f+width*0.4f+PXUtil.dip2px(25-2*i), width*0.5f-PXUtil.dip2px(1), height*0.5f+width*0.4f+PXUtil.dip2px(25-2*i), p);
				canvas.drawLine(width*0.5f+PXUtil.dip2px(1),height*0.5f+width*0.4f+PXUtil.dip2px(25-2*i), width*0.5f+PXUtil.dip2px(4), height*0.5f+width*0.4f+PXUtil.dip2px(25-2*i), p);
			}else{
				canvas.drawLine(width*0.5f-PXUtil.dip2px(4),height*0.5f+width*0.4f+PXUtil.dip2px(25-2*i), width*0.5f+PXUtil.dip2px(4), height*0.5f+width*0.4f+PXUtil.dip2px(25-2*i), p);

			}
		}

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension((int)(Constant.width), (int)(Constant.height));
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
