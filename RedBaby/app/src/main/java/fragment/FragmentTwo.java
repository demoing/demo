package fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adpter.MyAdpterRight;
import adpter.MyBaseAdpter;
import bawei.redbaby.R;
import bean.Bean;
import util.BaseFragment;
/**
 * Created by Sunyubo on 2016/11/10.
 */
public class FragmentTwo extends BaseFragment{
    private RecyclerView recyclerView_left;
    private RecyclerView recyclerView_right;
    private MyBaseAdpter ad;
    private Bean bean;
    int index=0;

    @Override
    public int bindLayout() {
        return R.layout.fragment_two;

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
    recyclerView_left =findview(R.id.recycleView_left);
    recyclerView_right =findview(R.id.recycleView_right);
    }

    @Override
    public void loadData() {
        String s=getAssets("category.json");
        Gson g=new Gson();
        bean =g.fromJson(s,Bean.class);
        final List<Bean.RsBean> list=bean.rs;
      //  System.out.println(list.size()+"------");
        ad =new MyBaseAdpter(list,getActivity());
        list.get(0).ischeck=true;
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView_left.setLayoutManager(layoutManager);
        recyclerView_left.setAdapter(ad);
        final List<Bean.RsBean.ChildrenBean> listall=new ArrayList<>();
        //右边的recycleView
        List<Bean.RsBean.ChildrenBean> childrenBeen=bean.rs.get(0).children;
        for (int i = 0; i < childrenBeen.size(); i++) {

                    childrenBeen.get(i).isheader=true;
                    listall.add(childrenBeen.get(i));
                 listall.addAll(childrenBeen.get(i).children);

        }
        final MyAdpterRight adpterRight=new MyAdpterRight(listall,getActivity());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return listall.get(position).isheader?3:1;
            }
        });
        recyclerView_right.setLayoutManager(gridLayoutManager);
        recyclerView_right.setAdapter(adpterRight);
        ad.setOnitemClickListener(new MyBaseAdpter.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(View view, int position) {
                    updata(position);
            }
            private void updata(int position) {
                list.get(index).ischeck=false;
                list.get(position).ischeck=true;
                index=position;
                up(position);

            }

            private void up(int position) {
                ad.notifyDataSetChanged();
                listall.clear();
                List<Bean.RsBean.ChildrenBean> childrenBeen=bean.rs.get(position).children;
                for (int i = 0; i < childrenBeen.size(); i++) {
                    childrenBeen.get(i).isheader=true;
                    listall.add(childrenBeen.get(i));
                    listall.addAll(childrenBeen.get(i).children);
                }
                adpterRight.notifyDataSetChanged();
            }
            public void setOnItemLongClickListener(View view, int position) {

            }
        });
    }
}
