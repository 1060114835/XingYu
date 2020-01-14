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
        configurePresenter().init();
        bindingVariable();
        setContentView(dataBinding.getRoot());
    }

    protected abstract BaseViewModel configureViewModel();

    protected abstract BasePresenter configurePresenter();

    protected abstract void bindingVariable();

    protected abstract ViewDataBinding configureDataBinding();

}
