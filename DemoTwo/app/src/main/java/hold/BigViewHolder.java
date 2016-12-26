package hold;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bawei.demotwo.BigActivity;
import bawei.demotwo.R;
import bean.BeanOne;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class BigViewHolder extends BaseViewHolder{
    private final ImageView imageView;
    public BigViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.holder7_img);
    }
    @Override
    public void setdata(final Context context, final BeanOne.DataBean dataBean) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BigActivity.class);
                Bundle bundle=new Bundle();
                if(dataBean.bigType==0){
                    bundle.putSerializable("sub",dataBean.subjects.get(0));
                }
                if(dataBean.bigType==1){
                    bundle.putSerializable("sub",dataBean.subjects.get(1));
                }
                if(dataBean.bigType==2){
                    bundle.putSerializable("sub",dataBean.subjects.get(2));
                }
                if(dataBean.bigType==3){
                    bundle.putSerializable("sub",dataBean.subjects.get(3));
                }
                if(dataBean.bigType==4){
                    bundle.putSerializable("sub",dataBean.subjects.get(4));
                }
                if(dataBean.bigType==5){
                    bundle.putSerializable("sub",dataBean.subjects.get(5));
                }
                if(dataBean.bigType==6){
                    bundle.putSerializable("sub",dataBean.subjects.get(6));
                }
                if(dataBean.bigType==7){
                    bundle.putSerializable("sub",dataBean.subjects.get(7));
                }
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        if(dataBean.bigType==0) {
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(0).image,imageView, ImageLoaderUtils.initOptions());
        }else if(dataBean.bigType==1){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(1).image, imageView, ImageLoaderUtils.initOptions());
        }
        else if(dataBean.bigType==2){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(2).image, imageView, ImageLoaderUtils.initOptions());
        }
        else if(dataBean.bigType==3){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(3).image, imageView, ImageLoaderUtils.initOptions());
        }
        else if(dataBean.bigType==4){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(4).image, imageView, ImageLoaderUtils.initOptions());
        }
        else if(dataBean.bigType==5){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(5).image, imageView, ImageLoaderUtils.initOptions());
        }
        else if(dataBean.bigType==6){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(6).image, imageView, ImageLoaderUtils.initOptions());
        }
        else if(dataBean.bigType==7){
            ImageLoader.getInstance().displayImage(dataBean.subjects.get(7).image, imageView, ImageLoaderUtils.initOptions());
        }

    }
}
