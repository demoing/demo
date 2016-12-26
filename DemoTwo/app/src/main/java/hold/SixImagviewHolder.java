package hold;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import adpter.SixImagvAdpter;
import bawei.demotwo.R;
import bawei.demotwo.ShowActivity;
import bean.BeanOne;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/2.
 */
public class SixImagviewHolder extends BaseViewHolder{

    private final GridView gv;
    private List<BeanOne.DataBean.DefaultGoodsListBean> list;

    public SixImagviewHolder(View itemView) {
        super(itemView);
        gv =(GridView)itemView.findViewById(R.id.six_imagview_gridview);
    }

    @Override
    public void setdata(final Context context, final BeanOne.DataBean dataBean) {
        list = dataBean.defaultGoodsList;
      //  Toast.makeText(context,list.size()+"",Toast.LENGTH_SHORT).show();
        gv.setAdapter(new SixImagvAdpter(list,context));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(context, ShowActivity.class);
                i.putExtra("stu",list.get(position).id);
                context.startActivity(i);
            }
        });
    }
}
