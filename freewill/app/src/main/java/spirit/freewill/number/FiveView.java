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

public class FiveView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 36000;
	public FiveView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public FiveView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public FiveView(Context context) {
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


//		p.setColor(0x40FFFFFF);
		p.setStrokeWidth(0.3f);

		canvas.drawCircle(width*0.5f, height*0.5f, width*0.01f, p);

//		canvas.drawCircle(width*0.5f, height*0.5f, height*0.5f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f, p);

		for (int i = 0; i < 3; i++) {
			canvas.rotate(360f / 6, width / 2, height / 2);
//			canvas.drawLine(width*0.25f,height*0.5f, width*0.75f, height*0.5f, p);
			canvas.drawLine(width*0.3f,height*0.5f-width*0.05f, width*0.7f, height*0.5f+width*0.05f, p);
			canvas.drawLine(width*0.3f,height*0.5f+width*0.05f, width*0.7f, height*0.5f-width*0.05f, p);
			for(int j = 1 ; j < 8;j++){
				if(j == 2  || j == 6){
					canvas.drawCircle(width*0.1f*j+width*0.1f, height*0.5f, width*0.05f, p);
					canvas.drawCircle(width*0.1f*j+width*0.1f, height*0.5f, width*0.04f, p);
					canvas.drawCircle(width*0.1f*j+width*0.1f, height*0.5f, width*0.03f, p);
					canvas.drawCircle(width*0.1f*j+width*0.1f, height*0.5f, width*0.02f, p);
					canvas.drawCircle(width*0.1f*j+width*0.1f, height*0.5f, width*0.01f, p);
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			canvas.drawLine(width*0.5f,height*0.5f, width*0.45f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), p);
			canvas.drawLine(width*0.5f,height*0.5f, width*0.55f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), p);
			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), width*0.05f, p);
			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), width*0.04f, p);
			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), width*0.03f, p);
			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), width*0.02f, p);
			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.2*Math.sqrt(3)), width*0.01f, p);


//			canvas.drawLine(width*0.5f-width*0.1f/3,(float) (height*0.5f+width*0.2*Math.sqrt(3)+width*0.05f), width*0.45f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), p);
//			canvas.drawLine(width*0.5f+width*0.1f/3,(float) (height*0.5f+width*0.2*Math.sqrt(3)+width*0.05f), width*0.55f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), p);
//			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), width*0.05f, p);
//			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), width*0.04f, p);
//			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), width*0.03f, p);
//			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), width*0.02f, p);
//			canvas.drawCircle(width*0.5f, (float) (height*0.5f+width*0.3*Math.sqrt(3)), width*0.01f, p);


			canvas.drawLine(width*0.05f,height*0.5f-width*0.05f, width*0.25f, height*0.5f-width*0.025f, p);
			canvas.drawLine(width*0.05f,height*0.5f+width*0.05f, width*0.25f, height*0.5f+width*0.025f, p);
			canvas.drawCircle(width*0.05f, height*0.5f, width*0.05f, p);
			canvas.drawCircle(width*0.05f, height*0.5f, width*0.04f, p);
			canvas.drawCircle(width*0.05f, height*0.5f, width*0.03f, p);
			canvas.drawCircle(width*0.05f, height*0.5f, width*0.02f, p);
			canvas.drawCircle(width*0.05f, height*0.5f, width*0.01f, p);

			canvas.rotate(360f / 6, width / 2, height / 2);
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
