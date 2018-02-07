package spirit.freewill.view;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import spirit.freewill.R;
import spirit.freewill.view.indicator.PageIndicator;
import spirit.freewill.view.indicator.UnderlinePageIndicator;


/**
 * ViewPager标签的封装类
 * 
 * @author pangfq
 * @date 2014年9月25日 下午4:35:14
 */
public class ViewPagerTab extends RelativeLayout {

	private Context mContext;
	private LinearLayout mTabGroup;

	private TextView[] mTabs;

	private PageIndicator mIndicator;

	private OnTabChangeListener mListener;

	public ViewPagerTab(Context context) {

		this(context, null);

	}

	public ViewPagerTab(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		View view = LayoutInflater.from(context).inflate(
				R.layout.viewpager_tab, this, true);

		mTabGroup = (LinearLayout) view.findViewById(R.id.tab_group);

		mIndicator = (UnderlinePageIndicator) view.findViewById(R.id.indicator);
	}

	// -------------------------自定义方法--------------------------------
	/**
	 * 设置ViewPagerTab的样式
	 * 
	 */
	private void setViewPagerTitleStyle(int page) {
		for (int i = 0; i < mTabs.length; i++) {
			if (i == page) {
				mTabs[i].setTextColor(Color.parseColor("#ffffff"));
				mTabs[i].getPaint().setFakeBoldText(true);
			} else {
				mTabs[i].setTextColor(Color.parseColor("#88ffffff"));
				mTabs[i].getPaint().setFakeBoldText(false);
			}
		}

	}

	private void addTabs(int tabSum) {
		mTabGroup.removeAllViews();
		mTabGroup.setWeightSum(tabSum);
		mTabs = new TextView[tabSum];
		for (int i = 0; i < tabSum; i++) {
			mTabs[i] = new TextView(mContext);
			mTabs[i].setTextSize(13);
			mTabs[i].setGravity(Gravity.CENTER);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			params.weight = 1;

			mTabGroup.addView(mTabs[i], params);

		}
	}

	/**
	 * 设置所依附的ViewPager
	 * 
	 * @param viewPager
	 */
	private void setViewPager(final ViewPager viewPager) {
		mIndicator.setViewPager(viewPager);
		mIndicator.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				setViewPagerTitleStyle(arg0);
				if (mListener != null) {
					mListener.onPageSelected(arg0);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				if (mListener != null) {
					mListener.onPageScrolled(arg0, arg1, arg2);
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				if (mListener != null) {
					mListener.onPageScrollStateChanged(arg0);
				}
			}
		});

		// 给每个Tab设置监听器
		for (int i = 0; i < mTabs.length; i++) {
			final int itemIndex = i;
			mTabs[i].setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					viewPager.setCurrentItem(itemIndex);
				}
			});
		}

	}

	/**
	 * 设置ViewPagerTab标题
	 * 
	 * @param tabTitlesResId
	 */
	private void setTabTitle(int[] tabTitlesResId) {

		if (tabTitlesResId != null && tabTitlesResId.length >= 1
				&& mTabs.length <= tabTitlesResId.length) {
			for (int i = 0; i < tabTitlesResId.length; i++) {
				mTabs[i].setText(mContext.getString(tabTitlesResId[i]));
			}
		}

	}

	/**
	 * 设置ViewPagerTab标题
	 * 
	 * @param tabTitles
	 */
	private void setTabTitle(String[] tabTitles) {

		if (tabTitles != null && tabTitles.length >= 1
				&& mTabs.length <= tabTitles.length) {
			for (int i = 0; i < tabTitles.length; i++) {
				mTabs[i].setText(tabTitles[i]);
			}
		}

	}

	// -------------------------外部接口---------------------------

	public interface OnTabChangeListener {

		void onPageSelected(int arg0);

		void onPageScrolled(int arg0, float arg1, int arg2);

		void onPageScrollStateChanged(int arg0);
	}

	/**
	 * 初始化ViewPagerTab，此方法需在ViewPager设置adapter之后调用
	 * 
	 * @param viewPager
	 *            所依附的ViewPager
	 * @param tabTitles
	 *            tabs的标题字符串
	 */
	public void init(ViewPager viewPager, String[] tabTitles) {
		if (tabTitles != null && tabTitles.length >= 1) {
			// 添加Tab
			addTabs(tabTitles.length);
			// 设置所依附的ViewPager
			setViewPager(viewPager);
			// 设置标题
			setTabTitle(tabTitles);
			// 设置样式
			setViewPagerTitleStyle(0);
		}
	}

	/**
	 * 初始化ViewPagerTab，此方法需在ViewPager设置adapter之后调用
	 * 
	 * @param viewPager
	 *            所依附的ViewPager
	 * @param tabTitlesResId
	 *            tabs的标题resId
	 */
	public void init(ViewPager viewPager, int[] tabTitlesResId) {
		if (tabTitlesResId != null && tabTitlesResId.length >= 1) {
			// 添加Tab
			addTabs(tabTitlesResId.length);
			// 设置所依附的ViewPager
			setViewPager(viewPager);
			// 设置标题
			setTabTitle(tabTitlesResId);
			// 设置样式
			setViewPagerTitleStyle(0);
		}
	}

	/**
	 * 修改ViewPagerTab标题
	 * 
	 * @param index
	 *            tab索引
	 * @param title
	 *            tab标题
	 */
	public void setTabTitle(int index, String title) {

		if (index < mTabs.length && title != null) {
			mTabs[index].setText(title);
		}
	}

	/**
	 * 设置ViewPageTab的监听器
	 */
	public void setOnTabChangeistener(OnTabChangeListener listener) {
		mListener = listener;
	}

}
