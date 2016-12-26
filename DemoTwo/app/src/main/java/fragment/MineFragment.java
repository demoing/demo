package fragment;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import base.BaseFragment;
import bawei.demotwo.R;
import bawei.demotwo.SetActivity;
import bean.Mine;
import utils.CommonAdapter;
import utils.ViewHolder;
import view.ShowingPage;
/**
 * Created by zhiyuan on 16/9/28.
 */
public class MineFragment extends BaseFragment {
    int[] arr={R.mipmap.ic_default,
            R.mipmap.ic_default,
            R.mipmap.ic_default,
            R.mipmap.ic_default,
            R.mipmap.ic_default,
            R.mipmap.ic_default,
            R.mipmap.ic_default,};
    String[] str={"我的订单","邀请有礼","刷脸测尺寸",
            "我的现金劵",
            "我的抽奖单",
            "我收藏的商品",
            "联系客服",};
    List<Mine> list=new ArrayList<>();
    private View view;
    private ListView lv;
    private ImageView setting;

    @Override
    protected void onLoad() {
        list.clear();
        initData();
        this.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    private void initData() {
        for(int i=0;i<str.length;i++){
            list.add(new Mine(arr[i],str[i]));
        }
    }

    @Override
    public View createSuccessView() {

        view =View.inflate(getActivity(),R.layout.fragment_mine,null);
        setting=(ImageView)view.findViewById(R.id.mine_img_setting);
        lv =(ListView)view.findViewById(R.id.mine_lv);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), SetActivity.class);
                startActivity(i);
            }
        });
        lv.setAdapter(new CommonAdapter<Mine>(getActivity(),list,R.layout.mine_listview_item) {
            @Override
            public void convert(ViewHolder helper, Mine item) {
                TextView textView=helper.getView(R.id.mine_text);
                textView.setText(item.name);
                ImageView imageView=helper.getView(R.id.mine_img);
                imageView.setImageResource(item.image);
            }
        });
        return view;
    }
}
