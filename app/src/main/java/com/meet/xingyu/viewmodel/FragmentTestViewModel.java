package com.meet.xingyu.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.common.mvvm.BaseViewModel;

public class FragmentTestViewModel extends BaseViewModel {
    private MutableLiveData<String> content;
    private static FragmentTestViewModel instance;
    private FragmentTestViewModel() {
        content = new MutableLiveData<>();
    }
    @Override
    public void loadData() {

    }

    public static FragmentTestViewModel getInstence() {
        if (instance == null) {
            synchronized (FragmentTestViewModel.class) {
                if (instance == null) {
                    instance = new FragmentTestViewModel();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<String> getContent() {
        return content;
    }
}
