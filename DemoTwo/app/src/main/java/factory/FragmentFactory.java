package factory;

import android.support.v4.app.Fragment;

import java.util.HashMap;

import fragment.CartFragment;
import fragment.CategoryFragment;
import fragment.HomeFragment;
import fragment.MineFragment;

/**
 * Created by zhiyuan on 16/9/28.
 */
public class FragmentFactory {
    //集合
    public static HashMap<Integer,Fragment> fragmentHashMap=new HashMap<>();

    public static Fragment getFragment(int position) {
        Fragment fragment=fragmentHashMap.get(position);
      //  System.out.println("fragment:"+fragment);
        if(fragment!=null){
            return fragment;
        }
        switch (position) {
            case 0: fragment=new HomeFragment();break;
            case 1: fragment=new CategoryFragment();break;
            case 2: fragment=new CartFragment();break;
            case 3: fragment=new MineFragment();break;
        }
        fragmentHashMap.put(position,fragment);
        return fragment;
    }
}