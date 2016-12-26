
package adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import bawei.custum.R;
import bean.Bean;

/**
 * Created by Sunyubo 2016/11/7.
 */

public class MyAdapter extends BaseAdapter {
    private final Context context;
    private final List<Bean.ResultBean.DataBean> data;

    public MyAdapter(Context context, List<Bean.ResultBean.DataBean> data) {

        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Bean.ResultBean.DataBean stu=data.get(i);
        Vh v;
        if (view==null){
            v=new Vh();
            view=View.inflate(context, R.layout.item, null);
            v.textView1= (TextView) view.findViewById(R.id.textView);
            v. textView2= (TextView) view.findViewById(R.id.textView2);
            v.textView3= (TextView) view.findViewById(R.id.textView3);
            v.textView4= (TextView) view.findViewById(R.id.textView4);

            view.setTag(v);
        }else{
           v=(Vh)view.getTag();
        }
        v.textView1.setText(data.get(i).getHashId());
        v.textView2.setText(data.get(i).getContent());
//      textView3.setText(data.get(i).getUnixtime());
        v. textView4.setText(data.get(i).getUpdatetime());
        return view;
    }
    class Vh{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
    }

}
