package hold;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
abstract  public class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    abstract  public  void setdata(Context context, BeanOne.DataBean dataBean);
}
