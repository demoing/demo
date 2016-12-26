package hold;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import adpter.RecycleAd;
import bawei.redbaby.R;
import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type4 extends BaseViewHolder{


    private final ImageView i1;
    private final ImageView i2;
    private final ImageView i3;
    private final RecyclerView r;

    private List<BeanOne.DataBean.TagBean> list;

    public Type4(View itemView) {
        super(itemView);
         i1= (ImageView) itemView.findViewById(R.id.type4_img1);
        i2 = (ImageView) itemView.findViewById(R.id.type4_img2);
        i3 = (ImageView) itemView.findViewById(R.id.type4_img3);
        r =(RecyclerView)itemView.findViewById(R.id.type4_recycle);


    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {

        Glide.with(context).load("http://image1.suning.cn"+ dataBean.tag.get(0).picUrl).into(i1);
        Glide.with(context).load("http://image1.suning.cn"+ dataBean.tag.get(1).picUrl).into(i2);
        Glide.with(context).load("http://image1.suning.cn"+ dataBean.tag.get(2).picUrl).into(i3);
        List<BeanOne.DataBean.TagBean> list=new ArrayList<>();
        for(int i=3;i<7;i++){
            list.add(dataBean.tag.get(i));
        }
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        RecycleAd ad=new RecycleAd(list,context);
        r.setLayoutManager(linearLayoutManager);
        r.setAdapter(ad);
    }
}
