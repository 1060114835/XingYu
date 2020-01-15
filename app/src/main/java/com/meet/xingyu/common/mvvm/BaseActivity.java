package com.meet.xingyu.common.mvvm;

import android.annotation.SuppressLint;
import android.os.Bundle;

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
        configurePresenter().init();
        bindingVariable();
        setContentView(dataBinding.getRoot());
    }

    /**
     * 返回页面的viewModel
     * @return
     */
    protected abstract BaseViewModel configureViewModel();

    /**
     * 返回页面的presenter
     * @return
     */
    protected abstract BasePresenter configurePresenter();

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
