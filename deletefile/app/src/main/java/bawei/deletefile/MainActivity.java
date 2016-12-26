package bawei.deletefile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private File file;
    private Button bt2;
    private FileOutputStream o;
    private InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt =(Button)findViewById(R.id.bt);
        bt2 =(Button)findViewById(R.id.bt2);
        file =getCacheDir();
        copy(file);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //土司内存大小
                long size=getsize(file);
                Toast.makeText(MainActivity.this,"内存大小:"+size+"",Toast.LENGTH_SHORT).show();

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long size=getsize(file);
                delete(file);
                Toast.makeText(MainActivity.this,"清理:"+size+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void copy(File file) {
        File f=new File(file,"adc.mp3");
        try {
            o = new FileOutputStream(f);
            in = getResources().openRawResource(R.raw.a);
            byte[] b=new byte[1024];
            int lenth=0;
            while((lenth= in.read(b))!=-1){
                o.write(b,0,lenth);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                in.close();
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    long getsize(File file){
        long size=0;
        File[] list=file.listFiles();
        if(list!=null){
            for(int i=0;i<list.length;i++){
               if(list[i].isDirectory()){
                   size=size+getsize(list[i]);
               }else{
                   size=size+list[i].length();
               }
            }
        }
       return size;
    }
         void delete(File file){
             File[] list=file.listFiles();
             if(list!=null){
               for(int i=0;i<list.length;i++){
                   //如果是文件直接删掉
                   if(list[i].isFile()){
                        list[i].delete();
                   }
                   else{
                       //如果是空文件夹
                       if(list[i].listFiles().length==0){
                           list[i].delete();
                       }else{
                           //如果不为空文件夹
                           delete(list[i]);
                       }
                   }
                   //若果文件夹放的是文件，删完文件，再删文件夹
                    list[i].delete();
               }
             }
         }
}
