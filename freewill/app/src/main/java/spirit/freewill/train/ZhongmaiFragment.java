package spirit.freewill.train;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import spirit.freewill.R;
import spirit.freewill.menu.BaseFragment;
import spirit.freewill.util.Constant;
import spirit.freewill.view.CenterView;
import spirit.freewill.view.ChakraView;
import spirit.freewill.view.DotView;
import spirit.freewill.view.SushumnaView;


public class ZhongmaiFragment extends BaseFragment {
	private static int[] petals =  {6,6,6,6,6,6,6};
	private CenterView centerView;
	private Animation animation2;
	private Animation animation1;
	private RelativeLayout root;
	private SushumnaView sushumnaView;
//	private ExplainView explainView;
//	private EnergyView energyView;
	private ChakraView view7;
	private DotView chakra1;
	private DotView chakra2;
	private DotView chakra3;
	private DotView chakra4;
	private DotView chakra5;
	private DotView chakra6;
	private DotView chakra7;
	private CenterView centerViewb;
	private CenterView centerViewt;
	private RelativeLayout menu;
	
	@Override
	public int setContentView() {
		return R.layout.activity_zhongmai;
	}

	@Override
	public void initView() {
		root = (RelativeLayout) inflate.findViewById(R.id.root);
		menu = (RelativeLayout) inflate.findViewById(R.id.menu);

	}

	@Override
	public void initData() {

	}

	public void Chakra(){
		addChakra1();
		addChakra2();
		addChakra3();
		addChakra4();
		addChakra5();
		addChakra6();
		addChakra7();
	}
	public void addChakra1(){
		chakra1 = new  DotView(getActivity(),6000,petals[0]);
		root.addView(chakra1);//
		MarginLayoutParams margin7=new MarginLayoutParams(chakra1.getLayoutParams()); 
		  margin7.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+Constant.width*0.75f),
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin7.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+Constant.width*0.75f)); 
		  RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(margin7); 
		  chakra1.setLayoutParams(layoutParams7); 
		  chakra1.setOnClickListener(new OnClickListener() {
			  
			  @Override
			  public void onClick(View v) {
				  change7chakra();
			  }
		  });
	}
	public void addChakra2(){
		chakra2 = new  DotView(getActivity(),6000,petals[1]);
		root.addView(chakra2);//
		MarginLayoutParams margin5=new MarginLayoutParams(chakra2.getLayoutParams()); 
		  margin5.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+Constant.width*0.5f), 
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin5.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+Constant.width*0.5f)); 
		  RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(margin5); 
		  chakra2.setLayoutParams(layoutParams5); 
		  chakra2.setOnClickListener(new OnClickListener() {
			  
			  @Override
			  public void onClick(View v) {
					changeCenterView();
					changeCenterBottomView();
					changeCenterTopView();
			  }
		  });
	}
	public void addChakra3(){
		chakra3 = new  DotView(getActivity(),6000,petals[2]);
		root.addView(chakra3);//
		MarginLayoutParams margin3=new MarginLayoutParams(chakra3.getLayoutParams()); 
		  margin3.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+Constant.width*0.25f), 
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin3.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+Constant.width*0.25f+margin3.height)); 
		  RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(margin3); 
		  chakra3.setLayoutParams(layoutParams3); 
		  chakra3.setOnClickListener(new OnClickListener() {
			  
			  @Override
			  public void onClick(View v) {
//				  changeEnergyView();
				  changeChakraView();
//				  changeExplainView();
			  }
		  });
	}
	public void addChakra4(){
		chakra4 = new  DotView(getActivity(),6000,petals[3]);
		root.addView(chakra4);//
		MarginLayoutParams margin1=new MarginLayoutParams(chakra4.getLayoutParams()); 
		  margin1.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f), 
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin1.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f+margin1.height)); 
		  RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(margin1); 
		  chakra4.setLayoutParams(layoutParams1); 
		  chakra4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
//					showMenu();
				}
			});
	}
	public void addChakra5(){
		chakra5 = new  DotView(getActivity(),6000,petals[4]);
		root.addView(chakra5);//
		 MarginLayoutParams margin2=new MarginLayoutParams(chakra5.getLayoutParams()); 
		  margin2.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f-Constant.width*0.25f), 
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin2.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f-Constant.width*0.25f+margin2.height)); 
		  RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(margin2); 
		  chakra5.setLayoutParams(layoutParams2); 
		  chakra5.setOnClickListener(new OnClickListener() {
			  

				@Override
				  public void onClick(View v) {
//						toMenu();
				  }
			  });
	}
	public void addChakra6(){
		chakra6 = new  DotView(getActivity(),6000,petals[5]);
		root.addView(chakra6);//
		MarginLayoutParams margin4=new MarginLayoutParams(chakra6.getLayoutParams()); 
		  margin4.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f-Constant.width*0.5f), 
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin4.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f-Constant.width*0.5f)); 
		  RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(margin4); 
		  chakra6.setLayoutParams(layoutParams4); 
		  chakra6.setOnClickListener(new OnClickListener() {
			  
			  @Override
			  public void onClick(View v) {
				 changeAllView();
			  }
		  });
	}
	public void addChakra7(){
		chakra7 = new  DotView(getActivity(),6000,petals[6]);
		root.addView(chakra7);//
		MarginLayoutParams margin6=new MarginLayoutParams(chakra7.getLayoutParams()); 
		  margin6.setMargins((int)(Constant.width*0.5f-Constant.width*0.0625f),
				  (int)(Constant.height*0.5f-Constant.width*0.0625f-Constant.width*0.75f), 
				  (int)(Constant.width*0.5f-Constant.width*0.0625f+margin6.width), 
				  (int)(Constant.height*0.5f-Constant.width*0.0625f-Constant.width*0.75f)); 
		  RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(margin6); 
		  chakra7.setLayoutParams(layoutParams6); 
		  chakra7.setOnClickListener(new OnClickListener() {
			  
			  @Override
			  public void onClick(View v) {
				  changeSushumnaView();
			  }
		  });
	}
	public void change7chakra(){
		if(petals[6] == 6){
			  petals = new int[]{6,9,12,15,18,21,24};
		  }else{
			  petals = new int[]{6,6,6,6,6,6,6};
		  }
		  
		  chakra1.setPetals(petals[0]);
		  chakra1.invalidate();
		  chakra2.setPetals(petals[1]);
		  chakra2.invalidate();
		  chakra3.setPetals(petals[2]);
		  chakra3.invalidate();
		  chakra4.setPetals(petals[3]);
		  chakra4.invalidate();
		  chakra5.setPetals(petals[4]);
		  chakra5.invalidate();
		  chakra6.setPetals(petals[5]);
		  chakra6.invalidate();
		  chakra7.setPetals(petals[6]);
		  chakra7.invalidate();
	} 
	public void changeCenterView(){
		if(root.indexOfChild(centerView) == -1){
			centerView = new CenterView(getActivity());
			root.addView(centerView);//
			MarginLayoutParams margin=new MarginLayoutParams(centerView.getLayoutParams()); 
			margin.setMargins((int)(Constant.width*0.25f),
					  (int)(Constant.height*0.5f-Constant.width*0.25f), 
					  (int)(Constant.width*0.75f), 
					  (int)(Constant.height*0.5f+Constant.width*0.25f)); 
			  RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin); 
			  centerView.setLayoutParams(layoutParams); 
		}else{
			centerView.clearAnimation();
			root.removeView(centerView);
			centerView = null;
		}
	} 
	public void changeCenterBottomView(){
		if(root.indexOfChild(centerViewb) == -1){
			centerViewb = new CenterView(getActivity());
			root.addView(centerViewb);//
			MarginLayoutParams margin=new MarginLayoutParams(centerViewb.getLayoutParams()); 
			margin.setMargins((int)(Constant.width*0.25f),
					  (int)(Constant.height*0.5f+Constant.width*0.25f), 
					  (int)(Constant.width*0.75f), 
					  (int)(Constant.height*0.5f+Constant.width*0.75f)); 
			  RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin); 
			  centerViewb.setLayoutParams(layoutParams); 
		}else{
			centerViewb.clearAnimation();
			root.removeView(centerViewb);
			centerViewb = null;
		}
	} 
	public void changeCenterTopView(){
		if(root.indexOfChild(centerViewt) == -1){
			centerViewt = new CenterView(getActivity());
			root.addView(centerViewt);//
			MarginLayoutParams margin=new MarginLayoutParams(centerViewt.getLayoutParams()); 
			margin.setMargins((int)(Constant.width*0.25f),
					  (int)(Constant.height*0.5f-Constant.width*0.75f), 
					  (int)(Constant.width*0.75f), 
					  (int)(Constant.height*0.5f-Constant.width*0.25f)); 
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin); 
			centerViewt.setLayoutParams(layoutParams); 
		}else{
			centerViewt.clearAnimation();
			root.removeView(centerViewt);
			centerViewt = null;
		}
	} 
	
	public void changeChakraView(){
		if(root.indexOfChild(view7) == -1){
			  view7 = new ChakraView(getActivity());
			  root.addView(view7);//
		  }else{
			  view7.clearAnimation();
			  root.removeView(view7);
			  view7 = null;
		  }
	} 
	

	public void changeAllView(){
		 if(root.getChildCount() == 7){
			 showAllView();
		  }else{
			  cleanViews();
			  petals = new int[]{6,6,6,6,6,6,6};
			  Chakra();
		  }
	} 
	
	public void changeSushumnaView(){
		if(root.indexOfChild(sushumnaView) == -1){
			  sushumnaView = new SushumnaView(getActivity());
			  root.addView(sushumnaView);//
		  }else{
			  sushumnaView.clearAnimation();
			  root.removeView(sushumnaView);
			  sushumnaView = null;
		  }
	} 
	
	public void cleanViews(){
		if(root.getChildCount() <= 0){
			  return;
		  }
		  for (int i = 0; i < root.getChildCount(); i++) {
			  View childAt = root.getChildAt(i);
			  childAt.clearAnimation();
		}
		  root.removeAllViews();
	} 
	public void showAllView(){
		cleanViews();
		petals = new int[]{6,6,6,6,6,6,6};
		Chakra();
		changeChakraView();
		change7chakra();
		changeCenterView();
		changeCenterBottomView();
		changeCenterTopView();
		changeEnergyView();
//		changeExplainView();
		changeSushumnaView();
	}
	
	public void changeEnergyView(){
//		if(root.indexOfChild(energyView) == -1){
//			  energyView = new EnergyView(getActivity());
//			  root.addView(energyView);//
//		  }else{
//			  energyView.clearAnimation();
//			  root.removeView(energyView);
//			  energyView = null;
//		  }
	}
	
	@Override
	public void onPause() {
		super.onPause();
		cleanViews();
	}

	@Override
	public void onResume() {
		super.onResume();
		showAllView();
		Log.i("123","root--"+root.getWidth());
		Log.i("123","root--"+root.getHeight());
	}

	private void init() {
		root = (RelativeLayout) inflate.findViewById(R.id.root);
		menu = (RelativeLayout) inflate.findViewById(R.id.menu);
		Chakra();
	}
}
