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
        setContentView(configureDataBinding().getRoot());
        configureDataBinding().setLifecycleOwner(this);
        configurePresenter().init();
        bindingVariable();
    }

    protected abstract BasePresenter configurePresenter();

    protected abstract void bindingVariable();

    protected abstract ViewDataBinding configureDataBinding();

}
