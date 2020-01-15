package com.meet.xingyu.common.mvvm;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.common.adapter.BaseAdapter;

/**
 * 页面有列表的item点击事件，那么页面的presenter继承这个类
 * @param <T>
 */
public abstract class ItemPresenter <T extends MutableLiveData> extends BasePresenter
        implements BasePresenter.OnItemClickListener<T> {



}
