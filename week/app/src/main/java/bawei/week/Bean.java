package bawei.week;

import java.util.List;

/**
 * Created by Sunyubo on 2016/11/18.
 */
public class Bean {




    public int code;
    public int width;
    public boolean success;
    public int height;
    public Object message;

    public List<DataBean> data;

    public static class DataBean {
        public int replyTimes;
        public long topTime;
        public int recommend;
        public int click;
        public long createTime;
        public String occupation;
        public String introduction;
        public String url;
        public String yulin;
        public String hxKey;
        public String img;
        public int impressEditId;
        public int impressType;
        public String userImg;
        public int star;
        public String title;
        public int userAge;
        public String remark;
        public int source;
        public String userName;
        public int reporter;
        public int status;
        public String content;
    }
}
