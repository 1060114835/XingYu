package com.meet.xingyu.viewmodel.route;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.BR;
import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.model.route.MyAndApplyBean;

public class RouteApplyViewModel extends AdapterViewModel<MutableLiveData<MyAndApplyBean>> {

    public MutableLiveData<String> start;
    public MutableLiveData<String> end;
    public MutableLiveData<String> data;
    public MutableLiveData<String> time;
    public MutableLiveData<Drawable> head;
    public MutableLiveData<String> id;
    public MutableLiveData<String> agree;

    private static RouteApplyViewModel instance;

    private SingleTypeAdapter<MutableLiveData<MyAndApplyBean>> singleTypeAdapter;

    private RouteApplyViewModel() {
    }

    @Override
    public BaseAdapter getAdapter(Context context) {
        if (singleTypeAdapter == null) {
            singleTypeAdapter = new SingleTypeAdapter<MutableLiveData<MyAndApplyBean>>(context,
                    BR.routeApplyVM, R.layout.item_route_apply, BR.routeApplyPresenter);
        }
        loadData();
        return singleTypeAdapter;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override
    public void loadData() {

    }

    public static RouteApplyViewModel getInstance() {
        if (instance == null) {
            synchronized (RouteApplyViewModel.class) {
                if (instance == null) {
                    instance = new RouteApplyViewModel();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<String> getStart() {
        return start;
    }

    public void setStart(MutableLiveData<String> start) {
        this.start = start;
    }

    public MutableLiveData<String> getEnd() {
        return end;
    }

    public void setEnd(MutableLiveData<String> end) {
        this.end = end;
    }

    public MutableLiveData<String> getData() {
        return data;
    }

    public void setData(MutableLiveData<String> data) {
        this.data = data;
    }

    public MutableLiveData<String> getTime() {
        return time;
    }

    public void setTime(MutableLiveData<String> time) {
        this.time = time;
    }

    public MutableLiveData<Drawable> getHead() {
        return head;
    }

    public void setHead(MutableLiveData<Drawable> head) {
        this.head = head;
    }

    public MutableLiveData<String> getId() {
        return id;
    }

    public void setId(MutableLiveData<String> id) {
        this.id = id;
    }

    public MutableLiveData<String> getAgree() {
        return agree;
    }

    public void setAgree(MutableLiveData<String> agree) {
        this.agree = agree;
    }
}
