package bawei.sunyubo20161121;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import adpter.MyAdpter;
import bawei.mylibrary.OkHttpUtils;
import bean.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.BaseActivity;
public class ShowActivity extends BaseActivity{
    private RecyclerView recyclerView;
    @Override
    public int bindLayout() {
        return R.layout.activity_show;
    }

    @Override
    public void initData() {
        OkHttpUtils.get("http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37 &page=2&pagesize=10&sort=asc&time=1418745237",
                new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                            String string=response.body().string();
                            Message m=Message.obtain();
                        m.obj=string;
                        h.sendMessage(m);
                    }
                });
    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String s= (String) msg.obj;
        Gson g=new Gson();
        Bean bean=g.fromJson(s,Bean.class);
        final List<Bean.ResultBean.DataBean> list= bean.result.data;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ShowActivity.this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        MyAdpter ad=new MyAdpter(list,ShowActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(ad);
        ad.setOnItemClickListener(new MyAdpter.onItemClickListener() {
            @Override
            public void setonItemClickListener(View view, int position) {
                Toast.makeText(ShowActivity.this,list.get(position).content,Toast.LENGTH_SHORT).show();
            }
        });
    }
};
    @Override
    public void initView(Bundle savedInstanceState) {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
    @Override
    public void loadData() {
    }
}
