package bawei.sunyubo1212;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import bawei.mylibrary.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.CommonAdapter;
import util.ViewHolder;


public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        String s= (String) msg.obj;
        Gson g=new Gson();
        Bean bean=g.fromJson(s,Bean.class);
        final List<Bean.ResultBean.DataBean> list=bean.result.data;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,list.get(i).content,Toast.LENGTH_SHORT).show();
            }
        });
        lv.setAdapter(new CommonAdapter<Bean.ResultBean.DataBean>(MainActivity.this,list,R.layout.item) {
            @Override
            public void convert(ViewHolder helper, Bean.ResultBean.DataBean item) {
                TextView content=helper.getView(R.id.content);
                TextView time=helper.getView(R.id.time);
                content.setText(item.content);
                time.setText(item.updatetime);
            }
        });
    }
};
    private void initData() {
        OkHttpUtils.get("http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37 &page=2&pagesize=10&sort=asc&time=1418745237", new Callback() {
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
    private void initView() {
        lv =(ListView)findViewById(R.id.lv);
    }
}
