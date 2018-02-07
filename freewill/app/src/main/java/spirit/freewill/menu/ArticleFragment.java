package spirit.freewill.menu;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import spirit.freewill.R;


public class ArticleFragment extends BaseFragment {

	@Override
	public int setContentView() {
		return R.layout.fragment_article;
	}

	@Override
	public void initView() {
		
		ListView listview = (ListView) inflate.findViewById(R.id.listview);
		listview.setAdapter(new WayAdapter(getResources().getStringArray(R.array.article)));
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String[] stringArray = getResources().getStringArray(R.array.article_content);
				if(position > stringArray.length || TextUtils.isEmpty(stringArray[position])){
					return;
				}
				Intent intent = new Intent(getActivity(), ArticleActivity.class);
				intent.putExtra("index", position);
				startActivity(intent);
			}
		});
//		WebView webview = (WebView) inflate.findViewById(R.id.webview);
//		webview.setWebViewClient(new WebViewClient());
//		webview.loadUrl("http://jilu.yuanwushi.com/");
//		webview.loadUrl("http://yuanwushi.com/forum.php?mobile=1");
		
		
	}

	@Override
	public void initData() {

	}

}
