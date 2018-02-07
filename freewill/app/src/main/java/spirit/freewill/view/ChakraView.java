package spirit.freewill.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import spirit.freewill.util.Constant;


public class ChakraView extends View{

	private int width;
	private int height;
	private float f;

	public ChakraView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		width = Constant.width;
		height = Constant.height;
		f = Constant.f1;
	}
	public ChakraView(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}
	public ChakraView(Context context) {
		this(context,null);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	Paint p = new Paint();
		p.setAntiAlias(true);
		p.setStyle(Paint.Style.STROKE);
		int[] mGradientColors = { Color.RED, Color.rgb(255, 165, 0),
				Color.YELLOW, Color.GREEN, Color.BLUE,
				Color.rgb(160, 32, 240) };
//		Shader mShader = new LinearGradient(0, 0, 100, 100, 
//				mGradientColors, 
//				null, TileMode.REPEAT);
//		p.setShader(mShader);
//		Shader mShader = new RadialGradient(width*0.5f,height*0.5f, height*0.5f,Constant.mGradientColors, null, TileMode.MIRROR) ;
//		p.setShader(mShader);
		p.setColor(Color.WHITE);
		p.setStrokeWidth(1);
//		canvas.drawCircle(width*0.5f, height*0.5f, width*0.75f, p);//
		/*******************丹田*************************/
		canvas.drawCircle(width*0.5f, height*0.5f, width*0.25f, p);//
		canvas.drawCircle(width*0.5f, height*0.5f-width*0.5f, width*0.25f, p);//
		canvas.drawCircle(width*0.5f, height*0.5f+width*0.5f, width*0.25f, p);//
		/******************七轮****************************/
//		canvas.drawCircle(width*0.5f, height*0.5f, width*f, p);//
//		canvas.drawCircle(width*0.5f, height*0.5f+width*0.25f, width*f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f+width*0.5f, width*f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f+width*0.75f, width*f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f-width*0.25f, width*f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f-width*0.5f, width*f, p);
//		canvas.drawCircle(width*0.5f, height*0.5f-width*0.75f, width*f, p);
		/****************中脉，任督***************/
		canvas.drawLine(width*0.25f, height*0.5f-width*0.5f, width*0.25f, height*0.5f+width*0.5f, p);
		canvas.drawLine(width*0.75f, height*0.5f-width*0.5f, width*0.75f, height*0.5f+width*0.5f, p);
		canvas.drawLine(width*0.5f-width*f,height*0.5f-width*0.75f, width*0.5f-width*f, height*0.5f+width*0.75f, p);
		canvas.drawLine(width*0.5f+width*f,height*0.5f-width*0.75f, width*0.5f+width*f, height*0.5f+width*0.75f, p);
		
		
		/***************中脉上下口****************/
		float r = (width*width*193/128+height*height/2-3*height*width/2)/(2*height-3*width);
		double sin = (width*7/16)/r;
		double asin = Math.asin(sin);
		float degree = (float) (asin/Math.PI*180);
		
		RectF ovaltl  = new RectF(-r, 0, r, r*2) ;
//		canvas.drawArc(ovaltl, 270, degree, false, p);
		RectF ovaltr  = new RectF(width-r, 0, width+r, r*2) ;
//		canvas.drawArc(ovaltr, 270-degree, degree, false, p);
		RectF ovalbl  = new RectF(-r, height-r*2, r, height) ;
//		canvas.drawArc(ovalbl,90-degree, degree, false, p);
		RectF ovalbr  = new RectF(width-r, height-r*2, width+r, height) ;
//		canvas.drawArc(ovalbr, 90, degree, false, p);
		/***********************************************************************************/
//		r = (width*width*49/1024+height*height/4-3*height*width/4+width*width*9/16)/(height-3*width/2);
//		sin = (width*7/32)/r;
//		asin = Math.asin(sin);
//		degree = (float) (asin/Math.PI*180);
//		
//		ovaltl  = new RectF(width*7/32-r, 0, width*7/32+r, r*2) ;
//		canvas.drawArc(ovaltl, 270, degree, false, p);
//		ovaltr  = new RectF(width-r-width*7/32, 0, width-width*7/32+r, r*2) ;
//		canvas.drawArc(ovaltr, 270-degree, degree, false, p);
//		ovalbl  = new RectF(width*7/32-r, height-r*2, width*7/32+r,height) ;
//		canvas.drawArc(ovalbl, 90-degree, degree, false, p);
//		ovalbr  = new RectF(width-r-width*7/32, height-r*2, width-width*7/32+r, height) ;
//		canvas.drawArc(ovalbr, 90, degree, false, p);
//		/***********************************************************************************/
//		ovaltl  = new RectF(0, height*0.5f-width*0.75f-(width*0.5f-width*f)/2, width*0.5f-width*f, height*0.5f-width*0.75f+(width*0.5f-width*f)/2) ;
//		canvas.drawArc(ovaltl, 270, 90, false, p);
//		ovaltr  = new RectF(width*0.5f+width*f, height*0.5f-width*0.75f-(width*0.5f-width*f)/2, width, height*0.5f-width*0.75f+(width*0.5f-width*f)/2) ;
//		canvas.drawArc(ovaltr, 180, 90, false, p);
//		ovalbl  = new RectF(0, height*0.5f+width*0.75f-(width*0.5f-width*f)/2, width*0.5f-width*f, height*0.5f+width*0.75f+(width*0.5f-width*f)/2) ;
//		canvas.drawArc(ovalbl, 0, 90, false, p);
//		ovalbr  = new RectF(width*0.5f+width*f, height*0.5f+width*0.75f-(width*0.5f-width*f)/2, width, height*0.5f+width*0.75f+(width*0.5f-width*f)/2) ;
//		canvas.drawArc(ovalbr, 90, 90, false, p);
		/**********************************************************************************/
		
//		RectF ovalt  = new RectF(0, height*0.5f-width*0.75f, width, height*0.5f+width*0.25f) ;
//		canvas.drawArc(ovalt, 180, 180, false, p);
//		RectF ovalb  = new RectF(0, height*0.5f-width*0.25f, width, height*0.5f+width*0.75f) ;
//		canvas.drawArc(ovalb, 0, 180, false, p);
//		canvas.drawLine(0.5f,height*0.5f-width*0.25f,0.5f,  height*0.5f+width*0.25f, p);
//		canvas.drawLine(width-0.5f, height*0.5f-width*0.25f,width-0.5f, height*0.5f+width*0.25f, p);
//		p.setAlpha(50);
//		
//		RectF ovall  = new RectF(width*0.5f-width*0.125f, height*0.5f+width*0.5f, width*0.5f+width*0.125f, height*0.5f+width*0.75f) ;
//		canvas.drawArc(ovall, 90, 90, false, p);
//		RectF ovalr  = new RectF(width*0.5f-width*0.125f, height*0.5f+width*0.25f, width*0.5f+width*0.125f, height*0.5f+width*0.5f) ;
//		canvas.drawArc(ovalr, 0, 90, false, p);
//		RectF ovallr  = new RectF(width*0.5f-width*0.125f, height*0.5f-width*0.5f, width*0.5f+width*0.125f, height*0.5f-width*0.25f) ;
//		canvas.drawArc(ovallr, 180, 180, false, p);
//		canvas.drawLine(width*0.5f-width*0.125f,height*0.5f-width*0.375f, width*0.5f-width*0.125f, height*0.5f+width*0.625f, p);
//		canvas.drawLine(width*0.5f+width*0.125f,height*0.5f-width*0.375f, width*0.5f+width*0.125f, height*0.5f+width*0.375f, p);
		
		
	}
}
