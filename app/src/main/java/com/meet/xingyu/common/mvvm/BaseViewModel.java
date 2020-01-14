package com.meet.xingyu.common.mvvm;

import androidx.lifecycle.ViewModel;

public abstract class BaseViewModel extends ViewModel {

    /**
     * 在加载页面时进行网络请求，加载需要的数据
     */
    public abstract void loadData();
}
