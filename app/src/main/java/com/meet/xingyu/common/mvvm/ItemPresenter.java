package com.meet.xingyu.common.mvvm;


import androidx.lifecycle.MutableLiveData;


/**
 * 页面有列表的item点击事件，那么页面的presenter继承这个类
 * @param <T>
 */
public abstract class ItemPresenter <T extends MutableLiveData> extends BasePresenter
        implements BasePresenter.OnItemClickListener<T> {



}
