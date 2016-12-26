package bawei.clear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button bt;
    private InputStream inputStream;
    private FileOutputStream o;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv);
        bt =(Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletecache(file);
                long size=getCacheSize(file);
                String string=DataClearManager.getFormatSize(size);
                tv.setText(string);
                Toast.makeText(MainActivity.this, string,Toast.LENGTH_SHORT).show();

            }
        });
        //获取缓存路径
        file = getCacheDir();
        //获取当前缓存
        copyfile();
        //获取文件大小
        long size=getCacheSize(file);
        tv.setText(DataClearManager.getFormatSize(size));
    }

   /* private void deleteCache(File dir) {
        File[] listFiles = dir.listFiles();
        if(listFiles!=null){
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                } else {
                    // 该文件夹为空
                    if (listFiles[i].listFiles().length == 0) {
                        listFiles[i].delete();
                    } else {
                        // 继续遍历该文件夹，进行删除操作
                        deleteCache(listFiles[i]);
                    }
                }
                //删除文件
                listFiles[i].delete();
            }
        }
    }*/
    //我的
    private void deletecache(File file) {
       File[] files=file.listFiles();
        if(files!=null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    files[i].delete();
                }
                //文件夹为空
                else {
                    if (files[i].listFiles().length == 0) {
                        files[i].delete();
                    } else {
                        //继续便利进行删除
                        deletecache(files[i]);
                    }
                }
             files[i].delete();
            }
        }
        }


    private long getCacheSize(File file) {
        long size=0;
        File[] files=file.listFiles();
        for (int i=0;i<files.length;i++){
            //如果是个文件夹
            if(files[i].isDirectory()){
             size=size+getCacheSize(files[i]);
               // getCacheSize(files[i]);
            }
            else{
                size=size+files[i].length();
            }
        }
        return size;
    }

    private void copyfile() {

        try {
            o = new FileOutputStream(new File(file,"stu.mp3"));
            inputStream = getResources().openRawResource(R.raw.a);
            int lenth=0;
            byte[] bytes=new byte[1024];
            while((lenth=inputStream.read(bytes))!=-1){
                    o.write(bytes,0,lenth);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                o.close();
                inputStream.close();;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
