package com.meet.xingyu.net;

import android.util.Log;

import io.reactivex.disposables.Disposable;

/**
 * @author Richard
 * @time 2020/1/16
 * @describe 自定义 Observer，处理暴露给外层的逻辑
 *      还不完整，有待改善
 *      注释的两个方法暂时不需要暴露给外层，否则外层需要全部实现了
 */
public abstract class Observer<T> implements io.reactivex.Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {
        //可做其他处理

        Log.d("MainActivity", "onNext()方法");
        onSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        //可做其他处理
//        onFail(e);
    }

    @Override
    public void onComplete() {
        //可做其他处理
//        onCompleted();
    }

    public abstract void onSuccess(T t);

    /**
     * 当请求失败时，也许你能用到此方法
     */
//    public abstract void onFail(Throwable e);

    /**
     * 请求完成时触发，一般不会用到
     */
//    public abstract void onCompleted();

}
