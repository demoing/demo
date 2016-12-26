package bawei.okhttp;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by Sunyubo on 16/9/29.
 */
public abstract class BaseData {
    Context context;

    private final File fileDir;
    public static final int NOTIME = 0;
    public static final int NORMALTIME = 3 * 24 * 60 * 60 * 1000;
    //缓存数据存到哪里？
    public BaseData(Context context) {
        this.context=context;
        //找到存储路径
        File cacheDir = context.getCacheDir();
        fileDir = new File(cacheDir, "sunyubo");
        if (!fileDir.exists()) {
            //创建文件夹
            fileDir.mkdir();
        }
      //  BaseAdapter
    }
    //？name=zhangsan  index 索引
    // 0页
    //http://www.baidu.com
    ///data/data/com/yunifang/dlsdfaweifanewlgnawe0.text  dlsdfaweifanewlgnawe1.text
    //htt
    /**
     * @param path      请求地址
     * @param args      请求参数
     * @param index     页码索引
     * @param validTime 有效时间
     */
    public void getData(String path, String args, int index, int validTime) {
        //先判断有效时间
        if (validTime == 0) {
            //直接请求网络，要最新数据
            getDataFromNet(path, args, index, validTime);
        } else {
            //从本地获取
            String data = getDataFromLocal(path,index, validTime);
            if (TextUtils.isEmpty(data)) {
                //如果为空，请求网络
                getDataFromNet(path, args, index, validTime);
            } else {
                //拿到了数据，返回数据
                setResultData(data);
            }
        }
    }
    public abstract void setResultData(String data);

    private String getDataFromLocal(String path, int index, int validTime) {
        //读取文件信息
        //读时间
        try {
            File file = new File(fileDir, bawei.okhttp.MD5Encoder.encode(path) + index);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String s = bufferedReader.readLine();

            long time = Long.parseLong(s);
            //和当前时间进行比较
            //111-110
            if (System.currentTimeMillis() < time) {
                //将信息读出来
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }
                bufferedReader.close();
                return builder.toString();


            } else {
                //无效
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 从网络获取数据
     *
     * @param path
     * @param args
     * @param index
     * @param validTime
     */
    private void getDataFromNet(final String path, final String args, final int index, final int validTime) {
        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder()
                .url(path + "?" + args)
                .build();
        //new call
        Call call = mOkHttpClient.newCall(request);
        //请求加入调度
      call.enqueue(new Callback() {
          @Override
          public void onFailure(Request request, IOException e) {

          }

          @Override
          public void onResponse(Response response) throws IOException {
              final String data = response.body().string();
                Message message=Message.obtain();
                message.obj=data;
                h.sendMessage(message);
              //写到本地
              writeDataToLocal(path, args, index, validTime, data);
          }
      });
    }
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String s= (String) msg.obj;
            setResultData(s);
        }
    };
    //protected abstract void setResulttError(ShowingPage.StateType stateLoadError);

    /**
     * 将数据写到本地
     *
     * @param path
     * @param args
     * @param index
     * @param validTime
     * @param
     */
    private void writeDataToLocal(String path, String args, int index, int validTime, String data) {
        //每一条请求，都是生成一个文件  xzhanggsan   dawedfakwehfaowehfoaw2
        try {
            File file = new File(fileDir, bawei.okhttp.MD5Encoder.encode(path) + index);
            //写流信息
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            //323250328383
            //打开个娃偶尔很乏味偶发沃尔夫哈乌龟啊我费劲儿啊dddd
            //4.33+1
            bufferedWriter.write(System.currentTimeMillis() + validTime + "\r\n");
            //从网络上请求的数据
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
