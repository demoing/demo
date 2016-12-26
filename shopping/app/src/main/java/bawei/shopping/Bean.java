package bawei.shopping;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/2.
 */
public class Bean {
    public String name;
    public int price;
    public boolean flag;

    public Bean(String name, int price, boolean flag) {
        this.name = name;
        this.price = price;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
