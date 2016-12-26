package bawei.shopping;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/2.
 */
public class MyAdpter  extends BaseAdapter{
    Context context;
    List<Bean> list;
    public OnMoneyChangeListener onMoneyChangeListener;
    public MyAdpter(Context context, List<Bean> list,OnMoneyChangeListener onMoneyChangeListener) {
        this.context = context;
        this.list = list;
        this.onMoneyChangeListener=onMoneyChangeListener;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Bean stu=list.get(position);
        final Vh v;
        if(convertView==null){
            v=new Vh();
            convertView=View.inflate(context,R.layout.item,null);
            v.tv1=(TextView)convertView.findViewById(R.id.item_tv1);
            v. tv2=(TextView)convertView.findViewById(R.id.item_tv2);
            v.cb=(CheckBox)convertView.findViewById(R.id.item_cb);

            convertView.setTag(v);
        }else{
            v= (Vh) convertView.getTag();
        }
        v.tv1.setText(stu.getName());
        v.tv2.setText(stu.getPrice()+"");
        v.cb.setChecked(stu.isFlag());
        v.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(v.cb.isChecked()){
                    stu.setFlag(true);
                }else{
                    stu.setFlag(false);
                }
                /*MainActivity mainActivity= (MainActivity) context;
                mainActivity.jiesuan();;*/
               // if(onMoneyChangeListener!=null){
                    onMoneyChangeListener.setMoneyChangeListener();
               // }
            }
        });
        return convertView;
    }
class Vh{
TextView tv1;
    TextView tv2;
    CheckBox cb;
    }

}
