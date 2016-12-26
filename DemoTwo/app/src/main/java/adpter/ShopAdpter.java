package adpter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;
import bawei.demotwo.R;
import bean.Shopping;
import utils.ImageLoaderUtils;
/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/16.
 */

public class ShopAdpter  extends BaseAdapter{
    List<Shopping> list;
    Context context;
    TextView t1;
    public OnMoneyChangeListener onMoneyChangeListener;
    public ShopAdpter(TextView t1,List<Shopping> list, Context context, OnMoneyChangeListener onMoneyChangeListener) {
        this.list = list;
        this.context = context;
        this.t1=t1;
        this.onMoneyChangeListener = onMoneyChangeListener;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Shopping stu=list.get(position);
        final Vh vh;
        if(convertView==null){
            vh=new Vh();
           convertView=View.inflate(context, R.layout.cart_item,null);
            vh.imageView=(ImageView) convertView.findViewById(R.id.cart_item_imageView);
            vh.name=(TextView)convertView.findViewById(R.id.cart_item_name);
            vh.number=(TextView)convertView.findViewById(R.id.cart_item_number);
            vh.price=(TextView)convertView.findViewById(R.id.cart_item_price);
            vh.cb=(CheckBox) convertView.findViewById(R.id.cart_item_cb);
            vh.ll=(LinearLayout)convertView.findViewById(R.id.showorhide);
            convertView.setTag(vh);
        }else{
            vh= (Vh) convertView.getTag();
        }
        if(t1.getText().toString().equals("编辑")){
           vh.ll.setVisibility(View.GONE);
          vh.number.setVisibility(View.VISIBLE);
        }
        if(t1.getText().toString().equals("完成")){
           vh.ll.setVisibility(View.VISIBLE);
            vh.number.setVisibility(View.GONE);
        }
        ImageLoader.getInstance().displayImage(stu.url,vh.imageView, ImageLoaderUtils.initOptions());
        vh.name.setText(stu.name);
        vh.number.setText(stu.number+"");
        vh.price.setText(stu.price+"");
        vh.cb.setChecked(stu.falg);
        vh.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vh.cb.isChecked()){
                    stu.setFalg(true);
                }else{
                    stu.setFalg(false);
                }if(onMoneyChangeListener!=null) {
                    onMoneyChangeListener.setMoneyChangeListener();
                }
            }
        });
        return convertView;
    }
    public interface OnMoneyChangeListener {
        public abstract  void setMoneyChangeListener();
    }

    class Vh{

        LinearLayout ll;
        ImageView imageView;
        TextView name;
        TextView number;
        TextView price;
        CheckBox cb;
    }
}
