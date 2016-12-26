package adpter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import bawei.redbaby.R;
import bean.Bean;

/**
 * Created by Sunyubo on 2016/11/12.
 */
public class MyBaseAdpter extends RecyclerView.Adapter<MyBaseAdpter.Vh>{
     List<Bean.RsBean> list;
    Context context;

    public MyBaseAdpter(List<Bean.RsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        Vh vh=new Vh(LayoutInflater.from(context).inflate(R.layout.item_left,parent,false));
        return vh;
    }
    public OnItemClickListener onItemClickListener;

public interface OnItemClickListener{
    void setOnItemClickListener(View view,int position);

}
public void setOnitemClickListener(OnItemClickListener onItemClickListener){
    this.onItemClickListener=onItemClickListener;
}
    @Override
    public void onBindViewHolder(final Vh holder, final int position) {
        holder.tv.setText(list.get(position).dirName);
        if(list.get(position).ischeck==true){
            holder.tv.setTextColor(Color.GREEN);
            holder.tv.setBackgroundResource(R.color.tabtrue);
            holder.i.setVisibility(View.VISIBLE);

        }else{
            holder.tv.setBackgroundResource(R.color.tabfalse);
            holder.tv.setTextColor(Color.BLACK);
            holder.i.setVisibility(View.GONE);
        }
        if(onItemClickListener!=null){
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   onItemClickListener.setOnItemClickListener(holder.itemView,position);
               }
           });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView i;
    public Vh(View itemView) {
            super(itemView);
            tv=(TextView)itemView.findViewById(R.id.text_item_left);
        i=(ImageView)itemView.findViewById(R.id.img_item_left);
        }
    }

}
