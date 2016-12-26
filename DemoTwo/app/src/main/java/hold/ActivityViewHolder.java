package hold;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import bawei.demotwo.R;
import bean.BeanOne;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class ActivityViewHolder extends BaseViewHolder{


    private List<BeanOne.DataBean.Ad5Bean> ad5;
    private final TextView textView;

    public ActivityViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.holder4_tv);
    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
        textView.setText("- "+"优惠活动"+" -");
    }
}
