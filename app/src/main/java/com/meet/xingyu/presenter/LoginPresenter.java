package com.meet.xingyu.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.databinding.ActivityMianBinding;
import com.meet.xingyu.view.MainActivity;

public class LoginPresenter extends BasePresenter {

    private static LoginPresenter instance;

    private LoginPresenter() {}





















































































    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_bt_1:
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
                ((Activity)v.getContext()).finish();
                break;
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
