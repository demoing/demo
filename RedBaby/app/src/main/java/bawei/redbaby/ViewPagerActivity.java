package bawei.redbaby;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adpter.MyPagerApter;
import util.BaseActivity;

public class ViewPagerActivity extends BaseActivity implements View.OnClickListener{
    //3个view视图
    List<View> list=new ArrayList<>();
    //集合存放三个小圆点
    List<ImageView> dotlist=new ArrayList<>();
    private LinearLayout lay;
    private ViewPager vp;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;


    @Override
    public int bindLayout() {
        return R.layout.activity_view_pager;
    }

    @Override
    public void initData() {
        //初始化三个导航页面
        View view1=View.inflate(ViewPagerActivity.this,R.layout.view_one,null);
        View view2=View.inflate(ViewPagerActivity.this,R.layout.view_two,null);
        View view3=View.inflate(ViewPagerActivity.this,R.layout.view_three,null);
         imageView1 =(ImageView) view1.findViewById(R.id.guide_imageView1);
         imageView1.setOnClickListener(this);
        imageView2 =(ImageView) view2.findViewById(R.id.guide_imageView2);
        imageView2.setOnClickListener(this);
        imageView3 =(ImageView) view3.findViewById(R.id.guide_imageView3);
        imageView3.setOnClickListener(this);
        list.add(view1);
        list.add(view2);
        list.add(view3);

        for(int i=0;i<list.size();i++){
                ImageView imageView=new ImageView(this);
            if(i==0){
                imageView.setImageResource(R.drawable.dot_true);
            }else{
                imageView.setImageResource(R.drawable.dot_false);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(10,10);
            params.setMargins(5,0,5,0);
            lay.addView(imageView,params);
            dotlist.add(imageView);
        }
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //初始化控件
        lay =(LinearLayout)findViewById(R.id.ll);
        vp =(ViewPager)findViewById(R.id.vp);
        SharedPreferences sp=getSharedPreferences("rem",0);
        String s=sp.getString("load","123");
        if(s.equals("load")){
            Intent i=new Intent(ViewPagerActivity.this,ShowActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void loadData() {
        vp.setAdapter(new MyPagerApter(this,list));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    for(int i=0;i<list.size();i++){
                            ImageView imageView=dotlist.get(i);
                        if(i==position){
                            imageView.setImageResource(R.drawable.dot_true);
                        }else{
                            imageView.setImageResource(R.drawable.dot_false);
                        }
                    }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sp=getSharedPreferences("rem",0);
        SharedPreferences.Editor ed=sp.edit();
        switch (v.getId()){
            case R.id.guide_imageView1:
                ed.putString("load","load");
                ed.commit();
                Intent i=new Intent(ViewPagerActivity.this,ShowActivity.class);
                startActivity(i);
                break;
            case R.id.guide_imageView2:
                ed.putString("load","load");
                ed.commit();
                Intent i2=new Intent(ViewPagerActivity.this,ShowActivity.class);
                startActivity(i2);

                break;
            case R.id.guide_imageView3:
                ed.putString("load","load");
                ed.commit();
                Intent i3=new Intent(ViewPagerActivity.this,ShowActivity.class);
                startActivity(i3);
                break;

        }
    }
}
