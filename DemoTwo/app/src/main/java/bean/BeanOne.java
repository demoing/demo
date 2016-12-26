package bean;

import java.io.Serializable;
import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/11/30.
 */
public class BeanOne implements Serializable{


    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        public int bigType;
        public int type;
        public ActivityInfoBean activityInfo;
        public boolean creditRecived;


        public List<Ad1Bean> ad1;

        public List<Ad5Bean> ad5;


        public List<BestSellersBean> bestSellers;


        public List<DefaultGoodsListBean> defaultGoodsList;


        public List<SubjectsBean> subjects;

        public static class ActivityInfoBean {
            public String activityAreaDisplay;

            public List<ActivityInfoListBean> activityInfoList;

            public static class ActivityInfoListBean {
                public String activityAreaDisplay;
                public String activityData;
                public String activityDataDetail;
                public String activityImg;
                public String activityStatus;
                public String activityType;
                public String countDownEnable;
                public String endSeconds;
                public String endtime;
                public String id;
                public int sort;
                public String startSeconds;
                public String starttime;
            }
        }

        public static class Ad1Bean {
            public int ad_type;
            public String ad_type_dynamic;
            public String ad_type_dynamic_data;
            public String ad_type_dynamic_detail;
            public String channelType;
            public String createtime;
            public String createuser;
            public int enabled;
            public String id;
            public String image;
            public int position;
            public String show_channel;
            public int sort;
        }

        public static class Ad5Bean {
            public int ad_type;
            public String ad_type_dynamic;
            public String ad_type_dynamic_data;
            public String ad_type_dynamic_detail;
            public int enabled;
            public String id;
            public String image;
            public int position;
            public String show_channel;
            public int sort;
            public String title;
        }

        public static class BestSellersBean {
            public String begin_date;
            public String descript;
            public String end_date;
            public String id;
            public String name;
            public int show_number;
            public String state;

            public List<GoodsListBean> goodsList;

            public static class GoodsListBean {
                public String efficacy;
                public String goods_img;
                public String goods_name;
                public String id;
                public double market_price;
                public boolean reservable;
                public double shop_price;
            }
        }

        public static class DefaultGoodsListBean {
            public String efficacy;
            public String goods_img;
            public String goods_name;
            public String id;
            public double market_price;
            public boolean reservable;
            public double shop_price;
        }

        public static class SubjectsBean implements Serializable{
            public String detail;
            public String end_time;
            public String id;
            public String image;
            public int show_number;
            public int sort;
            public String start_time;
            public String state;
            public String title;
            /**
             * efficacy : 清洁补水 提亮肤色
             * goods_img : http://image.hmeili.com/yunifang/images/goods/1254/goods_img/16112517549399376533709198.jpg
             * goods_name : 新品推荐|黑珍珠盈润亮采黑面膜7片
             * id : 1254
             * market_price : 99.0
             * reservable : false
             * shop_price : 49.9
             */

            public List<GoodsListBean> goodsList;

            public static class GoodsListBean implements  Serializable{
                public String efficacy;
                public String goods_img;
                public String goods_name;
                public String id;
                public double market_price;
                public boolean reservable;
                public double shop_price;
            }
        }
    }
}
