package hold;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import bawei.redbaby.R;
import bean.BeanOne;
import util.CommonAdapter;
import util.ViewHolder;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type3 extends BaseViewHolder{

    private final GridView gv;
    private final ImageView i;


    public Type3(View itemView) {
        super(itemView);
         i = (ImageView) itemView.findViewById(R.id.type3_img);
        gv =(GridView)itemView.findViewById(R.id.type3_gv);
    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
           BeanOne.DataBean.TagBean url= dataBean.tag.get(0);
        List<BeanOne.DataBean.TagBean>  list =dataBean.tag;
        List<BeanOne.DataBean.TagBean> listall=new ArrayList<>();
        Glide.with(context).load("http://image1.suning.cn"+url).into(i);
        for(int i=1;i<list.size();i++){
            listall.add(list.get(i));
        }
        gv.setAdapter(new CommonAdapter<BeanOne.DataBean.TagBean>(context,listall,R.layout.type3_item) {
            @Override
            public void convert(ViewHolder helper, BeanOne.DataBean.TagBean item) {
                ImageView i=helper.getView(R.id.item_type3_img);
                Glide.with(context).load("http://image1.suning.cn"+item.picUrl).into(i);
            }
        });
    }
}
