package fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import adpter.AdpterLeft;
import bawei.mylibrary.OkHttpUtils;
import bawei.sunyubo20161222.R;
import bean.Bean;
import myclick.MyOnitemClickListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/22.
 */

public class LeftFragment extends Fragment {

    private RecyclerView lv;
    private List<Bean.RsBean> list;
    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.left_fragment,null);
        lv =(RecyclerView) view.findViewById(R.id.listView);
        getData();
        manager =getActivity().getSupportFragmentManager();
        return view;
    }

    private void getData() {
        OkHttpUtils.get("http://mock.eoapi.cn/success/4q69ckcRaBdxhdHySqp2Mnxdju5Z8Yr4", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                        String s=response.body().string();
                        Message message=Message.obtain();
                        message.obj=s;
                       handler.sendMessage(message);

            }
        });
    }
    private FragmentTransaction transaction;
    Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        final String s= (String) msg.obj;
        final Gson gson=new Gson();
        list = gson.fromJson(s,Bean.class).rs;
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        lv.setLayoutManager(linearLayoutManager);
        AdpterLeft adpter=new AdpterLeft(list,getActivity());
        adpter.setOnitemClickListener(new MyOnitemClickListener() {
            @Override
            public void setOnitemClickListener(int position) {
               // gson.fromJson(s, Bean.class).rs.get(item).children.get(0).children;
                List<Bean.RsBean.ChildrenBeanX.ChildrenBean> childrenBeen=gson.fromJson(s,Bean.class).rs.get(position).children.get(0).children;
                Right_fragment fragment = new Right_fragment();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.right_fragment,fragment, "fragment");
                transaction.addToBackStack("fragment");
                Bundle bundle = new Bundle();
                bundle.putSerializable("item", (Serializable) childrenBeen);
                fragment.setArguments(bundle);
               transaction.commit();
            }
        });
        lv.setAdapter(adpter);
    }
};
}
