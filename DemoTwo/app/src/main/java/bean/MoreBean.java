package bean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/13.
 */

public class MoreBean {


    public int code;
    public String msg;
    public List<DataBean> data;

    public static class DataBean {
        public String id;
        public String goods_name;
        public double shop_price;
        public double market_price;
        public boolean is_coupon_allowed;
        public boolean is_allow_credit;
        public String goods_img;
        public int sales_volume;
        public String efficacy;
        public String watermarkUrl;
        public int sort;
    }
}
