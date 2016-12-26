package bawei.demotwo;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import java.util.List;
import base.BaseData;
import bean.MoreBean;
import utils.CommonAdapter;
import utils.ImageLoaderUtils;
import utils.ViewHolder;
import view.ShowingPage;
public class MoreActivity extends AppCompatActivity implements View.OnClickListener {

    private GridView lv;
    private TextView textView1;

    private TextView textView3;
    private TextView textView2;

    private ImageView imageView_back;
    private CommonAdapter<MoreBean.DataBean> ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        MyData data = new MyData();
        data.getData("http://m.yunifang.com/yunifang/mobile/goods/getall", "random=87749&encode=ac6bd45b8f50b626a6843b294af8fed5"
                , 0, 365 * 24 * 60 * 60 * 1000);


    }

    private List<MoreBean.DataBean> list;
    List<MoreBean.DataBean> newlist ;
    List<MoreBean.DataBean> commonList = new ArrayList<>();
    private void upData(String result) {
        Gson gson = new Gson();
        MoreBean bean = gson.fromJson(result, MoreBean.class);
        list=bean.data;
        MoreBean bean2 = gson.fromJson(result, MoreBean.class);
        newlist=bean2.data;
        commonList.addAll(list);
        ad = new CommonAdapter<MoreBean.DataBean>(MoreActivity.this, commonList, R.layout.holder_six_imagview_girdview_item) {
            @Override
            public void convert(ViewHolder helper, MoreBean.DataBean item) {
                ImageView imageView = helper.getView(R.id.six_imagview);
                TextView t1 = helper.getView(R.id.six_tv1);
                TextView t2 = helper.getView(R.id.six_tv2);
                TextView t3 = helper.getView(R.id.six_tv3);
                TextView t4 = helper.getView(R.id.six_tv4);
                ImageLoader.getInstance().displayImage(item.goods_img, imageView, ImageLoaderUtils.initOptions());
                t1.setText(item.efficacy);
                t2.setText(item.goods_name);
                t3.setText("￥" + item.shop_price + "");
                t4.setText("￥" + item.market_price + "");
            }
        };
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MoreActivity.this,ShowActivity.class);
                i.putExtra("stu",commonList.get(position).id);
                startActivity(i);
            }
        });
        lv.setAdapter(ad);
    }

    private void initView() {

        lv = (GridView) findViewById(R.id.more_listView);
        textView1 = (TextView) findViewById(R.id.default_textView);
        textView2 = (TextView) findViewById(R.id.order_textView);
        textView3 = (TextView) findViewById(R.id.down_textView);
        imageView_back = (ImageView) findViewById(R.id.more_back);
        imageView_back.setOnClickListener(this);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_back:
                finish();
                break;
            case R.id.default_textView:
                commonList.clear();
                commonList.addAll(newlist);
                ad.notifyDataSetChanged();
                break;
            case R.id.order_textView:
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        if (list.get(j).shop_price > list.get(j + 1).shop_price) {
                            double temp;
                            temp = list.get(j).shop_price;
                            list.get(j).shop_price = list.get(j + 1).shop_price;
                            list.get(j + 1).shop_price = temp;
                        }
                    }
                }
                commonList.clear();
                commonList.addAll(list);
                ad.notifyDataSetChanged();
                break;
            case R.id.down_textView:
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size() - 1; j++) {
                        if (list.get(j).shop_price < list.get(j + 1).shop_price) {
                            double temp;
                            temp = list.get(j).shop_price;
                            list.get(j).shop_price = list.get(j+1).shop_price;
                            list.get(j+1).shop_price = temp;
                        }
                    }
                }
                commonList.clear();
                commonList.addAll(list);
                ad.notifyDataSetChanged();;
                break;
        }
    }

    class MyData extends BaseData {
       // String result;

        @Override
        public void setResultData(String data) {
           // result = data;
            upData(data);
        }


        @Override
        protected void setResulttError(ShowingPage.StateType stateLoadError) {

        }
    }
}
