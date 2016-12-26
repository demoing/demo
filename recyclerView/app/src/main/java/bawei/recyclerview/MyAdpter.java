package bawei.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/3.
 */
public class MyAdpter extends RecyclerView.Adapter<MyAdpter.Vh>{
    public static final int TYPE0=0;
    public static final int TYPE1=1;
    public static final int TYPE2=2;
    public static final int TYPE3=3;
    public static final int TYPE4=4;
    List<String> list;
    Context context;

    public MyAdpter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Vh(View.inflate(context,R.layout.item,null));
    }

    @Override
    public void onBindViewHolder(Vh holder, int position) {
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0: return TYPE0;
        }
        return super.getItemViewType(position);
    }

     class Vh extends RecyclerView.ViewHolder{
         TextView tv;
        public Vh(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }

    }
}
