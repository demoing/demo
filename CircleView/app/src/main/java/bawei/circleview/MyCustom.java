package bawei.circleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/27.
 */
public class MyCustom extends View {

    private int height;
    private int width;
    private float x;
    private float y;
    private  float radius=40;
    private boolean onball;
    private Bitmap bitmap;
    private int bw;
    private int bh;

    public MyCustom(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyCustom(Context context) {
        this(context,null);

    }

    public MyCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //initView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //获取当前位置
               float downx=event.getX();
               float downy=event.getY();
                onball = isOnBall(downx,downy);
                Toast.makeText(getContext(),""+ onball,Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:

                if(onball){
                    x=event.getX();
                    y=event.getY();
                    //调用ondraw
                   // invalidate();
                    postInvalidate();
                }
                break;
        }
        return true;
    }

    private void initView() {

    }
    public boolean isOnBall(float downx,float downy){
        double sqrt = Math.sqrt((downx - x) * (downx - x) + (downy - y) * (downy - y));
        if(sqrt<=radius){
            return  true;
        }
        return  false;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        height = this.getHeight();
        width = this.getWidth();
        x = width/2;
        y = height/2;
    }
    boolean flas=true;
//cavas画布
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint paint=new Paint();
        paint.setColor(Color.RED);
       // canvas.drawCircle(x,y,radius,paint);
        if(flas){
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
            bw =bitmap.getWidth()/2;
            bh =bitmap.getHeight()/2;
            flas=false;
        }else{

        }
        canvas.drawBitmap(bitmap,x-bw,y-bh,null);
        Log.d("Tag","+++++"+"x"+x+"y"+y);
    }
}
