package com.meet.xingyu.presenter.route;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.model.route.MyAndApplyBean;

public class RouteMyPresenter extends ItemPresenter<MutableLiveData<MyAndApplyBean>> {

    private static RouteMyPresenter instance;

    @Override
    public void onClick(View v) {

    }

    public static RouteMyPresenter getInstance() {
        if (instance == null) {
            synchronized (RouteMyPresenter.class) {
                if (instance == null) {
                    instance = new RouteMyPresenter();
                }
            }
        }
        return instance;
    }

    @Override
    public void onItemClick(View view, MutableLiveData<MyAndApplyBean> bean) {
        switch (view.getId()) {
            case R.id.img_route_my_delete:
                ToastUtil.getInstance().toast("取消该行程，并移除Item");
                break;
            case R.id.tv_route_my_ended:
                ToastUtil.getInstance().toast("行程完结，进入评价页，并移除Item");
                break;
            case R.id.tv_route_my_communicate:
                ToastUtil.getInstance().toast("进入交流界面");
                break;
            default:
                break;
        }
    }
}
