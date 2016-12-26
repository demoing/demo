package bawei.sunyubo1219;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/19.
 */

public class Bean {

    /**
     * pageBean : {"size":3,"total":48,"count":142,"current":1,"pages":[1,2,-2,47,48]}
     * items : [{"mobilePushId":3307,"title":"一周热榜（第二期）","body":"一周热榜（第二期）","url":"http://i.dxy.cn/post/channel/17","path":"http://res.dxycdn.com/upload/2016/12/19/14/76009340.jpg","avatarPath":"","sortTime":"2016-12-19 11:14:32"},{"mobilePushId":3306,"title":"从炸药到良药：解析 4 类扩血管药","body":"从炸药到良药：解析 4 类扩血管药","url":"http://www.dxy.cn/bbs/topic/35621932","path":"http://res.dxycdn.com/upload/2016/12/19/02/54620460.jpg","avatarPath":"","sortTime":"2016-12-19 11:02:52"},{"mobilePushId":3301,"title":"揪出腹部 CT 影像背后的「真凶」","body":"揪出腹部 CT 影像背后的「真凶」","url":"http://www.dxy.cn/bbs/topic/35592249","path":"http://res.dxycdn.com/upload/2016/12/16/48/21784281.jpg!640","avatarPath":"","sortTime":"2016-12-16 10:48:39"}]
     * status : success
     */

    public PageBeanBean pageBean;
    public String status;
    public List<ItemsBean> items;

    public static class PageBeanBean {
        /**
         * size : 3
         * total : 48
         * count : 142
         * current : 1
         * pages : [1,2,-2,47,48]
         */

        public int size;
        public int total;
        public int count;
        public int current;
        public List<Integer> pages;
    }

    public static class ItemsBean {
        /**
         * mobilePushId : 3307
         * title : 一周热榜（第二期）
         * body : 一周热榜（第二期）
         * url : http://i.dxy.cn/post/channel/17
         * path : http://res.dxycdn.com/upload/2016/12/19/14/76009340.jpg
         * avatarPath :
         * sortTime : 2016-12-19 11:14:32
         */

        public int mobilePushId;
        public String title;
        public String body;
        public String url;
        public String path;
        public String avatarPath;
        public String sortTime;
    }
}
