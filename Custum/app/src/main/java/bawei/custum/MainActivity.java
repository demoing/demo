package bawei.custum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import util.circle.Circle;
public class MainActivity extends AppCompatActivity {
    private Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle =(Circle)findViewById(R.id.c);
       /* custum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowActivity.class);
                startActivity(i);
            }
        });*/
        circle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    //得到点击点的坐标
                    float x = event.getX();
                    float y = event.getY();
//                    float x1 = event.getRawX();
//                    float y1 = event.getRawY();
                    float radius = circle.getR();
                    //得到相对圆心的 x y的相对距离
                    float xx = Math.abs(x-radius);
                    float yy = Math.abs(y-radius);
                    //勾股定律 计算点击点到圆心点距离
                    double disstance = Math.sqrt(xx*xx+yy*yy);
                    //判断 距离小于半径 即在圆内
                    if(disstance<radius){
                        startActivity(new Intent(MainActivity.this,ShowActivity.class));
                        return  true;
                    }
                }
                return false;
            }
        });

    }

}
