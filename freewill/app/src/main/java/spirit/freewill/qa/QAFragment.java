package spirit.freewill.qa;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;

import spirit.freewill.R;
import spirit.freewill.about.AboutActivity;
import spirit.freewill.menu.BaseFragment;
import spirit.freewill.webview.BrowserActivity;
import spirit.freewill.webview.SonicJavaScriptInterface;


public class QAFragment extends BaseFragment {

	@Override
	public int setContentView() {
		return R.layout.fragment_qa;
	}

	@Override
	public void initView() {
		findViewById(R.id.t1).setOnClickListener(listener);
		findViewById(R.id.t2).setOnClickListener(listener);
		findViewById(R.id.t3).setOnClickListener(listener);
		findViewById(R.id.t4).setOnClickListener(listener);
		findViewById(R.id.t5).setOnClickListener(listener);
		findViewById(R.id.t6).setOnClickListener(listener);

	}

	@Override
	public void initData() {

	}
	private String url ;
	public void click(View v){

		if(v.getId() == R.id.t6){
			Intent intent = new Intent(getActivity(), AboutActivity.class);
			startActivity(intent);
			return;
		}

		switch (v.getId()){
			case R.id.t1:
				url = "http://blog.sina.com.cn/1ness";
//				url = "https://www.baidu.com/";
				break;
			case R.id.t2:
				url = "https://weibo.com/1ness";
				break;
			case R.id.t3:
				url = "http://yuanwushi.com/forum.php?mod=guide&view=new&mobile=2";
				break;
			case R.id.t4:
				url = "http://www.xuelingxiu.com/";
				break;
			case R.id.t5:
				url = "https://tieba.baidu.com/f?kw=%E5%85%83%E5%90%BE%E6%B0%8F&ie=utf-8";
				break;
			case R.id.t6:

				break;
		}
//		Intent intent = new Intent(getActivity(), WebViewActivity.class);
//		intent.putExtra("url",url);
//		startActivity(intent);

		Intent intent = new Intent(getActivity(), BrowserActivity.class);
		intent.putExtra(BrowserActivity.PARAM_URL, url);
		intent.putExtra(BrowserActivity.PARAM_MODE, BrowserActivity.MODE_DEFAULT);
		intent.putExtra(SonicJavaScriptInterface.PARAM_CLICK_TIME, System.currentTimeMillis());
		startActivity(intent);
	}
	public View.OnClickListener listener = new View.OnClickListener(){

		@Override
		public void onClick(View v) {
			click(v);
		}
	};
}
