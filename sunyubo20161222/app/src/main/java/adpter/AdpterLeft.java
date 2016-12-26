package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bawei.sunyubo20161222.R;
import bean.Bean;
import myclick.MyOnitemClickListener;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/22.
 */

public class AdpterLeft extends RecyclerView.Adapter<AdpterLeft.Vh> {
    List<Bean.RsBean> list;
    Context context;

    public AdpterLeft(List<Bean.RsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    MyOnitemClickListener onitemClickListener;
    public void setOnitemClickListener(MyOnitemClickListener onitemClickListener){
        this.onitemClickListener=onitemClickListener;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Vh(View.inflate(context, R.layout.item_left,null));
    }

    @Override
    public void onBindViewHolder(Vh holder, final int position) {
            holder.textView.setText(list.get(position).dirName);
        if(onitemClickListener!=null){
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onitemClickListener.setOnitemClickListener(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh extends RecyclerView.ViewHolder{
        TextView textView;

        public Vh(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.left_textView);
        }
    }
}
