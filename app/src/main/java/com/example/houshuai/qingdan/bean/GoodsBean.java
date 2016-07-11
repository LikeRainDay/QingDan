package com.example.houshuai.qingdan.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**解析商品详情url得到的Bean类
 * Created by xiajie on 2016/7/11.
 */

public class GoodsBean {

    /**
     * event_id : 208164
     * product_id : 1532867
     * title : 新百隆（10双）春夏季T档无痕丝袜连裤袜
     * desc : 春夏季T档无痕丝袜连裤袜 防勾丝超薄款隐形显瘦女袜子
     * price : 3990
     * origin_price : 16900
     * status : 1
     * followed_num : 1556
     * seller_uid : 3253541
     * brand_id : 9449
     * sold_num : 17
     * tuan_sold_num : 0
     * like_num : 0
     * mall_type : 0
     * total_item_count : 86
     * item_new_count : 1
     * brand_collection_count : 4118
     * country_circle_icon :
     * brand_desc : 新百隆为中国爱美女性提供精致耐用的裤袜，公司拥有一支常年游走于欧美的设计师团队，参与时尚发布会，汲取最新时尚元素，注重女性的成长与感受，新百隆用对传统手工的创新与坚持，圆现代人返璞归真的梦想，手工传递梦想，用线条勾勒灵气美。
     * is_mart_lf : 0
     * brand_sold_num : 165298
     * limit_num : 5
     * limit_num_text : 单件商品限购5件
     * platform_promises : [{"text":"正品保证","icon":"http://b0.hucdn.com/prom/2016/icon/authentic_promise.png","target":"http://m.beibei.com/app/about.html"},{"text":"全场包邮","icon":"http://b0.hucdn.com/prom/2016/icon/baoyou_promise.png","target":"http://m.beibei.com/app/about.html"},{"text":"退货补运费","icon":"http://b0.hucdn.com/prom/2016/icon/buyunfei_promise.png","target":"http://m.beibei.com/app/about.html"}]
     * platform_new_promises : [{"text":"全场包邮","icon":"http://s0.husor.cn/prom/2016/icon/ic_brand_3x.png","target":"http://m.beibei.com/app/about.html"},{"text":"7天退货","icon":"http://s0.husor.cn/prom/2016/icon/ic_brand_3x.png","target":"http://m.beibei.com/app/about.html"},{"text":"100%正品","icon":"http://s0.husor.cn/prom/2016/icon/ic_brand_3x.png","target":"http://m.beibei.com/app/about.html"},{"text":"退货补运费","icon":"http://s0.husor.cn/prom/2016/icon/ic_brand_3x.png","target":"http://m.beibei.com/app/about.html"}]
     * platform_compensation_promises : [{"text":"假就赔","icon":"http://b0.hucdn.com/prom/2016/icon/compensation_promise.png","target":"http://m.beibei.com/app/about.html#3"},{"text":"贵就赔","icon":"http://b0.hucdn.com/prom/2016/icon/compensation_promise.png","target":"http://m.beibei.com/app/about.html#1"},{"text":"慢就赔","icon":"http://b0.hucdn.com/prom/2016/icon/compensation_promise.png","target":"http://m.beibei.com/app/about.html#2"}]
     * show_tax : 0
     * hidden_time : false
     * order_back_shell_msg : 购买后约返10个贝壳
     * order_back_shell_rule_url : http://m.beibei.com/app/cashback/rules.html
     * order_back_shell_levels : [{"desc":"购买后约返10个贝壳","level":1},{"desc":"购买后约返10个贝壳","level":2},{"desc":"购买后约返10个贝壳","level":3},{"desc":"购买后约返10个贝壳","level":4},{"desc":"购买后约返10个贝壳","level":5},{"desc":"购买后约返10个贝壳","level":6}]
     * is_foreign_pay : 0
     * iid : 10956867
     * gmt_begin : 1468166400
     * gmt_end : 1468598400
     * main_img : http://b1.hucdn.com/upload/item/1605/29/07035627883541_700x700.jpg
     * discount : 24
     * event_type : show
     * mj_promotion : 满59减5元，满99减10元
     * sbanner : http://b1.hucdn.com/upload/show/1607/05/89898398095771_750x350.jpg
     * event_banner : http://b1.hucdn.com/upload/show/1607/05/89898398095771_750x350.jpg
     * banner : http://b1.hucdn.com/upload/show/1606/22/64765837093541_640x640.jpg
     * brand_sub_title : 上新86款
     * rate_count : 6
     * ship_city : 浙江杭州
     * logo : http://b1.hucdn.com/upload/brand/1506/29/74243331929971_200x100.png
     * brand : 新百隆
     * product_props : [{"prop_name":"材质","prop_value":"包芯丝"},{"prop_name":"品牌","prop_value":"新百隆"},{"prop_name":"货号","prop_value":"6544"},{"prop_name":"风格","prop_value":"百搭,性感"},{"prop_name":"适用季节","prop_value":"不限季节"},{"prop_name":"图案","prop_value":"纯色"},{"prop_name":"产地","prop_value":"全国"},{"prop_name":"适用性别","prop_value":"女"},{"prop_name":"厚薄","prop_value":"薄款"},{"prop_name":"款式","prop_value":"连裤袜"},{"prop_name":"功能","prop_value":"居家"},{"prop_name":"上市时间","prop_value":"2016年夏季"},{"prop_name":"默认快递","prop_value":"EMS"},{"prop_name":"服务信息","prop_value":"由品牌商从浙江杭州发货"}]
     * props : <!DOCTYPE html> <html> <head> <meta charset="utf-8"><style type="text/css"> body {font-family: HeitiJ-Light, "Helvetica Neue", Helvetica, STHeiTi, sans-serif; font-size: 0.6rem;} html[data-dpr="3"] body {font-size: 0.512rem; } a {color: #0087D5; text-decoration: none } .props {width: 100%; color: #666; background-color:#fff;} .prop {padding: .512rem; padding-bottom: 0; display: block; vertical-align: top; overflow: hidden } .prop .label {text-align: justify; width: auto; width: 3.3rem } </style> <script> ! function(a) {function g() {a.rem = e.getBoundingClientRect().width / 16, e.style.fontSize = a.rem + "px"} var b, h, c = a.navigator.appVersion.match(/iphone/gi) ? a.devicePixelRatio : 1, d = 1 / c, e = document.documentElement, f = document.createElement("meta"); a.dpr = c, a.addEventListener("resize", function() {clearTimeout(b), b = setTimeout(g, 300) }, !1), a.addEventListener("pageshow", function(a) {a.persisted && (clearTimeout(b), b = setTimeout(g, 300)) }, !1), e.setAttribute("data-dpr", c), f.setAttribute("name", "viewport"), f.setAttribute("content", "initial-scale=" + d + ", maximum-scale=" + d + ", minimum-scale=" + d + ", user-scalable=no"), e.firstElementChild ? e.firstElementChild.appendChild(f) : (h = document.createElement("div"), h.appendChild(f), document.write(h.innerHTML)), g() }(window); </script></head><body><table class="props"><tr class="prop"><td class="label">材质</td><td>包芯丝</td></tr><tr class="prop"><td class="label">品牌</td><td>新百隆</td></tr><tr class="prop"><td class="label">货号</td><td>6544</td></tr><tr class="prop"><td class="label">风格</td><td>百搭,性感</td></tr><tr class="prop"><td class="label">适用季节</td><td>不限季节</td></tr><tr class="prop"><td class="label">图案</td><td>纯色</td></tr><tr class="prop"><td class="label">产地</td><td>全国</td></tr><tr class="prop"><td class="label">适用性别</td><td>女</td></tr><tr class="prop"><td class="label">厚薄</td><td>薄款</td></tr><tr class="prop"><td class="label">款式</td><td>连裤袜</td></tr><tr class="prop"><td class="label">功能</td><td>居家</td></tr><tr class="prop"><td class="label">上市时间</td><td>2016年夏季</td></tr><tr class="prop"><td class="label">默认快递</td><td>EMS</td></tr><tr class="prop"><td class="label">服务信息</td><td>由品牌商从浙江杭州发货</td></tr></table></body></html>
     * shipping_rate : 4.6
     * shipment_rate : 4.6
     * total_rate : 4.7
     * is_disable_buy_alone : 0
     * disable_buy_alone_message :
     * detail : <style>*{margin:0;padding:0}body{background-color:#eee}p img{display:block;width:100%}.detail{background-color:#fff;padding:.6rem .4rem;font-size:.6rem;color:#000}.detail img{display:block;width:auto}.detail img.placeholderfull{width:100%;height:auto!important}.detail img.full{width:100%}.detail img.placeholder{width:1px}.detail img:last-of-type{margin-bottom:.3rem}</style><script>!function(a){function g(){a.rem=e.getBoundingClientRect().width/16,e.style.fontSize=a.rem+"px"}var b,h,c=a.navigator.appVersion.match(/iphone/gi)?a.devicePixelRatio:1,d=1/c,e=document.documentElement,f=document.createElement("meta");a.dpr=c,a.addEventListener("resize",function(){clearTimeout(b),b=setTimeout(g,300)},!1),a.addEventListener("pageshow",function(a){a.persisted&&(clearTimeout(b),b=setTimeout(g,300))},!1),e.setAttribute("data-dpr",c),f.setAttribute("name","viewport"),f.setAttribute("content","initial-scale="+d+", maximum-scale="+d+", minimum-scale="+d+", user-scalable=no"),e.firstElementChild?e.firstElementChild.appendChild(f):(h=document.createElement("div"),h.appendChild(f),document.write(h.innerHTML)),g()}(window);</script><section class="detail"><p><a href='http://www.beibei.com?beibeiapp_info={"target":"http://t.beibei.com/shangxianmaiquan"}'>
     <img class="lazy" src="http://simg.husor.cn/bill/201607/cb82acca415a943110d1b0ffbee0da59948732_750x117.png"/></a></p><ul class=" list-paddingleft-2" style="list-style-type: disc;"><li><h1 style="text-align: center;">丝袜均码</h1></li><li><h1 style="text-align: center;">165cm以内</h1></li><li><h1 style="text-align: center;">105斤以内好穿哦<img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27492997223541_790x1397.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27480473033541_790x632.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27488517823541_790x624.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27482293623541_790x1301.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27491730133541_790x832.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27524342813541_790x832.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27483781273541_790x892.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27484993683541_790x862.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27488962673541_790x867.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27485496993541_790x861.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27559844053541_790x871.jpg!detail.jpg"/><img class="lazy" src="http://b1.hucdn.com/upload/item/1605/29/27574471443541_790x1175.jpg!detail.jpg"/></h1></li></ul></section><script>var imgs=document.querySelectorAll(".detail img");for(var i=0;i<imgs.length;i++){imgs[i].addEventListener("load",function(){if(this.getAttribute("src")=="http://s0.husor.cn/image/app/beibei_loading.jpg"){this.className="placeholderfull"}else{this.className="";if(this.width==1){this.className="placeholder"}else{this.className="full"}}})};</script>
     * detail_v2 : ["<style type=\"text/css\">.props{width:100%;color:#666;background-color:#fff;font-size:.512rem}.prop{padding:.512rem .512rem 0;display:block;vertical-align:top;overflow:hidden}.prop .label{text-align:justify;width:3.3rem}<\/style><table class=\"props\"><tr class=\"prop\"><td class=\"label\">材质<\/td><td>包芯丝<\/td><\/tr><tr class=\"prop\"><td class=\"label\">品牌<\/td><td>新百隆<\/td><\/tr><tr class=\"prop\"><td class=\"label\">货号<\/td><td>6544<\/td><\/tr><tr class=\"prop\"><td class=\"label\">风格<\/td><td>百搭,性感<\/td><\/tr><tr class=\"prop\"><td class=\"label\">适用季节<\/td><td>不限季节<\/td><\/tr><tr class=\"prop\"><td class=\"label\">图案<\/td><td>纯色<\/td><\/tr><tr class=\"prop\"><td class=\"label\">产地<\/td><td>全国<\/td><\/tr><tr class=\"prop\"><td class=\"label\">适用性别<\/td><td>女<\/td><\/tr><tr class=\"prop\"><td class=\"label\">厚薄<\/td><td>薄款<\/td><\/tr><tr class=\"prop\"><td class=\"label\">款式<\/td><td>连裤袜<\/td><\/tr><tr class=\"prop\"><td class=\"label\">功能<\/td><td>居家<\/td><\/tr><tr class=\"prop\"><td class=\"label\">上市时间<\/td><td>2016年夏季<\/td><\/tr><tr class=\"prop\"><td class=\"label\">默认快递<\/td><td>EMS<\/td><\/tr><tr class=\"prop\"><td class=\"label\">服务信息<\/td><td>由品牌商从浙江杭州发货<\/td><\/tr><\/table>","<style>.detail{background-color:#fff;padding:.6rem .4rem;font-size:.6rem;color:#000}.detail img{display:block;width:auto}.detail img.placeholderfull{width:100%;height:auto!important}.detail img.full{width:100%}.detail img.placeholder{width:1px}.detail img:last-of-type{margin-bottom:.3rem}<\/style><section class=\"detail\"><p><a href='http://www.beibei.com?beibeiapp_info={\"target\":\"http://t.beibei.com/shangxianmaiquan\"}'>\n<img class=\"lazy\" src=\"http://simg.husor.cn/bill/201607/cb82acca415a943110d1b0ffbee0da59948732_750x117.png\"/><\/a><\/p><ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><h1 style=\"text-align: center;\">丝袜均码<\/h1><\/li><li><h1 style=\"text-align: center;\">165cm以内<\/h1><\/li><li><h1 style=\"text-align: center;\">105斤以内好穿哦<img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27492997223541_790x1397.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27480473033541_790x632.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27488517823541_790x624.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27482293623541_790x1301.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27491730133541_790x832.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27524342813541_790x832.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27483781273541_790x892.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27484993683541_790x862.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27488962673541_790x867.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27485496993541_790x861.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27559844053541_790x871.jpg!detail.jpg\"/><img class=\"lazy\" src=\"http://b1.hucdn.com/upload/item/1605/29/27574471443541_790x1175.jpg!detail.jpg\"/><\/h1><\/li><\/ul><\/section><script>var imgs=document.querySelectorAll(\".detail img\");for(var i=0;i<imgs.length;i++){imgs[i].style = \"\";imgs[i].className = \"full\";imgs[i].addEventListener(\"load\",function(){if(this.getAttribute(\"src\")==\"http://s0.husor.cn/image/app/beibei_loading.jpg\"){this.className=\"placeholderfull\"}else{this.className=\"\";if(this.width==1){this.className=\"placeholder\"}else{this.className=\"full\"}}})};<\/script>","<style>.guarantee{margin:.3rem auto}.guarantee img{display:block;width:100%}<\/style><p class='guarantee'><a href='http://m.beibei.com/app/about.html?beibeiapp_info={\"target\":\"http://m.beibei.com/app/about.html\"}'><img src='http://b0.hucdn.com/prom/2016/prod_detail_promise_footer.png' /><\/a><\/p>"]
     * imgs : {"16":"http://b1.hucdn.com/upload/item/1605/29/07035627883541_700x700.jpg","995":"http://b1.hucdn.com/upload/item/1606/02/51257341423541_703x703.jpg","869":"http://b1.hucdn.com/upload/item/1606/02/51261651103541_703x703.jpg","996":"http://b1.hucdn.com/upload/item/1605/30/14519194313541_800x800.jpg","997":"http://b1.hucdn.com/upload/item/1605/30/14523935183541_800x800.jpg","998":"http://b1.hucdn.com/upload/item/1605/30/14526244763541_800x800.jpg","1002":"http://b1.hucdn.com/upload/item/1605/30/15823962793541_800x800.jpg"}
     * sku : {"sku_id_map":{"3":[16,869,995,996,997,998,1002],"161":[7384]},"sku_kv_map":{"k3":"颜色","v16":"黑色10双","k161":"尺码","v7384":"均码","v869":"灰色10双","v995":"肤色10双","v996":"黑5灰5","v997":"黑5肤5","v998":"灰5肤5","v1002":"黑4肤4灰2"},"sku_stock_map":{"v16v7384":{"sku_id":36659144,"stock":9996,"price":3990,"origin_price":16900},"v869v7384":{"sku_id":36659145,"stock":9999,"price":3990,"origin_price":16900},"v995v7384":{"sku_id":36659146,"stock":9987,"price":3990,"origin_price":16900},"v996v7384":{"sku_id":36792452,"stock":9999,"price":3990,"origin_price":16900},"v997v7384":{"sku_id":36792453,"stock":9999,"price":3990,"origin_price":16900},"v998v7384":{"sku_id":36792454,"stock":9997,"price":3990,"origin_price":16900},"v1002v7384":{"sku_id":36792455,"stock":9997,"price":3990,"origin_price":16900}}}
     * sku_expand : true
     * num : 69974
     * stock : 69974
     * labels : ["折扣","包邮"]
     * promotion_tips : [{"icon":"http://s0.husor.cn/image/app/img_detail_tag1_v1.png","message":"满59减5元，满99减10元","short_message":"专场满减"},{"icon":"http://s0.husor.cn/image/app/img_detail_tag2_v1.png","message":"购买后约返10个贝壳","short_message":"返贝壳","rule_url":"http://m.beibei.com/app/cashback/rules.html","levels":[{"desc":"购买后约返10个贝壳","level":1},{"desc":"购买后约返10个贝壳","level":2},{"desc":"购买后约返10个贝壳","level":3},{"desc":"购买后约返10个贝壳","level":4},{"desc":"购买后约返10个贝壳","level":5},{"desc":"购买后约返10个贝壳","level":6}]}]
     * mizhe_promotion_tips : {"mj_promotion":{"icon":"http://s0.husor.cn/image/app/img_detail_tag1_v1.png","message":"满59减5元，满99减10元","short_message":"专场满减"}}
     * tags : []
     * product_sizes : []
     * rate_tags : []
     * rate_items : []
     * platform_advantages : ["正品保证","全场包邮","7天无理由退货"]
     * guarantee_url : http://m.beibei.com/app/about.html
     */

    private int event_id;
    private int product_id;
    private String title;
    private String desc;
    private int price;
    private int origin_price;
    private int status;
    private int followed_num;
    private int seller_uid;
    private int brand_id;
    private int sold_num;
    private int tuan_sold_num;
    private int like_num;
    private int mall_type;
    private int total_item_count;
    private int item_new_count;
    private int brand_collection_count;
    private String country_circle_icon;
    private String brand_desc;
    private int is_mart_lf;
    private int brand_sold_num;
    private int limit_num;
    private String limit_num_text;
    private int show_tax;
    private boolean hidden_time;
    private String order_back_shell_msg;
    private String order_back_shell_rule_url;
    private int is_foreign_pay;
    private int iid;
    private int gmt_begin;
    private int gmt_end;
    private String main_img;
    private int discount;
    private String event_type;
    private String mj_promotion;
    private String sbanner;
    private String event_banner;
    private String banner;
    private String brand_sub_title;
    private int rate_count;
    private String ship_city;
    private String logo;
    private String brand;
    private String props;
    private double shipping_rate;
    private double shipment_rate;
    private double total_rate;
    private int is_disable_buy_alone;
    private String disable_buy_alone_message;
    private String detail;
    /**
     * 16 : http://b1.hucdn.com/upload/item/1605/29/07035627883541_700x700.jpg
     * 995 : http://b1.hucdn.com/upload/item/1606/02/51257341423541_703x703.jpg
     * 869 : http://b1.hucdn.com/upload/item/1606/02/51261651103541_703x703.jpg
     * 996 : http://b1.hucdn.com/upload/item/1605/30/14519194313541_800x800.jpg
     * 997 : http://b1.hucdn.com/upload/item/1605/30/14523935183541_800x800.jpg
     * 998 : http://b1.hucdn.com/upload/item/1605/30/14526244763541_800x800.jpg
     * 1002 : http://b1.hucdn.com/upload/item/1605/30/15823962793541_800x800.jpg
     */

    private ImgsBean imgs;
    /**
     * sku_id_map : {"3":[16,869,995,996,997,998,1002],"161":[7384]}
     * sku_kv_map : {"k3":"颜色","v16":"黑色10双","k161":"尺码","v7384":"均码","v869":"灰色10双","v995":"肤色10双","v996":"黑5灰5","v997":"黑5肤5","v998":"灰5肤5","v1002":"黑4肤4灰2"}
     * sku_stock_map : {"v16v7384":{"sku_id":36659144,"stock":9996,"price":3990,"origin_price":16900},"v869v7384":{"sku_id":36659145,"stock":9999,"price":3990,"origin_price":16900},"v995v7384":{"sku_id":36659146,"stock":9987,"price":3990,"origin_price":16900},"v996v7384":{"sku_id":36792452,"stock":9999,"price":3990,"origin_price":16900},"v997v7384":{"sku_id":36792453,"stock":9999,"price":3990,"origin_price":16900},"v998v7384":{"sku_id":36792454,"stock":9997,"price":3990,"origin_price":16900},"v1002v7384":{"sku_id":36792455,"stock":9997,"price":3990,"origin_price":16900}}
     */

    private SkuBean sku;
    private boolean sku_expand;
    private int num;
    private int stock;
    /**
     * mj_promotion : {"icon":"http://s0.husor.cn/image/app/img_detail_tag1_v1.png","message":"满59减5元，满99减10元","short_message":"专场满减"}
     */

    private MizhePromotionTipsBean mizhe_promotion_tips;
    private String guarantee_url;
    /**
     * text : 正品保证
     * icon : http://b0.hucdn.com/prom/2016/icon/authentic_promise.png
     * target : http://m.beibei.com/app/about.html
     */

    private List<PlatformPromisesBean> platform_promises;
    /**
     * text : 全场包邮
     * icon : http://s0.husor.cn/prom/2016/icon/ic_brand_3x.png
     * target : http://m.beibei.com/app/about.html
     */

    private List<PlatformNewPromisesBean> platform_new_promises;
    /**
     * text : 假就赔
     * icon : http://b0.hucdn.com/prom/2016/icon/compensation_promise.png
     * target : http://m.beibei.com/app/about.html#3
     */

    private List<PlatformCompensationPromisesBean> platform_compensation_promises;
    /**
     * desc : 购买后约返10个贝壳
     * level : 1
     */

    private List<OrderBackShellLevelsBean> order_back_shell_levels;
    /**
     * prop_name : 材质
     * prop_value : 包芯丝
     */

    private List<ProductPropsBean> product_props;
    private List<String> detail_v2;
    private List<String> labels;
    /**
     * icon : http://s0.husor.cn/image/app/img_detail_tag1_v1.png
     * message : 满59减5元，满99减10元
     * short_message : 专场满减
     */

    private List<PromotionTipsBean> promotion_tips;
    private List<?> tags;
    private List<?> product_sizes;
    private List<?> rate_tags;
    private List<?> rate_items;
    private List<String> platform_advantages;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFollowed_num() {
        return followed_num;
    }

    public void setFollowed_num(int followed_num) {
        this.followed_num = followed_num;
    }

    public int getSeller_uid() {
        return seller_uid;
    }

    public void setSeller_uid(int seller_uid) {
        this.seller_uid = seller_uid;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getSold_num() {
        return sold_num;
    }

    public void setSold_num(int sold_num) {
        this.sold_num = sold_num;
    }

    public int getTuan_sold_num() {
        return tuan_sold_num;
    }

    public void setTuan_sold_num(int tuan_sold_num) {
        this.tuan_sold_num = tuan_sold_num;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public int getMall_type() {
        return mall_type;
    }

    public void setMall_type(int mall_type) {
        this.mall_type = mall_type;
    }

    public int getTotal_item_count() {
        return total_item_count;
    }

    public void setTotal_item_count(int total_item_count) {
        this.total_item_count = total_item_count;
    }

    public int getItem_new_count() {
        return item_new_count;
    }

    public void setItem_new_count(int item_new_count) {
        this.item_new_count = item_new_count;
    }

    public int getBrand_collection_count() {
        return brand_collection_count;
    }

    public void setBrand_collection_count(int brand_collection_count) {
        this.brand_collection_count = brand_collection_count;
    }

    public String getCountry_circle_icon() {
        return country_circle_icon;
    }

    public void setCountry_circle_icon(String country_circle_icon) {
        this.country_circle_icon = country_circle_icon;
    }

    public String getBrand_desc() {
        return brand_desc;
    }

    public void setBrand_desc(String brand_desc) {
        this.brand_desc = brand_desc;
    }

    public int getIs_mart_lf() {
        return is_mart_lf;
    }

    public void setIs_mart_lf(int is_mart_lf) {
        this.is_mart_lf = is_mart_lf;
    }

    public int getBrand_sold_num() {
        return brand_sold_num;
    }

    public void setBrand_sold_num(int brand_sold_num) {
        this.brand_sold_num = brand_sold_num;
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

    public int getShow_tax() {
        return show_tax;
    }

    public void setShow_tax(int show_tax) {
        this.show_tax = show_tax;
    }

    public boolean isHidden_time() {
        return hidden_time;
    }

    public void setHidden_time(boolean hidden_time) {
        this.hidden_time = hidden_time;
    }

    public String getOrder_back_shell_msg() {
        return order_back_shell_msg;
    }

    public void setOrder_back_shell_msg(String order_back_shell_msg) {
        this.order_back_shell_msg = order_back_shell_msg;
    }

    public String getOrder_back_shell_rule_url() {
        return order_back_shell_rule_url;
    }

    public void setOrder_back_shell_rule_url(String order_back_shell_rule_url) {
        this.order_back_shell_rule_url = order_back_shell_rule_url;
    }

    public int getIs_foreign_pay() {
        return is_foreign_pay;
    }

    public void setIs_foreign_pay(int is_foreign_pay) {
        this.is_foreign_pay = is_foreign_pay;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
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

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getMj_promotion() {
        return mj_promotion;
    }

    public void setMj_promotion(String mj_promotion) {
        this.mj_promotion = mj_promotion;
    }

    public String getSbanner() {
        return sbanner;
    }

    public void setSbanner(String sbanner) {
        this.sbanner = sbanner;
    }

    public String getEvent_banner() {
        return event_banner;
    }

    public void setEvent_banner(String event_banner) {
        this.event_banner = event_banner;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBrand_sub_title() {
        return brand_sub_title;
    }

    public void setBrand_sub_title(String brand_sub_title) {
        this.brand_sub_title = brand_sub_title;
    }

    public int getRate_count() {
        return rate_count;
    }

    public void setRate_count(int rate_count) {
        this.rate_count = rate_count;
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

    public String getProps() {
        return props;
    }

    public void setProps(String props) {
        this.props = props;
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

    public int getIs_disable_buy_alone() {
        return is_disable_buy_alone;
    }

    public void setIs_disable_buy_alone(int is_disable_buy_alone) {
        this.is_disable_buy_alone = is_disable_buy_alone;
    }

    public String getDisable_buy_alone_message() {
        return disable_buy_alone_message;
    }

    public void setDisable_buy_alone_message(String disable_buy_alone_message) {
        this.disable_buy_alone_message = disable_buy_alone_message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ImgsBean getImgs() {
        return imgs;
    }

    public void setImgs(ImgsBean imgs) {
        this.imgs = imgs;
    }

    public SkuBean getSku() {
        return sku;
    }

    public void setSku(SkuBean sku) {
        this.sku = sku;
    }

    public boolean isSku_expand() {
        return sku_expand;
    }

    public void setSku_expand(boolean sku_expand) {
        this.sku_expand = sku_expand;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public MizhePromotionTipsBean getMizhe_promotion_tips() {
        return mizhe_promotion_tips;
    }

    public void setMizhe_promotion_tips(MizhePromotionTipsBean mizhe_promotion_tips) {
        this.mizhe_promotion_tips = mizhe_promotion_tips;
    }

    public String getGuarantee_url() {
        return guarantee_url;
    }

    public void setGuarantee_url(String guarantee_url) {
        this.guarantee_url = guarantee_url;
    }

    public List<PlatformPromisesBean> getPlatform_promises() {
        return platform_promises;
    }

    public void setPlatform_promises(List<PlatformPromisesBean> platform_promises) {
        this.platform_promises = platform_promises;
    }

    public List<PlatformNewPromisesBean> getPlatform_new_promises() {
        return platform_new_promises;
    }

    public void setPlatform_new_promises(List<PlatformNewPromisesBean> platform_new_promises) {
        this.platform_new_promises = platform_new_promises;
    }

    public List<PlatformCompensationPromisesBean> getPlatform_compensation_promises() {
        return platform_compensation_promises;
    }

    public void setPlatform_compensation_promises(List<PlatformCompensationPromisesBean> platform_compensation_promises) {
        this.platform_compensation_promises = platform_compensation_promises;
    }

    public List<OrderBackShellLevelsBean> getOrder_back_shell_levels() {
        return order_back_shell_levels;
    }

    public void setOrder_back_shell_levels(List<OrderBackShellLevelsBean> order_back_shell_levels) {
        this.order_back_shell_levels = order_back_shell_levels;
    }

    public List<ProductPropsBean> getProduct_props() {
        return product_props;
    }

    public void setProduct_props(List<ProductPropsBean> product_props) {
        this.product_props = product_props;
    }

    public List<String> getDetail_v2() {
        return detail_v2;
    }

    public void setDetail_v2(List<String> detail_v2) {
        this.detail_v2 = detail_v2;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<PromotionTipsBean> getPromotion_tips() {
        return promotion_tips;
    }

    public void setPromotion_tips(List<PromotionTipsBean> promotion_tips) {
        this.promotion_tips = promotion_tips;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public List<?> getProduct_sizes() {
        return product_sizes;
    }

    public void setProduct_sizes(List<?> product_sizes) {
        this.product_sizes = product_sizes;
    }

    public List<?> getRate_tags() {
        return rate_tags;
    }

    public void setRate_tags(List<?> rate_tags) {
        this.rate_tags = rate_tags;
    }

    public List<?> getRate_items() {
        return rate_items;
    }

    public void setRate_items(List<?> rate_items) {
        this.rate_items = rate_items;
    }

    public List<String> getPlatform_advantages() {
        return platform_advantages;
    }

    public void setPlatform_advantages(List<String> platform_advantages) {
        this.platform_advantages = platform_advantages;
    }

    public static class ImgsBean {
        @SerializedName("16")
        private String value16;
        @SerializedName("995")
        private String value995;
        @SerializedName("869")
        private String value869;
        @SerializedName("996")
        private String value996;
        @SerializedName("997")
        private String value997;
        @SerializedName("998")
        private String value998;
        @SerializedName("1002")
        private String value1002;

        public String getValue16() {
            return value16;
        }

        public void setValue16(String value16) {
            this.value16 = value16;
        }

        public String getValue995() {
            return value995;
        }

        public void setValue995(String value995) {
            this.value995 = value995;
        }

        public String getValue869() {
            return value869;
        }

        public void setValue869(String value869) {
            this.value869 = value869;
        }

        public String getValue996() {
            return value996;
        }

        public void setValue996(String value996) {
            this.value996 = value996;
        }

        public String getValue997() {
            return value997;
        }

        public void setValue997(String value997) {
            this.value997 = value997;
        }

        public String getValue998() {
            return value998;
        }

        public void setValue998(String value998) {
            this.value998 = value998;
        }

        public String getValue1002() {
            return value1002;
        }

        public void setValue1002(String value1002) {
            this.value1002 = value1002;
        }
    }

    public static class SkuBean {
        private SkuIdMapBean sku_id_map;
        /**
         * k3 : 颜色
         * v16 : 黑色10双
         * k161 : 尺码
         * v7384 : 均码
         * v869 : 灰色10双
         * v995 : 肤色10双
         * v996 : 黑5灰5
         * v997 : 黑5肤5
         * v998 : 灰5肤5
         * v1002 : 黑4肤4灰2
         */

        private SkuKvMapBean sku_kv_map;
        /**
         * v16v7384 : {"sku_id":36659144,"stock":9996,"price":3990,"origin_price":16900}
         * v869v7384 : {"sku_id":36659145,"stock":9999,"price":3990,"origin_price":16900}
         * v995v7384 : {"sku_id":36659146,"stock":9987,"price":3990,"origin_price":16900}
         * v996v7384 : {"sku_id":36792452,"stock":9999,"price":3990,"origin_price":16900}
         * v997v7384 : {"sku_id":36792453,"stock":9999,"price":3990,"origin_price":16900}
         * v998v7384 : {"sku_id":36792454,"stock":9997,"price":3990,"origin_price":16900}
         * v1002v7384 : {"sku_id":36792455,"stock":9997,"price":3990,"origin_price":16900}
         */

        private SkuStockMapBean sku_stock_map;

        public SkuIdMapBean getSku_id_map() {
            return sku_id_map;
        }

        public void setSku_id_map(SkuIdMapBean sku_id_map) {
            this.sku_id_map = sku_id_map;
        }

        public SkuKvMapBean getSku_kv_map() {
            return sku_kv_map;
        }

        public void setSku_kv_map(SkuKvMapBean sku_kv_map) {
            this.sku_kv_map = sku_kv_map;
        }

        public SkuStockMapBean getSku_stock_map() {
            return sku_stock_map;
        }

        public void setSku_stock_map(SkuStockMapBean sku_stock_map) {
            this.sku_stock_map = sku_stock_map;
        }

        public static class SkuIdMapBean {
            @SerializedName("3")
            private List<Integer> value3;
            @SerializedName("161")
            private List<Integer> value161;

            public List<Integer> getValue3() {
                return value3;
            }

            public void setValue3(List<Integer> value3) {
                this.value3 = value3;
            }

            public List<Integer> getValue161() {
                return value161;
            }

            public void setValue161(List<Integer> value161) {
                this.value161 = value161;
            }
        }

        public static class SkuKvMapBean {
            private String k3;
            private String v16;
            private String k161;
            private String v7384;
            private String v869;
            private String v995;
            private String v996;
            private String v997;
            private String v998;
            private String v1002;

            public String getK3() {
                return k3;
            }

            public void setK3(String k3) {
                this.k3 = k3;
            }

            public String getV16() {
                return v16;
            }

            public void setV16(String v16) {
                this.v16 = v16;
            }

            public String getK161() {
                return k161;
            }

            public void setK161(String k161) {
                this.k161 = k161;
            }

            public String getV7384() {
                return v7384;
            }

            public void setV7384(String v7384) {
                this.v7384 = v7384;
            }

            public String getV869() {
                return v869;
            }

            public void setV869(String v869) {
                this.v869 = v869;
            }

            public String getV995() {
                return v995;
            }

            public void setV995(String v995) {
                this.v995 = v995;
            }

            public String getV996() {
                return v996;
            }

            public void setV996(String v996) {
                this.v996 = v996;
            }

            public String getV997() {
                return v997;
            }

            public void setV997(String v997) {
                this.v997 = v997;
            }

            public String getV998() {
                return v998;
            }

            public void setV998(String v998) {
                this.v998 = v998;
            }

            public String getV1002() {
                return v1002;
            }

            public void setV1002(String v1002) {
                this.v1002 = v1002;
            }
        }

        public static class SkuStockMapBean {
            /**
             * sku_id : 36659144
             * stock : 9996
             * price : 3990
             * origin_price : 16900
             */

            private V16v7384Bean v16v7384;
            /**
             * sku_id : 36659145
             * stock : 9999
             * price : 3990
             * origin_price : 16900
             */

            private V869v7384Bean v869v7384;
            /**
             * sku_id : 36659146
             * stock : 9987
             * price : 3990
             * origin_price : 16900
             */

            private V995v7384Bean v995v7384;
            /**
             * sku_id : 36792452
             * stock : 9999
             * price : 3990
             * origin_price : 16900
             */

            private V996v7384Bean v996v7384;
            /**
             * sku_id : 36792453
             * stock : 9999
             * price : 3990
             * origin_price : 16900
             */

            private V997v7384Bean v997v7384;
            /**
             * sku_id : 36792454
             * stock : 9997
             * price : 3990
             * origin_price : 16900
             */

            private V998v7384Bean v998v7384;
            /**
             * sku_id : 36792455
             * stock : 9997
             * price : 3990
             * origin_price : 16900
             */

            private V1002v7384Bean v1002v7384;

            public V16v7384Bean getV16v7384() {
                return v16v7384;
            }

            public void setV16v7384(V16v7384Bean v16v7384) {
                this.v16v7384 = v16v7384;
            }

            public V869v7384Bean getV869v7384() {
                return v869v7384;
            }

            public void setV869v7384(V869v7384Bean v869v7384) {
                this.v869v7384 = v869v7384;
            }

            public V995v7384Bean getV995v7384() {
                return v995v7384;
            }

            public void setV995v7384(V995v7384Bean v995v7384) {
                this.v995v7384 = v995v7384;
            }

            public V996v7384Bean getV996v7384() {
                return v996v7384;
            }

            public void setV996v7384(V996v7384Bean v996v7384) {
                this.v996v7384 = v996v7384;
            }

            public V997v7384Bean getV997v7384() {
                return v997v7384;
            }

            public void setV997v7384(V997v7384Bean v997v7384) {
                this.v997v7384 = v997v7384;
            }

            public V998v7384Bean getV998v7384() {
                return v998v7384;
            }

            public void setV998v7384(V998v7384Bean v998v7384) {
                this.v998v7384 = v998v7384;
            }

            public V1002v7384Bean getV1002v7384() {
                return v1002v7384;
            }

            public void setV1002v7384(V1002v7384Bean v1002v7384) {
                this.v1002v7384 = v1002v7384;
            }

            public static class V16v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }

            public static class V869v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }

            public static class V995v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }

            public static class V996v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }

            public static class V997v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }

            public static class V998v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }

            public static class V1002v7384Bean {
                private int sku_id;
                private int stock;
                private int price;
                private int origin_price;

                public int getSku_id() {
                    return sku_id;
                }

                public void setSku_id(int sku_id) {
                    this.sku_id = sku_id;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
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
            }
        }
    }

    public static class MizhePromotionTipsBean {
        /**
         * icon : http://s0.husor.cn/image/app/img_detail_tag1_v1.png
         * message : 满59减5元，满99减10元
         * short_message : 专场满减
         */

        private MjPromotionBean mj_promotion;

        public MjPromotionBean getMj_promotion() {
            return mj_promotion;
        }

        public void setMj_promotion(MjPromotionBean mj_promotion) {
            this.mj_promotion = mj_promotion;
        }

        public static class MjPromotionBean {
            private String icon;
            private String message;
            private String short_message;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public String getShort_message() {
                return short_message;
            }

            public void setShort_message(String short_message) {
                this.short_message = short_message;
            }
        }
    }

    public static class PlatformPromisesBean {
        private String text;
        private String icon;
        private String target;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }
    }

    public static class PlatformNewPromisesBean {
        private String text;
        private String icon;
        private String target;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }
    }

    public static class PlatformCompensationPromisesBean {
        private String text;
        private String icon;
        private String target;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }
    }

    public static class OrderBackShellLevelsBean {
        private String desc;
        private int level;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }

    public static class ProductPropsBean {
        private String prop_name;
        private String prop_value;

        public String getProp_name() {
            return prop_name;
        }

        public void setProp_name(String prop_name) {
            this.prop_name = prop_name;
        }

        public String getProp_value() {
            return prop_value;
        }

        public void setProp_value(String prop_value) {
            this.prop_value = prop_value;
        }
    }

    public static class PromotionTipsBean {
        private String icon;
        private String message;
        private String short_message;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getShort_message() {
            return short_message;
        }

        public void setShort_message(String short_message) {
            this.short_message = short_message;
        }
    }
}
