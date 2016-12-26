package fragment;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import adpter.ShopAdpter;
import base.BaseFragment;
import bawei.demotwo.R;
import bean.Shopping;
import database.Dao;
import view.ShowingPage;

import static bawei.demotwo.R.id.sum;


/**
 * Created by zhiyuan on 16/9/28.
 */
public class CartFragment extends BaseFragment implements View.OnClickListener{

    private View view;
    private ListView lv;
    private List<Shopping> list;
    private TextView sum_text;
    private TextView count_text;
    private CheckBox quanxuan;
    private ShopAdpter ad;
    private TextView qiehuan;
    private Button pays;
    private TextView counts;

    @Override
    protected void onLoad() {
        CartFragment.this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }
    @Override
    public View createSuccessView() {
        initView();
        return view;
    }

    private void initView() {
        view =View.inflate(getActivity(),R.layout.fragment_cart,null);
        lv =(ListView)view.findViewById(R.id.fragment_cart_lv);
        counts =(TextView)view.findViewById(R.id.counts);
        sum_text=(TextView)view.findViewById(sum);
        quanxuan =(CheckBox)view.findViewById(R.id.quanxuan);
        qiehuan =(TextView)view.findViewById(R.id.qiehuan);
        pays =(Button)view.findViewById(R.id.pays);
        pays.setOnClickListener(CartFragment.this);
        qiehuan.setOnClickListener(CartFragment.this);
        quanxuan.setOnClickListener(CartFragment.this);
        updata();
    }
    int count=0;
    public void jiesuan(){
        count=0;
        double sum=0;
        for(int i = 0; i< list.size(); i++){
            if(list.get(i).isFalg()){
                count++;
                sum=sum+ list.get(i).getPrice()*list.get(i).number;
            }
        }
        sum_text.setText("￥："+sum+"元");
        counts.setText("购物车"+"("+count+")");
    }
    private void updata() {
        Dao dao=new Dao(getActivity());
        list = dao.query();
        ad = new ShopAdpter(qiehuan,list, getActivity(), new ShopAdpter.OnMoneyChangeListener() {
            @Override
            public void setMoneyChangeListener() {
                //ad.notifyDataSetChanged();;
                jiesuan();
            }
        });
        lv.setAdapter(ad);
    }
    boolean flag=true;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quanxuan:
               if(quanxuan.isChecked()){
                   for(int i=0;i<list.size();i++){
                       list.get(i).setFalg(true);
                   }
               }else{
                   for(int i=0;i<list.size();i++){
                       list.get(i).setFalg(false);
                   }
               }
                ad.notifyDataSetChanged();
                jiesuan();
                break;
            case R.id.qiehuan:
               // Toast.makeText(getActivity(), "点击了", Toast.LENGTH_SHORT).show();
                    if(flag) {
                        qiehuan.setText("完成");
                        pays.setText("删除");
                    sum_text.setVisibility(View.GONE);
                        for(int i=0;i<list.size();i++){
                            list.get(i).setFalg(false);
                        }
                        jiesuan();

                    }else{
                        sum_text.setVisibility(View.VISIBLE);
                        qiehuan.setText("编辑");
                        pays.setText("结算");
                    }
                flag=!flag;
                ad.notifyDataSetChanged();
                break;
            case R.id.pays:
                if(pays.getText().toString().equals("结算")) {
                    if (count == 0) {
                        Toast.makeText(getActivity(), "尚未选择商品", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
                    }
                }else if(pays.getText().toString().equals("删除")){
                    Toast.makeText(getActivity(), "删除", Toast.LENGTH_SHORT).show();
                    for(int i = list.size()-1; i>=0; i--){
                        if(list.get(i).isFalg()){
                            list.remove(i);
                        }
                    }
                    ad.notifyDataSetChanged();
                }
                break;
        }
    }
}
