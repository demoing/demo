package hold;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bean.BeanOne;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder{


    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    abstract  public void setdata(Context context, BeanOne.DataBean dataBean);
}
