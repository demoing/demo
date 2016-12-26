package util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import bawei.mylibrary.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 * Created by Sunyubo on 2016/11/9.
 */
public  abstract  class  BaseActivity extends AppCompatActivity implements  MyOnCreate{

    private View mRootView;
    private FragmentManager supportFragmentManager = getSupportFragmentManager();
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(bindLayout()!=0){
            mRootView = View.inflate(this,bindLayout(),null);
            setContentView(mRootView);
            initView(savedInstanceState);
            initData();
            loadData();
        }
    }

    public View getmRootView() {
        return mRootView;
    }
    //异步请求
    public void getAyn(String url, final Handler handler, final int code){
        OkHttpUtils.get(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                        String string=response.body().string();
                Message msg=Message.obtain();
                msg.obj=string;
                msg.arg1=code;
                handler.sendMessage(msg);
            }
        });
    }
    public void showToast(CharSequence text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();;
}
    public void startAct(Class<? extends BaseActivity> cls){
        Intent i=new Intent(this,cls);
        startActivity(i);
    }
    public void startAct(Class<? extends BaseActivity> cls,Bundle bundle){
        Intent i=new Intent(this,cls);
        i.putExtras(bundle);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRootView=null;
    }

public void addfragment(int layout, Fragment fragment){

    fragmentTransaction = supportFragmentManager.beginTransaction();
    fragmentTransaction.add(layout,fragment);
    fragmentTransaction.commit();
}
  public void replace(int layout,Fragment fragment){
      fragmentTransaction = supportFragmentManager.beginTransaction();
      fragmentTransaction.replace(layout,fragment);
      fragmentTransaction.commit();
  }
public FragmentManager getFragmentManger(){
    return  supportFragmentManager;
}
}
