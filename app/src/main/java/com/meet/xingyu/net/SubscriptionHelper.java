package com.meet.xingyu.net;

import io.reactivex.disposables.Disposable;

/**
 * @author Richard
 * @time 2020/1/18
 * @describe 处理订阅关系接口
 */
public interface SubscriptionHelper {

    /**
     * 加入订阅
     * @param disposable
     */
    void add(Disposable disposable);

    /**
     * 取消订阅
     * @param disposable
     */
    void cancel(Disposable disposable);

    /**
     * 取消所有订阅
     */
    void clear();
}
