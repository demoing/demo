package bawei.custum;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adpter.MyAdapter;
import bawei.mylibrary.XListView;
import bean.Bean;
import util.BaseActivity;

public class ShowActivity extends BaseActivity implements  XListView.IXListViewListener{

    int page=1;
    private XListView lv;
    private String path;

    @Override
    public int bindLayout() {
        return R.layout.activity_show;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
    lv =(XListView)findViewById(R.id.lv);
        lv.setPullLoadEnable(true);
        lv.setPullRefreshEnable(true);
        lv.setXListViewListener(this);
    }
//获取网络资源
    void getres(int code){
    getAyn(path,handler,code);

    }
    List<Bean.ResultBean.DataBean> listall=new ArrayList<>();
Handler handler=new Handler(){
    private MyAdapter ad;

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int code=msg.arg1;
        String string= (String) msg.obj;
        Gson g=new Gson();
        Bean b=g.fromJson(string,Bean.class);
       List<Bean.ResultBean.DataBean> list=b.getResult().getData();
        switch (code){
            case 0:
                //第一次
                listall.addAll(list);
                ad=new MyAdapter(ShowActivity.this,listall);
                lv.setAdapter(ad);
                break;
            case 1:
                //刷新
                listall.clear();
                listall.addAll(list);
                ad.notifyDataSetChanged();
                stop();
                break;
            case 2:
                //加载
                listall.addAll(list);
                ad.notifyDataSetChanged();
                stop();
                break;

        }
    }
};
public void stop(){
    lv.stopLoadMore();
    lv.stopRefresh();
}

    @Override
    public void loadData() {
        path = "http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page=" + page;
getres(0);
    }

    @Override
    public void onRefresh() {
        //刷新
        page++;
        path = "http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page=" + page;
        getres(1);
    }

    @Override
    public void onLoadMore() {
        page++;
        path = "http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page=" + page;
        getres(2);
    }
}
