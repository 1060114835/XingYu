package com.meet.xingyu.presenter.route;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.model.route.MyAndApplyBean;

public class RouteMyApplyPresenter extends ItemPresenter<MutableLiveData<MyAndApplyBean>> {

    private static RouteMyApplyPresenter instance;

    @Override
    public void onClick(View v) {

    }

    public static RouteMyApplyPresenter getInstance() {
        if (instance == null) {
            synchronized (RouteMyApplyPresenter.class) {
                if (instance == null) {
                    instance = new RouteMyApplyPresenter();
                }
            }
        }
        return instance;
    }

    @Override
    public void onItemClick(View view, MutableLiveData<MyAndApplyBean> bean) {
        switch (view.getId()) {
            case R.id.btn_route_my_select:
                ToastUtil.getInstance().toast("已选择该成员作为该行程的队员，并改变按钮字体");
                break;
                default:
                    break;
        }
    }

}
