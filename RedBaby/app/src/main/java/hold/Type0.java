package hold;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adpter.Type0PagerAdpter;
import bawei.redbaby.R;
import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type0 extends BaseViewHolder{
    //小集合
    List<ImageView> dotList;
    List<BeanOne.DataBean.TagBean> list;
    private final ViewPager vp;
    private final LinearLayout ll;

    public Type0(View itemView) {
        super(itemView);
        vp =(ViewPager)itemView.findViewById(R.id.type0_vp);
        ll =(LinearLayout)itemView.findViewById(R.id.type0_ll);
        dotList=new ArrayList<>();
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotList.size(); i++) {
                    if (i == position % dotList.size()) {
                        dotList.get(i).setImageResource(R.drawable.dot_true);
                    } else {
                        dotList.get(i).setImageResource(R.drawable.dot_false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
        list=dataBean.tag;
        ll.removeAllViews();
       h.removeCallbacksAndMessages(null);
        //知道集合长度，初始化小圆点
        initdot(context);
        //无线轮播
        vp.setAdapter(new Type0PagerAdpter(list,context));
        vp.setCurrentItem(list.size()*1000);
        h.sendEmptyMessageDelayed(0,2000);
    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int index=vp.getCurrentItem();
        index++;
        vp.setCurrentItem(index);
        h.sendEmptyMessageDelayed(0,2000);
    }
};

    private void initdot(Context context) {
        dotList.clear();
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(context);
            if (i == 0) {
                imageView.setImageResource(R.drawable.
                dot_true);
            } else {
                imageView.setImageResource(R.drawable.dot_false);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6,6);
            params.setMargins(5, 0, 5, 0);
            ll.addView(imageView, params);
            dotList.add(imageView);
        }
    }
}
