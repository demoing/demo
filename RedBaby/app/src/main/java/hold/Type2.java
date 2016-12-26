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
public class Type2 extends BaseViewHolder{
    private final ImageView i;
    private final RecyclerView r;
    List<BeanOne.DataBean.TagBean> list;
    List<BeanOne.DataBean.TagBean> listall=new ArrayList<>();
    public Type2(View itemView) {
        super(itemView);
        i = (ImageView) itemView.findViewById(R.id.type2_img);
        r =(RecyclerView) itemView.findViewById(R.id.recycleView);
    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
        list=dataBean.tag;
        String url=list.get(0).picUrl;
        Glide.with(context).load("http://image1.suning.cn"+url).into(i);
        listall.clear();
        for(int i=1;i<7;i++){
            listall.add(list.get(i));
        }
        LinearLayoutManager l=new LinearLayoutManager(context);
        l.setOrientation(OrientationHelper.HORIZONTAL);
        RecycleAd ad=new RecycleAd(listall,context);
        r.setLayoutManager(l);
        r.setAdapter(ad);
    }
}
