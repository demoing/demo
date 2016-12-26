package bean;

import java.util.List;

/**
 * Created by Sunyubo on 2016/11/12.
 */
public class Bean {


    public String message;
    public int status;


    public List<RsBean> rs;

    public static class RsBean {
        public boolean ischeck;
        public String attriCf;
        public String bigPicture;
        public String categoryGoto;
        public int clickCount;
        public String description;
        public String dirName;
        public String gotoApp;
        public String gotoWap;
        public int id;
        public String ifShowShoppingCart;
        public String imgApp;
        public String imgWap;
        public int level;
        public int parentId;
        public String pcCi;
        public String seoCf;
        public int sort;
        public List<?> advts;

        public List<ChildrenBean> children;

        public static class ChildrenBean {
            
            public List<ChildrenBean> children;
            public boolean isheader;
            public String attriCf;
            public String bigPicture;
            public String categoryGoto;
            public int clickCount;
            public String description;
            public String dirName;
            public String gotoApp;
            public String gotoWap;
            public int id;
            public String ifShowShoppingCart;
            public String imgApp;
            public String imgWap;
            public int level;
            public int parentId;
            public String pcCi;
            public String seoCf;
            public int sort;
            public List<?> advts;
        }
    }

}
