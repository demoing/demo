package hold;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import bawei.redbaby.R;
import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Type5 extends BaseViewHolder{


    private final ImageView i;

    public Type5(View itemView) {
        super(itemView);
         i = (ImageView) itemView.findViewById(R.id.type5_img1);


    }

    @Override
    public void setdata(Context context, BeanOne.DataBean dataBean) {
       String url= dataBean.tag.get(0).picUrl;
        Glide.with(context).load("http://image1.suning.cn"+url).into(i);
    }
}
