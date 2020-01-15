package com.meet.xingyu.common.mvvm;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.common.adapter.BaseAdapter;


/**
 * 布局中如果用到recyclerView就继承这个viewModel
 * @param <T> 子项的Bean
 */
public abstract class AdapterViewModel<T extends MutableLiveData> extends BaseViewModel {

    public abstract BaseAdapter<T> getAdapter(Context context);

    public abstract LinearLayoutManager getLayoutManager(Context context);

}
