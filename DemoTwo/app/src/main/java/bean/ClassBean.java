package bean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/6.
 */

public class ClassBean {


    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        public List<CategoryBean> category;
        public List<GoodsBriefBean> goodsBrief;

        public static class CategoryBean {


            public String cat_name;
            public String id;
            public String is_leaf;
            public List<ChildrenBean> children;

            public static class ChildrenBean {

                public String cat_name;
                public String id;
                public String is_leaf;
            }
        }

        public static class GoodsBriefBean {

            public String efficacy;
            public String goods_img;
            public String goods_name;
            public String id;
            public double market_price;
            public boolean reservable;
            public double shop_price;
            public String watermarkUrl;
        }
    }
}
