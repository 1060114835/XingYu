package com.meet.xingyu.viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.model.TestBean;
import com.meet.xingyu.net.ApiRetrofit;
import com.meet.xingyu.net.Observer;
import com.meet.xingyu.net.SubscriptionManager;
import com.meet.xingyu.net.bean.YouDao;
import com.meet.xingyu.net.idescrbe.IYouDao;
import com.meet.xingyu.presenter.TestPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestViewModel extends AdapterViewModel {
    private static TestViewModel instance;
    private MutableLiveData<String> appName;
    private MutableLiveData<String> detail;
    private MutableLiveData<String> title;
    private SingleTypeAdapter<MutableLiveData<TestBean>> singleTypeAdapter;

    private TestViewModel() {
        appName = new MutableLiveData<>();
        detail = new MutableLiveData<>();
        title = new MutableLiveData<>();
    }

    @Override
    public void loadData() {
        List<MutableLiveData<TestBean>> list = new ArrayList<>();
        //网络请求数据
        appName.setValue("行遇");
        detail.setValue("练手项目");
        title.setValue("测试页");
        for (int i = 0; i < 20; i++) {
            MutableLiveData<TestBean> mutableLiveData = new MutableLiveData<>();
            mutableLiveData.setValue(new TestBean(i + "", "用户" + i + "号"));
            list.add(mutableLiveData);
        }
        if (singleTypeAdapter != null) {
            singleTypeAdapter.set(list);
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
            loadData();
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

    /**
     * 测试网络请求方法，模板未完善，勿删
     */
    public void test() {
        //测试网络请求
        //注意在重写的 onSubscribe() 方法中添加订阅
        //提醒不使用的时候应该进行取消
        ApiRetrofit.create("https://fanyi.youdao.com/", IYouDao.class)
                .getObservable("translate?doctype=json&jsonversion=&type" +
                                         "=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=",
                          "i am richard")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YouDao>() {
                    @Override
                    public void onSuccess(YouDao youDao) {
                        Log.d("TestActivity", "开始打印数据");
                        String s = youDao.getTranslateResult().get(0).get(0).getTgt();
                        Log.d("TestActivity", s);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        SubscriptionManager.getInstance().add(d);
                    }
                });
    }
}
