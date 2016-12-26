package bawei.sunyubo1219;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

import hold.NoHolder;
import hold.UrlBean;
import hold.YesHolder;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/19.
 */

public class Ad extends RecyclerView.Adapter<BaseViewHolder>{
    List<Bean2.ItemsBean> list;
    Context context;

    public Ad(List<Bean2.ItemsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 1:
                View view=View.inflate(context,R.layout.you,null);
                YesHolder yes=new YesHolder(view);
                return yes;
            case 2:
                View view2=View.inflate(context,R.layout.wu,null);
                NoHolder no=new NoHolder(view2);
                return no;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(context,list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
       /* if(list.get(position).url!=null){
            return 1;
        }else if(list.get(position).url==null){
            return 2;
        }
        return super.getItemViewType(position);*/
        Gson gson=new Gson();
        String url=list.get(position).content;
        UrlBean  urlBean=gson.fromJson(url,UrlBean.class);
        if(urlBean.url!=null){
            return 1;//有图片
        }
        else if(urlBean.url==null){
            return 2;
        }
        return 0;
    }
}
