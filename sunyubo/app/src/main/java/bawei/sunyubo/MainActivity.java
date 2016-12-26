package bawei.sunyubo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bawei.mylibrary.BaseData;
import bawei.mylibrary.DataClearManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv;
    private TextView size;
    private Button clear;
    private BaseData basedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =(TextView)findViewById(R.id.tv);
        size =(TextView)findViewById(R.id.size);
        clear =(Button)findViewById(R.id.clear);
        clear.setOnClickListener(this);
        basedata = new BaseData(this) {
            @Override
            public void setResultData(String data) {
                updata(data);
            }
        };
        basedata.getData("http://www.baidu.com","",0,3*24*60*60*1000);

    }

    private void updata(String data) {
        tv.setText(data);
        long max= basedata.getCacheSize(getCacheDir());
        String str= DataClearManager.getFormatSize(max);
        size.setText(str);
    }

    @Override
    public void onClick(View view) {
        basedata.deletecache(getCacheDir());
        long max= basedata.getCacheSize(getCacheDir());
        String str= DataClearManager.getFormatSize(max);
        size.setText(str);
        Toast.makeText(MainActivity.this,"清楚成功",Toast.LENGTH_SHORT).show();;
    }
}
