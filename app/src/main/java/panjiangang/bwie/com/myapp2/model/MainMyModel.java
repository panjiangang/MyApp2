package panjiangang.bwie.com.myapp2.model;

import android.os.Handler;
import android.os.Looper;


import java.util.List;

import panjiangang.bwie.com.myapp2.bean.Bean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ddy
 */
public class MainMyModel {

    private MPInterface mpInterface;
    private final Handler handler;

    public MainMyModel(MPInterface mpInterface) {
        this.mpInterface = mpInterface;
        handler = new Handler(Looper.getMainLooper());
    }

    public void getOkHttp() {
        OkHttpUtils01.getInstance().asy(null, "http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage", new AbstractUiCallback<Bean>() {

            @Override
            public void success(Bean bean) {
                List<Bean.DataBean.SubjectsBean> subjects = bean.getData().getSubjects();
                mpInterface.getHC(subjects);
            }

            @Override
            public void failure(Exception e) {

            }
        });
    }

    public void getReterfit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://result.eolinker.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<Bean> call = gitHubService.get("homepage");

        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                final List<Bean.DataBean.SubjectsBean> subjects = response.body().getData().getSubjects();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mpInterface.getHC(subjects);
                    }
                });
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {

            }
        });
    }

    public interface MPInterface {

        void getHC(List<Bean.DataBean.SubjectsBean> subjects);
    }
}
