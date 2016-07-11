package com.example.houshuai.qingdan.bean;

import java.util.List;

/**解析每一个专场URL得到的实体类
 * Created by xiajie on 2016/7/10.
 */

public class ZhuanchangBean {



    private String seller_title;
    private int brand_id;
    private int union_type;
    private String brand;
    private String title;
    private String logo;
    private String event_id;
    private String buying_info;
    private String main_img;
    private String main_img_no_logo;
    private int main_img_height;
    private int main_img_width;
    private String brand_story;
    private int gmt_begin;
    private int gmt_end;
    private String sort;
    private String promotion;
    private boolean filter_sellout;
    private String mj_promotion;
    private String mj_icon;
    private int count;
    private int page;
    private int page_size;
    private int show_item_total_sale_num;
    private List<?> category_tree;


    private List<MartshowItemCategoriesBean> martshow_item_categories;


    private List<MartshowItemsBean> martshow_items;

    private List<RecomMartshowsListsBean> recom_martshows_lists;

    public String getSeller_title() {
        return seller_title;
    }

    public void setSeller_title(String seller_title) {
        this.seller_title = seller_title;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getUnion_type() {
        return union_type;
    }

    public void setUnion_type(int union_type) {
        this.union_type = union_type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getBuying_info() {
        return buying_info;
    }

    public void setBuying_info(String buying_info) {
        this.buying_info = buying_info;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public String getMain_img_no_logo() {
        return main_img_no_logo;
    }

    public void setMain_img_no_logo(String main_img_no_logo) {
        this.main_img_no_logo = main_img_no_logo;
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

    public String getBrand_story() {
        return brand_story;
    }

    public void setBrand_story(String brand_story) {
        this.brand_story = brand_story;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public boolean isFilter_sellout() {
        return filter_sellout;
    }

    public void setFilter_sellout(boolean filter_sellout) {
        this.filter_sellout = filter_sellout;
    }

    public String getMj_promotion() {
        return mj_promotion;
    }

    public void setMj_promotion(String mj_promotion) {
        this.mj_promotion = mj_promotion;
    }

    public String getMj_icon() {
        return mj_icon;
    }

    public void setMj_icon(String mj_icon) {
        this.mj_icon = mj_icon;
    }

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

    public int getShow_item_total_sale_num() {
        return show_item_total_sale_num;
    }

    public void setShow_item_total_sale_num(int show_item_total_sale_num) {
        this.show_item_total_sale_num = show_item_total_sale_num;
    }

    public List<?> getCategory_tree() {
        return category_tree;
    }

    public void setCategory_tree(List<?> category_tree) {
        this.category_tree = category_tree;
    }

    public List<MartshowItemCategoriesBean> getMartshow_item_categories() {
        return martshow_item_categories;
    }

    public void setMartshow_item_categories(List<MartshowItemCategoriesBean> martshow_item_categories) {
        this.martshow_item_categories = martshow_item_categories;
    }

    public List<MartshowItemsBean> getMartshow_items() {
        return martshow_items;
    }

    public void setMartshow_items(List<MartshowItemsBean> martshow_items) {
        this.martshow_items = martshow_items;
    }

    public List<RecomMartshowsListsBean> getRecom_martshows_lists() {
        return recom_martshows_lists;
    }

    public void setRecom_martshows_lists(List<RecomMartshowsListsBean> recom_martshows_lists) {
        this.recom_martshows_lists = recom_martshows_lists;
    }

    public static class MartshowItemCategoriesBean {
        private int cid;
        private int count;
        private String name;
        /**
         * vid : 0
         * name : 全部
         */

        private List<SizesBean> sizes;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SizesBean> getSizes() {
            return sizes;
        }

        public void setSizes(List<SizesBean> sizes) {
            this.sizes = sizes;
        }

        public static class SizesBean {
            private int vid;
            private String name;

            public int getVid() {
                return vid;
            }

            public void setVid(int vid) {
                this.vid = vid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class MartshowItemsBean {
        private int iid;
        private int product_id;
        private String vid;
        private String title;
        private String img;
        private int price;
        private int price_ori;
        private int discount;
        private int status;
        private String country_name;
        private String country_circle_icon;
        private String sale_tip;
        private int use_color;
        private int stock;
        private String label_img;
        private String event_type;

        public int getIid() {
            return iid;
        }

        public void setIid(int iid) {
            this.iid = iid;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
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

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public String getCountry_circle_icon() {
            return country_circle_icon;
        }

        public void setCountry_circle_icon(String country_circle_icon) {
            this.country_circle_icon = country_circle_icon;
        }

        public String getSale_tip() {
            return sale_tip;
        }

        public void setSale_tip(String sale_tip) {
            this.sale_tip = sale_tip;
        }

        public int getUse_color() {
            return use_color;
        }

        public void setUse_color(int use_color) {
            this.use_color = use_color;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public String getLabel_img() {
            return label_img;
        }

        public void setLabel_img(String label_img) {
            this.label_img = label_img;
        }

        public String getEvent_type() {
            return event_type;
        }

        public void setEvent_type(String event_type) {
            this.event_type = event_type;
        }
    }

    public static class RecomMartshowsListsBean {
        private int event_id;
        private String title;
        private String brand;
        private String main_img;
        private String banner;
        private String recom_id;
        private String mj_promotion_full;
        private String mj_promotion;
        private String promotion;
        private String buying_info;
        private String mj_icon;
        private int gmt_begin;
        private int gmt_end;
        private String brand_story;
        private String logo;
        /**
         * id : 10588672
         * iid : 10588672
         * product_id : 1241701
         * title : DIDIAONVREN/低调女人 韩版小白鞋女春秋2016休闲运动女鞋板鞋夏
         * img : http://b1.hucdn.com/upload/item/1603/17/00741442224656_800x800.jpg
         * price : 12900
         * price_ori : 22900
         * discount : 56
         */

        private List<RecomItemsBean> recom_items;

        public int getEvent_id() {
            return event_id;
        }

        public void setEvent_id(int event_id) {
            this.event_id = event_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getMain_img() {
            return main_img;
        }

        public void setMain_img(String main_img) {
            this.main_img = main_img;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public String getRecom_id() {
            return recom_id;
        }

        public void setRecom_id(String recom_id) {
            this.recom_id = recom_id;
        }

        public String getMj_promotion_full() {
            return mj_promotion_full;
        }

        public void setMj_promotion_full(String mj_promotion_full) {
            this.mj_promotion_full = mj_promotion_full;
        }

        public String getMj_promotion() {
            return mj_promotion;
        }

        public void setMj_promotion(String mj_promotion) {
            this.mj_promotion = mj_promotion;
        }

        public String getPromotion() {
            return promotion;
        }

        public void setPromotion(String promotion) {
            this.promotion = promotion;
        }

        public String getBuying_info() {
            return buying_info;
        }

        public void setBuying_info(String buying_info) {
            this.buying_info = buying_info;
        }

        public String getMj_icon() {
            return mj_icon;
        }

        public void setMj_icon(String mj_icon) {
            this.mj_icon = mj_icon;
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

        public List<RecomItemsBean> getRecom_items() {
            return recom_items;
        }

        public void setRecom_items(List<RecomItemsBean> recom_items) {
            this.recom_items = recom_items;
        }

        public static class RecomItemsBean {
            private int id;
            private int iid;
            private int product_id;
            private String title;
            private String img;
            private int price;
            private int price_ori;
            private int discount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIid() {
                return iid;
            }

            public void setIid(int iid) {
                this.iid = iid;
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

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }
        }
    }
}
