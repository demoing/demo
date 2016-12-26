package bean;

/**
 * 1.类的用途
 * 2.@author:Sunyubo
 * 3.@ 2016/12/15.
 */

public class Shopping {
   public double price;
    public String name;
    public int number;
    public String url;
    public boolean falg;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }

    public Shopping(double price, String name, int number, String url, boolean falg) {
        this.price = price;
        this.name = name;
        this.number = number;
        this.url = url;
        this.falg = falg;
    }

    public Shopping(double price, String name, int number, String url) {
        this.price = price;
        this.name = name;
        this.number = number;
        this.url = url;
    }
}
