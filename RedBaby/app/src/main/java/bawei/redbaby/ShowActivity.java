package bawei.redbaby;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import fragment.FragmentFour;
import fragment.FragmentOne;
import fragment.FragmentThree;
import fragment.FragmentTwo;
import util.BaseActivity;
import util.BaseFragment;

public class ShowActivity extends BaseActivity {

    private FrameLayout fl;
    List<BaseFragment> list=new ArrayList<>();
    private RadioGroup radioGroup;
    private FragmentManager fm;
    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentThree fragmentThree;
    private FragmentFour fragmentFour;
    private FragmentManager supportFragmentManager;


    @Override
    public int bindLayout() {
        return R.layout.activity_show;
    }

    @Override
    public void initData() {
        //初始化数据
      fragmentOne =new FragmentOne();
       fragmentTwo =new FragmentTwo();
     fragmentThree =new FragmentThree();
       fragmentFour =new FragmentFour();
        supportFragmentManager =getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.fl,fragmentOne).add(R.id.fl,fragmentTwo).add(R.id.fl,fragmentThree).add(R.id.fl,fragmentFour).hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour).commit();
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        fl =(FrameLayout)findViewById(R.id.fl);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.radio1:
                        supportFragmentManager.beginTransaction().show(fragmentOne).hide(fragmentTwo).hide(fragmentThree).hide(fragmentFour).commit();
                        break;
                    case R.id.radio2:
                        supportFragmentManager.beginTransaction().show(fragmentTwo).hide(fragmentOne).hide(fragmentThree).hide(fragmentFour).commit();
                        break;
                    case R.id.radio3:
                        supportFragmentManager.beginTransaction().show(fragmentThree).hide(fragmentTwo).hide(fragmentOne).hide(fragmentFour).commit();
                        break;
                    case R.id.radio4:
                        supportFragmentManager.beginTransaction().show(fragmentFour).hide(fragmentTwo).hide(fragmentThree).hide(fragmentOne).commit();
                        break;

                }
            }
        });
    }

    @Override
    public void loadData() {


    }
}
