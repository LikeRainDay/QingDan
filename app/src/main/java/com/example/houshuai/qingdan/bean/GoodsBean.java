package com.example.houshuai.qingdan.bean;

import java.io.Serializable;
import java.util.List;

/**解析商品详情url得到的Bean类
 * Created by xiajie on 2016/7/11.
 */

public class GoodsBean {



    private int event_id;
    private int product_id;
    private String title;
    private String desc;
    private int price;
    private int origin_price;
    private String brand_desc;
    private int limit_num;
    private String limit_num_text;

    private ShareInfoBean share_info;
    private boolean has_promotion;
    private int iid;
    private String main_img;
    private int discount;
    private int focus_num;
    private int click_num;
    private String ship_city;
    private String logo;
    private String brand;
    private double shipping_rate;
    private double shipment_rate;
    private double total_rate;
    private String product_size_detail_url;
    private List<String> item_tips;


    private List<ProductSizesBean> product_sizes;

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(int origin_price) {
        this.origin_price = origin_price;
    }

    public String getBrand_desc() {
        return brand_desc;
    }

    public void setBrand_desc(String brand_desc) {
        this.brand_desc = brand_desc;
    }

    public int getLimit_num() {
        return limit_num;
    }

    public void setLimit_num(int limit_num) {
        this.limit_num = limit_num;
    }

    public String getLimit_num_text() {
        return limit_num_text;
    }

    public void setLimit_num_text(String limit_num_text) {
        this.limit_num_text = limit_num_text;
    }

    public ShareInfoBean getShare_info() {
        return share_info;
    }

    public void setShare_info(ShareInfoBean share_info) {
        this.share_info = share_info;
    }

    public boolean isHas_promotion() {
        return has_promotion;
    }

    public void setHas_promotion(boolean has_promotion) {
        this.has_promotion = has_promotion;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFocus_num() {
        return focus_num;
    }

    public void setFocus_num(int focus_num) {
        this.focus_num = focus_num;
    }

    public int getClick_num() {
        return click_num;
    }

    public void setClick_num(int click_num) {
        this.click_num = click_num;
    }

    public String getShip_city() {
        return ship_city;
    }

    public void setShip_city(String ship_city) {
        this.ship_city = ship_city;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getShipping_rate() {
        return shipping_rate;
    }

    public void setShipping_rate(double shipping_rate) {
        this.shipping_rate = shipping_rate;
    }

    public double getShipment_rate() {
        return shipment_rate;
    }

    public void setShipment_rate(double shipment_rate) {
        this.shipment_rate = shipment_rate;
    }

    public double getTotal_rate() {
        return total_rate;
    }

    public void setTotal_rate(double total_rate) {
        this.total_rate = total_rate;
    }

    public String getProduct_size_detail_url() {
        return product_size_detail_url;
    }

    public void setProduct_size_detail_url(String product_size_detail_url) {
        this.product_size_detail_url = product_size_detail_url;
    }

    public List<String> getItem_tips() {
        return item_tips;
    }

    public void setItem_tips(List<String> item_tips) {
        this.item_tips = item_tips;
    }

    public List<ProductSizesBean> getProduct_sizes() {
        return product_sizes;
    }

    public void setProduct_sizes(List<ProductSizesBean> product_sizes) {
        this.product_sizes = product_sizes;
    }

    public static class ShareInfoBean implements Serializable {
        private String share_channel;
        private String share_title;
        private String share_icon;
        private String share_desc;
        private String share_link;

        public String getShare_channel() {
            return share_channel;
        }

        public void setShare_channel(String share_channel) {
            this.share_channel = share_channel;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getShare_icon() {
            return share_icon;
        }

        public void setShare_icon(String share_icon) {
            this.share_icon = share_icon;
        }

        public String getShare_desc() {
            return share_desc;
        }

        public void setShare_desc(String share_desc) {
            this.share_desc = share_desc;
        }

        public String getShare_link() {
            return share_link;
        }

        public void setShare_link(String share_link) {
            this.share_link = share_link;
        }
    }

    public static class ProductSizesBean {
        private String vid;
        /**
         * key : 衣长
         * value : 62
         * unit : cm
         */

        private List<SizesBean> sizes;

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public List<SizesBean> getSizes() {
            return sizes;
        }

        public void setSizes(List<SizesBean> sizes) {
            this.sizes = sizes;
        }

        public static class SizesBean {
            private String key;
            private String value;
            private String unit;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }
        }
    }
}
