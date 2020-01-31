package com.meet.xingyu.viewmodel.route;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.view.route.RouteAdapter;

public class RouteViewModel extends AdapterViewModel {

    private static RouteViewModel instance;

    private RouteAdapter adapter;

    private RouteViewModel() {
    }

    @Override
    public BaseAdapter getAdapter(Context context) {
        if (adapter == null) {
            adapter = new RouteAdapter(context);
        }
        loadData();
        return adapter;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override
    public void loadData() {

    }

    public static RouteViewModel getInstance() {
        if (instance == null) {
            synchronized (RouteViewModel.class) {
                if (instance == null) {
                    instance = new RouteViewModel();
                }
            }
        }
        return instance;
    }
}
