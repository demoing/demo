package hold;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.demotwo.R;
import bean.BeanOne;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class FourImagviewViewHolder extends BaseViewHolder{
    private final ViewPager vp;
    private List<BeanOne.DataBean.ActivityInfoBean.ActivityInfoListBean> list;

    public FourImagviewViewHolder(View itemView) {
        super(itemView);
        vp = (ViewPager) itemView.findViewById(R.id.holder5_vp);
    }

    @Override
    public void setdata(final Context context, BeanOne.DataBean dataBean) {
        list= dataBean.activityInfo.activityInfoList;
        vp.setOffscreenPageLimit(3);
        vp.setPageMargin(20);

        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Integer.MAX_VALUE;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                 View view=View.inflate(context,R.layout.view,null);
                 ImageView i= (ImageView) view.findViewById(R.id.view_image);
                ImageLoader.getInstance().displayImage(list.get(position%list.size()).activityImg,i, ImageLoaderUtils.initOptions());
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
        vp.setCurrentItem(100);
    }
}
