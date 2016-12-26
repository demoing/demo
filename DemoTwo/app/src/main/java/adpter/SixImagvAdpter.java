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
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/2.
 */
public class SixImagvAdpter extends BaseAdapter {
    List<BeanOne.DataBean.DefaultGoodsListBean> list;
    Context context;

    public SixImagvAdpter(List<BeanOne.DataBean.DefaultGoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        BeanOne.DataBean.DefaultGoodsListBean stu=list.get(position);
        Vh v;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.holder_six_imagview_girdview_item,null);
            v=new Vh();
            v.i=(ImageView)convertView.findViewById(R.id.six_imagview);
            v.tv1=(TextView)convertView.findViewById(R.id.six_tv1);
            v.tv2=(TextView)convertView.findViewById(R.id.six_tv2);
            v.tv3=(TextView)convertView.findViewById(R.id.six_tv3);
            v.tv4=(TextView)convertView.findViewById(R.id.six_tv4);
            convertView.setTag(v);
        }else{
            v= (Vh) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(stu.goods_img,v.i, ImageLoaderUtils.initOptions());
        v.tv1.setText(stu.efficacy);
        v.tv2.setText(stu.goods_name);
        v.tv3.setText("￥"+stu.shop_price+"");
        v.tv4.setText("￥"+stu.market_price+"");

        return convertView;
    }

    class  Vh{
        ImageView i;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
    }
}
