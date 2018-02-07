package spirit.freewill.menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import spirit.freewill.util.Constant;

public class WayAdapter extends BaseAdapter {

	private String[] arrays;

	public WayAdapter(String[] arrays) {
		this.arrays = arrays;
	}

	@Override
	public int getCount() {
		return arrays.length;
	}

	@Override
	public Object getItem(int position) {
		return arrays[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = new TextView(Constant.context);
		textView.setText(arrays[position]);
		return textView;
	}

}
