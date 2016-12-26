package adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bawei.sunyubo20161114.R;
import bean.Student;

/**
 * Created by Sunyubo on 2016/11/14.
 */
public class Ad extends BaseAdapter{
    Context context;
    List<Student> list;

    public Ad(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
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
        Student s=list.get(position);
        Vh v;
        if(convertView==null){
            v=new Vh();
            convertView=View.inflate(context, R.layout.item,null);
            v.t=(TextView) convertView.findViewById(R.id.name);
            convertView.setTag(v);
        }else{
            v= (Vh)convertView.getTag();
        }
        v.t.setText(s.name);
        return convertView;
    }
    class Vh{
        TextView t;
    }
}
