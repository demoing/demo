package bawei.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private ImageView i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 =(Button)findViewById(R.id.b1);
        b2 =(Button)findViewById(R.id.b2);
        b3 =(Button)findViewById(R.id.b3);
        b4 =(Button)findViewById(R.id.b4);
        i = (ImageView)findViewById(R.id.i);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
             case R.id.b1:
                 //位移
               ObjectAnimator translationX = ObjectAnimator.ofFloat(i, "translationX", 0, 10, 20, 30, 100, 200);
                 translationX.setDuration(5000);
               // translationX.setRepeatCount(ObjectAnimator.INFINITE);
                translationX.start();
                break;
            case R.id.b2:
                //旋转
                ObjectAnimator rotate = ObjectAnimator.ofFloat(i, "rotation", 0, 10, 20, 30, 100, 200);
                rotate.setDuration(3000);
                // translationX.setRepeatCount(ObjectAnimator.INFINITE);
                rotate.start();
                break;
            case R.id.b3:
                //透明
                ObjectAnimator alpha = ObjectAnimator.ofFloat(i, "alpha",1.0f,0.0f);
                alpha.setDuration(3000);
                // translationX.setRepeatCount(ObjectAnimator.INFINITE);
                alpha.start();
                break;
            case R.id.b4:
                //缩放
                ObjectAnimator scale = ObjectAnimator.ofFloat(i,"scaleX",1.0f,0.0f);
                scale.setDuration(3000);
                // translationX.setRepeatCount(ObjectAnimator.INFINITE);
                scale.start();
                break;
        }
    }
}
