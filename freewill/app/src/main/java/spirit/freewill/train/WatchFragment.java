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
import spirit.freewill.util.TimeUtil;
import spirit.freewill.util.TypeUtil;
import spirit.freewill.view.ClockMapView;
import spirit.freewill.view.ClockPerView;


public class WatchFragment extends BaseFragment {
	private RelativeLayout menu;
	private RelativeLayout root;
	private RelativeLayout chart_group;
	private ListView list;
	private ListView list_kind;
	private TextView physiology;
	private TextView silent;
	private TextView action;
	private List<FreewillItem> data = new ArrayList<FreewillItem>();
	private TrainAdapter trainAdapter;
	private KindAdapter kindAdapter;
	private ClockMapView clockper;

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
//		chart_group = (RelativeLayout) findViewById(R.id.chart_group);
		list = (ListView) findViewById(R.id.list);
		list_kind = (ListView) findViewById(R.id.list_kind);
		silent = (TextView) findViewById(R.id.silent);
		action = (TextView) findViewById(R.id.action);
		physiology = (TextView) findViewById(R.id.physiology);
		findViewById(R.id.emotion).setOnClickListener(listener);
		findViewById(R.id.thought).setOnClickListener(listener);
		findViewById(R.id.will).setOnClickListener(listener);
		findViewById(R.id.remember).setOnClickListener(listener);
		findViewById(R.id.wisdom).setOnClickListener(listener);
		findViewById(R.id.peculiarity).setOnClickListener(listener);
		findViewById(R.id.inertia).setOnClickListener(listener);
		findViewById(R.id.all).setOnClickListener(listener);
		silent.setOnClickListener(listener);
		action.setOnClickListener(listener);
		physiology.setOnClickListener(listener);

		trainAdapter = new TrainAdapter(this.getActivity());
//		if(TimeUtil.isyesterday(SPUtil.getLast(Constant.context))){
//			FileUtil.deleteList(Constant.context);
//		}


		clockper = (ClockMapView) findViewById(R.id.clockper);

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
				trainAdapter.setData(data);
//				list.setSelection(trainAdapter.getCount() - 1);
			}
		});
	}




	@Override
	public void initData() {

	}

	@Override
	public void onResume() {
		super.onResume();
		FileUtil.deleteYestodayList(Constant.context);
		data = FileUtil.readlist(Constant.context);
		if(data == null){
			data = new ArrayList<FreewillItem>();
		}
		clockper.setData(data);
		trainAdapter.setData(data);
		list.setAdapter(trainAdapter);
//		list.setSelection(trainAdapter.getCount() - 1);
//		chart_group.post(new Runnable() {
//			@Override
//			public void run() {
//			}
//		});
	}
	public void click(View v){
		FreewillItem freewillItem = new FreewillItem();
		freewillItem.setTime(System.currentTimeMillis());
		freewillItem.setKind(((TextView)v).getText().toString());

		switch (v.getId()){
			case R.id.physiology:
				freewillItem.setType(TypeUtil.PHYSIOLOGY);
				freewillItem.setColor(TypeUtil.PHYSIOLOGY_COLOR);
				break;
			case R.id.emotion:
				freewillItem.setType(TypeUtil.EMOTION);
				freewillItem.setColor(TypeUtil.EMOTION_COLOR);
				break;
			case R.id.thought:
				freewillItem.setType(TypeUtil.THOUGHT);
				freewillItem.setColor(TypeUtil.THOUGHT_COLOR);
				break;
			case R.id.will:
				freewillItem.setType(TypeUtil.WILL);
				freewillItem.setColor(TypeUtil.WILL_COLOR);
				break;
			case R.id.remember:
				freewillItem.setType(TypeUtil.REMEMBER);
				freewillItem.setColor(TypeUtil.REMEMBER_COLOR);
				break;
			case R.id.wisdom:
				freewillItem.setType(TypeUtil.WISDOM);
				freewillItem.setColor(TypeUtil.WISDOM_COLOR);
				break;
			case R.id.peculiarity:
				freewillItem.setType(TypeUtil.PECULIARITY);
				freewillItem.setColor(TypeUtil.PECULIARITY_COLOR);
				break;
			case R.id.inertia:
				freewillItem.setType(TypeUtil.INERTIA);
				freewillItem.setColor(TypeUtil.INERTIA_COLOR);
				break;
			case R.id.silent:
				freewillItem.setType(TypeUtil.SILENT);
				freewillItem.setColor(TypeUtil.SILENT_COLOR);
				break;
			case R.id.action:
				freewillItem.setType(TypeUtil.ACTION);
				freewillItem.setColor(TypeUtil.ACTION_COLOR);
				break;
			case R.id.all:
				freewillItem.setType(TypeUtil.ALL);
				freewillItem.setColor(TypeUtil.ALL_COLOR);
//				freewillItem.setKind("你好，欢迎使用静观助手app");
				break;
		}
		data = FileUtil.addItem(freewillItem);
		clockper.setData(data);
		trainAdapter.setData(data);

	}
	public View.OnClickListener listener = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			click(v);
		}
	};
}
