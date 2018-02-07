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

import spirit.freewill.util.Constant;

public class TimeView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 6000;
	private int petals = 81;
	private String  tag = "";
	public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public TimeView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public TimeView(Context context) {
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
			p.setStyle(Paint.Style.FILL);
			p.setColor(Color.WHITE);
			p.setStrokeWidth(3);
		int measuredWidth = getMeasuredWidth();
		int measuredHeight = getMeasuredHeight();
		width = measuredWidth;
		height = measuredHeight;
//		setBackgroundColor(Color.parseColor("#44888888"));

		RectF oval0 = new RectF(0, 0, this.width, this.height);
		canvas.drawArc(oval0, 0, 180, true, p);

		p.setColor(Color.BLACK);
		RectF oval1 = new RectF(0, 0, this.width, this.height);
		canvas.drawArc(oval1, 180, 180, true, p);

		p.setColor(Color.WHITE);

		RectF oval4 = new RectF(this.width *0.5f, this.height *0.5f- this.width *0.25f, this.width, this.height *0.5f+this.width *0.25f);
		canvas.drawArc(oval4, 180, 180, true, p);
		canvas.drawLine(width*0.5f,this.height *0.5f,width,height *0.5f,p);

		p.setColor(Color.BLACK);
		RectF oval3 = new RectF(0, this.height *0.5f- this.width *0.25f, this.width *0.5f, this.height *0.5f+this.width *0.25f);
		canvas.drawArc(oval3, 0, 180, true, p);
		canvas.drawLine(0,this.height *0.5f,width*0.5f,height *0.5f,p);
		canvas.drawCircle(this.width *0.5f+ this.width *0.25f, this.height *0.5f, this.width *0.25f/4, p);

		p.setColor(Color.WHITE);
		canvas.drawCircle(this.width *0.5f - this.width *0.25f, this.height *0.5f, this.width *0.25f/4, p);


	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		super.onMeasure(widthMeasureSpec, widthMeasureSpec);
	}
	


}
