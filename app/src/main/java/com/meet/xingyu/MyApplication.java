package com.meet.xingyu;

import android.app.Application;

import com.meet.xingyu.common.utils.ToastUtil;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.getInstance().init(this);
    }
}
