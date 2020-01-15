package com.meet.xingyu.net;

import com.meet.xingyu.BuildConfig;
import com.meet.xingyu.net.bean.YouDao;
import com.meet.xingyu.net.idescrbe.IYouDao;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Richard
 * @time 2020/1/15
 * @describe 网络请求主体
 *
 * 使用示例：
 *
 *     public void test() {
 *         NetUtil.getInstance("http://fanyi.youdao.com/").getDataWithPost(new IResults() {
 *             @Override
 *             public void onSuccess(Object o) {
 *                 //参数即为请求结果
 *             }
 *
 *             @Override
 *             public void onFail(Throwable e) {
 *
 *             }
 *
 *             @Override
 *             public void onCompleted() {
 *
 *             }
 *         }, "translate?doctype=json&jsonversion=&type=&keyfrom=&model" +
 *                 "=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=", "i am richard");
 *     }
 *
 */
public class NetUtil {

    private static volatile NetUtil instance = null;
    private Retrofit retrofit;

    private NetUtil(String baseUrl) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
            client.addInterceptor(logging);
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    /**
     * 获取请求结果 POST 方式
     * @param results 暴露给外层的接口对象
     * @param query Url的查询参数
     * @param send 发送给服务端的信息
     */
    public void getDataWithPost(IResults results, String query,String send) {
        IYouDao youDao = retrofit.create(IYouDao.class);
        Observable<YouDao> observable = youDao.getObservable(query, send);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YouDao>() {});
    }

    /**
     * 获取请求结果 GET 方式
     * @param results 暴露给外层的接口对象
     * @param query Url的查询参数
     */
    public void getDataWithGet(IResults results, String query) {
        //···
    }


    /**
     * 获取单例
     * @param baseUrl URL基本地址
     * @return NetUtil 实例
     */
    public static NetUtil getInstance(String baseUrl) {
        if (instance == null) {
            synchronized (NetUtil.class) {
                if (instance == null) {
                    instance = new NetUtil(baseUrl);
                }
            }
        }
        return instance;
    }

}
