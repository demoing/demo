package bawei.demotwo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class GuideThreeActivity extends AppCompatActivity {
    private ViewPager vp;
    private ArrayList<Integer> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_three);
        vp=(ViewPager) findViewById(R.id.three_vp);

        SharedPreferences sp=getSharedPreferences("isrem",0);
        boolean rem=sp.getBoolean("isrem",false);
      //  Toast.makeText(this,rem+"",Toast.LENGTH_SHORT).show();;
        if(rem){
            Intent i=new Intent(GuideThreeActivity.this,MainActivity.class);
            startActivity(i);
            finish();;

        }
        //添加数据
        initData();
        //适配器
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv=new ImageView(GuideThreeActivity.this);
                iv.setImageResource(list.get(position));
                container.addView(iv);
                return iv;
            }
        });

         final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
               SharedPreferences sp=getSharedPreferences("isrem",0);
                SharedPreferences.Editor ed= sp.edit();
                ed.putBoolean("isrem",true);
                ed.commit();
                Intent i=new Intent(GuideThreeActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        };
     vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

         }

         @Override
         public void onPageSelected(int position) {
                if(position==3){
                    handler.sendEmptyMessageDelayed(0,2000);
                }
         }

         @Override
         public void onPageScrollStateChanged(int state) {

         }
     });
    }

    //添加数据
    private void initData() {
        list.add(R.mipmap.xiaomi_guidance_1);
        list.add(R.mipmap.xiaomi_guidance_2);
        list.add(R.mipmap.xiaomi_guidance_3);
        list.add(R.mipmap.xiaomi_guidance_4);
    }
}
