package panjiangang.bwie.com.myapp2.model;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        //公共请求参数
//        String s = request.url().toString() + "?source=android";
//        Request request1 = request.newBuilder().url(s).build();
//        return chain.proceed(request1);

        FormBody.Builder builder = new FormBody.Builder();
        RequestBody requestBody = request.body();
        FormBody formBody = (FormBody) requestBody;
        for (int i = 0; i < formBody.size(); i++) {
            builder.add(formBody.name(i), formBody.value(i));
        }
        FormBody formBody1 = builder.add("source", "android").build();
        Request request2 = request.newBuilder().post(formBody1).build();
        return chain.proceed(request2);
    }
}
