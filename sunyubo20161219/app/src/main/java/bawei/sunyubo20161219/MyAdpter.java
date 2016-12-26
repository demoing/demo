package bawei.sunyubo20161219;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bean.Bean;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/19.
 */

public class MyAdpter  extends RecyclerView.Adapter<MyAdpter.Vh>{
List<Bean.DataBean> list;
    Context context;

    public MyAdpter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
       Vh vh=new Vh(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return  vh;
      /*  MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                HomeActivity.this).inflate(R.layout.item_home, parent,
                false));
        return holder;*/
    }

    @Override
    public void onBindViewHolder(Vh holder, int position) {
       // holder.tv.setText(mDatas.get(position));
        holder.age.setText(list.get(position).userAge+"岁");
        holder.title.setText(list.get(position).title);
        holder.introduction.setText(list.get(position).introduction);
        holder.occupation.setText(list.get(position).occupation);
        Glide.with(context).load(list.get(position).userImg).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Vh extends RecyclerView.ViewHolder{
        private final TextView occupation;
        ImageView imageView;
        TextView age;
        TextView title;
        TextView introduction;

        public Vh(View itemView) {
            super(itemView);
            age= (TextView) itemView.findViewById(R.id.userAge);
            occupation =(TextView)itemView.findViewById(R.id.occupation);
            title= (TextView) itemView.findViewById(R.id.title);
            introduction= (TextView) itemView.findViewById(R.id.introduction);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
