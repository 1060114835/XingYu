package com.meet.xingyu.net;

/**
 * @author Richard
 * @time 2020/1/15
 * @describe 网络请求暴露给外层的接口，用于外层处理数据结果
 */
public interface IResults<T> {

    void onSuccess(T t);

    void onFail(Throwable e);

    /**
     * 整个请求过程结束
     */
    void onCompleted();
}
