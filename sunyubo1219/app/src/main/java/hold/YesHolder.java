package hold;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import bawei.sunyubo1219.BaseViewHolder;
import bawei.sunyubo1219.Bean2;
import bawei.sunyubo1219.R;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/19.
 */

public class YesHolder extends BaseViewHolder {

    private final TextView title;
    private final TextView content;
    private final ImageView imageView;
    private final ImageView imageView2;

    public YesHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.you_title);
        content = (TextView) itemView.findViewById(R.id.you_content);
        imageView = (ImageView)itemView.findViewById(R.id.you_img1);
        imageView2 = (ImageView)itemView.findViewById(R.id.you_img2);
    }
    @Override
    protected void setData(Context context, Bean2.ItemsBean itemsBean) {
        title.setText(itemsBean.username);

        Glide.with(context).load("http://img.dxycdn.com/avatars/120/"+itemsBean.infoAvatar).into(imageView);
        Gson gson=new Gson();
        String url=itemsBean.content;
        UrlBean  urlBean=gson.fromJson(url,UrlBean.class);
        content.setText(urlBean.body);
        Glide.with(context).load("http://res.dxycdn.com/upload/"+urlBean.url).into(imageView2);
    }
}
