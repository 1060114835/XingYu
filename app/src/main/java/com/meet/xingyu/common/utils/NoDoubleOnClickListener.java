package com.meet.xingyu.common.utils;

import android.view.View;

/**
 * 点击事件防抖
 */
public abstract class NoDoubleOnClickListener implements View.OnClickListener {
    //点击最短时间间隔
    private static final int MIN_CLICK_TIME = 200;
    //上次点击时间
    private long lastClickTime = System.currentTimeMillis();
    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastClickTime > MIN_CLICK_TIME) {
            noDoubleOnClick(v);
            lastClickTime = currentTime;
        }
    }

    public abstract void noDoubleOnClick(View v);
}
