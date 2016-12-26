package bawei.sunyubo20161114;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import adpter.Ad;
import bean.Student;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button up;
    private Button down;
    private Button start;
    private Button pause;
    private Button con;
    private ListView lv;
    List<File> list1=new ArrayList<>();
    private SeekBar sb;
    List<Student> list;
    private MediaPlayer mp;
    private void saomiao(File file) {

//        if(file.isDirectory()){
//            File[] files = file.listFiles();
//            if(files!=null){
//                for(File mfile:files){
//                    saomiao(mfile);
//
//                }
//
//            }
//
//        }else if(file.getName().endsWith("mp3")){
//            list.add(file);
//        }


        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory() || file.getName().endsWith(".mp3")) {
                    return true;
                } else {
                    return false;
                }

            }
        });
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    saomiao(files[i]);
                } else {
                    list1.add(files[i]);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();
       /* saomiao(Environment.getExternalStorageDirectory());
        for (int i=0;i<list1.size();i++){
            System.out.println(list1.get(i).getName());
        }*/

    }
    private void getSDFile(File root)
    {
        File files[] = root.listFiles();
        //为空的文件夹，不做任何动作
        if(files!=null)
        {
            for(File f:files)
            {
                if(f.isDirectory())//判断是否是文件夹
                {
                    getSDFile(f);

                }else{
                    if(f.getPath().endsWith(".mp3")){
                        list.add(new Student(f.getName(),f.getPath()));
                    }
                }

            }
        }
    }
    private void initdata() {

        list=new ArrayList<>();
        getSDFile(Environment.getExternalStorageDirectory());
        lv.setAdapter(new Ad(this,list));
    }
    public void play(String path){
        mp = new MediaPlayer();
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();
            int time=mp.getDuration();
            sb.setMax(time);
            Timer t=new Timer();
           // final  int c=mp.getCurrentPosition();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                   final  int c=mp.getCurrentPosition();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                             sb.setProgress(c);
                        }
                    });
                }
            },0,1000);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
};

    private void initview() {
        sb =(SeekBar)findViewById(R.id.seekBar);
        lv =(ListView)findViewById(R.id.lv);
        up =(Button)findViewById(R.id.button1);
        down =(Button)findViewById(R.id.button2);
        start =(Button)findViewById(R.id.button3);
        pause =(Button)findViewById(R.id.button4);
        con =(Button)findViewById(R.id.button5);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mp.seekTo(seekBar.getProgress());
            }
        });
        up.setOnClickListener(this);
        down.setOnClickListener(this);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        con.setOnClickListener(this);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student s=list.get(position);
                if(mp==null){
                    play(s.path);
                }else{
                   // mp=null;
                    mp.reset();
                    play(s.path);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:break;
        }
    }
}
