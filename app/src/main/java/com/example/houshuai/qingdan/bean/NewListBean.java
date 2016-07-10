package com.example.houshuai.qingdan.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 首页分类解析得到的实体类（专场）
 * Created by xiajie on 2016/7/8.
 */

public class NewListBean implements Serializable {



    private String page;
    private String page_size;
    private String items_style;
    private int main_img_height;
    private int main_img_width;
    private int count;
    private int today_count;


    private List<MzMartshowsBean> mz_martshows;
    private List<?> blast_items;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage_size() {
        return page_size;
    }

    public void setPage_size(String page_size) {
        this.page_size = page_size;
    }

    public String getItems_style() {
        return items_style;
    }

    public void setItems_style(String items_style) {
        this.items_style = items_style;
    }

    public int getMain_img_height() {
        return main_img_height;
    }

    public void setMain_img_height(int main_img_height) {
        this.main_img_height = main_img_height;
    }

    public int getMain_img_width() {
        return main_img_width;
    }

    public void setMain_img_width(int main_img_width) {
        this.main_img_width = main_img_width;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getToday_count() {
        return today_count;
    }

    public void setToday_count(int today_count) {
        this.today_count = today_count;
    }

    public List<MzMartshowsBean> getMz_martshows() {
        return mz_martshows;
    }

    public void setMz_martshows(List<MzMartshowsBean> mz_martshows) {
        this.mz_martshows = mz_martshows;
    }

    public List<?> getBlast_items() {
        return blast_items;
    }

    public void setBlast_items(List<?> blast_items) {
        this.blast_items = blast_items;
    }

    public static class MzMartshowsBean {
        private String event_id;
        private String seller_title;
        private String title;
        private int bid;
        private String brand;
        private String brand_story;
        private String logo;
        private String main_img;
        private int gmt_begin;
        private int gmt_end;
        private String label_img_tr;
        private int min_price;
        private int avg_price;
        private int min_discount;
        private String promotion;
        private String um_promotion;
        private int item_count;
        private String mj_promotion;

        public String getEvent_id() {
            return event_id;
        }

        public void setEvent_id(String event_id) {
            this.event_id = event_id;
        }

        public String getSeller_title() {
            return seller_title;
        }

        public void setSeller_title(String seller_title) {
            this.seller_title = seller_title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getBrand_story() {
            return brand_story;
        }

        public void setBrand_story(String brand_story) {
            this.brand_story = brand_story;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getMain_img() {
            return main_img;
        }

        public void setMain_img(String main_img) {
            this.main_img = main_img;
        }

        public int getGmt_begin() {
            return gmt_begin;
        }

        public void setGmt_begin(int gmt_begin) {
            this.gmt_begin = gmt_begin;
        }

        public int getGmt_end() {
            return gmt_end;
        }

        public void setGmt_end(int gmt_end) {
            this.gmt_end = gmt_end;
        }

        public String getLabel_img_tr() {
            return label_img_tr;
        }

        public void setLabel_img_tr(String label_img_tr) {
            this.label_img_tr = label_img_tr;
        }

        public int getMin_price() {
            return min_price;
        }

        public void setMin_price(int min_price) {
            this.min_price = min_price;
        }

        public int getAvg_price() {
            return avg_price;
        }

        public void setAvg_price(int avg_price) {
            this.avg_price = avg_price;
        }

        public int getMin_discount() {
            return min_discount;
        }

        public void setMin_discount(int min_discount) {
            this.min_discount = min_discount;
        }

        public String getPromotion() {
            return promotion;
        }

        public void setPromotion(String promotion) {
            this.promotion = promotion;
        }

        public String getUm_promotion() {
            return um_promotion;
        }

        public void setUm_promotion(String um_promotion) {
            this.um_promotion = um_promotion;
        }

        public int getItem_count() {
            return item_count;
        }

        public void setItem_count(int item_count) {
            this.item_count = item_count;
        }

        public String getMj_promotion() {
            return mj_promotion;
        }

        public void setMj_promotion(String mj_promotion) {
            this.mj_promotion = mj_promotion;
        }
    }
}
