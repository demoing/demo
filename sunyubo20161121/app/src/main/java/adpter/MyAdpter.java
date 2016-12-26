package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bawei.sunyubo20161121.R;
import bean.Bean;/**
*1.类的作用
*2.Sunyubo
*3.2016/11/23
*/
/**
 * Created by Sunyubo on 2016/11/21.
 */
public class MyAdpter extends RecyclerView.Adapter<MyAdpter.Vh2> implements View.OnClickListener{
    List<Bean.ResultBean.DataBean> list;
    Context context;
    public MyAdpter(List<Bean.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
onItemClickListener onItemClickListener;
public interface  onItemClickListener{
    void setonItemClickListener(View view,int position);
}
public void setOnItemClickListener(onItemClickListener onItemClickListener){
    this.onItemClickListener=onItemClickListener;
}

    @Override
    public Vh2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        Vh2 vh2=new Vh2(view);
        view.setOnClickListener(this);
        return vh2;
    }

    @Override
    public void onBindViewHolder(final Vh2 holder, final int position) {
                holder.t1.setText(list.get(position).content);
        holder.t2.setText(list.get(position).updatetime);
        if(onItemClickListener!=null){
            //点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //接口回调
                   onItemClickListener.setonItemClickListener(holder.itemView,position);
                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {

    }

    class Vh2 extends RecyclerView.ViewHolder{
        TextView t1;
        TextView t2;
        public Vh2(View itemView) {
            super(itemView);
            t1= (TextView) itemView.findViewById(R.id.text1);
            t2= (TextView) itemView.findViewById(R.id.text2);
        }
    }
}
