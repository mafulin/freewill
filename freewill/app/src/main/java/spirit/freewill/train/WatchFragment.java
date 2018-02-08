package spirit.freewill.train;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.R;
import spirit.freewill.data.ConsciousnKind;
import spirit.freewill.data.FreewillItem;
import spirit.freewill.menu.BaseFragment;
import spirit.freewill.util.Constant;
import spirit.freewill.util.FileUtil;
import spirit.freewill.util.SPUtil;
import spirit.freewill.util.TestUtil;
import spirit.freewill.view.ClockPerView;


public class WatchFragment extends BaseFragment {
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
	private ClockPerView clockper;

	@Override
	public int setContentView() {
		return R.layout.fragment_watch;
	}

	@Override
	public void initView() {
		Log.i("123","WatchFragment--initView--");
//		NotifyUtil.start(Constant.context);
		root = (RelativeLayout) findViewById(R.id.root);
		menu = (RelativeLayout) findViewById(R.id.menu);
		chart_group = (RelativeLayout) findViewById(R.id.chart_group);
		list = (ListView) findViewById(R.id.list);
		list_kind = (ListView) findViewById(R.id.list_kind);
		silent = (TextView) findViewById(R.id.silent);
		action = (TextView) findViewById(R.id.action);
		start_end = (TextView) findViewById(R.id.start_end);
		start_end.setText(SPUtil.getStart_End(Constant.context)?"结束":"开始");
		silent.setOnClickListener(listener);
		action.setOnClickListener(listener);
		start_end.setOnClickListener(listener);

		trainAdapter = new TrainAdapter(this.getActivity());
//		if(TimeUtil.isyesterday(SPUtil.getLast(Constant.context))){
//			FileUtil.deleteList(Constant.context);
//		}
		FileUtil.deleteYestodayList(Constant.context);

		clockper = (ClockPerView) findViewById(R.id.clockper);

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
				data = FileUtil.addItem(new FreewillItem(item.getIndex(), System.currentTimeMillis(),item.getKind(),item.getColor()));
				clockper.setData(data);
			}
		});
	}




	@Override
	public void initData() {

	}

	@Override
	public void onResume() {
		super.onResume();
		data = FileUtil.readlist(Constant.context);
		if(data == null){
			data = new ArrayList<FreewillItem>();
		}
		clockper.setData(data);
		trainAdapter.setData(data);
		list.setAdapter(trainAdapter);
		list.setSelection(trainAdapter.getCount() - 1);
		chart_group.post(new Runnable() {
			@Override
			public void run() {
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
			TestUtil.makeD();
		}
	};
}
