package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import bawei.redbaby.R;
import bean.BeanOne;
import hold.BaseViewHolder;
import hold.Type0;
import hold.Type1;
import hold.Type2;
import hold.Type3;
import hold.Type4;
import hold.Type5;
import hold.Type6;
import hold.Type7;
import hold.Type8;
import hold.Type9;

/**
 * Created by Sunyubo on 2016/11/16.
 */
public class Ad extends RecyclerView.Adapter<BaseViewHolder>{
    List<BeanOne.DataBean> list;
    Context context;
    LayoutInflater layoutInflater;
    public static final int TYPE0=0;//viewpager的类型
    public static final int TYPE1=1;//gridview类型
    public static final int TYPE2=2;//一张图片和一个recycleView
    public static final int TYPE3=3;//一个图片和一个gridview
    public static final int TYPE4=4;//7个图片
    public static final int TYPE5=5;//主题特卖
    public static final int TYPE6=6;//海外购
    public static final int TYPE7=7;//recycle

    public static final int TYPE8=8;
    public static final int TYPE9=9;

    public static final int TYPE10=10;
    public static final int TYPE11=11;

    public static final int TYPE12=12;
    public static final int TYPE13=13;

    public static final int TYPE14=14;
    public static final int TYPE15=15;

    public static final int TYPE16=16;
    public static final int TYPE17=17;
    public static final int TYPE18=18;
    public static final int TYPE19=19;
    public static final int TYPE20=20;
    public static final int TYPE21=21;

    public Ad(List<BeanOne.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE0:
                return new Type0(layoutInflater.inflate(R.layout.type0,parent,false));
            case TYPE1:
                return new Type1(layoutInflater.inflate(R.layout.type1,parent,false));
            case TYPE2:
                return new Type2(layoutInflater.inflate(R.layout.type2,parent,false));
            case TYPE3:
                return new Type3(layoutInflater.inflate(R.layout.type3,parent,false));
            case TYPE4:
                return new Type4(layoutInflater.inflate(R.layout.type4,parent,false));
            case TYPE5:
            case TYPE14:
            case TYPE20:
                return new Type5(layoutInflater.inflate(R.layout.type5,parent,false));
            case TYPE6:
            case TYPE8:
            case TYPE10:
            case TYPE12:

                return new Type6(layoutInflater.inflate(R.layout.type6,parent,false));
            case TYPE7:
            case TYPE9:
            case TYPE11:
            case TYPE13:
                return new Type7(layoutInflater.inflate(R.layout.type7,parent,false));
            case TYPE15:
            case TYPE16:
            case TYPE17:
            case TYPE18:
            case TYPE19:
                return new Type8(layoutInflater.inflate(R.layout.type8,parent,false));
            case TYPE21:
                return new Type9(layoutInflater.inflate(R.layout.type9,parent,false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setdata(context,list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case 0: return TYPE0;
            case 1: return TYPE1;
            case 2: return TYPE2;
            case 3: return TYPE3;
            case 4: return TYPE4;
            case 5: return TYPE5;
            case 6: return TYPE6;
            case 7: return TYPE7;
            case 8: return TYPE8;
            case 9: return TYPE9;
            case 10: return TYPE10;
            case 11: return TYPE11;
            case 12: return TYPE12;
            case 13: return TYPE13;
            case 14: return TYPE14;
            case 15: return TYPE15;
            case 16: return TYPE16;
            case 17: return TYPE17;
            case 18: return TYPE18;
            case 19: return TYPE19;
            case 20: return TYPE20;
            case 21: return TYPE21;
        }
        return TYPE0;
    }

}
