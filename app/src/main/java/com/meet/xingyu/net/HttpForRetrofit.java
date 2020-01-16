package com.meet.xingyu.net;

import com.meet.xingyu.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author Richard
 * @time 2020/1/16
 * @describe 设置给 Retrofit 的 OkHttpClient
 *      内容不完整，有待完善
 */
public class HttpForRetrofit {

    /**
     * 返回一个 OkHttpClient 实例
     */
    public static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            //拦截器可能有变化，暂时使用 HttpLoggingInterceptor
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(interceptor);
        }

        return builder.build();
    }
}
