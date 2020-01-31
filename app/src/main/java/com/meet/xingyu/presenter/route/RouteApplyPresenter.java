package com.meet.xingyu.presenter.route;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.model.route.MyAndApplyBean;

public class RouteApplyPresenter extends ItemPresenter<MutableLiveData<MyAndApplyBean>> {

    private static RouteApplyPresenter instance;

    @Override
    public void onClick(View v) {

    }

    public static RouteApplyPresenter getInstance() {
        if (instance == null) {
            synchronized (RouteApplyPresenter.class) {
                if (instance == null) {
                    instance = new RouteApplyPresenter();
                }
            }
        }
        return instance;
    }

    @Override
    public void onItemClick(View view, MutableLiveData<MyAndApplyBean> bean) {
        ToastUtil.getInstance().toast("Item被点击：" + view.getId() + "进入队长发布页查看详情");
    }
}
