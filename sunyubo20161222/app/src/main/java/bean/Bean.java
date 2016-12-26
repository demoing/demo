package bean;

import java.io.Serializable;
import java.util.List;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/22.
 */

public class Bean implements Serializable{


    public String message;
    public int status;
    public List<RsBean> rs;

    public static class RsBean implements Serializable{


        public boolean check;
        public String dirName;
        public int id;
        public List<ChildrenBeanX> children;

        public static class ChildrenBeanX implements Serializable{


            public String dirName;
            public int id;
            public String imgApp;
            public boolean isHeader;
            public List<ChildrenBean> children;

            public static class ChildrenBean implements Serializable{


                public String dirName;
                public int id;
                public String imgApp;
                public boolean isHeader;
                public List<?> children;
            }
        }
    }
}
