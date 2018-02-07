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

public class NineView extends View{

	private float width = Constant.width;
	private float height = Constant.height;
	private long durationMillis = 12000;
	private int petals = 81;
	private String  tag = "";

	public NineView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	public NineView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
		setAnimation();
	}
	public NineView(Context context) {
		this(context,null);
		setAnimation();
	}

	public NineView(Context context,long durationMillis,int petals) {
		this(context);
		this.durationMillis = durationMillis;
		this.petals = petals;
		setAnimation();
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

		for(int j = 1; j < 10 ; j++){

			canvas.drawCircle(width*0.5f, height*0.5f, width*0.5f-(550f - j*60), p);

			for (int i = 0; i <(j*j); i++) {
				canvas.rotate(360f/(j*j),width/2,height/2);
				canvas.drawCircle(550f - j*60, height*0.5f, 4f, p);
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
