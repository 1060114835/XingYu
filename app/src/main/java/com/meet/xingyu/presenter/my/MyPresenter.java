package com.meet.xingyu.presenter.my;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BasePresenter;

public class MyPresenter extends BasePresenter {

    private static MyPresenter instance;

    private MyPresenter(){

    }

    @Override
    public void onClick(View v) {
    }

    public static MyPresenter getInstance(){
        if (instance == null){
            synchronized (MyPresenter.class){
                if (instance == null){
                    instance = new MyPresenter();
                }
            }
        }
        return instance;
    }
}
