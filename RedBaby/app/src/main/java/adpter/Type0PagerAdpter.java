package adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import bawei.redbaby.R;
import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type0PagerAdpter extends PagerAdapter {
    List<BeanOne.DataBean.TagBean> list;
    Context context;

    public Type0PagerAdpter(List<BeanOne.DataBean.TagBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context,R.layout.view,null);
        ImageView imageView= (ImageView) view.findViewById(R.id.type0_img);
        Glide.with(context).load("http://image1.suning.cn"+list.get(position%list.size()).picUrl).into(imageView);
        container.addView(view);
        return view;
    }
}
