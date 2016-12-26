package bawei.jishi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import util.CommonAdapter;
import util.ViewHolder;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*http://xinshipu.cn/20110528/smallImage1/1306536264861.jpg
http://xinshipu.cn/20100506/smallImage1/1273157301640.jpg
http://xinshipu.cn/20110721/smallImage1/1311234728768.jpg
http://xinshipu.cn/20100605/smallImage1/1275738758736.jpg
http://xinshipu.cn/20100506/smallImage1/1273106865078.jpg
http://xinshipu.cn/20100613/smallImage1/1276425889259.jpg
http://xinshipu.cn/20100521/original/1274403878791.jpg
http://xinshipu.cn/20110403/smallImage1/1301805300564.jpg
http://xinshipu.cn/20100325/smallImage1/1269459830286.jpg
http://xinshipu.cn/20150102/original/1420152641128.jpg
http://xinshipu.cn/20100809/smallImage1/1281348073140.jpg
http://xinshipu.cn/20140706/smallImage1/1404599235077.jpg
http://xinshipu.cn/20100325/smallImage1/1269495282911.jpg
http://xinshipu.cn/20130320/smallImage1/1363712079835.jpg
http://xinshipu.cn/20100323/smallImage1/1269319132942.jpg
http://xinshipu.cn/20100325/smallImage1/1269465144254.jpg
http://xinshipu.cn/20110627/smallImage1/1309127322498.jpg
http://xinshipu.cn/20150312/original/1426129355728.jpg*/
        lv =(ListView)findViewById(R.id.lv);
        List<String> list=new ArrayList<>();
        list.add("http://xinshipu.cn/20110528/smallImage1/1306536264861.jpg");
        list.add("http://xinshipu.cn/20100506/smallImage1/1273157301640.jpg");
        list.add("http://xinshipu.cn/20110721/smallImage1/1311234728768.jpg");
        list.add("http://xinshipu.cn/20100605/smallImage1/1275738758736.jpg");
        list.add("http://xinshipu.cn/20100613/smallImage1/1276425889259.jpg");
        list.add("http://xinshipu.cn/20100613/smallImage1/1276425889259.jpg");
            lv.setAdapter(new CommonAdapter<String>(MainActivity.this,list,R.layout.item) {
                @Override
                public void convert(ViewHolder helper, String item) {
                    ImageView i=helper.getView(R.id.imageview);
                    Glide.with(MainActivity.this).load(item).into(i);
                }
            });


    }
}
