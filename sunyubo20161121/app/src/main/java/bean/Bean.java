package bean;

import java.util.List;

/**
 * Created by Sunyubo on 2016/11/21.
 */
public class Bean {


    public int error_code;
    public String reason;
    public ResultBean result;

    public static class ResultBean {

        public List<DataBean> data;

        public static class DataBean {
            public String content;
            public String hashId;
            public int unixtime;
            public String updatetime;
        }
    }
}
