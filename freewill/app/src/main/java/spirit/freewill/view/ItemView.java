package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import spirit.freewill.main.FreewillActivity;
import spirit.freewill.util.Constant;
import spirit.freewill.util.TypeUtil;

public class ItemView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 6000;
	private int type = 0;
	private String  tag = "";
	public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public ItemView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
//		setAnimation();
	}
	public ItemView(Context context) {
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
			p.setStrokeWidth(3);
		int measuredWidth = getMeasuredWidth();
		int measuredHeight = getMeasuredHeight();
		width = measuredWidth;
		height = measuredHeight;

//		switch (type){
//			case TypeUtil.TYPE_start:
//				canvas.drawLine(this.width*0.5f, this.height *0.5f, this.width *0.5f,this.height, p);
//				canvas.drawLine(this.width*0.5f, this.height *0.5f, this.width,this.height *0.5f, p);
//				break;
//			case TypeUtil.TYPE_end:
//				canvas.drawLine(this.width*0.5f, this.height *0.5f, this.width *0.5f,0, p);
//				canvas.drawLine(this.width*0.5f, this.height *0.5f, this.width,this.height *0.5f, p);
//				break;
//			default:
//				canvas.drawLine(this.width/2, 0, this.width *0.5f,this.height, p);
//				canvas.drawLine(this.width*0.5f, this.height *0.5f, this.width,this.height *0.5f, p);
//				break;
//		}



	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		Log.i("123","width/2-"+width/2);
//		setMeasuredDimension((int)(Constant.width/2), (int)(Constant.width/2));
//		setMeasuredDimension((int)(width), (int)(height));
	}
	
	public void setAnimation(){
		Animation animation = new RotateAnimation(0f, -360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(durationMillis);
		animation.setRepeatCount(-1);
		 LinearInterpolator lir = new LinearInterpolator();    
		 animation.setInterpolator(lir);
		startAnimation(animation);
	}

	public void setType(int type){
		this.type = type;
		invalidate();
	}
	

}
