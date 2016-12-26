package hold;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;
import bawei.demotwo.R;
import bawei.demotwo.WebViewActivity;
import bean.BeanOne;
import utils.CommonUtils;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class ViewPagerViewHolder extends BaseViewHolder{
    List<ImageView> dotList;
    public   ViewPager vp;
    private  LinearLayout ll;
   public  List<BeanOne.DataBean.Ad1Bean> list;
    private  float downx;
    private float downy;
    private  long downTime;

    public ViewPagerViewHolder(View itemView) {
        super(itemView);
        dotList=new ArrayList<>();
        vp =(ViewPager)itemView.findViewById(R.id.holder0_vp);
        ll =(LinearLayout)itemView.findViewById(R.id.holder0_ll);
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
    public void setdata(final Context context, BeanOne.DataBean dataBean) {
        list = dataBean.ad1;
        initdot(context);
        MyPagerAdpter ad=new MyPagerAdpter();
        vp.setAdapter(ad);
        vp.setCurrentItem(1000);
        ad.setOnPagerClickListener(new OnPagerClickListener() {
            @Override
            public void setOnPagerClickListener(int position) {
                Toast.makeText(context, list.get(position%list.size()).ad_type_dynamic_data+"------->"+position,Toast.LENGTH_SHORT).show();
                Intent i=new Intent(context,WebViewActivity.class);
               // i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("url",list.get(position%list.size()).ad_type_dynamic_data);
               context.startActivity(i);

            }
        });
        h.sendEmptyMessageDelayed(0,2000);
    }

 Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int i=vp.getCurrentItem();
        i++;
        vp.setCurrentItem(i);
        h.sendEmptyMessageDelayed(0,2000);
    }
};
    private void initdot(Context context) {
        h.removeCallbacksAndMessages(null);
        ll.removeAllViews();
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
    interface OnPagerClickListener {
        void setOnPagerClickListener(int position);
    }
    public class MyPagerAdpter extends PagerAdapter {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
        OnPagerClickListener onPagerClickListener;
        public void setOnPagerClickListener(OnPagerClickListener onPagerClickListener){
            this.onPagerClickListener=onPagerClickListener;
        }
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = CommonUtils.inflate(R.layout.holder_viewpager_item);
            ImageView img = (ImageView) view.findViewById(R.id.holder0_item_img);
            ImageLoader i = ImageLoader.getInstance();
            i.displayImage(list.get(position % list.size()).image, img, ImageLoaderUtils.initOptions());
            // Glide.with(context).load(list.get(position).image).into(img);
            container.addView(view);
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            h.removeCallbacksAndMessages(null);
                            downx = event.getX();
                            downy = event.getY();
                            downTime = System.currentTimeMillis();
                            break;
                        case MotionEvent.ACTION_UP:
                            float x = event.getX();
                            float y = event.getY();
                            if (x == downx && y == downy && System.currentTimeMillis() - downTime < 2000) {
                                // Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show();
                                //viewpager点击跳转
                                if (onPagerClickListener != null) {
                                    onPagerClickListener.setOnPagerClickListener(position);
                                }
                            }
                            h.sendEmptyMessageDelayed(0, 2000);
                            break;
                        case MotionEvent.ACTION_CANCEL:
                            break;
                    }
                    return true;
                }
            });
            return view;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}



