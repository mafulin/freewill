package spirit.freewill.train;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.R;
import spirit.freewill.data.ConsciousnKind;
import spirit.freewill.data.FreewillItem;
import spirit.freewill.util.Constant;
import spirit.freewill.util.FileUtil;
import spirit.freewill.util.TimeUtil;
import spirit.freewill.util.TypeUtil;
import spirit.freewill.view.ItemView;

/**
 * Created by mafulin on 2018/1/16.
 */

public class KindAdapter extends BaseAdapter {

    private LayoutInflater mInflater;

    private String[] arrays;
    private String[] colors;
    private List<ConsciousnKind>  consciousnKinds;
    public KindAdapter(String[] arrays,String[] colors) {
        this.arrays = arrays;
        this.colors = colors;
        mInflater = LayoutInflater.from(Constant.context);
    }
    public KindAdapter() {
        consciousnKinds = FileUtil.readKindlist(Constant.context);
        mInflater = LayoutInflater.from(Constant.context);
    }

    public KindAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
//        return arrays.length;
        return consciousnKinds.size();
    }

    @Override
    public Object getItem(int position) {
        return consciousnKinds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {

            holder=new ViewHolder();


            convertView = mInflater.inflate(R.layout.item_kind, null);
            holder.color = convertView.findViewById(R.id.color);
            holder.kind = (TextView)convertView.findViewById(R.id.kind);
            convertView.setTag(holder);

        }else {

            holder = (ViewHolder)convertView.getTag();
        }
//        Log.i("123","item--"+item);
//        holder.time.setText(item.getDate());

//        holder.color.setBackgroundColor(Color.parseColor(colors[position]));
//        holder.kind.setText(arrays[position]);
        holder.color.setBackgroundColor(Color.parseColor(consciousnKinds.get(position).getColor()));
        holder.kind.setText(consciousnKinds.get(position).getKind());
        return convertView;
    }
    public final class ViewHolder{
        public View color;
        public TextView kind;
    }

}
