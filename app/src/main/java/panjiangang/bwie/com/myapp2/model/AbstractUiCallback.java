package panjiangang.bwie.com.myapp2.model;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author ddy
 */
abstract class AbstractUiCallback<T> implements Callback {

    /**
     * 成功回调
     *
     * @param t
     */
    public abstract void success(T t);

    /**
     * 失败回调
     *
     * @param e
     */
    public abstract void failure(Exception e);

    private Handler handler = null;
    private Class<T> clazz;

    AbstractUiCallback() {
        handler = new Handler(Looper.getMainLooper());
        //  得到的是一个 AbstractUiCallback<T> 的Type
        Type type = getClass().getGenericSuperclass();
        // 得到的是T的实际Type
        Type[] arr = ((ParameterizedType) type).getActualTypeArguments();
        clazz = (Class<T>) arr[0];
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        failure(e);
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
        String result = response.body().string();
        Gson gson = new Gson();
        final T t = gson.fromJson(result, clazz);
        handler.post(new Runnable() {
            @Override
            public void run() {
                success(t);
            }
        });
    }
}