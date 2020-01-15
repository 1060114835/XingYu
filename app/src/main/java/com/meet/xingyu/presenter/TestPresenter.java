package com.meet.xingyu.presenter;

import android.app.Activity;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.model.TestBean;

public class TestPresenter extends ItemPresenter<MutableLiveData<TestBean>> {

    private static TestPresenter instance;


    private TestPresenter() {
    }

    public static TestPresenter getInstance() {
        if (instance == null)
            synchronized (TestPresenter.class) {
                if (instance == null) {
                    instance = new TestPresenter();
                }
            }
        return instance;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_icon:
                ((Activity)v.getContext()).finish();
                break;
            case R.id.bt_1:
                ToastUtil.getInstance().toast("弹一条消息");
                break;
        }
    }



    @Override
    public void onItemClick(View view, MutableLiveData<TestBean> bean) {
        ToastUtil.getInstance().toast(bean.getValue().getUserName());
    }
}
