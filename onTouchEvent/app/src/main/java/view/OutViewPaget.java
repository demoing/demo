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
public class OutViewPaget extends ViewPager {
    public OutViewPaget(Context context) {
        super(context);
    }

    public OutViewPaget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
