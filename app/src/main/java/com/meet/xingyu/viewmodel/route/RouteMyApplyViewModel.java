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

public class RouteMyApplyViewModel extends AdapterViewModel<MutableLiveData<MyAndApplyBean>> {

    public MutableLiveData<Drawable> head;
    public MutableLiveData<Integer> sex;
    public MutableLiveData<String> id;
    public MutableLiveData<Boolean> clicked;

    private static RouteMyApplyViewModel instance;
    private SingleTypeAdapter<MutableLiveData<MyAndApplyBean>> singleTypeAdapter;

    @Override
    public BaseAdapter<MutableLiveData<MyAndApplyBean>> getAdapter(Context context) {
        if (singleTypeAdapter == null) {
            singleTypeAdapter = new SingleTypeAdapter<MutableLiveData<MyAndApplyBean>>(context,
                    BR.routeMyApplyBean, R.layout.item_route_my_apply, BR.routeMyApplyPresenter);
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

    public static RouteMyApplyViewModel getInstance() {
        if (instance == null) {
            synchronized (RouteMyApplyViewModel.class) {
                if (instance == null) {
                    instance = new RouteMyApplyViewModel();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<Drawable> getHead() {
        return head;
    }

    public void setHead(MutableLiveData<Drawable> head) {
        this.head = head;
    }

    public MutableLiveData<Integer> getSex() {
        return sex;
    }

    public void setSex(MutableLiveData<Integer> sex) {
        this.sex = sex;
    }

    public MutableLiveData<String> getId() {
        return id;
    }

    public void setId(MutableLiveData<String> id) {
        this.id = id;
    }

    public MutableLiveData<Boolean> getClicked() {
        return clicked;
    }

    public void setClicked(MutableLiveData<Boolean> clicked) {
        this.clicked = clicked;
    }
}
