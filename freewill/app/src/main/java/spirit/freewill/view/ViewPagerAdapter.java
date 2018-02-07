package spirit.freewill.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Viewpager适配器
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> mFragmentList;

	public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
		super(fm);
		mFragmentList = fragmentList;
	}

	@Override
	public Fragment getItem(int arg0) {
		return mFragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		return mFragmentList.size();
	}

}
