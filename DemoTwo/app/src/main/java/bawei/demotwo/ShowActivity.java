package bawei.demotwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import adpter.GoodsPagerAdpter;
import base.BaseData;
import bean.Goods;
import bean.Shopping;
import bean.UrlBean;
import database.Dao;
import utils.CommonAdapter;
import utils.ImageLoaderUtils;
import utils.ViewHolder;
import view.MyListView;
import view.ShowingPage;
public class ShowActivity extends AutoLayoutActivity implements View.OnClickListener{
    private ViewPager vp;
    String s;
    private List<Goods.DataBean.GoodsBean.GalleryBean> gallery;
    private TextView mark_price;
    private TextView shop_price;
    private TextView goods_name;
    private MyListView lv;
    private LinearLayout ll;
    List<ImageView> dotList=new ArrayList<>();
    private MyListView listView;
    private TextView textView1;
    private TextView textView3;
    private TextView textView2;
    private List<Goods.DataBean.CommentsBean> comments;
    private List<Goods.DataBean.GoodsBean.AttributesBean> attitude;
    private String pics;
    private UrlBean[] urlBeen;
    private ImageView back;
    private Button add;
    private PopupWindow popupWindow;
    private ImageView add_imagview;
    private TextView pop_price;
    private TextView pop_number;
    private TextView pop_xiangou;
    private int xiangou;
    private Button quer;
    Dao dao=new Dao(ShowActivity.this);
    private ImageView dis;
    private TextView pop_jia;
    private TextView pop_jian;
    private TextView pop_cots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
       Intent i = getIntent();
       // Toast.makeText(ShowActivity.this,i.getStringExtra("stu"), Toast.LENGTH_SHORT).show();
        initView();
       MyData data= new MyData();
        setListener();
            data.getData("http://m.yunifang.com/yunifang/mobile/goods/detail","random=6716&encode=b02382bd9e457e06e09b68a6a4f26eb4&id="+i.getStringExtra("stu"),
                    Integer.parseInt(i.getStringExtra("stu")),365*24*60*60*1000);

    }
    private void setListener() {
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < dotList.size(); i++) {
                    if (i == position % dotList.size()) {
                        dotList.get(i).setImageResource(R.drawable.dot_true);
                    } else {
                        dotList.get(i).setImageResource(R.drawable.dot_false);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    double price;
    int number=1;
    String img_url;
    String name;
    int  kucun;
    private void upData(String result) {
        Gson g = new Gson();
        Goods goods = g.fromJson(result, Goods.class);
        gallery = goods.data.goods.gallery;
        vp.setAdapter(new GoodsPagerAdpter(gallery, this));
        intdot();
        lv.setAdapter(new CommonAdapter<Goods.DataBean.ActivityBean>(ShowActivity.this, goods.data.activity, R.layout.show_item) {
            @Override
            public void convert(ViewHolder helper, Goods.DataBean.ActivityBean item) {
                TextView tv = helper.getView(R.id.show_item_textView);
                tv.setText(item.title);
            }
        });
        kucun=goods.data.goods.sales_volume;
        name=goods.data.goods.goods_name;
        img_url=goods.data.goods.gallery.get(0).normal_url;
        xiangou =goods.data.goods.restrict_purchase_num;
        price=goods.data.goods.shop_price;
        mark_price.setText("￥" + goods.data.goods.market_price + "");
        shop_price.setText("￥" + goods.data.goods.shop_price + "");
        goods_name.setText(goods.data.goods.goods_name);
        comments =goods.data.comments;
        attitude =goods.data.goods.attributes;
        pics =goods.data.goods.goods_desc;
        Gson  gson=new Gson();
        urlBeen = gson.fromJson(pics, UrlBean[].class);
        listView.setAdapter(new CommonAdapter<Goods.DataBean.CommentsBean>(ShowActivity.this,comments,R.layout.comments_item) {
            @Override
            public void convert(ViewHolder helper, Goods.DataBean.CommentsBean item) {
                ImageView i=helper.getView(R.id.comments_item_imagView);
                TextView name=helper.getView(R.id.comments_item_name);
                TextView time=helper.getView(R.id.comments_item_time);
                TextView comments=helper.getView(R.id.comments_item_comments);
                ImageLoader.getInstance().displayImage(item.user.icon,i, ImageLoaderUtils.initCircleOptions());
                name.setText(item.user.nick_name);
                time.setText(item.createtime);
                comments.setText(item.content);
            }
        });
    }
    private void intdot() {
        dotList.clear();
        for (int i = 0; i < gallery.size(); i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0) {
                imageView.setImageResource(R.drawable.
                        dot_true);
            } else {
                imageView.setImageResource(R.drawable.dot_false);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(6,6);
            params.setMargins(5, 0, 5, 0);
            ll.addView(imageView, params);
            dotList.add(imageView);
        }
    }
    private void initView() {
       // invis = (LinearLayout) findViewById(invis);
       back =(ImageView)findViewById(R.id.back_show);
        vp = (ViewPager) findViewById(R.id.vp_show);
        add =(Button)findViewById(R.id.add);
        add.setOnClickListener(this);
        mark_price = (TextView) findViewById(R.id.mark_price);
        shop_price = (TextView) findViewById(R.id.shop_price);
        goods_name = (TextView) findViewById(R.id.goods_name);
        lv =(MyListView)findViewById(R.id.show_MylistView);
        ll =(LinearLayout)findViewById(R.id.show_ll);
        listView =(MyListView)findViewById(R.id.show_listView_three);
        textView1 = (TextView)findViewById(R.id.show_t1);
        textView1.setOnClickListener(this);
        textView2 = (TextView)findViewById(R.id.show_t2);
        textView2.setOnClickListener(this);
        textView3 = (TextView)findViewById(R.id.show_t3);
        textView3.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_show:
                finish();
                break;
        case R.id.show_t1:
                    List<UrlBean> list=new ArrayList<>();
            for(int i=0;i<urlBeen.length;i++){
                list.add(new UrlBean(urlBeen[i].url,urlBeen[i].width,urlBeen[i].height));
            }
            listView.setAdapter(new CommonAdapter<UrlBean>(ShowActivity.this,list,R.layout.desc_item) {
                    @Override
                    public void convert(ViewHolder helper, UrlBean item) {
                        ImageView i=helper.getView(R.id.desc_imagView);
                       i.setMaxWidth(Integer.parseInt(item.width));
                        i.setMaxHeight(Integer.parseInt(item.height));
                        i.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        ImageLoader.getInstance().displayImage(item.url,i,ImageLoaderUtils.initOptions());
                    }
                });
                break;
            case R.id.show_t2:
                listView.setAdapter(new CommonAdapter<Goods.DataBean.GoodsBean.AttributesBean>(ShowActivity.this,attitude,R.layout.parm_item) {
                    @Override
                    public void convert(ViewHolder helper, Goods.DataBean.GoodsBean.AttributesBean item) {
                       TextView t1=helper.getView(R.id.parm_text1);
                        TextView t2=helper.getView(R.id.parm_text2);
                        t1.setText(item.attr_name);
                        t2.setText(item.attr_value);
                    }
                });
                break;
            case R.id.show_t3:
                listView.setAdapter(new CommonAdapter<Goods.DataBean.CommentsBean>(ShowActivity.this,comments,R.layout.comments_item) {
                    @Override
                    public void convert(ViewHolder helper, Goods.DataBean.CommentsBean item) {
                        ImageView i=helper.getView(R.id.comments_item_imagView);
                        TextView name=helper.getView(R.id.comments_item_name);
                        TextView time=helper.getView(R.id.comments_item_time);
                        TextView comments=helper.getView(R.id.comments_item_comments);
                        ImageLoader.getInstance().displayImage(item.user.icon,i, ImageLoaderUtils.initCircleOptions());
                        name.setText(item.user.nick_name);
                        time.setText(item.createtime);
                        comments.setText(item.content);
                    }
                });
                break;
            case R.id.add:
                // TODO Auto-generated method stub
                getPopupWindow();
                // 这里是位置显示方式,在屏幕的左侧
                popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);
                break;
            case R.id.add_quer:
                dao.insert(new Shopping(price,name,number,img_url));
                Toast.makeText(ShowActivity.this,"添加成功",Toast.LENGTH_SHORT).show();;
                popupWindow.dismiss();
                break;
            case R.id.dis:
                popupWindow.dismiss();
                break;
            case R.id.pop_jia:
                if(number<xiangou){
                    number=number+1;
                    pop_cots.setText(number+"");
                }
                break;
            case R.id.pop_jian:
                if(number>1){
                    number=number-1;
                    pop_cots.setText(number+"");
                }
                break;


        }

    }
    private void getPopupWindow() {
        if (null != popupWindow) {
            popupWindow.dismiss();
            return;
        } else {
            initPopuptWindow();
        }
    }

    private void initPopuptWindow() {
        // TODO Auto-generated method stub
        // 获取自定义布局文件activity_popupwindow_left.xml的视图
        View popupWindow_view = getLayoutInflater().inflate(R.layout.addcart, null,
                false);
        add_imagview =(ImageView)popupWindow_view.findViewById(R.id.add_imagView);
        pop_price =(TextView)popupWindow_view.findViewById(R.id.pop_price);
        pop_number =(TextView)popupWindow_view.findViewById(R.id.pop_number);
        pop_xiangou =(TextView)popupWindow_view.findViewById(R.id.pop_xiangou);
        pop_jia =(TextView)popupWindow_view.findViewById(R.id.pop_jia);
        pop_jian =(TextView)popupWindow_view.findViewById(R.id.pop_jian);
        pop_cots =(TextView)popupWindow_view.findViewById(R.id.pop_cots);
        pop_jia.setOnClickListener(ShowActivity.this);
        pop_jian.setOnClickListener(ShowActivity.this);
        dis =(ImageView)popupWindow_view.findViewById(R.id.dis);
        dis.setOnClickListener(ShowActivity.this);
        quer =(Button)popupWindow_view.findViewById(R.id.add_quer);
        quer.setOnClickListener(ShowActivity.this);
        ImageLoader.getInstance().displayImage(img_url,add_imagview,ImageLoaderUtils.initOptions());
        pop_price.setText("￥"+price);
        pop_number.setText("库存"+kucun+"件");
        pop_xiangou.setText("限购"+xiangou+"件");
        // 创建PopupWindow实例,200,LayoutParams.MATCH_PARENT分别是宽度和高度
        popupWindow = new PopupWindow(popupWindow_view,  ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        // 设置动画效果
       // popupWindow.setAnimationStyle(R.style.AnimationFade);
        popupWindow.showAtLocation(popupWindow_view, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
        // 点击其他地方消失
       /* popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });*/
    }


    class MyData extends BaseData{
        @Override
        public void setResultData(String data) {
           upData(data);
        }

        @Override
        protected void setResulttError(ShowingPage.StateType stateLoadError) {

        }
    }
}
