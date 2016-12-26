package hold;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import adpter.MaskHolderAdpter;
import bawei.demotwo.R;
import bean.BeanOne;
import myinterface.OnItemClickListener;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class MaskViewHolder extends BaseViewHolder{

    private final RecyclerView recyclerView;

    private List<BeanOne.DataBean.BestSellersBean.GoodsListBean> goodsList;

    public MaskViewHolder(View itemView) {
        super(itemView);
        recyclerView = (RecyclerView)itemView.findViewById(R.id.holder3_recyclerView);

    }


    @Override
    public void setdata(final Context context, BeanOne.DataBean dataBean) {
        goodsList = dataBean.bestSellers.get(0).goodsList;
        MaskHolderAdpter ad=new MaskHolderAdpter(goodsList,context);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ad);
        ad.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {
                Toast.makeText(context,position+"short",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setOnItemLongClickListener(int position) {
                 Toast.makeText(context,"long"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
