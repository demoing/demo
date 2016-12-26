package com.example.zhiyuan.yunifang.fragment;

import android.view.View;

import com.example.zhiyuan.yunifang.base.BaseFragment;
import com.example.zhiyuan.yunifang.view.ShowingPage;

/**
 * Created by zhiyuan on 16/9/28.
 */
public class CategoryFragment extends BaseFragment {
    @Override
    protected void onLoad() {
        CategoryFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
    }
    @Override
    public View createSuccessView() {
        return null;
    }
}
