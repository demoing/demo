package bawei.shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    List<Bean> list=new ArrayList<>();
    private TextView tv;
    private ListView lv;
    private MyAdpter ad;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();//初始化数据
        Toast.makeText(this,list.size()+"",Toast.LENGTH_SHORT).show();
        ad =new MyAdpter(MainActivity.this, list, new OnMoneyChangeListener() {
            @Override
            public void setMoneyChangeListener() {
                jiesuan();
            }
        });
        lv.setAdapter(ad);
    }
    private void initData() {
        for(int i=0;i<50;i++){
            list.add(new Bean("商品"+i,i+10,false));
        }
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.bt1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.bt2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.bt3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.bt4);
        button4.setOnClickListener(this);
        tv =(TextView)findViewById(R.id.tv);
        tv2 =(TextView)findViewById(R.id.tv2);
        lv =(ListView)findViewById(R.id.recyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt1:
                for(int i=0;i<list.size();i++){
                   list.get(i).setFlag(true);
                }
                ad.notifyDataSetChanged();
                jiesuan();
                break;
            case R.id.bt2:
                for(int i=0;i<list.size();i++){
                    list.get(i).setFlag(false);
                }
                ad.notifyDataSetChanged();
                jiesuan();

                break;
            case R.id.bt3:
                for(int i=0;i<list.size();i++){
                    list.get(i).setFlag(!list.get(i).flag);
                }
                ad.notifyDataSetChanged();
                jiesuan();

                break;
            case R.id.bt4:
            jiesuan();

                break;
        }
    }

    public void jiesuan(){
        int count=0;
        int sum=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).isFlag()){
                count++;
                sum=sum+list.get(i).getPrice();
            }
        }
        tv.setText(sum+"元");
        tv2.setText(count+"个");
    }
}
