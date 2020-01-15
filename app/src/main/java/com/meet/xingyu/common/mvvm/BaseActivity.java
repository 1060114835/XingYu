package com.meet.xingyu.common.mvvm;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;


@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dealDataBing();
    }

    private void dealDataBing() {
        ViewDataBinding dataBinding = configureDataBinding();
        dataBinding.setLifecycleOwner(this);
        configureViewModel().loadData();
        bindingVariable();
        init();
        setContentView(dataBinding.getRoot());
    }

    /**
     * 如果需要在页面加载时做一些初始化操作，则覆写这个方法
     */
    protected void init(){
        //...
    }

    /**
     * 返回页面的viewModel
     * @return
     */
    protected abstract BaseViewModel configureViewModel();


    /**
     * 绑定xml中指定的vm和presenter
     */

    protected abstract void bindingVariable();

    /**
     * 返回页面的binding
     * @return
     */

    protected abstract ViewDataBinding configureDataBinding();


}
