package com.meet.xingyu.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.common.mvvm.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private MutableLiveData<String> title;
    private static MainViewModel instance;


    private MainViewModel() {
        title = new MutableLiveData<>();
    }
    @Override
    public void loadData() {
        title.setValue("推荐");
    }

    public static MainViewModel getInstance() {
        if (instance == null) {
            synchronized (MainViewModel.class) {
                if (instance == null)
                    instance = new MainViewModel();
            }
        }
        return instance;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(MutableLiveData<String> title) {
        this.title = title;
    }
}
