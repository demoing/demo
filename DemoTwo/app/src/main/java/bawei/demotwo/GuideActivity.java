package bawei.demotwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import utils.CommonUtils;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //h.sendEmptyMessageDelayed(0,2000);
        CommonUtils.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(GuideActivity.this,GuideTwoActivity.class);
                startActivity(i);
                finish();
            }
        },1000);
    }
   /*     Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Intent i=new Intent(GuideActivity.this,MainActivity.class);
        startActivity(i);
    }
};*/

}
