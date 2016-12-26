package bawei.ontouchevent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import fragment.Fragment1;
import fragment.Fragment2;
import fragment.Fragment3;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp =(ViewPager)findViewById(R.id.vp_out);
        initFragment();
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                   return  list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });
    }

    private void initFragment() {
        Fragment  fragment1=new Fragment1();
        Fragment  fragment2=new Fragment2();
        Fragment  fragment3=new Fragment3();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);

    }
}
