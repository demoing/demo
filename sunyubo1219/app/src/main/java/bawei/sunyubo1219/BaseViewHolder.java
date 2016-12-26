package bawei.sunyubo1219;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/19.
 */

public abstract  class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    protected abstract  void setData(Context context,Bean2.ItemsBean itemsBean);
}
