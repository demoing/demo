package bawei.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =(TextView)findViewById(R.id.tv);
       BaseData data=new BaseData(MainActivity.this) {
           @Override
           public void setResultData(String data) {
               tv.setText(data);
           }
       };
        data.getData("http://m.yunifang.com/yunifang/mobile/home","",0,3*24*60*60*1000);

    }
}
