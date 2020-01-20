package com.meet.xingyu.net;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author Richard
 * @time 2020/1/18
 * @describe SubscriptionHelper实现类，实现订阅关系的处理
 */
public class SubscriptionManager implements SubscriptionHelper {

    private static SubscriptionManager instance = null;
    private CompositeDisposable mPool;

    private SubscriptionManager() {
        if (mPool == null) {
            mPool = new CompositeDisposable();
        }
    }

    @Override
    public void add(Disposable disposable) {
        if (mPool != null && !disposable.isDisposed()) {
            mPool.add(disposable);
        }
    }

    @Override
    public void cancel(Disposable disposable) {
        if (mPool != null) {
            mPool.delete(disposable);
            if (disposable.isDisposed()) disposable.dispose();
        }
    }

    /**
     * 请谨慎使用此方法，Disposable池会被抹除
     */
    @Override
    public void clear() {
        if (mPool != null) {
            mPool.clear();
            mPool = null;
        }
    }

    public static SubscriptionManager getInstance() {
        if (instance == null) {
            synchronized (SubscriptionManager.class) {
                if (instance == null) {
                    instance = new SubscriptionManager();
                }
            }
        }
        return instance;
    }

}
