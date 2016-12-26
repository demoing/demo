package bawei.sunyubo1219;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bawei.mylibrary.BaseData;


public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private MyPagerAdpter pagerAdpter;
    private List<Bean.ItemsBean> list;

    private LinearLayout ll;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        BaseData baseData=new BaseData(this) {
            @Override
            public void setResultData(String data) {
                    updata(data);
            }
        };
        baseData.getData("http://i.dxy.cn/snsapi/event/count/list/all","",0,3*24*60*60*1000);
        BaseData baseData1=new BaseData(this) {
            @Override
            public void setResultData(String data) {
                up(data);
            }
        };
        baseData1.getData("http://i.dxy.cn/snsapi/home/feeds/list/all?sid=4df0360f-2a20-4198-beb8-4dc5660c4f08&u=zhetianyishou&s=10&mc=0000000049029dcaffffffff99d603a9&token=TGT-13165-buaw5fHpqLlefw9bSOB0oF41fobaV4rMZmK-50&hardName=iToolsAVM_T0008098S&ac=4124c5f1-2029-4fda-b06f-a87ac5ad8d11&bv=2013&vc=6.0.6&tid=c25e673d-e82a-4e46-bd4e-c1e86d497126&vs=4.4.4&ref_tid=54720e1a-7eed-4993-9f51-3d760f3d0b2e"
        ,"",0,3*24*60*60*1000);
    }

    private void up(String data) {
        Gson gson=new Gson();
        List<Bean2.ItemsBean> list=gson.fromJson(data,Bean2.class).items;
       // recyclerView.setLinearLayout();;
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Ad(list,MainActivity.this));
      /*  recyclerView.setRefreshing(true);
        recyclerView.setPushRefreshEnable(true);
        recyclerView.setFooterViewText("loading");
        recyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {

            }
        });*/

    }

    private void initView() {
        vp =(ViewPager)findViewById(R.id.vp);
        ll = (LinearLayout) findViewById(R.id.ll);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void updata(String data) {
        Gson gson=new Gson();
        list = gson.fromJson(data,Bean.class).items;
        initdota();
        pagerAdpter =new MyPagerAdpter(list,MainActivity.this);
        vp.setAdapter(pagerAdpter);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    for(int i=0;i<dotaList.size();i++){
                        if (i == position % dotaList.size()) {
                            dotaList.get(i).setImageResource(R.drawable.dot_true);
                        } else {
                            dotaList.get(i).setImageResource(R.drawable.dot_false);
                        }
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        h.sendEmptyMessageDelayed(0,1000);
    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int i=vp.getCurrentItem();
        i++;
        vp.setCurrentItem(i);
        h.sendEmptyMessageDelayed(0,1000);

    }
};
List<ImageView> dotaList=new ArrayList<>();
    private void initdota() {
        dotaList.clear();
        ll.removeAllViews();
        h.removeCallbacksAndMessages(null);
        for(int i=0;i<list.size();i++){
            ImageView imageView=new ImageView(MainActivity.this);
            if(i==0){
                imageView.setImageResource(R.drawable.dot_true);
            }else{
                imageView.setImageResource(R.drawable.dot_false);
            }
            dotaList.add(imageView);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6,6);
            params.setMargins(5, 0, 5, 0);
            ll.addView(imageView, params);
        }
    }
}
