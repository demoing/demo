package bawei.kaoshi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bawei.mylibrary.OkHttpUtils;
import bawei.mylibrary.XListView;
import bean.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import util.CommonAdapter;
import util.ViewHolder;

/**
*1.类的作用
*2.Sunyubo
*3.2016/12/21
*/
public class MainActivity extends AppCompatActivity {
int index=1;
    private XListView lv;
    private List<Bean.ResultBean.DataBean> list;

    //http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page=1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (XListView)findViewById(R.id.lv);
        lv.setPullRefreshEnable(true);
        lv.setPullLoadEnable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,listall.get(i-1).content,Toast.LENGTH_SHORT).show();;
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {

                // 创建构建器
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("你确定要删除吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // 这里添加点击确定后的逻辑
                       /* new AlertDialog.Builder(ShowActivity.this).setMessage("你选择了确定")
                                .show();*/
                        listall.remove(i-1);
                        ad.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // 这里添加点击确定后的逻辑
                       /* new AlertDialog.Builder(ShowActivity.this).setMessage("你选择了取消")
                                .show();*/
                    }
                });
                builder.create().show();
                return true;
            }
        });
        lv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                index++;
                getdata("http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page="+index+""
                        ,2);
                lv.stopRefresh();;
            }

            @Override
            public void onLoadMore() {
                index++;
                getdata("http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page="+index+""
                        ,3);
                lv.stopLoadMore();;
            }
        });
        getdata("http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page="+index+""
        ,1);

    }
    void getdata(String url, final int tag){
        OkHttpUtils.get(url, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String s=response.body().string();
                        Message m=Message.obtain();
                        m.arg1=tag;//第一次请求
                        m.obj=s;
                        handler.sendMessage(m);
                    }
                });
    }
    CommonAdapter ad;
    List<Bean.ResultBean.DataBean> listall=new ArrayList<>();
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s= (String) msg.obj;
            int tag=msg.arg1;
            Gson g=new Gson();
           // Toast.makeText(MainActivity.this,list.size()+"",Toast.LENGTH_SHORT).show();;
            list = g.fromJson(s, Bean.class).result.data;
            if(ad==null){
                ad=new CommonAdapter<Bean.ResultBean.DataBean>(MainActivity.this,listall,R.layout.item) {

                    @Override
                    public void convert(ViewHolder helper, Bean.ResultBean.DataBean item) {
                        TextView t1=helper.getView(R.id.tv1);
                        TextView t2=helper.getView(R.id.tv2);
                        t1.setText(item.content);
                        t2.setText(item.updatetime);
                    }
                };
                lv.setAdapter(ad);
            }
            switch (tag){
                case 1:
                    listall.addAll(list);
                    ad.notifyDataSetChanged();

                    break;
                case 2:
                    listall.clear();
                    listall.addAll(list);
                    ad.notifyDataSetChanged();

                    break;
                case 3:
                    listall.addAll(list);
                    ad.notifyDataSetChanged();
                    break;
            }
        }
    };
}
