package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import bawei.ontouchevent.R;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/28.
 */
public class Fragment1 extends android.support.v4.app.Fragment{

    private View view;
    private ViewPager vp;
    private ListView lv;
    List<Integer> list=new ArrayList<>();
    List<String> list1=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

     //   view = inflater.inflate(R.layout.f1,null);
        view=View.inflate(getActivity(),R.layout.f1,null);
        vp =(ViewPager)view.findViewById(R.id.vp_in);
        lv =(ListView)view.findViewById(R.id.lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
        lv.setAdapter(new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list1));
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
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView i=new ImageView(getActivity());
                i.setImageResource(list.get(position));
                container.addView(i);
                return i;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
              //  super.destroyItem(container, position, object);
                container.removeView((View) object);
            }
        });
    }

    private void initdata() {
        list.clear();
        list.add(R.drawable.a1);
        list.add(R.drawable.a2);
        list.add(R.drawable.a3);
        list.add(R.drawable.a4);
        for(int i=0;i<20;i++){
            list1.add("这是第"+i+"条数据");

        }

    }
}
