package com.meet.xingyu.viewmodel.route;


import com.meet.xingyu.common.mvvm.BaseViewModel;

public class FragmentRouteViewModel extends BaseViewModel {

    private static FragmentRouteViewModel instance;

    private FragmentRouteViewModel() {
    }

    @Override
    public void loadData() {
    }

    public static FragmentRouteViewModel getInstance() {
        if (instance == null) {
            synchronized (FragmentRouteViewModel.class) {
                if (instance == null) {
                    instance = new FragmentRouteViewModel();
                }
            }
        }
        return instance;
    }

}
