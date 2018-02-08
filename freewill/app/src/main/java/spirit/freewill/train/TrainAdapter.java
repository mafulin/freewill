package spirit.freewill.train;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import spirit.freewill.R;
import spirit.freewill.data.FreewillItem;
import spirit.freewill.util.TimeUtil;
import spirit.freewill.util.TypeUtil;
import spirit.freewill.view.ItemView;

/**
 * Created by mafulin on 2018/1/16.
 */

public class TrainAdapter extends BaseAdapter {

    private List<FreewillItem> list = new ArrayList<FreewillItem>();
    private LayoutInflater mInflater;

    public TrainAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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


            convertView = mInflater.inflate(R.layout.item_freewill, null);
            holder.time = (TextView)convertView.findViewById(R.id.time);
            holder.type = (TextView)convertView.findViewById(R.id.type);
            holder.start_end = (ItemView) convertView.findViewById(R.id.start);
//            holder.middle = convertView.findViewById(R.id.middle);
//            holder.end = convertView.findViewById(R.id.end);
            convertView.setTag(holder);

        }else {

            holder = (ViewHolder)convertView.getTag();
        }
        FreewillItem item = list.get(position);
//        Log.i("123","item--"+item);
//        holder.time.setText(item.getDate());
        holder.time.setText(TimeUtil.getTimeByM(item.getTime()));
        holder.type.setText(item.getKind());
        holder.start_end.setType(item.getType());
        return convertView;
    }
    public final class ViewHolder{
        public TextView time;
        public TextView type;
        public ItemView start_end;
    }

    public void setData(List<FreewillItem> data){
        list = data;
        notifyDataSetChanged();
    }
}
