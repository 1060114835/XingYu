package com.meet.xingyu.viewmodel;

import com.meet.xingyu.common.mvvm.BaseViewModel;

public class LoginViewModel extends BaseViewModel {
    private static LoginViewModel instance;

    private LoginViewModel() {}

    @Override
    public void loadData() {

    }

    public static LoginViewModel getInstance() {
        if (instance == null) {
            synchronized (LoginViewModel.class) {
                if (instance == null) {
                    instance = new LoginViewModel();
                }
            }
        }
        return instance;
    }
}
