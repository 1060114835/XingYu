package com.meet.xingyu.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.view.TestActivity;

public class LoginPresenter extends BasePresenter {

    private static LoginPresenter instance;

    private LoginPresenter() {}

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_bt_1) {
            Intent intent = new Intent(v.getContext(), TestActivity.class);
            v.getContext().startActivity(intent);
            ((Activity)v.getContext()).finish();
        }
    }

    public static LoginPresenter getInstance() {
        if (instance == null) {
            synchronized (LoginPresenter.class) {
                if (instance == null) {
                    instance = new LoginPresenter();
                }
            }
        }
        return instance;
    }
}
