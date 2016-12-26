package bawei.week;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import bawei.mylibrary.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.BaseActivity;
import util.CommonAdapter;
import util.ViewHolder;

public class MainActivity extends BaseActivity{

String url="http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page=1\n";
    private ListView lv;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String s= (String) msg.obj;
        Gson g=new Gson();
        List<Bean.DataBean> list=g.fromJson(s,Bean.class).data;
        lv.setAdapter(new CommonAdapter<Bean.DataBean>(MainActivity.this,list,R.layout.item) {
            @Override
            public void convert(ViewHolder helper, Bean.DataBean item) {
                TextView tv=helper.getView(R.id.tv);
                ImageView i=helper.getView(R.id.img);
                tv.setText(item.title);
                Glide.with(context).load(item.userImg).into(i);
            }
        });
    }
};
    @Override
    public void initData() {
        OkHttpUtils.get("http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=10&gender=2&ts=1871746850&page=1\n", new
                Callback() {
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
                });
    }

    @Override
    public void initView(Bundle savedInstanceState) {
   lv =(ListView)findViewById(R.id.lv);
    }

    @Override
    public void loadData() {

    }
}
