package adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.demotwo.R;
import bean.Goods;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/8.
 */

public class GoodsPagerAdpter extends PagerAdapter {
    List<Goods.DataBean.GoodsBean.GalleryBean> list;
    Context context;

    public GoodsPagerAdpter(List<Goods.DataBean.GoodsBean.GalleryBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context, R.layout.view_show,null);
        ImageView i= (ImageView) view.findViewById(R.id.view_show_img);
        ImageLoader.getInstance().displayImage(list.get(position).normal_url,i, ImageLoaderUtils.initOptions());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
