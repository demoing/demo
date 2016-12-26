package hold;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bawei.redbaby.R;
import bean.BeanOne;
import util.CommonAdapter;
import util.ViewHolder;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type1 extends BaseViewHolder{
    List<BeanOne.DataBean.TagBean> list;
    private final GridView gv;

    public Type1(View itemView) {
        super(itemView);
        gv=(GridView)itemView.findViewById(R.id.gv);
    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
        list=dataBean.tag;
        gv.setAdapter(new CommonAdapter<BeanOne.DataBean.TagBean>(context,list,R.layout.gv_item) {
            @Override
            public void convert(ViewHolder helper, BeanOne.DataBean.TagBean item) {
                TextView t=helper.getView(R.id.gv_textView);
                t.setText(item.elementName);
                ImageView i=helper.getView(R.id.gv_imageView);
                Glide.with(context).load("http://image1.suning.cn"+item.picUrl).into(i);
            }
        });
    }
}
