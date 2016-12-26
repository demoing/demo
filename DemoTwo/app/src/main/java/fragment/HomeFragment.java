package fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import adpter.RecycleAdpter;
import base.BaseData;
import base.BaseFragment;
import bawei.demotwo.R;
import bean.BeanOne;
import utils.CommonUtils;
import view.ShowingPage;

/**
 * Created by zhiyuan on 16/9/28.
 */
public class HomeFragment extends BaseFragment{
    List<BeanOne.DataBean> list=new ArrayList<>();
    String s;
    private View view;
    private RecyclerView recyclerView;
    private RecycleAdpter ad;
    private BeanOne.DataBean bean7;
    @Override
    protected void onLoad() {

      BaseData base=new BaseData() {
            @Override
            public void setResultData(String data) {
                HomeFragment.this.s=data;
                HomeFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }

            @Override
            protected void setResulttError(ShowingPage.StateType stateLoadError) {

            }
        };
        base.getData("http://m.yunifang.com/yunifang/mobile/home","random=59676&encode=62d458fefce9c740359873cc19b05188",0,3650*24*60*60*1000);
    }
    @Override
    public View createSuccessView() {

        initView();
        list.clear();
        Gson gson=new Gson();
        BeanOne.DataBean dataBean=gson.fromJson(s,BeanOne.class).data;
        //添加数据
        upData(dataBean);
        return view;

    }

    private void upData(BeanOne.DataBean dataBean) {
        BeanOne.DataBean bean0=new BeanOne.DataBean();
        bean0.ad1=dataBean.ad1;
        BeanOne.DataBean bean1=new BeanOne.DataBean();
        bean1.ad5=dataBean.ad5;
        BeanOne.DataBean bean2=new BeanOne.DataBean();
        bean2.bestSellers = dataBean.bestSellers;
        BeanOne.DataBean bean3=new BeanOne.DataBean();
        bean3=dataBean;
        BeanOne.DataBean bean4=new BeanOne.DataBean();
        bean4.activityInfo=dataBean.activityInfo;
        BeanOne.DataBean bean5=new BeanOne.DataBean();
        bean5.activityInfo=dataBean.activityInfo;
        BeanOne.DataBean bean6=new BeanOne.DataBean();
        // bean6.activityInfo=dataBean.activityInfo;
        BeanOne.DataBean bean7=new BeanOne.DataBean();
        bean7.subjects= dataBean.subjects;
        bean7.bigType=0;//大图
        BeanOne.DataBean bean8=new BeanOne.DataBean();
        bean8.subjects=dataBean.subjects;
        bean8.type=0;//小图
        BeanOne.DataBean bean9=new BeanOne.DataBean();
        bean9.subjects= dataBean.subjects;
        bean9.bigType=1;//大图
        BeanOne.DataBean bean10=new BeanOne.DataBean();
        bean10.subjects=dataBean.subjects;
        bean10.type=1;//小图
        BeanOne.DataBean bean11=new BeanOne.DataBean();
        bean11.subjects= dataBean.subjects;
        bean11.bigType=2;//大图
        BeanOne.DataBean bean12=new BeanOne.DataBean();
        bean12.subjects=dataBean.subjects;
        bean12.type=2;//小图
        BeanOne.DataBean bean13=new BeanOne.DataBean();
        bean13.subjects= dataBean.subjects;
        bean13.bigType=3;//大图
        BeanOne.DataBean bean14=new BeanOne.DataBean();
        bean14.subjects=dataBean.subjects;
        bean14.type=3;//小图
        BeanOne.DataBean bean15=new BeanOne.DataBean();
        bean15.subjects= dataBean.subjects;
        bean15.bigType=4;//大图
        BeanOne.DataBean bean16=new BeanOne.DataBean();
        bean16.subjects=dataBean.subjects;
        bean16.type=4;//小图
        BeanOne.DataBean bean17=new BeanOne.DataBean();
        bean17.subjects= dataBean.subjects;
        bean17.bigType=5;//大图
        BeanOne.DataBean bean18=new BeanOne.DataBean();
        bean18.subjects=dataBean.subjects;
        bean18.type=5;//小图
        BeanOne.DataBean bean19=new BeanOne.DataBean();
        bean19.subjects= dataBean.subjects;
        bean19.bigType=6;//大图
        BeanOne.DataBean bean20=new BeanOne.DataBean();
        bean20.subjects=dataBean.subjects;
        bean20.type=6;//小图
        BeanOne.DataBean bean21=new BeanOne.DataBean();
        bean21.subjects= dataBean.subjects;
        bean21.bigType=7;//大图
        BeanOne.DataBean bean22=new BeanOne.DataBean();
        bean22.subjects=dataBean.subjects;
        bean22.type=7;//小图
        //6个图片
        BeanOne.DataBean bean23=new BeanOne.DataBean();
        bean23.defaultGoodsList=dataBean.defaultGoodsList;
        BeanOne.DataBean bean24=new BeanOne.DataBean();
        list.add(bean0);
        list.add(bean1);
       list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        //list.add(bean5);
       // list.add(bean6);
        list.add(bean7);
        list.add(bean8);
        list.add(bean9);
        list.add(bean10);
        list.add(bean11);
        list.add(bean12);
        list.add(bean13);
        list.add(bean14);
        list.add(bean15);
        list.add(bean16);
        list.add(bean17);
        list.add(bean18);
        list.add(bean19);
        list.add(bean20);
        list.add(bean21);
        list.add(bean22);
        list.add(bean23);
        list.add(bean24);
        ad.notifyDataSetChanged();
    }

    private void initView() {
        view = View.inflate(getContext(), R.layout.home_fragment,null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(CommonUtils.getContext());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        ad = new RecycleAdpter(list,getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ad);
    }
}
