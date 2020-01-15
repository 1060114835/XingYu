package com.meet.xingyu.net.idescrbe;

import com.meet.xingyu.net.bean.YouDao;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author Richard
 * @time 2020/1/15
 * @describe 描述网络请求接口
 */
public interface IYouDao {

    @POST("/")
    @FormUrlEncoded
    Observable<YouDao> getObservable(@Query("translation") String translation,
                                     @Field("1") String sentence);
}
