package panjiangang.bwie.com.myapp2.model;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author ddy
 *         OkHttp二次封装类
 */
class OkHttpUtils01 {

    private static OkHttpUtils01 okhttpUtils = null;
    private static OkHttpClient client;

    private OkHttpUtils01() {

    }

    static OkHttpUtils01 getInstance() {
        if (okhttpUtils == null) {
            okhttpUtils = new OkHttpUtils01();
            client = new OkHttpClient();
        }
        return okhttpUtils;
    }

    void asy(Map<String, String> params, String url, AbstractUiCallback callBack) {
        Request request;
        if (params != null) {
            // post 请求
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            FormBody body = builder.build();
            request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        } else {
            // get 请求
            request = new Request.Builder()
                    .url(url)
                    .build();
        }
        client.newCall(request).enqueue(callBack);
    }
}
