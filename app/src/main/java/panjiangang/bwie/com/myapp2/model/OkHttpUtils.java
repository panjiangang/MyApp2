package panjiangang.bwie.com.myapp2.model;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author ddy
 */
class OkHttpUtils {

    private static OkHttpUtils okHttpUtils;
    private static OkHttpClient okHttpClient;

    private OkHttpUtils() {

    }

    //单例
    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            okHttpUtils = new OkHttpUtils();
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new MyInterceptor())
                    .build();
        }
        return okHttpUtils;
    }

    public void get(String wz, Map<String, String> canshu, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : canshu.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        FormBody formBody = builder.build();

        Request request = new Request.Builder()
                .url("https://www.zhaoapi.cn/product/"+wz)
                .post(formBody)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
