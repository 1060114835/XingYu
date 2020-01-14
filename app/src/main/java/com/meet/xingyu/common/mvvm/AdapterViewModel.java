package com.meet.xingyu.common.mvvm;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.common.adapter.BaseAdapter;


/**
 * 布局中如果用到recyclerview就用这个viewmodel
 * @param <T>
 */
public abstract class AdapterViewModel<T extends MutableLiveData> extends BaseViewModel {

    public abstract BaseAdapter<T> getAdapter(Context context);

    public abstract LinearLayoutManager getLayoutManager(Context context);

}
