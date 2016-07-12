package com.example.houshuai.qingdan.bean;

import android.os.Parcel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by haohao on 2016/7/9.
 */

public class typebean {

  
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 558
         * name : 特细型刨刀
         * fullName : Microplane 特细型刨刀
         * excerpt :
         * featuredImageUrl : http://img01.eqingdan.com/09aa0f4e-3feb-11e5-b8d4-00163e002745.jpeg?imageView2/1/w/320/h/320/q/75
         * imageUrls : ["http://img01.eqingdan.com/09aa0f4e-3feb-11e5-b8d4-00163e002745.jpeg?imageView2/1/w/640/h/640/q/75"]
         * description : <h2>▎产品说明</h2><p>Microplane号称“北美厨具第一刨”，它在家庭厨房及餐厅具有坚不可摧的地位，是厨房的必需品。该品牌的刨刀使用独特的化学抛尖技术，刀锋锋利无比，可以毫不费力的刮擦软硬食物，无需撕扯。</p><h2>▎产品参数</h2><p>尺寸：12×1.3×1 inches</p><p>重量：2.1 ounces</p><p>材质：18/8不锈钢</p><p>产地：美国</p><h2><img src="http://7xj2gj.com2.z0.glb.qiniucdn.com/35bb2f32-3feb-11e5-ad1f-00163e002745.png" title="35bb2f32-3feb-11e5-ad1f-00163e002745.png" alt="Icon - 亮点.png"/></h2><p>该品牌号称“北美厨具第一刨”，刀面使用纯正的18/8不锈钢材，锋利持久；手柄采用ABS树脂，强度高，韧性好。</p><h2><img src="http://7xj2gj.com2.z0.glb.qiniucdn.com/3b6c2a08-3feb-11e5-90f9-00163e002745.png" title="3b6c2a08-3feb-11e5-90f9-00163e002745.png" alt="Icon - 优点.png"/></h2><ul class=" list-paddingleft-2" style="list-style-type: disc;"><li><p>可用于巧克力、胡萝卜或软奶酪等食材的刨丝，刨出的细丝偏沫状，奶酪更容易拉丝。</p></li><li><p>多种颜色可选，美观大方，深得女性喜爱；美国原产，做工精细，持久耐用。</p></li></ul><h2><img src="http://7xj2gj.com2.z0.glb.qiniucdn.com/450deef2-3feb-11e5-a36d-00163e002745.png" title="450deef2-3feb-11e5-a36d-00163e002745.png" alt="Icon - 缺点.png"/></h2><p>价格偏高，使用场合有限。如需超粗丝刨，可在该品牌另行选购。</p><h2>▎总结评价</h2><p>适用于巧克力、肉桂、奶酪、葱姜蒜等食材的细丝。</p>
         * price : ￥82
         * buylinks : [{"platform":"Amazon","price":"￥82","link":"http://www.amazon.com/gp/product/B001VGS1M6/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=B001VGS1M6&linkCode=as2&tag=eqingdan-20&linkId=33KQO7UHIN25ZYU4"}]
         * isLiked : false
         * imageCount : 1
         * likeCount : 11
         * commentCount : 0
         * links : {"self":"http://api.eqingdan.com/v1/things/558","html":"http://www.eqingdan.com/app/things/558?version=1.0.2","share":"http://www.eqingdan.com/mobile/things/558","like":"http://api.eqingdan.com/v1/thing/558/actions/like","cancelLike":"http://api.eqingdan.com/v1/thing/558/actions/cancel-like"}
         * categories : [{"tagId":8483,"name":"刨刀","slug":"bao-dao","excerpt":"可用于巧克力、胡萝卜或软奶酪等食材的刨丝。","coverImageUrl":"http://img01.eqingdan.com/86296da4-9a2b-11e5-a845-00163e002745.jpeg?imageView2/1/w/640/h/640/q/75","thingCount":1,"articleCount":0,"links":{"wikiHtml":"http://www.eqingdan.com/app/categories/bao-dao/wiki?version=1.0.2","wikiShare":"http://www.eqingdan.com/mobile/categories/bao-dao/wiki","things":"http://api.eqingdan.com/v1/categories/bao-dao/things"},"featuredImageUrl":"?imageView2/1/w/160/h/160/q/75"}]
         * brand : {"name":"Microplane","slug":"microplane"}
         * creator : {"id":63,"username":"intern","nickname":"intern","tagline":"","avatarUrl":"http://img01.eqingdan.com/7821642e-3859-11e6-9f28-00163e002745.png?imageView2/1/w/120/h/120/q/75","backgroundImageUrl":null,"weibo":null,"wechat":null}
         */

        private List<ThingsBean> things;

        public List<ThingsBean> getThings() {
            return things;
        }

        public void setThings(List<ThingsBean> things) {
            this.things = things;
        }

        public  class ThingsBean implements Serializable{
            private int id;
            private String name;
            private String fullName;
            private String excerpt;
            private String featuredImageUrl;
            private String description;
            private String price;
            private boolean isLiked;
            private int imageCount;
            private int likeCount;
            private int commentCount;
            /**
             * self : http://api.eqingdan.com/v1/things/558
             * html : http://www.eqingdan.com/app/things/558?version=1.0.2
             * share : http://www.eqingdan.com/mobile/things/558
             * like : http://api.eqingdan.com/v1/thing/558/actions/like
             * cancelLike : http://api.eqingdan.com/v1/thing/558/actions/cancel-like
             */

            private LinksBean links;
            /**
             * name : Microplane
             * slug : microplane
             */

            private BrandBean brand;
            /**
             * id : 63
             * username : intern
             * nickname : intern
             * tagline :
             * avatarUrl : http://img01.eqingdan.com/7821642e-3859-11e6-9f28-00163e002745.png?imageView2/1/w/120/h/120/q/75
             * backgroundImageUrl : null
             * weibo : null
             * wechat : null
             */

            private CreatorBean creator;
            private List<String> imageUrls;
            /**
             * platform : Amazon
             * price : ￥82
             * link : http://www.amazon.com/gp/product/B001VGS1M6/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=B001VGS1M6&linkCode=as2&tag=eqingdan-20&linkId=33KQO7UHIN25ZYU4
             */

            private List<BuylinksBean> buylinks;
            /**
             * tagId : 8483
             * name : 刨刀
             * slug : bao-dao
             * excerpt : 可用于巧克力、胡萝卜或软奶酪等食材的刨丝。
             * coverImageUrl : http://img01.eqingdan.com/86296da4-9a2b-11e5-a845-00163e002745.jpeg?imageView2/1/w/640/h/640/q/75
             * thingCount : 1
             * articleCount : 0
             * links : {"wikiHtml":"http://www.eqingdan.com/app/categories/bao-dao/wiki?version=1.0.2","wikiShare":"http://www.eqingdan.com/mobile/categories/bao-dao/wiki","things":"http://api.eqingdan.com/v1/categories/bao-dao/things"}
             * featuredImageUrl : ?imageView2/1/w/160/h/160/q/75
             */

            private List<CategoriesBean> categories;

            protected ThingsBean(Parcel in) {
                id = in.readInt();
                name = in.readString();
                fullName = in.readString();
                excerpt = in.readString();
                featuredImageUrl = in.readString();
                description = in.readString();
                price = in.readString();
                isLiked = in.readByte() != 0;
                imageCount = in.readInt();
                likeCount = in.readInt();
                commentCount = in.readInt();
                imageUrls = in.createStringArrayList();
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }

            public String getExcerpt() {
                return excerpt;
            }

            public void setExcerpt(String excerpt) {
                this.excerpt = excerpt;
            }

            public String getFeaturedImageUrl() {
                return featuredImageUrl;
            }

            public void setFeaturedImageUrl(String featuredImageUrl) {
                this.featuredImageUrl = featuredImageUrl;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public boolean isIsLiked() {
                return isLiked;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public int getImageCount() {
                return imageCount;
            }

            public void setImageCount(int imageCount) {
                this.imageCount = imageCount;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public LinksBean getLinks() {
                return links;
            }

            public void setLinks(LinksBean links) {
                this.links = links;
            }

            public BrandBean getBrand() {
                return brand;
            }

            public void setBrand(BrandBean brand) {
                this.brand = brand;
            }

            public CreatorBean getCreator() {
                return creator;
            }

            public void setCreator(CreatorBean creator) {
                this.creator = creator;
            }

            public List<String> getImageUrls() {
                return imageUrls;
            }

            public void setImageUrls(List<String> imageUrls) {
                this.imageUrls = imageUrls;
            }

            public List<BuylinksBean> getBuylinks() {
                return buylinks;
            }

            public void setBuylinks(List<BuylinksBean> buylinks) {
                this.buylinks = buylinks;
            }

            public List<CategoriesBean> getCategories() {
                return categories;
            }

            public void setCategories(List<CategoriesBean> categories) {
                this.categories = categories;
            }
            public  class LinksBean implements Serializable{
                private String self;
                private String html;
                private String share;
                private String like;
                private String cancelLike;

                public String getSelf() {
                    return self;
                }

                public void setSelf(String self) {
                    this.self = self;
                }

                public String getHtml() {
                    return html;
                }

                public void setHtml(String html) {
                    this.html = html;
                }

                public String getShare() {
                    return share;
                }

                public void setShare(String share) {
                    this.share = share;
                }

                public String getLike() {
                    return like;
                }

                public void setLike(String like) {
                    this.like = like;
                }

                public String getCancelLike() {
                    return cancelLike;
                }

                public void setCancelLike(String cancelLike) {
                    this.cancelLike = cancelLike;
                }
            }

            public  class BrandBean implements Serializable{
                private String name;
                private String slug;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }
            }

            public  class CreatorBean implements Serializable{
                private int id;
                private String username;
                private String nickname;
                private String tagline;
                private String avatarUrl;
                private Object backgroundImageUrl;
                private Object weibo;
                private Object wechat;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getTagline() {
                    return tagline;
                }

                public void setTagline(String tagline) {
                    this.tagline = tagline;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public Object getBackgroundImageUrl() {
                    return backgroundImageUrl;
                }

                public void setBackgroundImageUrl(Object backgroundImageUrl) {
                    this.backgroundImageUrl = backgroundImageUrl;
                }

                public Object getWeibo() {
                    return weibo;
                }

                public void setWeibo(Object weibo) {
                    this.weibo = weibo;
                }

                public Object getWechat() {
                    return wechat;
                }

                public void setWechat(Object wechat) {
                    this.wechat = wechat;
                }
            }

            public  class BuylinksBean implements Serializable{
                private String platform;
                private String price;
                private String link;

                public String getPlatform() {
                    return platform;
                }

                public void setPlatform(String platform) {
                    this.platform = platform;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }
            }

            public  class CategoriesBean implements Serializable{
                private int tagId;
                private String name;
                private String slug;
                private String excerpt;
                private String coverImageUrl;
                private int thingCount;
                private int articleCount;
                /**
                 * wikiHtml : http://www.eqingdan.com/app/categories/bao-dao/wiki?version=1.0.2
                 * wikiShare : http://www.eqingdan.com/mobile/categories/bao-dao/wiki
                 * things : http://api.eqingdan.com/v1/categories/bao-dao/things
                 */

                private LinksBean links;
                private String featuredImageUrl;

                public int getTagId() {
                    return tagId;
                }

                public void setTagId(int tagId) {
                    this.tagId = tagId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getSlug() {
                    return slug;
                }

                public void setSlug(String slug) {
                    this.slug = slug;
                }

                public String getExcerpt() {
                    return excerpt;
                }

                public void setExcerpt(String excerpt) {
                    this.excerpt = excerpt;
                }

                public String getCoverImageUrl() {
                    return coverImageUrl;
                }

                public void setCoverImageUrl(String coverImageUrl) {
                    this.coverImageUrl = coverImageUrl;
                }

                public int getThingCount() {
                    return thingCount;
                }

                public void setThingCount(int thingCount) {
                    this.thingCount = thingCount;
                }

                public int getArticleCount() {
                    return articleCount;
                }

                public void setArticleCount(int articleCount) {
                    this.articleCount = articleCount;
                }

                public LinksBean getLinks() {
                    return links;
                }

                public void setLinks(LinksBean links) {
                    this.links = links;
                }

                public String getFeaturedImageUrl() {
                    return featuredImageUrl;
                }

                public void setFeaturedImageUrl(String featuredImageUrl) {
                    this.featuredImageUrl = featuredImageUrl;
                }

                public  class LinksBean implements Serializable{
                    private String wikiHtml;
                    private String wikiShare;
                    private String things;

                    public String getWikiHtml() {
                        return wikiHtml;
                    }

                    public void setWikiHtml(String wikiHtml) {
                        this.wikiHtml = wikiHtml;
                    }

                    public String getWikiShare() {
                        return wikiShare;
                    }

                    public void setWikiShare(String wikiShare) {
                        this.wikiShare = wikiShare;
                    }

                    public String getThings() {
                        return things;
                    }

                    public void setThings(String things) {
                        this.things = things;
                    }
                }
            }
        }
    }
}
