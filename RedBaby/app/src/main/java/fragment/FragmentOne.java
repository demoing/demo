package fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adpter.Ad;
import bawei.redbaby.R;
import bean.BeanOne;
import util.BaseFragment;

/**
 * Created by Sunyubo on 2016/11/10.
 */
public class FragmentOne extends BaseFragment{
    List<BeanOne.DataBean> list=new ArrayList<>();
    String url="http://lib.suning.com/app/redbaby/80000_5.0.0-459.json";
    private BeanOne beanOne;
    private Ad ad;

    @Override
    public int bindLayout() {
        return R.layout.fragment_one;
    }

    @Override
    public void initData() {
        String s=getAssets("home.json");
        Gson g=new Gson();
        beanOne=g.fromJson(s,BeanOne.class);
        updata();
      /*  OkHttpUtils.get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                        String s=response.body().string();
                        Message m=Message.obtain();
                        m.obj=s;
                      h.sendMessage(m);
            }
        });*/
    }




    @Override
    public void loadData() {

    }
/*
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String s= (String) msg.obj;
        Gson g=new Gson();
       beanOne=g.fromJson(s,BeanOne.class);
        updata();
    }
*/

    private void updata() {

        list.add(beanOne.data.get(0));//0
        list.add(beanOne.data.get(1));//1
        list.add(beanOne.data.get(2));//2
        BeanOne.DataBean databean= beanOne.data.get(4);
        List<BeanOne.DataBean.TagBean> tagbean= databean.tag;
        tagbean.addAll(beanOne.data.get(5).tag);
        tagbean.addAll(beanOne.data.get(6).tag);
        tagbean.addAll(beanOne.data.get(7).tag);
        list.add(databean);//3
        //母婴专区
        List<BeanOne.DataBean.TagBean> tagBeanlist=beanOne.data.get(9).tag;
        tagBeanlist.addAll(beanOne.data.get(10).tag);
        tagBeanlist.addAll(beanOne.data.get(11).tag);
        list.add(beanOne.data.get(9));//4
        //主题特卖
        list.add(beanOne.data.get(13));//5
        list.add(beanOne.data.get(14));//6
       list.add(beanOne.data.get(15));//7

        list.add(beanOne.data.get(16));//8
        list.add(beanOne.data.get(17));//9
        list.add(beanOne.data.get(18));//10
        list.add(beanOne.data.get(19));//11
        list.add(beanOne.data.get(20));//12
        list.add(beanOne.data.get(21));//13
        list.add(beanOne.data.get(23));//14

        list.add(beanOne.data.get(24));//15
        list.add(beanOne.data.get(26));//16
        list.add(beanOne.data.get(28));//17
        list.add(beanOne.data.get(30));//18
        list.add(beanOne.data.get(32));//19
        list.add(beanOne.data.get(33));//20
        list.add(beanOne.data.get(34));//21
        ad.notifyDataSetChanged();
    }
    @Override
    public void initView(Bundle savedInstanceState) {
        RecyclerView recyclerView=findview(R.id.fragment_one_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        ad =new Ad(list,getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ad);
    }


}

