package a1501b.bawei.com.load;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.smssdk.SMSSDK;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/26.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        UMShareAPI.get(this);
        SMSSDK.initSDK(this, "1a3d1d952b092", "c4f5f938891c331de451953b013f6d90");
    }
}
