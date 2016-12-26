package bawei.sunyubo20161219;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bawei.mylibrary.OkHttpUtils;
import bean.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button dingwei;
    private Button huancun;
    private PullLoadMoreRecyclerView recyclerView;
    private List<Bean.DataBean> list1;
    private MyAdpter ad;
    int index=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getdata("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page="+index+"",
                1);

    }

    private void getdata(String url, final int tag) {
        OkHttpUtils.get(url
                , new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String string=response.body().string();
                        Message message=Message.obtain();
                        message.obj=string;
                        message.arg1=tag;
                        h.sendMessage(message);
                    }
                });
    }

    List<Bean.DataBean> listall=new ArrayList<>();
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String s= (String) msg.obj;
        int tag=msg.arg1;
        Gson gson=new Gson();
        List<Bean.DataBean> list=gson.fromJson(s,Bean.class).data;
    switch (tag){
        case 1:
            listall.addAll(list);
            ad=new MyAdpter(listall,MainActivity.this);
            recyclerView.setAdapter(ad);
            break;
        case 2:
            listall.clear();
            listall.addAll(list);
            ad.notifyDataSetChanged();;
            recyclerView.setPullLoadMoreCompleted();
            break;
        case 3:
            listall.addAll(list);
            ad.notifyDataSetChanged();;
            recyclerView.setPullLoadMoreCompleted();
            break;
    }
    }
};

    private void initView() {
        //SimpleAdapter s=new SimpleAdapter()
        tv =(TextView)findViewById(R.id.tv);
        dingwei =(Button)findViewById(R.id.dingwei);
        huancun =(Button)findViewById(R.id.huancun);
        recyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLinearLayout();
        recyclerView.setPullRefreshEnable(true);
        recyclerView.setPushRefreshEnable(true);
        recyclerView.setFooterViewText("loading");
        recyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
        index++;
                getdata("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page="+index+"",
                        2);
            }

            @Override
            public void onLoadMore() {
                index++;
                getdata("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page="+index+"",
                        3);
            }
        });

    }



}
