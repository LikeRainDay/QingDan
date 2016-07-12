package com.example.houshuai.qingdan.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by haohao on 2016/7/8.
 */

public class javaBean {  
    private int code;
    private DataBean data;
    private String message;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private List<zongLeiBieBean> categories;

        public List<zongLeiBieBean> getCategories() {
            return categories;
        }

        public void setCategories(List<zongLeiBieBean> categories) {
            this.categories = categories;
        }

        public static class zongLeiBieBean {
            private int articleCount;
            private String coverImageUrl;
            private String excerpt;
            private String featuredImageUrl;
            /**
             * active : {"height":144,"imageUrl":"http://img01.eqingdan.com/43483348-084a-11e6-a3ef-00163e002745.png","width":132}
             * inactive : {"height":144,"imageUrl":"http://img01.eqingdan.com/51c529bc-084a-11e6-a624-00163e002745.png","width":132}
             */

            private IconsBean icons;
            /**
             * things : http://api.eqingdan.com/v1/categories/kitchen/things
             * wikiHtml : http://www.eqingdan.com/app/categories/kitchen/wiki?version=1.0.2
             * wikiShare : http://www.eqingdan.com/mobile/categories/kitchen/wiki
             */
            private LinksBean links;
            private String name;
            private String slug;
            private int thingCount;

            private List<biaoTiLeiBieBean> children;

            public int getArticleCount() {
                return articleCount;
            }

            public void setArticleCount(int articleCount) {
                this.articleCount = articleCount;
            }

            public String getCoverImageUrl() {
                return coverImageUrl;
            }

            public void setCoverImageUrl(String coverImageUrl) {
                this.coverImageUrl = coverImageUrl;
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

            public IconsBean getIcons() {
                return icons;
            }

            public void setIcons(IconsBean icons) {
                this.icons = icons;
            }

            public LinksBean getLinks() {
                return links;
            }

            public void setLinks(LinksBean links) {
                this.links = links;
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

            public int getThingCount() {
                return thingCount;
            }

            public void setThingCount(int thingCount) {
                this.thingCount = thingCount;
            }

            public List<biaoTiLeiBieBean> getChildren() {
                return children;
            }

            public void setChildren(List<biaoTiLeiBieBean> children) {
                this.children = children;
            }

            public static class IconsBean {
                /**
                 * height : 144
                 * imageUrl : http://img01.eqingdan.com/43483348-084a-11e6-a3ef-00163e002745.png
                 * width : 132
                 */

                private ActiveBean active;
                /**
                 * height : 144
                 * imageUrl : http://img01.eqingdan.com/51c529bc-084a-11e6-a624-00163e002745.png
                 * width : 132
                 */

                private InactiveBean inactive;

                public ActiveBean getActive() {
                    return active;
                }

                public void setActive(ActiveBean active) {
                    this.active = active;
                }

                public InactiveBean getInactive() {
                    return inactive;
                }

                public void setInactive(InactiveBean inactive) {
                    this.inactive = inactive;
                }

                public static class ActiveBean {
                    private int height;
                    private String imageUrl;
                    private int width;

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public String getImageUrl() {
                        return imageUrl;
                    }

                    public void setImageUrl(String imageUrl) {
                        this.imageUrl = imageUrl;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }
                }

                public static class InactiveBean {
                    private int height;
                    private String imageUrl;
                    private int width;

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }

                    public String getImageUrl() {
                        return imageUrl;
                    }

                    public void setImageUrl(String imageUrl) {
                        this.imageUrl = imageUrl;
                    }

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }
                }
            }

            public static class LinksBean {
                private String things;
                private String wikiHtml;
                private String wikiShare;

                public String getThings() {
                    return things;
                }

                public void setThings(String things) {
                    this.things = things;
                }

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
            }

            public static class biaoTiLeiBieBean implements Parcelable {
                private int articleCount;
                private String coverImageUrl;
                private String excerpt;
                private String featuredImageUrl;
                /**
                 * things : http://api.eqingdan.com/v1/categories/dao-jian/things
                 * wikiHtml : http://www.eqingdan.com/app/categories/dao-jian/wiki?version=1.0.2
                 * wikiShare : http://www.eqingdan.com/mobile/categories/dao-jian/wiki
                 */

                private LinksBean links;
                private String name;
                private String slug;
                private int thingCount;
                /**
                 * articleCount : 0
                 * children : []
                 * coverImageUrl : http://img01.eqingdan.com/51952f20-9688-11e5-8cd2-00163e002745.jpeg?imageView2/1/w/640/h/640/q/75
                 * excerpt : 特点是一把菜刀走天下，一把刀包含了多种功能，并且不同菜系的刀会略有不同。
                 * featuredImageUrl : ?imageView2/1/w/160/h/160/q/75
                 * links : {"things":"http://api.eqingdan.com/v1/categories/zhong-shi-cai-dao/things","wikiHtml":"http://www.eqingdan.com/app/categories/zhong-shi-cai-dao/wiki?version=1.0.2","wikiShare":"http://www.eqingdan.com/mobile/categories/zhong-shi-cai-dao/wiki"}
                 * name : 中式菜刀
                 * slug : zhong-shi-cai-dao
                 * thingCount : 5
                 */

                private List<juTiPinPaiBean> children;

                protected biaoTiLeiBieBean(Parcel in) {
                    articleCount = in.readInt();
                    coverImageUrl = in.readString();
                    excerpt = in.readString();
                    featuredImageUrl = in.readString();
                    name = in.readString();
                    slug = in.readString();
                    thingCount = in.readInt();
                }

                public static final Creator<biaoTiLeiBieBean> CREATOR = new Creator<biaoTiLeiBieBean>() {
                    @Override
                    public biaoTiLeiBieBean createFromParcel(Parcel in) {
                        return new biaoTiLeiBieBean(in);
                    }

                    @Override
                    public biaoTiLeiBieBean[] newArray(int size) {
                        return new biaoTiLeiBieBean[size];
                    }
                };

                public int getArticleCount() {
                    return articleCount;
                }

                public void setArticleCount(int articleCount) {
                    this.articleCount = articleCount;
                }

                public String getCoverImageUrl() {
                    return coverImageUrl;
                }

                public void setCoverImageUrl(String coverImageUrl) {
                    this.coverImageUrl = coverImageUrl;
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

                public LinksBean getLinks() {
                    return links;
                }

                public void setLinks(LinksBean links) {
                    this.links = links;
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

                public int getThingCount() {
                    return thingCount;
                }

                public void setThingCount(int thingCount) {
                    this.thingCount = thingCount;
                }

                public List<juTiPinPaiBean> getChildren() {
                    return children;
                }

                public void setChildren(List<juTiPinPaiBean> children) {
                    this.children = children;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeInt(articleCount);
                    parcel.writeString(coverImageUrl);
                    parcel.writeString(excerpt);
                    parcel.writeString(featuredImageUrl);
                    parcel.writeString(name);
                    parcel.writeString(slug);
                    parcel.writeInt(thingCount);
                }

                public static class LinksBean {
                    private String things;
                    private String wikiHtml;
                    private String wikiShare;

                    public String getThings() {
                        return things;
                    }

                    public void setThings(String things) {
                        this.things = things;
                    }

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
                }

                public static class juTiPinPaiBean implements Parcelable{
                    private int articleCount;
                    private String coverImageUrl;
                    private String excerpt;
                    private String featuredImageUrl;
                    /**
                     * things : http://api.eqingdan.com/v1/categories/zhong-shi-cai-dao/things
                     * wikiHtml : http://www.eqingdan.com/app/categories/zhong-shi-cai-dao/wiki?version=1.0.2
                     * wikiShare : http://www.eqingdan.com/mobile/categories/zhong-shi-cai-dao/wiki
                     */

                    private LinksBean links;
                    private String name;
                    private String slug;
                    private int thingCount;
                    private List<?> children;

                    protected juTiPinPaiBean(Parcel in) {
                        articleCount = in.readInt();
                        coverImageUrl = in.readString();
                        excerpt = in.readString();
                        featuredImageUrl = in.readString();
                        name = in.readString();
                        slug = in.readString();
                        thingCount = in.readInt();
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(articleCount);
                        dest.writeString(coverImageUrl);
                        dest.writeString(excerpt);
                        dest.writeString(featuredImageUrl);
                        dest.writeString(name);
                        dest.writeString(slug);
                        dest.writeInt(thingCount);
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    public static final Creator<juTiPinPaiBean> CREATOR = new Creator<juTiPinPaiBean>() {
                        @Override
                        public juTiPinPaiBean createFromParcel(Parcel in) {
                            return new juTiPinPaiBean(in);
                        }

                        @Override
                        public juTiPinPaiBean[] newArray(int size) {
                            return new juTiPinPaiBean[size];
                        }
                    };

                    public int getArticleCount() {
                        return articleCount;
                    }

                    public void setArticleCount(int articleCount) {
                        this.articleCount = articleCount;
                    }

                    public String getCoverImageUrl() {
                        return coverImageUrl;
                    }

                    public void setCoverImageUrl(String coverImageUrl) {
                        this.coverImageUrl = coverImageUrl;
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

                    public LinksBean getLinks() {
                        return links;
                    }

                    public void setLinks(LinksBean links) {
                        this.links = links;
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

                    public int getThingCount() {
                        return thingCount;
                    }

                    public void setThingCount(int thingCount) {
                        this.thingCount = thingCount;
                    }

                    public List<?> getChildren() {
                        return children;
                    }

                    public void setChildren(List<?> children) {
                        this.children = children;
                    }

                    public static class LinksBean {
                        private String things;
                        private String wikiHtml;
                        private String wikiShare;

                        public String getThings() {
                            return things;
                        }

                        public void setThings(String things) {
                            this.things = things;
                        }

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
                    }
                }
            }
        }
    }
}
