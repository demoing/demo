package hold;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import adpter.RAd;
import bawei.redbaby.R;
import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type7 extends BaseViewHolder{


    private final RecyclerView r;

    public Type7(View itemView) {
        super(itemView);
        r =(RecyclerView)itemView.findViewById(R.id.type7_recycle);

    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
        List<BeanOne.DataBean.TagBean> list=dataBean.tag;
        RAd ad=new RAd(list,context);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        r.setLayoutManager(linearLayoutManager);
        r.setAdapter(ad);
    }
}
