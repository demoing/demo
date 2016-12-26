package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import adpter.AdpterRight;
import bawei.sunyubo20161222.R;
import bean.Bean;
import myclick.MyOnitemClickListener;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/22.
 */

public class Right_fragment extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.right_fragment,null);
       RecyclerView gv=(RecyclerView)view.findViewById(R.id.gridView);
        Bundle bundle = getArguments();
        if (bundle != null) {
            final List<Bean.RsBean.ChildrenBeanX.ChildrenBean> list =  (List<Bean.RsBean.ChildrenBeanX.ChildrenBean>) bundle.getSerializable("item");
            Toast.makeText(getActivity(), list.size()+"---",Toast.LENGTH_SHORT).show();
            GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),3);
            gv.setLayoutManager(gridLayoutManager);
           AdpterRight ad = new AdpterRight(getActivity(), list);
            gv.setAdapter(ad);
            ad.setOnitemClickListener(new MyOnitemClickListener() {
                @Override
                public void setOnitemClickListener(int position) {
                    Toast.makeText(getActivity(), list.get(position).dirName,Toast.LENGTH_SHORT).show();;
                }
            });
        }
        return view;
    }

}
