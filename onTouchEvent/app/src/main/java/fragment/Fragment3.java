package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/28.
 */
public class Fragment3 extends android.support.v4.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView tv=new TextView(getActivity());
        tv.setText("Fragment3");
        return tv;
    }
}
