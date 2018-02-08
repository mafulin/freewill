package spirit.freewill.train;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import spirit.freewill.R;
import spirit.freewill.menu.BaseFragment;
import spirit.freewill.qa.QAFragment;
import spirit.freewill.user.MyFragment;
import spirit.freewill.view.ViewPagerAdapter;
import spirit.freewill.view.ViewPagerTab;


public class TrainFragment extends BaseFragment {
	private RelativeLayout menu;
	private RelativeLayout root;
	@Override
	public int setContentView() {
		return R.layout.fragment_train;
	}

	@Override
	public void initView() {
		root = (RelativeLayout) findViewById(R.id.root);
		menu = (RelativeLayout) findViewById(R.id.menu);

		ArrayList<Fragment> mFragmentList = new ArrayList<>();
		mFragmentList.add(new WatchFragment());
		mFragmentList.add(new ZhongmaiFragment());
		mFragmentList.add(new QAFragment());

		final ViewPager viewPager = (ViewPager) root
				.findViewById(R.id.viewPager);
		viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),
				mFragmentList));

		ViewPagerTab viewPagerTab = (ViewPagerTab) root
				.findViewById(R.id.viewpager_tab);
		viewPagerTab.init(viewPager, new int[]{R.string.jingguan,
				R.string.zhongmai,R.string.mengguan});
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		ViewGroup p = (ViewGroup) inflate.getParent();
		if (p != null) {
			p.removeAllViewsInLayout();
		}
		return inflate;
	}


	@Override
	public void initData() {

	}

	@Override
	public void onResume() {
		super.onResume();
	}
}
