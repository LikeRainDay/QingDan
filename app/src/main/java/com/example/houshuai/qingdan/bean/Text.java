package com.example.houshuai.qingdan.bean;

/**
 * 测试数据
 * Created by Dufei on 2016/7/9.
 */

public class Text {
    private  int icon;
    private  String goodname;
    private String price;
    private String discount;
    //

    public Text(int icon, String goodname, String price, String discount) {
        this.icon = icon;
        this.goodname = goodname;
        this.price = price;
        this.discount = discount;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
