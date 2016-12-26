package bawei.xlist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bawei.mylibrary.BaseData;
import bawei.mylibrary.XListView;
import util.CommonAdapter;
import util.ViewHolder;

public class MainActivity extends AppCompatActivity {

    private XListView xListView;
    private List<Bean.ResultBean.DataBean> list;
    private CommonAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView = (XListView)findViewById(R.id.lv);
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                index++;
                initdata("http://japi.juhe.cn/joke/content/list.from",
                        "key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page="+index+""
                        ,index,2,30*24*60*60*1000);

                xListView.stopRefresh();;

            }

            @Override
            public void onLoadMore() {
                index++;
                initdata("http://japi.juhe.cn/joke/content/list.from",
                        "key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page="+index+""
                        ,index,3,30*24*60*60*1000);
                xListView.stopLoadMore();
            }
        });
        //1.url
        //2.args;
        //3.index
        //4.类型
        initdata("http://japi.juhe.cn/joke/content/list.from",
                "key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page="+index+""
                ,index,1,30*24*60*60*1000);
    }
    int index=1;
//http://japi.juhe.cn/joke/content/list.from?key= 874ed931559ba07aade103eee279bb37&pagesize=10&sort=asc&time=1418745237&page=
    private void initdata(String url, String args, int index, final int tag,long time) {
        BaseData data=new BaseData(this) {
            @Override
            public void setResultData(String data) {
                updata(data,tag);
            }
        };

        data.getData(url,args+index,index,tag);
    }

    List<Bean.ResultBean.DataBean> listall=new ArrayList<>();

    private void updata(String data,int tag) {
        Gson gson=new Gson();
        list = gson.fromJson(data,Bean.class).result.data;

        //TextView t1=helper.getView(R.id.content);
       // TextView t2=helper.getView(R.id.tv2);
       if (ad==null){
           ad = new CommonAdapter<Bean.ResultBean.DataBean>(MainActivity.this,listall, R.layout.item) {

               @Override
               public void convert(ViewHolder helper, Bean.ResultBean.DataBean item) {
                   TextView t1=helper.getView(R.id.content);
                   TextView t2=helper.getView(R.id.tv2);
                   t1.setText(item.content);
                   t2.setText(item.updatetime);
               }
           };
           xListView.setAdapter(ad);
           xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   Toast.makeText(MainActivity.this,listall.get(i-1).content,Toast.LENGTH_SHORT).show();
               }
           });
           xListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
               @Override
               public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                   // 创建构建器
                   // 创建构建器
                   AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                   // 设置参数
                   builder.setTitle("世静美不美啊？").setIcon(R.mipmap.psb)
                           .setMessage("真的很美吗？")
                           .setPositiveButton("美", new DialogInterface.OnClickListener() {// 积极

                               @Override
                               public void onClick(DialogInterface dialog,
                                                   int which) {
                                   // TODO Auto-generated method stub
                                   Toast.makeText(MainActivity.this, "恭喜你答对了",  Toast.LENGTH_SHORT)
                                           .show();
                                   listall.remove(i-1);
                                   ad.notifyDataSetChanged();
                               }
                           }).setNegativeButton("不美", new DialogInterface.OnClickListener() {// 消极

                       @Override
                       public void onClick(DialogInterface dialog,
                                           int which) {
                           // TODO Auto-generated method stub
                           Toast.makeText(MainActivity.this, "一点也不老实",  Toast.LENGTH_SHORT)
                                   .show();

                       }
                   }).setNeutralButton("不知道", new DialogInterface.OnClickListener() {// 中间级

                       @Override
                       public void onClick(DialogInterface dialog,
                                           int which) {
                           // TODO Auto-generated method stub
                           Toast.makeText(MainActivity.this, "快睁开眼瞅瞅", Toast.LENGTH_SHORT)
                                   .show();
                       }
                   });
                   builder.create().show();
                   return true;
               }
           });
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
}
