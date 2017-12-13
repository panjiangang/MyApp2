package panjiangang.bwie.com.myapp2.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/08.
 */

public class ClassifyClassifyBean {

    /**
     * code : 200
     * msg : success
     * data : [{"id":"97","goods_name":"男士黑茶控油矿物洁面乳100ml","shop_price":39.9,"market_price":59,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/97/goods_img/170626105917313325496038459.jpg","sales_volume":25505,"efficacy":"深层清洁 收缩毛孔","goods_type":"0","activityPrice":39.9,"sort":0},{"id":"17","goods_name":"男士黑茶控油护肤三件套","shop_price":129.9,"market_price":199.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/17/goods_img/170626111428511385203738370.jpg","sales_volume":15254,"efficacy":"控油保湿 型男必备","goods_type":"0","activityPrice":99.9,"sort":0},{"id":"161","goods_name":"送7片共14片|男士补水活力矿物蚕丝7片","shop_price":59.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/161/goods_img/170626104914816121546518189.jpg","sales_volume":10397,"efficacy":"补水保湿 清爽控油","goods_type":"0","activityPrice":49.9,"sort":0},{"id":"319","goods_name":"补水首选丨男士补水活力矿物蚕丝21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/319/goods_img/17062610389308105384234516.jpg","sales_volume":7498,"efficacy":"畅爽补水 活力四射","goods_type":"0","activityPrice":99.9,"sort":0},{"id":"61","goods_name":"男士黑茶控油保湿两件套 （洁面乳，保湿露）","shop_price":69.9,"market_price":129.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/61/goods_img/17062611124916581955077472.jpg","sales_volume":7114,"efficacy":"控油保湿 清爽洁净","goods_type":"0","activityPrice":59.9,"sort":0},{"id":"869","goods_name":"男士深海水动力洁面乳","shop_price":39.9,"market_price":59,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/869/goods_img/17062610284582879718612169.jpg","sales_volume":6680,"efficacy":"洁净控油 深层补水","goods_type":"0","activityPrice":39.9,"sort":0},{"id":"868","goods_name":"男士黑茶清爽矿物面膜  今日买5片送5片","shop_price":49.9,"market_price":150,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/868/goods_img/17062610333352551606068502.jpg","sales_volume":5206,"efficacy":"洁净控油 强劲清爽","goods_type":"0","activityPrice":49.9,"sort":0},{"id":"598","goods_name":"男士黑茶清爽控油矿物泥浆面膜260g","shop_price":69,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/598/goods_img/1706261046696111799129343.jpg","sales_volume":4457,"efficacy":"清洁补水 保湿控油","goods_type":"0","activityPrice":49.9,"sort":0},{"id":"870","goods_name":"男士深海水动力三件套","shop_price":109.9,"market_price":208.8,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/870/goods_img/170626102678314643514655651.jpg","sales_volume":4308,"efficacy":"解决肌渴 爆发水能量","goods_type":"0","activityPrice":109.9,"sort":0},{"id":"1176","goods_name":"新品特惠丨男士火山泥清洁控油洁面乳加小样","shop_price":39.9,"market_price":104,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1176/goods_img/17062610413163995017012315.jpg","sales_volume":4222,"efficacy":"深层清洁 平衡水油","goods_type":"0","activityPrice":39.9,"sort":0},{"id":"514","goods_name":"男士清爽净痘亮采套装21片","shop_price":109.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/514/goods_img/170626105146115845247362007.jpg","sales_volume":3152,"efficacy":"清爽控油 净痘亮彩","goods_type":"0","activityPrice":109.9,"sort":0},{"id":"687","goods_name":"男士黑茶控油爽肤水90ml","shop_price":39.9,"market_price":69.9,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/687/goods_img/17062610409015869621667154.jpg","sales_volume":1679,"efficacy":"清洁控油 补水保湿","goods_type":"0","activityPrice":39.9,"sort":0},{"id":"871","goods_name":"男士深海水动力面膜5片","shop_price":39.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/871/goods_img/170626102661714895717277379.jpg","sales_volume":1536,"efficacy":"水润肌肤 有效锁水","goods_type":"0","activityPrice":39.9,"sort":0},{"id":"103","goods_name":"男士黑茶控油保湿3件套 洁面乳保湿露蚕丝面膜套装","shop_price":99.9,"market_price":219.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/103/goods_img/170626110612321434456413571.jpg","sales_volume":1220,"efficacy":"控油保湿 净爽型男","goods_type":"0","activityPrice":99.9,"sort":0},{"id":"516","goods_name":"男士清爽亮采面膜套装14片","shop_price":79.9,"market_price":198,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/516/goods_img/17062610502217625434737063.jpg","sales_volume":917,"efficacy":"清爽控油 净透亮肤","goods_type":"0","activityPrice":79.9,"sort":0},{"id":"1218","goods_name":"男士炫活亮肤洁面乳","shop_price":49,"market_price":69,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1218/goods_img/170626102663018358414224089.jpg","sales_volume":903,"efficacy":"改善黯哑  清洁亮肤","goods_type":"0","activityPrice":49,"sort":0},{"id":"1221","goods_name":"男士新品丨炫活亮肤礼盒","shop_price":139.9,"market_price":237,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1221/goods_img/170626102582911828516809467.jpg","sales_volume":718,"efficacy":"炫活亮彩 劲能醒肤","goods_type":"0","activityPrice":139.9,"sort":0},{"id":"1216","goods_name":"男士新品|净畅黑头泥浆鼻膜60g","shop_price":59,"market_price":69,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1216/goods_img/170626102787118960453588521.jpg","sales_volume":714,"efficacy":"改善黑头 收缩毛孔","goods_type":"0","activityPrice":59,"sort":0},{"id":"1220","goods_name":"男士炫活亮肤凝乳","shop_price":69,"market_price":89,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1220/goods_img/17062610257705622073607962.jpg","sales_volume":678,"efficacy":"改善黯哑 保湿锁水","goods_type":"0","activityPrice":69,"sort":0},{"id":"1229","goods_name":"男士黑茶清爽矿物面膜20片","shop_price":99.9,"market_price":300,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1229/goods_img/17062610235102599078009541.jpg","sales_volume":677,"efficacy":"净透肌肤 清洁控油","goods_type":"0","activityPrice":99.9,"sort":0},{"id":"1113","goods_name":"男士深海水动力爽肤水90ml","shop_price":49.9,"market_price":69.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1113/goods_img/17062610458248937043044948.jpg","sales_volume":673,"efficacy":"温和清洁 有效保湿","goods_type":"0","activityPrice":49.9,"sort":0},{"id":"1212","goods_name":"男士新品|茶树清痘净爽泥浆面膜110g","shop_price":79,"market_price":119,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1212/goods_img/17062610335099695507625805.jpg","sales_volume":560,"efficacy":"深层清洁 净肤祛痘","goods_type":"0","activityPrice":79,"sort":0},{"id":"1114","goods_name":"男士深海水动力爽肤乳80ml","shop_price":59.9,"market_price":79.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1114/goods_img/17062610459716617708316340.jpg","sales_volume":538,"efficacy":"深层补水 有效保湿","goods_type":"0","activityPrice":59.9,"sort":0},{"id":"1639","goods_name":"男士炫活两件套（洁面乳加晶露）","shop_price":79.9,"market_price":148,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1639/goods_img/170626144196318481692504523.jpg","sales_volume":500,"efficacy":"炫活亮彩 劲能醒肤","goods_type":"0","activityPrice":79.9,"sort":0},{"id":"2034","goods_name":"男士竹炭去黑头洁面乳100ml","shop_price":39.9,"market_price":59,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/2034/goods_img/170818212510015281738752471.jpg","sales_volume":472,"efficacy":"控油收毛孔 帮助去黑头","goods_type":"0","activityPrice":0,"sort":0},{"id":"2010","goods_name":"男士珊瑚清痘控油洁面乳100ml","shop_price":49,"market_price":69,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/2010/goods_img/1708101757139150350366237.jpg","sales_volume":394,"efficacy":"深层清洁 控油祛痘","goods_type":"0","activityPrice":0,"sort":0},{"id":"1219","goods_name":"男士新品丨炫活亮肤晶露","shop_price":59,"market_price":79,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1219/goods_img/1706261026871943129029530.jpg","sales_volume":381,"efficacy":"深层补水 改善黯哑","goods_type":"0","activityPrice":59,"sort":0},{"id":"1330","goods_name":"新品推荐|男士冰川深润补水面膜","shop_price":49.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1330/goods_img/170626103331019649572381031.jpg","sales_volume":222,"efficacy":"深润补水 有效保湿","goods_type":"0","activityPrice":49.9,"sort":0},{"id":"1217","goods_name":"男士新品丨火山泥清洁控油泥浆面膜","shop_price":79,"market_price":139,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1217/goods_img/170626102736115624811509582.jpg","sales_volume":213,"efficacy":"清洁控油 无畏挑战","goods_type":"0","activityPrice":79,"sort":0},{"id":"1699","goods_name":"男士新品丨玉石紧致细肤水凝面膜","shop_price":99.9,"market_price":159,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1699/goods_img/17062611525378027557967390.jpg","sales_volume":175,"efficacy":"紧致细肤 平抚肌纹","goods_type":"0","activityPrice":99.9,"sort":0}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 97
         * goods_name : 男士黑茶控油矿物洁面乳100ml
         * shop_price : 39.9
         * market_price : 59.0
         * is_coupon_allowed : false
         * is_allow_credit : false
         * goods_img : https://image.yunifang.com/yunifang/images/goods/97/goods_img/170626105917313325496038459.jpg
         * sales_volume : 25505
         * efficacy : 深层清洁 收缩毛孔
         * goods_type : 0
         * activityPrice : 39.9
         * sort : 0
         */

        private String id;
        private String goods_name;
        private double shop_price;
        private double market_price;
        private boolean is_coupon_allowed;
        private boolean is_allow_credit;
        private String goods_img;
        private int sales_volume;
        private String efficacy;
        private String goods_type;
        private double activityPrice;
        private int sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public double getShop_price() {
            return shop_price;
        }

        public void setShop_price(double shop_price) {
            this.shop_price = shop_price;
        }

        public double getMarket_price() {
            return market_price;
        }

        public void setMarket_price(double market_price) {
            this.market_price = market_price;
        }

        public boolean isIs_coupon_allowed() {
            return is_coupon_allowed;
        }

        public void setIs_coupon_allowed(boolean is_coupon_allowed) {
            this.is_coupon_allowed = is_coupon_allowed;
        }

        public boolean isIs_allow_credit() {
            return is_allow_credit;
        }

        public void setIs_allow_credit(boolean is_allow_credit) {
            this.is_allow_credit = is_allow_credit;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(int sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getEfficacy() {
            return efficacy;
        }

        public void setEfficacy(String efficacy) {
            this.efficacy = efficacy;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }

        public double getActivityPrice() {
            return activityPrice;
        }

        public void setActivityPrice(double activityPrice) {
            this.activityPrice = activityPrice;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
