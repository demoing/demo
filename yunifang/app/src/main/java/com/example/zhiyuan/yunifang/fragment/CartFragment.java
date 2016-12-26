package com.example.zhiyuan.yunifang.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.zhiyuan.yunifang.base.BaseFragment;
import com.example.zhiyuan.yunifang.utils.LogUtils;
import com.example.zhiyuan.yunifang.view.ShowingPage;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by zhiyuan on 16/9/28.
 */
public class CartFragment extends BaseFragment {
    private String s;

    @Override
    protected void onLoad() {
        RequestParams re=new RequestParams("http://www.baidu.com");
        //去加载
        x.http().get(re, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                //先赋值---
                CartFragment.this.s=s;
                CartFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                LogUtils.e("AAAAA","success-------cart-"+s);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }
            @Override
            public void onCancelled(CancelledException e) {
            }
            @Override
            public void onFinished() {
            }
        });
    }
    @Override
    public View createSuccessView() {

        LogUtils.e("AAAAA","create-------cart-"+s);
        TextView textView =new TextView(getContext());
        textView.setText(s);
        return textView;
    }
}
