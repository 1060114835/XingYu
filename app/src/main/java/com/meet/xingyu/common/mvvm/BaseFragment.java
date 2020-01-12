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
        configurePresenter().init();
        bindingVariable();
        return dataBinding.getRoot();
    }


    protected abstract ViewDataBinding configureDataBinding();

    protected abstract void bindingVariable();

    protected abstract BasePresenter configurePresenter();
}
