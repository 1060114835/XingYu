package com.meet.xingyu.presenter.my;

import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.model.my.MyBean;

public class MyFriendPresenter extends ItemPresenter<MutableLiveData<MyBean>> {

    private static MyFriendPresenter instance;

    public static MyFriendPresenter getInstance() {
        if (instance == null){
            synchronized (MyFriendPresenter.class){
                if (instance == null){
                    instance = new MyFriendPresenter();
                }
            }
        }
        return instance;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onItemClick(View view, MutableLiveData<MyBean> bean) {
        ToastUtil.getInstance().toast("点击了第" + bean.getValue().position + "个好友");

        switch (view.getId()){
            case R.id.button_talk:
                ToastUtil.getInstance().toast("你将和"+ bean.getValue().getNickName() +"交流");
        }

    }
}
