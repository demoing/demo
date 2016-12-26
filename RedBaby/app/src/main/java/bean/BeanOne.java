package bean;

import java.util.List;

/**
 * Created by Sunyubo on 2016/11/14.
 */
public class BeanOne {
    public String api;
    public String code;
    public String msg;
    public String v;
    public int version;
    public List<DataBean> data;

    @Override
    public String toString() {
        return "BeanOne{" +
                "api='" + api + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", v='" + v + '\'' +
                ", version=" + version +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        public int elementShowNumber;
        public int elementType;
        public String modelFullCode;
        public int modelFullId;
        public int modelId;
        public int pmodelFullId;
        public int sequence;
        public List<TagBean> tag;

        @Override
        public String toString() {
            return "DataBean{" +
                    "elementShowNumber=" + elementShowNumber +
                    ", elementType=" + elementType +
                    ", modelFullCode='" + modelFullCode + '\'' +
                    ", modelFullId=" + modelFullId +
                    ", modelId=" + modelId +
                    ", pmodelFullId=" + pmodelFullId +
                    ", sequence=" + sequence +
                    ", tag=" + tag +
                    '}';
        }

        public static class TagBean {
            public String businessType;
            public String color;
            public String elementDesc;
            public String elementName;
            public int elementType;
            public int linkType;
            public String linkUrl;
            public int modelFullId;
            public String picUrl;
            public String productSpecialFlag;
            public int sequence;
            public int templateFullId;
            public String trickPoint;

            @Override
            public String toString() {
                return picUrl ;
            }
        }
    }
}
