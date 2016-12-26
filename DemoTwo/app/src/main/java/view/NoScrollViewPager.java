package view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/28.
 */
public class NoScrollViewPager extends ViewPager{

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
     //不消费
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
    //不阻断

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
