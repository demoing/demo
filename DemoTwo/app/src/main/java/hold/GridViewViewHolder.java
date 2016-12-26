package hold;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.demotwo.R;
import bawei.demotwo.WebViewActivity;
import bean.BeanOne;
import utils.CommonAdapter;
import utils.ImageLoaderUtils;
import utils.ViewHolder;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class GridViewViewHolder extends BaseViewHolder{

    private final GridView gv;
    private List<BeanOne.DataBean.Ad5Bean> ad5;

    public GridViewViewHolder(View itemView) {
        super(itemView);
        gv =(GridView)itemView.findViewById(R.id.gv);
    }

    @Override
    public void setdata(final Context context, BeanOne.DataBean dataBean) {
        ad5 = dataBean.ad5;

        /*gv.setAdapter(new MyGridAdpter(ad5,context));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(context, WebViewActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("url",ad5.get(position).ad_type_dynamic_data);
                context.startActivity(i);
            }
        });*/
        CommonAdapter ad=new CommonAdapter<BeanOne.DataBean.Ad5Bean>(context,ad5,R.layout.holder_grid_item) {

            @Override
            public void convert(ViewHolder helper, BeanOne.DataBean.Ad5Bean item) {
               ImageView imageView=helper.getView(R.id.holder1_img);
                TextView tv=helper.getView(R.id.holder1_tv);
                ImageLoader.getInstance().displayImage(item.image,imageView, ImageLoaderUtils.initOptions());
                tv.setText(item.title);
            }
        };
        gv.setAdapter(ad);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(context, WebViewActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("url",ad5.get(position).ad_type_dynamic_data);
                context.startActivity(i);
            }
        });
    }
}
