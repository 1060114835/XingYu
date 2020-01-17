package com.meet.xingyu;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.meet.xingyu.common.utils.ToastUtil;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.getInstance().init(this);
    }

}
