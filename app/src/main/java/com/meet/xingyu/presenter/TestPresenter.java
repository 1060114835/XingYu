package com.meet.xingyu.presenter;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

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
        ToastUtil.getInstance().toast("弹一条消息");
    }



    @Override
    public void onItemClick(View view, MutableLiveData<TestBean> bean) {
        ToastUtil.getInstance().toast(bean.getValue().getUserName());
    }
}
