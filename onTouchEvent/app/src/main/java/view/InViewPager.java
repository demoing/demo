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
public class InViewPager extends ViewPager{
    public InViewPager(Context context) {
        super(context);
    }

    public InViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
       if(this.getChildCount()<=1){
           return super.onTouchEvent(ev);
       }
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                //告诉父类不要拦截
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            //告诉父类拦截
            case MotionEvent.ACTION_UP:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_CANCEL:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        //执行父类原来的逻辑
        super.onTouchEvent(ev);
        return true;
    }
}
