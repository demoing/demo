package adpter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import bawei.demotwo.R;
import bean.BeanOne;
import myinterface.OnItemClickListener;
import utils.ImageLoaderUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/2.
 */
public class SmallImagviewAdpter extends RecyclerView.Adapter<SmallImagviewAdpter.Vh>{
    List<BeanOne.DataBean.SubjectsBean.GoodsListBean> list;
    Context context;

    public SmallImagviewAdpter(List<BeanOne.DataBean.SubjectsBean.GoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Vh(View.inflate(context, R.layout.holder_small_recyclerview_item,null));
    }
    OnItemClickListener onItemClickListener;
   public void setOnItemClickListener(OnItemClickListener onItemClickListener){
       this.onItemClickListener=onItemClickListener;
   }
    @Override
    public void onBindViewHolder(Vh holder, final int position) {
        ImageLoader.getInstance().displayImage(list.get(position).goods_img,holder.i, ImageLoaderUtils.initOptions());
        holder.t1.setText("￥"+list.get(position).shop_price+"");
        holder.t2.setText("￥"+list.get(position).market_price+"");
        holder.t3.setText(list.get(position).goods_name+"");
        holder.t1.setTextColor(Color.RED);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null) {
                    onItemClickListener.setOnItemClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh extends RecyclerView.ViewHolder{
        ImageView i;
        TextView t1;
        TextView t2;
        TextView t3;
        public Vh(View itemView) {
            super(itemView);
            i=(ImageView)itemView.findViewById(R.id.holder8_img);
            t1=(TextView)itemView.findViewById(R.id.holder8_tv1);
            t2=(TextView)itemView.findViewById(R.id.holder8_tv2);
            t3=(TextView)itemView.findViewById(R.id.holder8_tv3);

        }
    }
}
