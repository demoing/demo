package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.demotwo.R;
import bean.BeanOne;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/1.
 */
public class FourImagviewHolderAdpter extends RecyclerView.Adapter<FourImagviewHolderAdpter.Vh> {
    List<BeanOne.DataBean.ActivityInfoBean.ActivityInfoListBean> list;
    Context context;

    public FourImagviewHolderAdpter(List<BeanOne.DataBean.ActivityInfoBean.ActivityInfoListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Vh(View.inflate(context, R.layout.holder_four_imagview_recyclerview_item,null));
    }

    @Override
    public void onBindViewHolder(Vh holder, int position) {
        ImageLoader.getInstance().displayImage(list.get(position).activityImg,holder.i, ImageLoaderUtils.initOptions());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh extends RecyclerView.ViewHolder{
            ImageView i;
        public Vh(View itemView) {
            super(itemView);
        i=(ImageView)itemView.findViewById(R.id.holder5_img);
        }
    }
}
