package bawei.demotwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bean.BeanOne;
import utils.CommonAdapter;
import utils.ImageLoaderUtils;
import utils.ViewHolder;
import view.MyGridView;


public class BigActivity extends AppCompatActivity {

    private ImageView imagView;
    private TextView title;
    private TextView detail;
    MyGridView gv;
    private BeanOne.DataBean.SubjectsBean subjectsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
        Intent intent=getIntent();
        subjectsBean = (BeanOne.DataBean.SubjectsBean) intent.getSerializableExtra("sub");
        initView();
        initdata(subjectsBean);
    }

    private void initdata(final BeanOne.DataBean.SubjectsBean subjectsBean) {
        title.setText(subjectsBean.title + "\n" + "--");
        detail.setText(subjectsBean.end_time + "\n" + subjectsBean.detail);
        gv.setAdapter(new CommonAdapter<BeanOne.DataBean.SubjectsBean.GoodsListBean>(BigActivity.this,subjectsBean.goodsList,R.layout.holder_six_imagview_girdview_item) {
            @Override
            public void convert(ViewHolder helper, BeanOne.DataBean.SubjectsBean.GoodsListBean item) {
                ImageView i=helper.getView(R.id.six_imagview);
                ImageLoader.getInstance().displayImage(item.goods_img,i, ImageLoaderUtils.initOptions());
                TextView t1=helper.getView(R.id.six_tv1);
                TextView t2=helper.getView(R.id.six_tv2);
                TextView t3=helper.getView(R.id.six_tv3);
                TextView t4=helper.getView(R.id.six_tv4);
                t1.setText(item.efficacy);
                t2.setText(item.goods_name);
                t3.setText("￥"+item.shop_price+"");
                t4.setText("￥"+item.market_price+"");
            }
        });
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(BigActivity.this,ShowActivity.class);
                i.putExtra("stu",subjectsBean.goodsList.get(position).id);
                startActivity(i);
            }
        });
    }



    private void initView() {
        imagView = (ImageView)findViewById(R.id.big_back);
        title=(TextView)findViewById(R.id.big_title);
        detail =(TextView)findViewById(R.id.big_detail);
        gv=(MyGridView)findViewById(R.id.big_gv);
        imagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
