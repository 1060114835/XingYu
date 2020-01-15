package com.meet.xingyu.net;


import io.reactivex.disposables.Disposable;

/**
 * @author Richard
 * @time 2020/1/15
 * @describe 替换 RxJava 的 Observer
 */
public abstract class Observer<T> implements io.reactivex.Observer<T> {

    private IResults<T> results;

    @Override
    public void onSubscribe(Disposable d) {
        //添加到Disposable池中的
    }

    @Override
    public void onNext(T t) {
        results.onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        results.onFail(e);
    }

    @Override
    public void onComplete() {
        results.onCompleted();
    }
}
