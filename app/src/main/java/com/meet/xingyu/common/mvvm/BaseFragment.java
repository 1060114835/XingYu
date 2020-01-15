package com.meet.xingyu.common.mvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return dealDataBinding();
    }

    private View dealDataBinding() {
        ViewDataBinding dataBinding = configureDataBinding();
        dataBinding.setLifecycleOwner(this);
        configureViewModel().loadData();
        bindingVariable();
        return dataBinding.getRoot();
    }

    protected abstract BaseViewModel configureViewModel();

    protected abstract ViewDataBinding configureDataBinding();

    protected abstract void bindingVariable();

    /**
     * 如果需要在页面加载时做一些初始化操作，则覆写这个方法
     */
    protected void init(){
        //...
    }

}
