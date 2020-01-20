package com.meet.xingyu.viewmodel;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe
 */
public class FragmentRouteAdapterViewModel extends AdapterViewModel {


    private static FragmentRouteAdapterViewModel instance;

    @Override
    public BaseAdapter getAdapter(Context context) {
        return null;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return null;
    }

    @Override
    public void loadData() {

    }

    public static FragmentRouteAdapterViewModel getInstance() {
        if (instance == null) {
            synchronized (FragmentRouteAdapterViewModel.class) {
                if (instance == null) {
                    instance = new FragmentRouteAdapterViewModel();
                }
            }
        }
        return instance;
    }
}
