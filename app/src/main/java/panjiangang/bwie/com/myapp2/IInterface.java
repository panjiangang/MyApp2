package panjiangang.bwie.com.myapp2;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import panjiangang.bwie.com.myapp2.bean.Bean;
import panjiangang.bwie.com.myapp2.bean.CaiPuBean;
import panjiangang.bwie.com.myapp2.bean.ClassifyBean;
import panjiangang.bwie.com.myapp2.bean.ClassifyClassifyBean;
import panjiangang.bwie.com.myapp2.bean.NbaBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/12/06.
 */

public interface IInterface {

    @GET("front/{user}/videoDetail.do?mediaId=d8628ea824ca4ae9af3cfc0d4afed0a9")
        //把参数user  替换到 {user}
    Call<CaiPuBean> ListRepos(@Path("user") String user);

    @GET("/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Call<ResponseBody> get();

    @GET("/nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Observable<NbaBean> get1();//@Path("user")String user

    //path = "http://apis.juhe.cn/cook/query?key=c89083f1fc9b411484fd290386335510&menu="+ URLEncoder.encode(name, "utf-8")+"&rn=10&pn=1";
    @GET("/cook/query")
    Observable<CaiPuBean> get2(@Query("key") String key, @Query("menu") String menu, @Query("rn") int rn, @Query("pn") int pn);

    //http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414
    //http://m.yunifang.com/yunifang/mobile/goods/getall?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=9

    @GET("/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414")
    Call<ClassifyBean> get3();

    //?random=91873&encode=68301f6ea0d6adcc0fee63bd21815d69&category_id=9
    @GET("/yunifang/mobile/goods/getall")
    Call<ClassifyClassifyBean> get4(@Query("random") int random, @Query("encode") String encode, @Query("category_id") String category_id);
}


