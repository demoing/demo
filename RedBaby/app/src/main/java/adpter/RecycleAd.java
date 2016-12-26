package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import bawei.redbaby.R;
import bean.BeanOne;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class RecycleAd extends RecyclerView.Adapter<RecycleAd.ViewH>{
    List<BeanOne.DataBean.TagBean> list;
    Context context;

    public RecycleAd(List<BeanOne.DataBean.TagBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public ViewH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewH(LayoutInflater.from(context).inflate(R.layout.type2_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewH holder, int position) {
        Glide.with(context).load("http://image1.suning.cn"+list.get(position).picUrl).into(holder.i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewH extends RecyclerView.ViewHolder{
        ImageView i;

        public ViewH(View itemView) {
            super(itemView);
            i= (ImageView) itemView.findViewById(R.id.item_type2_img);
        }
    }

}
