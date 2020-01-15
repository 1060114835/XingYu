package com.meet.xingyu.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.model.TestBean;
import com.meet.xingyu.presenter.TestPresenter;

import java.util.ArrayList;
import java.util.List;

public class TestViewModel extends AdapterViewModel {
    private List<MutableLiveData<TestBean>> mList;
    private static TestViewModel instance;
    private MutableLiveData<String> appName;
    private MutableLiveData<String> detail;
    private MutableLiveData<String> title;
    private SingleTypeAdapter<MutableLiveData<TestBean>> singleTypeAdapter;

    private TestViewModel() {
        mList = new ArrayList<>();
        appName = new MutableLiveData<>();
        detail = new MutableLiveData<>();
        title = new MutableLiveData<>();
    }

    @Override
    public void loadData() {
        //网络请求数据
        appName.setValue("行遇");
        detail.setValue("练手项目");
        title.setValue("测试页");
        for (int i = 0; i < 30; i++) {
            MutableLiveData<TestBean> mutableLiveData = new MutableLiveData<>();
            mutableLiveData.setValue(new TestBean(i + "", "用户" + i + "号"));
            mList.add(mutableLiveData);
        }
        if (singleTypeAdapter != null) {
            singleTypeAdapter.set(mList);
        }

    }

    public static TestViewModel getInstance() {
        if (instance == null) {
            synchronized (TestViewModel.class) {
                if (instance == null) {
                    instance = new TestViewModel();
                }
            }
        }
        return instance;
    }

    @Override
    public BaseAdapter getAdapter(Context context) {
        if (singleTypeAdapter == null) {
            singleTypeAdapter =  new SingleTypeAdapter<>(context,com.meet.xingyu.BR.data
                    , R.layout.item_test, com.meet.xingyu.BR.presenter);
            singleTypeAdapter.set(mList);
            singleTypeAdapter.setmListener(TestPresenter.getInstance());
        }
        return singleTypeAdapter;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    public MutableLiveData<String> getAppName() {
        return appName;
    }

    public void setAppName(MutableLiveData<String> appName) {
        this.appName = appName;
    }

    public MutableLiveData<String> getDetail() {
        return detail;
    }

    public void setDetail(MutableLiveData<String> detail) {
        this.detail = detail;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(MutableLiveData<String> title) {
        this.title = title;
    }
}
