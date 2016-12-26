package hold;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import adpter.SmallImagviewAdpter;
import bawei.demotwo.R;
import bawei.demotwo.ShowActivity;
import bean.BeanOne;
import myinterface.OnItemClickListener;
import utils.CommonUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class SmallViewHolder extends BaseViewHolder{

    private final RecyclerView recyclerView;
    private List<BeanOne.DataBean.SubjectsBean.GoodsListBean> goodsList;
    private SmallImagviewAdpter ad;

    public SmallViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.holder8_recyclerView);
    }

    @Override
    public void setdata(final Context context, BeanOne.DataBean dataBean) {
        if(dataBean.type==0) {
            goodsList = dataBean.subjects.get(0).goodsList;
        }else if(dataBean.type==1){
            goodsList = dataBean.subjects.get(1).goodsList;
        }
        else if(dataBean.type==2){
            goodsList = dataBean.subjects.get(2).goodsList;
        }
        else if(dataBean.type==2){
            goodsList = dataBean.subjects.get(2).goodsList;
        }
        else if(dataBean.type==3){
            goodsList = dataBean.subjects.get(3).goodsList;
        }
        else if(dataBean.type==4){
            goodsList = dataBean.subjects.get(4).goodsList;
        }
        else if(dataBean.type==5){
            goodsList = dataBean.subjects.get(5).goodsList;
        }
        else if(dataBean.type==6){
            goodsList = dataBean.subjects.get(6).goodsList;
        }
        else if(dataBean.type==7){
            goodsList = dataBean.subjects.get(7).goodsList;
        }
        ad = new SmallImagviewAdpter(goodsList, context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CommonUtils.getContext());
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ad);
        ad.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {
                Intent intent=new Intent(context, ShowActivity.class);
                intent.putExtra("stu",goodsList.get(position).id);
                context.startActivity(intent);
            }

            @Override
            public void setOnItemLongClickListener(int position) {

            }
        });
    }
}
