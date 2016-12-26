package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bawei.redbaby.R;
import bean.Bean;

/**
 * Created by Sunyubo on 2016/11/13.
 */
public class MyAdpterRight extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Bean.RsBean.ChildrenBean> list;
    Context context;
    int HEADER=1;
    int CONTENT=2;
    public MyAdpterRight(List<Bean.RsBean.ChildrenBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public boolean isheader(int position){
        return list.get(position).isheader;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).isheader){
            return HEADER;
        }
       else{
            return  CONTENT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==1){
            VhOne vhOne=new VhOne(LayoutInflater.from(context).inflate(R.layout.item_right_top,parent,false));
            return vhOne;
        }else if(viewType==2){
            VhTwo vhTwo=new VhTwo(LayoutInflater.from(context).inflate(R.layout.item_right_buttom,parent,false));
            return vhTwo;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof VhOne){
            ((VhOne) holder).t1.setText(list.get(position).dirName);
        }else if(holder instanceof  VhTwo){
         ((VhTwo) holder).t2.setText(list.get(position).dirName);
            String url=list.get(position).imgApp;
            Glide.with(context).load(url).into(((VhTwo) holder).img);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VhOne extends RecyclerView.ViewHolder{
        TextView t1;
        public VhOne(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.item_right_top_text);
        }
    }
    class VhTwo extends RecyclerView.ViewHolder{
        TextView t2;
        ImageView img;
        public VhTwo(View itemView) {
            super(itemView);
            t2=(TextView)itemView.findViewById(R.id.item_right_buttom_text);
            img=(ImageView)itemView.findViewById(R.id.item_right_buttom_img);
        }
    }

}
