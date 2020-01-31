package com.meet.xingyu.presenter.route;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.model.route.AllBean;

public class RouteAllPresenter extends ItemPresenter<MutableLiveData<AllBean>> {

    private static RouteAllPresenter instance;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(View view, MutableLiveData<AllBean> bean) {
        switch (view.getId()) {
            case R.id.img_route_all_delete:
                ToastUtil.getInstance().toast("从所有的行程页面消除这个行程，并移除这个Item");
                break;
            case R.id.tv_route_all_ended:
                ToastUtil.getInstance().toast("完结行程进入评价页，并移除这个Item");
                break;
            case R.id.tv_route_all_communicate:
                ToastUtil.getInstance().toast("进入聊天页面");
                break;
            default:
                break;
        }
    }

    public static RouteAllPresenter getInstance() {
        if (instance == null) {
            synchronized (RouteAllPresenter.class) {
                if (instance == null) {
                    instance = new RouteAllPresenter();
                }
            }
        }
        return instance;
    }
}
