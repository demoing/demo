package bawei.demotwo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GuideTwoActivity extends AppCompatActivity {

    private TextView tv;
    int index=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_two);
        tv =(TextView)findViewById(R.id.guide_two_text);
        h.sendEmptyMessageDelayed(0,0);
    tv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            h.removeCallbacksAndMessages(null);
            Intent i=new Intent(GuideTwoActivity.this,GuideThreeActivity.class);
            startActivity(i);
            finish();
        }
    });

    }
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tv.setText("倒计时"+index);
            index=index-1;
            if(index==0){
                h.removeCallbacksAndMessages(null);
                Intent i=new Intent(GuideTwoActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
            h.sendEmptyMessageDelayed(0,1000);
        }
    };

}
