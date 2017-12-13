package panjiangang.bwie.com.myapp2.model;

import panjiangang.bwie.com.myapp2.bean.Bean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ddy
 */
public interface GitHubService {

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611")
    Call<Bean> get(@Query("uri") String uri);
}