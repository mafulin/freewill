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

public class BGView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 6000;
	private int petals = 81;
	private String  tag = "";
	private String[] str = {"坤","兑","乾","坎","艮","震","巽","离"};
	public BGView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public BGView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
//		setAnimation();
	}
	public BGView(Context context) {
		this(context,null);
//		setAnimation();
	}

	public BGView(Context context, long durationMillis, int petals) {
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


		p.setTextSize(PXUtil.dip2px(20));
		for (int i = 0; i <(8); i++) {
			p.setColor(Color.WHITE);
			canvas.rotate(360f/(8),width/2,height/2);
//			canvas.drawLine(0,height*0.5f, width*0.5f- width*0.15f, height*0.5f, p);
			canvas.drawText(str[i],width*0.5f-PXUtil.dip2px(10),height*0.5f+width*0.25f,p);
			if(i == 0){
				drawbg(canvas,p,0);
			}
			if(i == 1){
				drawbg(canvas,p,3);
			}
			if(i == 2){
				drawbg(canvas,p,7);
			}
			if(i == 3){
				drawbg(canvas,p,2);
			}
			if(i == 4){
				drawbg(canvas,p,4);
			}
			if(i == 5){
				drawbg(canvas,p,1);
			}
			if(i == 6){
				drawbg(canvas,p,6);
			}
			if(i == 7){
				drawbg(canvas,p,5);
			}




//			canvas.drawLine(width*0.5f-PXUtil.dip2px(20),height*0.5f+width*0.30f, width*0.5f+PXUtil.dip2px(20), height*0.5f+width*0.30f, p);
//			canvas.drawLine(width*0.5f-PXUtil.dip2px(20),height*0.5f+width*0.30f+PXUtil.dip2px(10), width*0.5f+PXUtil.dip2px(20), height*0.5f+width*0.30f+PXUtil.dip2px(10), p);
//			canvas.drawLine(width*0.5f-PXUtil.dip2px(20),height*0.5f+width*0.30f+PXUtil.dip2px(20), width*0.5f+PXUtil.dip2px(20), height*0.5f+width*0.30f+PXUtil.dip2px(20), p);
//			if(i == 0){
//				p.setColor(Color.BLACK);
//				canvas.drawLine(width*0.5f-PXUtil.dip2px(2),height*0.5f+width*0.30f, width*0.5f+PXUtil.dip2px(2), height*0.5f+width*0.30f, p);
//				canvas.drawLine(width*0.5f-PXUtil.dip2px(2),height*0.5f+width*0.30f+PXUtil.dip2px(10), width*0.5f+PXUtil.dip2px(2), height*0.5f+width*0.30f+PXUtil.dip2px(10), p);
//				canvas.drawLine(width*0.5f-PXUtil.dip2px(2),height*0.5f+width*0.30f+PXUtil.dip2px(20), width*0.5f+PXUtil.dip2px(2), height*0.5f+width*0.30f+PXUtil.dip2px(20), p);
//
//			}
		}

	}

	private void drawbg(Canvas canvas,Paint p,int model){
		p.setColor(Color.WHITE);

		canvas.drawLine(width*0.5f-PXUtil.dip2px(20),height*0.5f+width*0.30f, width*0.5f+PXUtil.dip2px(20), height*0.5f+width*0.30f, p);
		canvas.drawLine(width*0.5f-PXUtil.dip2px(20),height*0.5f+width*0.30f+PXUtil.dip2px(10), width*0.5f+PXUtil.dip2px(20), height*0.5f+width*0.30f+PXUtil.dip2px(10), p);
		canvas.drawLine(width*0.5f-PXUtil.dip2px(20),height*0.5f+width*0.30f+PXUtil.dip2px(20), width*0.5f+PXUtil.dip2px(20), height*0.5f+width*0.30f+PXUtil.dip2px(20), p);
		p.setColor(Color.BLACK);
		if((model & 1) == 0){
			canvas.drawLine(width*0.5f-PXUtil.dip2px(3),height*0.5f+width*0.30f+PXUtil.dip2px(20), width*0.5f+PXUtil.dip2px(3), height*0.5f+width*0.30f+PXUtil.dip2px(20), p);
		}
		if((model & 2) == 0){
			canvas.drawLine(width*0.5f-PXUtil.dip2px(3),height*0.5f+width*0.30f+PXUtil.dip2px(10), width*0.5f+PXUtil.dip2px(3), height*0.5f+width*0.30f+PXUtil.dip2px(10), p);
		}
		if((model & 4) == 0){
			canvas.drawLine(width*0.5f-PXUtil.dip2px(3),height*0.5f+width*0.30f, width*0.5f+PXUtil.dip2px(3), height*0.5f+width*0.30f, p);
		}

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
