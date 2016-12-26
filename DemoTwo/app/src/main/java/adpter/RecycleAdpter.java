package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;
import bawei.demotwo.R;
import bean.BeanOne;
import hold.BaseViewHolder;
import hold.BigViewHolder;
import hold.FourImagviewViewHolder;
import hold.GridViewViewHolder;
import hold.HotViewHolder;
import hold.MoreHolder;
import hold.SixImagviewHolder;
import hold.SmallViewHolder;
import hold.ThisWeekViewHolder;
import hold.ViewPagerViewHolder;
import utils.CommonUtils;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class RecycleAdpter extends RecyclerView.Adapter<BaseViewHolder>{
    public static  final int HOLDER0=0;
    public static  final int HOLDER1=1;
    public static  final int HOLDER2=2;
    public static  final int HOLDER3=3;
    public static  final int HOLDER4=4;
    public static  final int HOLDER5=5;
    public static  final int HOLDER6=6;
    public static  final int HOLDER7=7;
    public static  final int HOLDER8=8;
    public static  final int HOLDER9=9;
    public static  final int HOLDER10=10;
    public static  final int HOLDER11=11;
    public static  final int HOLDER12=12;
    public static  final int HOLDER13=13;
    public static  final int HOLDER14=14;
    public static  final int HOLDER15=15;
    public static  final int HOLDER16=16;
    public static  final int HOLDER17=17;
    public static  final int HOLDER18=18;
    public static  final int HOLDER19=19;
    public static  final int HOLDER20=20;
    public static  final int HOLDER21=21;
    public static  final int HOLDER22=22;
    public static  final int HOLDER23=23;

    List<BeanOne.DataBean> list;
    Context context;

    public RecycleAdpter(List<BeanOne.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case HOLDER0:return new ViewPagerViewHolder(CommonUtils.inflate(R.layout.holder_viewpager));
            case HOLDER1:return new GridViewViewHolder(CommonUtils.inflate(R.layout.holder_gridview));
            case HOLDER2:return new ThisWeekViewHolder(CommonUtils.inflate(R.layout.holder_thisweek));
            case HOLDER3:return new FourImagviewViewHolder(CommonUtils.inflate(R.layout.holder_four_imagview_recyclerview));
            case HOLDER4:return new HotViewHolder(CommonUtils.inflate(R.layout.holder_hot_title));
            case HOLDER9:
            case HOLDER11:
            case HOLDER13:
            case HOLDER15:
            case HOLDER17:
            case HOLDER19:
            case HOLDER7:
            case HOLDER5:return new BigViewHolder(CommonUtils.inflate(R.layout.holder_big_imagview));
            case HOLDER10:
            case HOLDER12:
            case HOLDER14:
            case HOLDER16:
            case HOLDER18:
            case HOLDER20:
            case HOLDER8:
            case HOLDER6:return new SmallViewHolder(CommonUtils.inflate(R.layout.holder_small_recyclerview));
            case HOLDER21:return  new SixImagviewHolder(CommonUtils.inflate(R.layout.holder_six_imagview_girdview));
            case HOLDER22:return  new MoreHolder(CommonUtils.inflate(R.layout.more));
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
            case 0: return HOLDER0;
            case 1: return HOLDER1;
            case 2: return HOLDER2;
            case 3: return HOLDER3;
            case 4: return HOLDER4;
            case 5: return HOLDER5;
            case 6: return HOLDER6;
            case 7: return HOLDER7;
            case 8: return HOLDER8;
            case 9: return HOLDER9;
            case 10: return HOLDER10;
            case 11: return HOLDER11;
            case 12: return HOLDER12;
            case 13: return HOLDER13;
            case 14: return HOLDER14;
            case 15: return HOLDER15;
            case 16: return HOLDER16;
            case 17: return HOLDER17;
            case 18: return HOLDER18;
            case 19: return HOLDER19;
            case 20: return HOLDER20;
            case 21: return HOLDER21;
            case 22: return HOLDER22;
        }
        return HOLDER0;
    }
}
