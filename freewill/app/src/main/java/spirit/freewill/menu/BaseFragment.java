package spirit.freewill.menu;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

	protected View inflate;
	private int layoutResID;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setInflate();
		initView();
		initData();
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		ViewGroup parent = (ViewGroup) inflate.getParent();
		if(parent != null)
		parent.removeAllViewsInLayout();
		return inflate;
	}

	public abstract int setContentView();

	public  void setInflate(){
		layoutResID = setContentView();
		inflate = getActivity().getLayoutInflater().inflate(this.layoutResID, null);
	};

	public final View findViewById(@IdRes int id) {
		if (id < 0) {
			return null;
		}
		return inflate.findViewById(id);
	}
	
	public abstract void initView();
	public abstract void initData();
}
