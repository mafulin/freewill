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

public class NewView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 6000;
	private int petals = 81;
	private String  tag = "";
	private String[] str = {"坤","兑","乾","坎","艮","震","巽","离"};
	public NewView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public NewView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
//		setAnimation();
	}
	public NewView(Context context) {
		this(context,null);
//		setAnimation();
	}

	public NewView(Context context, long durationMillis, int petals) {
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
			p.setStrokeWidth(0.7f);


		canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f, p);

		canvas.drawLine(0,height*0.5f,width,height*0.5f,p);
		canvas.drawLine(width*0.5f,height*0.5f-width*0.5f,width*0.5f,height*0.5f+width*0.5f,p);

//		canvas.drawLine(0,height*0.5f-width*0.5f,width,height*0.5f+width*0.5f,p);
//		canvas.drawLine(width,height*0.5f-width*0.5f,0,height*0.5f+width*0.5f,p);
//
//		canvas.drawLine(0,height*0.5f-width*0.5f,width,height*0.5f-width*0.5f,p);
//		canvas.drawLine(0,height*0.5f+width*0.5f,width,height*0.5f+width*0.5f,p);
//
//		canvas.drawLine(0,height*0.5f-width*0.5f,0,height*0.5f+width*0.5f,p);
//		canvas.drawLine(width,height*0.5f-width*0.5f,width,height*0.5f+width*0.5f,p);
//
//
//		RectF rect = new RectF(width*0.25f, height*0.5f-width*0.25f, width*0.75f, height*0.5f+width*0.25f);
//
//		canvas.drawRect(rect, p);

	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		setMeasuredDimension((int)(Constant.width), (int)(Constant.height));
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
