package com.meet.xingyu.view;

import androidx.databinding.ViewDataBinding;

import com.meet.xingyu.common.mvvm.BaseActivity;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.ActivityLoginBinding;
import com.meet.xingyu.presenter.LoginPresenter;
import com.meet.xingyu.viewmodel.LoginViewModel;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    @Override
    protected BaseViewModel configureViewModel() {
        return LoginViewModel.getInstance();
    }

    @Override
    protected void bindingVariable() {
        binding.setPresenter(LoginPresenter.getInstance());
        binding.setVm(LoginViewModel.getInstance());
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        return binding = ActivityLoginBinding.inflate(getLayoutInflater());
    }
}
