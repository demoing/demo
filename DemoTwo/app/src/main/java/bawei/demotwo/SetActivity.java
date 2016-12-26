package bawei.demotwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import utils.DataClearManager;


public class SetActivity extends AppCompatActivity  implements View.OnClickListener{

    private ImageView back;
    private ListView lv;
    private LinearLayout huancun;
    private TextView chche;
    private File cacheDir;
    private LinearLayout erweima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();

    }
    private void initView() {
        erweima =(LinearLayout)findViewById(R.id.erweima);
        back =(ImageView)findViewById(R.id.set_back);
        huancun =(LinearLayout)findViewById(R.id.huancun);
        chche =(TextView)findViewById(R.id.set_cache);
        back.setOnClickListener(this);
        huancun.setOnClickListener(this);
        erweima.setOnClickListener(this);
        cacheDir = getCacheDir();
        long cacheSize = getCacheSize(cacheDir);
        chche.setText("已缓存"+DataClearManager.getFormatSize(cacheSize));
    }
    private long getCacheSize(File dir) {
        long size = 0;
        File[] listFiles = dir.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            // 是个文件夹
            if (listFiles[i].isDirectory()) {
                size = size + getCacheSize(listFiles[i]);
            }
            // 当前是个文件
            else {
                size = size + listFiles[i].length();
            }
        }
        return size;

    }
    private void deleteCache(File dir) {
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
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.set_back :
                    finish();
                break;
            case R.id.huancun:
                // 清除缓存
                deleteCache(cacheDir);
                // 刷新textView
                // 获取当前缓存的大小
                long cacheSize = getCacheSize(cacheDir);
                chche.setText("已缓存"+DataClearManager.getFormatSize(cacheSize));
                Toast.makeText(SetActivity.this,"清除成功",Toast.LENGTH_SHORT).show();;
                break;
            case R.id.erweima:
                Intent i=new Intent(SetActivity.this,ZxingActivity.class);
                startActivity(i);
                break;
        }

    }
}
