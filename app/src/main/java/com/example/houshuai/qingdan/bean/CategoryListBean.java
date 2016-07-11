package com.example.houshuai.qingdan.bean;

import java.util.List;

/**
 * Created by xiajie on 2016/7/10.
 */

public class CategoryListBean {




    private int count;
    private int page;
    private int page_size;


    private List<TuanItemsBean> tuan_items;


    private List<FanliItemsBean> fanli_items;


    private List<MzMartshowsBean> mz_martshows;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public List<TuanItemsBean> getTuan_items() {
        return tuan_items;
    }

    public void setTuan_items(List<TuanItemsBean> tuan_items) {
        this.tuan_items = tuan_items;
    }

    public List<FanliItemsBean> getFanli_items() {
        return fanli_items;
    }

    public void setFanli_items(List<FanliItemsBean> fanli_items) {
        this.fanli_items = fanli_items;
    }

    public List<MzMartshowsBean> getMz_martshows() {
        return mz_martshows;
    }

    public void setMz_martshows(List<MzMartshowsBean> mz_martshows) {
        this.mz_martshows = mz_martshows;
    }

    public static class TuanItemsBean {
        private int price_ori;
        private String img;
        private int iid;
        private int end_time;
        private int volumn;
        private int discount;
        private int num_iid;
        private String title;
        private int type;
        private int sid;
        private int start_time;
        private int event_id;
        private int price;
        private int clicks;
        private int logo;
        private String brand;
        private int status;
        private String desc;

        public int getPrice_ori() {
            return price_ori;
        }

        public void setPrice_ori(int price_ori) {
            this.price_ori = price_ori;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getIid() {
            return iid;
        }

        public void setIid(int iid) {
            this.iid = iid;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getVolumn() {
            return volumn;
        }

        public void setVolumn(int volumn) {
            this.volumn = volumn;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getNum_iid() {
            return num_iid;
        }

        public void setNum_iid(int num_iid) {
            this.num_iid = num_iid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getEvent_id() {
            return event_id;
        }

        public void setEvent_id(int event_id) {
            this.event_id = event_id;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getClicks() {
            return clicks;
        }

        public void setClicks(int clicks) {
            this.clicks = clicks;
        }

        public int getLogo() {
            return logo;
        }

        public void setLogo(int logo) {
            this.logo = logo;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public static class FanliItemsBean {
        private int tuan_id;
        private String iid;
        private String title;
        private String img;
        private int price;
        private int price_ori;
        private int end_time;
        private int start_time;

        public int getTuan_id() {
            return tuan_id;
        }

        public void setTuan_id(int tuan_id) {
            this.tuan_id = tuan_id;
        }

        public String getIid() {
            return iid;
        }

        public void setIid(String iid) {
            this.iid = iid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getPrice_ori() {
            return price_ori;
        }

        public void setPrice_ori(int price_ori) {
            this.price_ori = price_ori;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }
    }

    public static class MzMartshowsBean {
        private int event_id;
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
        private int min_discount;
        private String promotion;
        private int item_count;
        private String mj_promotion;

        public int getEvent_id() {
            return event_id;
        }

        public void setEvent_id(int event_id) {
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
