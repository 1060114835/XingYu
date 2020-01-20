package com.meet.xingyu.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Richard
 * @time 2020/1/16
 * @describe 封装构建 Retrofit 实例
 *
 * 网络请求使用示例：
 *
 * // URL
 * http://fanyi.youdao.com/translate
 *
 * // URL实例
 * http://fanyi.youdao.com/translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid
 *      =&imei=&vendor=&screen=&ssid=&network=&abtest=
 *
 *       ApiRetrofit.create("https://fanyi.youdao.com/", IYouDao.class)
 *            .getObservable("translate?doctype=json&jsonversion=&type=&keyfrom=&model"
 *                  + "=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=",
 *                      "i am richard")
 *            .subscribeOn(Schedulers.newThread())
 *            .observeOn(AndroidSchedulers.mainThread())
 *            .subscribe(new Observer<YouDao>() {
 *                @Override
 *                public void onSuccess(YouDao youDao) {
 *                    Log.d("TestActivity", "开始打印数据");
 *                    String s = youDao.getTranslateResult().get(0).get(0).getTgt();
 *                    Log.d("TestActivity", s);
 *                }
 *
 *                @Override
 *                public void onSubscribe(Disposable d) {
 *                    SubscriptionManager.getInstance().add(d);
 *                }
 *            });
 *
 *  订阅应该在 View 销毁的时候（或者不使用网络请求的时候）取消
 *          SubscriptionManager.getInstance().cancel(d);
 *      或者取消全部
 *          SubscriptionManager.getInstance().clear;
 *     上面两行代码也可作为取消网络请求来使用
 */
public class ApiRetrofit {

    private ApiRetrofit instance = null;

    private ApiRetrofit() {
    }

    /**
     * 创建网络连接所需的接口实例
     *
     * @param baseUrl 基本 Url
     * @param tClass 接口 Class 对象
     * @param <T> 类型参数
     * @return T 接口实例
     */
    public static <T> T create(String baseUrl, Class<T> tClass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(HttpForRetrofit.getOkHttpClient())
                .build();
        return retrofit.create(tClass);
    }

    /**
     * 获取 ApiRetrofit 的单例
     * 一般用不到
     * @return ApiRetrofit 实例
     */
    public ApiRetrofit getInstance() {
        if (instance == null) {
            synchronized (ApiRetrofit.class) {
                if (instance == null) {
                    instance = new ApiRetrofit();
                }
            }
        }
        return instance;
    }

}
