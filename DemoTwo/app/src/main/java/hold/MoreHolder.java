package hold;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import bawei.demotwo.MoreActivity;
import bawei.demotwo.R;
import bean.BeanOne;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class MoreHolder extends BaseViewHolder{

    private final TextView textView;

    public MoreHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.more);
    }

    @Override
    public void setdata(final Context context, BeanOne.DataBean dataBean) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context, MoreActivity.class);
                context.startActivity(i);
            }
        });
    }
}
