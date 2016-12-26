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
 * Created by Sunyubo on 2016/11/17.
 */
public class RAd  extends RecyclerView.Adapter<RAd.Vh7>{
    List<BeanOne.DataBean.TagBean> list;
    Context contect;

    public RAd(List<BeanOne.DataBean.TagBean> list, Context contect) {
        this.list = list;
        this.contect = contect;
    }

    @Override
    public Vh7 onCreateViewHolder(ViewGroup parent, int viewType) {
        Vh7 vh=new Vh7(LayoutInflater.from(contect).inflate(R.layout.type7_item,parent,false));
        return vh;
    }

    @Override
    public void onBindViewHolder(Vh7 holder, int position) {
        Glide.with(contect).load("http://image1.suning.cn"+list.get(position).picUrl).into(holder.i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh7 extends RecyclerView.ViewHolder{
            ImageView i;
        public Vh7(View itemView) {
            super(itemView);
           i= (ImageView) itemView.findViewById(R.id.item_type7);
        }
    }

}
