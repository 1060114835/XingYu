package com.meet.xingyu.view;

import androidx.databinding.ViewDataBinding;

import com.meet.xingyu.common.mvvm.BaseActivity;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.ActivityTestBinding;
import com.meet.xingyu.presenter.TestPresenter;
import com.meet.xingyu.viewmodel.TestViewModel;

public class TestActivity extends BaseActivity {

    private ActivityTestBinding binding;

    @Override
    protected BaseViewModel configureViewModel() {
        return TestViewModel.getInstance();
    }

    @Override
    protected BasePresenter configurePresenter() {
        return TestPresenter.getInstance();
    }

    @Override
    protected void bindingVariable() {
        binding.setVm(TestViewModel.getInstance());
        binding.setPresenter(TestPresenter.getInstance());
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        return binding;
    }
}
