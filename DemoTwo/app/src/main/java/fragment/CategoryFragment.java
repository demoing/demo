package fragment;

import android.content.Intent;
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
import base.BaseFragment;
import bawei.demotwo.R;
import bawei.demotwo.ShowActivity;
import bean.ClassBean;
import utils.CommonAdapter;
import utils.ImageLoaderUtils;
import utils.ViewHolder;
import view.ShowingPage;


/**
 * Created by zhiyuan on 16/9/28.
 */
public class CategoryFragment extends BaseFragment {
    List<ClassBean.DataBean> list=new ArrayList<>();
    String s;
    private View view;
    private GridView gv1;
    private GridView gv2;

    @Override
    protected void onLoad() {
        BaseData baseData=new BaseData() {
            @Override
            public void setResultData(String data) {
                    CategoryFragment.this.s=data;
                showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }

            @Override
            protected void setResulttError(ShowingPage.StateType stateLoadError) {

            }
        };
        baseData.getData("http://m.yunifang.com/yunifang/mobile/category/list?random=9503&encode=e181334d0cd93bf2ec95f3c9f85d1dde",
                "",0,3*24*60*60*1000);

    }
    @Override
    public View createSuccessView() {
        initview();
        Gson gson=new Gson();
        ClassBean.DataBean classBean=gson.fromJson(s,ClassBean.class).data;
        updata(classBean);
        return view;
    }

    private void updata(ClassBean.DataBean classBean) {
        List<ClassBean.DataBean.CategoryBean.ChildrenBean> list=classBean.category.get(2).children;
        gv1.setAdapter(new CommonAdapter<ClassBean.DataBean.CategoryBean.ChildrenBean>(getActivity(),list,R.layout.holder_class_gridview_item) {
            @Override
            public void convert(ViewHolder helper, ClassBean.DataBean.CategoryBean.ChildrenBean item) {
                  TextView tv= helper.getView(R.id.class_gv_tv);
                    tv.setText(item.cat_name);
            }
        });
        final List<ClassBean.DataBean.GoodsBriefBean> goodslist=classBean.goodsBrief;
        gv2.setAdapter(new CommonAdapter<ClassBean.DataBean.GoodsBriefBean>(getActivity(),goodslist,R.layout.holder_six_imagview_girdview_item) {
            @Override
            public void convert(ViewHolder helper, ClassBean.DataBean.GoodsBriefBean item) {
                TextView t1=helper.getView(R.id.six_tv1);
                TextView t2=helper.getView(R.id.six_tv2);
                TextView t3=helper.getView(R.id.six_tv3);
                TextView t4=helper.getView(R.id.six_tv4);
                ImageView i=helper.getView(R.id.six_imagview);
                t1.setText(item.efficacy);
                t2.setText(item.goods_name);
                t3.setText("￥"+item.shop_price);
                t4.setText("￥"+item.market_price);
                ImageLoader.getInstance().displayImage(item.goods_img,i, ImageLoaderUtils.initOptions());
            }
        });
        gv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(getActivity(), ShowActivity.class);
                i.putExtra("stu",goodslist.get(position).id);
                startActivity(i);
            }
        });
    }


    private void initview() {
        view=View.inflate(getActivity(), R.layout.fragment_calss,null);
        gv1 = (GridView) view.findViewById(R.id.class_gv1);
        gv2 = (GridView) view.findViewById(R.id.class_gv2);
    }
}
