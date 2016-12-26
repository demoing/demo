package bawei.xlist;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/21.
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
