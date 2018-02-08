package spirit.freewill.train;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.R;
import spirit.freewill.data.ConsciousnKind;
import spirit.freewill.data.FreewillItem;
import spirit.freewill.menu.BaseFragment;
import spirit.freewill.number.PXUtil;
import spirit.freewill.util.Constant;
import spirit.freewill.util.FileUtil;
import spirit.freewill.util.NotifyUtil;
import spirit.freewill.util.SPUtil;
import spirit.freewill.util.TimeUtil;
import spirit.freewill.util.TypeUtil;


public class JingGuanFragment extends BaseFragment {
	private RelativeLayout menu;
	private RelativeLayout root;
	private RelativeLayout chart_group;
	private ListView list;
	private ListView list_kind;
	private TextView start_end;
	private TextView silent;
	private TextView action;
	private List<FreewillItem> data = new ArrayList<FreewillItem>();
	private TrainAdapter trainAdapter;
	private KindAdapter kindAdapter;
	private PieChart mChart;
	private View clock;

	protected String[] mParties = new String[] {
			"Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
			"Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
			"Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
			"Party Y", "Party Z"
	};
	@Override
	public int setContentView() {
		return R.layout.fragment_jingguan;
	}

	@Override
	public void initView() {
		NotifyUtil.start(Constant.context);
		root = (RelativeLayout) findViewById(R.id.root);
		menu = (RelativeLayout) findViewById(R.id.menu);
		chart_group = (RelativeLayout) findViewById(R.id.chart_group);
		list = (ListView) findViewById(R.id.list);
		list_kind = (ListView) findViewById(R.id.list_kind);
		silent = (TextView) findViewById(R.id.silent);
		action = (TextView) findViewById(R.id.action);
		start_end = (TextView) findViewById(R.id.start_end);
		clock =  findViewById(R.id.clock);
		start_end.setText(SPUtil.getStart_End(Constant.context)?"结束":"开始");
		silent.setOnClickListener(listener);
		action.setOnClickListener(listener);
		start_end.setOnClickListener(listener);

		trainAdapter = new TrainAdapter(this.getActivity());
		if(TimeUtil.isyesterday(SPUtil.getLast(Constant.context))){
//			FileUtil.deleteList(Constant.context);
		}


//		mChart = (PieChart) findViewById(R.id.chart);


		initKind();
	}

	private void initKind() {
		kindAdapter = new KindAdapter();
		list_kind.setAdapter(kindAdapter);
//		list_kind.setAdapter(new KindAdapter(getResources().getStringArray(R.array.kind),getResources().getStringArray(R.array.color)));
		list_kind.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				ConsciousnKind item = (ConsciousnKind) kindAdapter.getItem(position);
				Log.i("123","position--"+position);
				Log.i("123","item--"+item);
				data = FileUtil.addItem(new FreewillItem(item.getIndex(), System.currentTimeMillis(),item.getColor()));
				setData();
			}
		});
	}

	private void initChart() {
		mChart = new PieChart(this.getContext());
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(clock.getMeasuredWidth()-PXUtil.dip2px(10), clock.getMeasuredHeight()-PXUtil.dip2px(10));
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		chart_group.addView(mChart,layoutParams);

		mChart.setUsePercentValues(true);
		mChart.getDescription().setEnabled(false);
//		mChart.setExtraOffsets(5, 5, 5, 5);

		mChart.setDragDecelerationFrictionCoef(0.95f);

//		mChart.setCenterTextTypeface(mTfLight);
//		mChart.setCenterText(generateCenterSpannableText());
		mChart.setDrawCenterText(false);

		mChart.setDrawHoleEnabled(true);
		mChart.setHoleColor(Color.parseColor("#222222"));

		mChart.setTransparentCircleColor(Color.WHITE);
		mChart.setTransparentCircleAlpha(110);

		mChart.setHoleRadius(36f);
		mChart.setTransparentCircleRadius(36f);
		Log.i("123",""+ PXUtil.dip2px(50));
		Log.i("123",""+ PXUtil.px2dip(54));


		mChart.setRotationAngle(270);
		// enable rotation of the chart by touch
		mChart.setRotationEnabled(false);
		mChart.setHighlightPerTapEnabled(true);
//		mChart.setOnChartValueSelectedListener(this);

//		mChart.animateY(0, Easing.EasingOption.Linear);
		// mChart.spin(2000, 0, 360);


		Legend l = mChart.getLegend();
		l.setEnabled(false);
		mChart.setEntryLabelColor(Color.WHITE);
		mChart.setEntryLabelTextSize(12f);
		setData();

	}
	private ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
	private ArrayList<Integer> colors = new ArrayList<Integer>();
	private void setData() {
		entries.clear();
		colors.clear();
		setPies();
//		setColors();
//		ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
//		entries.add(new PieEntry(TimeUtil.beforeseconds(0)));
//		entries.add(new PieEntry(TimeUtil.leftseconds(0)));

		PieDataSet dataSet = new PieDataSet(entries, "颜色对应");

		dataSet.setDrawIcons(false);

		dataSet.setSliceSpace(0.1f);
		dataSet.setSelectionShift(0f);


//		ArrayList<Integer> colors = new ArrayList<Integer>();
//
//		colors.add(Color.GRAY);
//		colors.add(Color.parseColor("#00000000"));
//		ArrayList<Integer> colors = new ArrayList<Integer>();
//
//		for (int c : ColorTemplate.VORDIPLOM_COLORS)
//			colors.add(c);
//
//		for (int c : ColorTemplate.JOYFUL_COLORS)
//			colors.add(c);
//
//		for (int c : ColorTemplate.COLORFUL_COLORS)
//			colors.add(c);
//
//		for (int c : ColorTemplate.LIBERTY_COLORS)
//			colors.add(c);
//
//		for (int c : ColorTemplate.PASTEL_COLORS)
//			colors.add(c);
//
//		colors.add(ColorTemplate.getHoloBlue());

		dataSet.setColors(colors);
//		ArrayList<Integer> colors = setColors();
//
//		dataSet.setColors(colors);

		PieData data = new PieData(dataSet);
		data.setValueFormatter(new PercentFormatter());
//		data.setValueTextSize(11f);
		data.setValueTextColor(Color.TRANSPARENT);
		mChart.setData(data);

		// undo all highlights
		mChart.highlightValues(null);

		mChart.invalidate();
	}

	private ArrayList<PieEntry> setPies() {
//		ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
		Log.i("123","data.size()--"+data.size());
//		if(data.size() > 0){
//			for(int i = 0 ; i < data.size(); i++){
//				if(i == 0){
//					Log.i("123","TimeUtil.beforeseconds(data.get(i).getTime()----"+TimeUtil.beforeseconds(data.get(i).getTime()));
//					entries.add(new PieEntry(TimeUtil.beforeseconds(data.get(i).getTime())));
//					colors.add(Color.GRAY);
//
//				}else{
//					Log.i("123","(data.get(i).getTime() - data.get(i -1).getTime())----"+(data.get(i).getTime() - data.get(i -1).getTime()));
//					Log.i("123","data.get(i-1).getColor()----"+data.get(i-1).getColor());
//
//					entries.add(new PieEntry(data.get(i).getTime() - data.get(i -1).getTime()));
//					colors.add(Color.parseColor(data.get(i-1).getColor()));
//				}
//				if(i == (data.size() -1)){
//					Log.i("123","TimeUtil.leftseconds(data.get(i).getTime())----"+TimeUtil.leftseconds(data.get(i).getTime()));
//
//					entries.add(new PieEntry(TimeUtil.leftseconds(data.get(i).getTime())));
//					colors.add(Color.parseColor("#00000000"));
//				}
//
//			}
//		}else{
//			entries.add(new PieEntry(TimeUtil.beforeseconds(0)));
//			colors.add(Color.GRAY);
//			entries.add(new PieEntry(TimeUtil.leftseconds(0)));
//			colors.add(Color.parseColor("#00000000"));
//		}
//		if(data.size() > 0){
//			entries.add(new PieEntry(TimeUtil.beforeseconds(data.get(0).getTime())/1000f));
//			colors.add(Color.GRAY);
//		}


		for(int i = 1 ; i < data.size(); i++){
//				Log.i("123","(data.get(i).getTime() - data.get(i -1).getTime())----"+(data.get(i).getTime() - data.get(i -1).getTime()));
//				Log.i("123","data.get(i).getTime()-data.get(i-1).getTime()----"+(data.get(i).getTime()-data.get(i-1).getTime()));

				entries.add(new PieEntry((data.get(i).getTime()-data.get(i-1).getTime())/1000f));
				colors.add(Color.parseColor(data.get(i).getColor()));

		}

		Log.i("123","entries--"+entries.size());
		return entries;
	}
	private ArrayList<Integer> setColors() {
		ArrayList<Integer> colors = new ArrayList<Integer>();
		if(data.size() > 0){
			for(int i = 0 ; i < data.size(); i++){
				if(i == 0){
					colors.add(Color.GRAY);
				}else{
					colors.add(Color.parseColor(data.get(i).getColor()));

				}
				if(i == (data.size() -1)){
					colors.add(Color.parseColor("#00000000"));
				}

			}
		}else{
			colors.add(Color.GRAY);
			colors.add(Color.parseColor("#00000000"));
		}
		Log.i("123","colors--"+colors);
		return colors;
	}

	private SpannableString generateCenterSpannableText() {

		SpannableString s = new SpannableString("静观");
		return s;
	}

	@Override
	public void initData() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onResume() {
		super.onResume();
		data = FileUtil.readlist(Constant.context);
		if(data == null){
			data = new ArrayList<FreewillItem>();
		}
		trainAdapter.setData(data);
		list.setAdapter(trainAdapter);
		list.setSelection(trainAdapter.getCount() - 1);
		chart_group.post(new Runnable() {
			@Override
			public void run() {
				initChart();
			}
		});
	}
	public void click(View v){
//		FreewillItem freewillItem = new FreewillItem();
//        freewillItem.setDate(TimeUtil.getNowTimeyyyy_MM_dd_HH_mm_ss());
//		freewillItem.setTime(System.currentTimeMillis());
//		SPUtil.saveLast(Constant.context,System.currentTimeMillis());
//		switch (v.getId()){
//			case R.id.start_end:
//				boolean startend = SPUtil.getStart_End(Constant.context);
//				SPUtil.setStart_End(Constant.context,!startend);
//				start_end.setText(!startend?"结束":"开始");
//				freewillItem.setType(!startend?TypeUtil.TYPE_start:TypeUtil.TYPE_end);
//				break;
//			case R.id.silent:
//				freewillItem.setType(TypeUtil.TYPE_jing);
//				break;
//			case R.id.action:
//				freewillItem.setType(TypeUtil.TYPE_dong);
//				break;
//		}
//		data = FileUtil.readlist(Constant.context);
//		if(data == null){
//			data = new ArrayList<FreewillItem>();
//		}
//		data.add(freewillItem);
//		trainAdapter.setData(data);
//		FileUtil.writeList(Constant.context,data);
//		list.setSelection(trainAdapter.getCount() - 1);
		Log.i("123",""+FileUtil.readlist(Constant.context).size());

	}
	public View.OnClickListener listener = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			click(v);
		}
	};
}
