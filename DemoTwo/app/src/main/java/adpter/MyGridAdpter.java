package adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.demotwo.R;
import bean.BeanOne;
import myinterface.OnItemClickListener;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/1.
 */
public class MyGridAdpter extends BaseAdapter{
    List<BeanOne.DataBean.Ad5Bean> list;
    Context context;


    public MyGridAdpter(List<BeanOne.DataBean.Ad5Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BeanOne.DataBean.Ad5Bean stu=list.get(i);
        Vh v;
        if(view==null){
            view=View.inflate(context,R.layout.holder_grid_item,null);
            v=new Vh();
            v.i=(ImageView)view.findViewById(R.id.holder1_img);
            v.tv=(TextView)view.findViewById(R.id.holder1_tv);
            view.setTag(v);
        }else{
            v= (Vh) view.getTag();
        }
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(stu.image,v.i, ImageLoaderUtils.initOptions());
        v.tv.setText(stu.title);
        return view;
    }
    OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    class Vh{
        ImageView i;
        TextView tv;
    }
}
