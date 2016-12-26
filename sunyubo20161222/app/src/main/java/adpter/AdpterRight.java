package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bawei.sunyubo20161222.R;
import bean.Bean;
import myclick.MyOnitemClickListener;


/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/22.
 */

public class AdpterRight extends RecyclerView.Adapter<AdpterRight.Vh> {
    Context context;
    List<Bean.RsBean.ChildrenBeanX.ChildrenBean> list;

    public AdpterRight(Context context, List<Bean.RsBean.ChildrenBeanX.ChildrenBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Vh(View.inflate(context,R.layout.item_right,null));
    }

    @Override
    public void onBindViewHolder(Vh holder, final int position) {
        Glide.with(context).load(list.get(position).imgApp).into(holder.imageView);
        holder.name.setText(list.get(position).dirName);
        if (onitemClickListener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemClickListener.setOnitemClickListener(position);
                }
            });
        }
    }
    MyOnitemClickListener onitemClickListener;
public void setOnitemClickListener( MyOnitemClickListener onitemClickListener){

    this.onitemClickListener=onitemClickListener;
}

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        public Vh(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imgView);
            name=(TextView)itemView.findViewById(R.id.name);
        }
    }

}
