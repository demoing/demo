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
 * 3.@ 2016/12/1.
 */
public class MaskHolderAdpter extends RecyclerView.Adapter<MaskHolderAdpter.Vh> {
    List<BeanOne.DataBean.BestSellersBean.GoodsListBean> list;
    Context context;



    public MaskHolderAdpter(List<BeanOne.DataBean.BestSellersBean.GoodsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.holder_mask_recyclerview_item,null);
        return new Vh(view);
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
        if(onItemClickListener!=null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onItemClickListener.setOnItemClickListener(position);

                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    onItemClickListener.setOnItemLongClickListener(position);
                    return true;
                }
            });
        }


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
            i=(ImageView)itemView.findViewById(R.id.holder3_img);
            t1=(TextView)itemView.findViewById(R.id.holder3_tv1);
            t2=(TextView)itemView.findViewById(R.id.holder3_tv2);
            t3=(TextView)itemView.findViewById(R.id.holder3_tv3);
        }
    }
}
