package com.meet.xingyu.viewmodel.my;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.BR;
import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.model.my.MyBean;
import com.meet.xingyu.presenter.my.MyFriendPresenter;

import java.util.ArrayList;

public class FragmentMyFriendViewModel extends AdapterViewModel<MutableLiveData<MyBean>> {

    Context context;

    private static FragmentMyFriendViewModel instance;

    private MutableLiveData<Drawable> headImg;
    private MutableLiveData<String> nickName;
    private MutableLiveData<String> startStation;
    private MutableLiveData<String> endStation;
    private MutableLiveData<String> publishTime;
    private MutableLiveData<String> longTime;

    SingleTypeAdapter<MutableLiveData<MyBean>> singleTypeAdapterFri;

    public static FragmentMyFriendViewModel getInstance(){
        if (instance == null){
            synchronized (FragmentMyFriendViewModel.class){
                if (instance == null){
                    instance = new FragmentMyFriendViewModel();
                }
            }
        }
        return instance;
    }

    @Override
    public BaseAdapter<MutableLiveData<MyBean>> getAdapter(Context context) {
        this.context = context;
        if (singleTypeAdapterFri == null){
            singleTypeAdapterFri = new SingleTypeAdapter<>(context, BR.myBean,
                    R.layout.fragment_my_friend_pager_item, BR.myFriendPresenter);
            loadData();
            singleTypeAdapterFri.setmListener(MyFriendPresenter.getInstance());
        }
        return singleTypeAdapterFri;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override
    public void loadData() {
        ArrayList<MutableLiveData<MyBean>> mutableLiveData = new ArrayList<>();
        Activity activity = (Activity)context;

        for (int i = 0; i < 8;i++){
            MyBean myBean = new MyBean(activity.getDrawable(R.drawable.ic_launcher_background)
                    ,"jeery" + i
                    ,"重庆邮电大学"
                    , "重庆西站"
                    ,i +"月"+ i +"日"+" "+i+":"+i
                    ,"发布于" + i + "小时前",1);

            MutableLiveData<MyBean> myBeanMutableLiveData = new MutableLiveData<>();
            myBeanMutableLiveData.setValue(myBean);

            mutableLiveData.add(myBeanMutableLiveData);
        }

        if (singleTypeAdapterFri != null){
            for (int i = 0;i < mutableLiveData.size();i++){
                mutableLiveData.get(i).getValue().position = i;
            }
            singleTypeAdapterFri.set(mutableLiveData);
        }
    }

    public MutableLiveData<Drawable> getHeadImg() {
        return headImg;
    }

    public void setHeadImg(MutableLiveData<Drawable> headImg) {
        this.headImg = headImg;
    }

    public MutableLiveData<String> getNickName() {
        return nickName;
    }

    public void setNickName(MutableLiveData<String> nickName) {
        this.nickName = nickName;
    }

    public MutableLiveData<String> getStartStation() {
        return startStation;
    }

    public void setStartStation(MutableLiveData<String> startStation) {
        this.startStation = startStation;
    }

    public MutableLiveData<String> getEndStation() {
        return endStation;
    }

    public void setEndStation(MutableLiveData<String> endStation) {
        this.endStation = endStation;
    }

    public MutableLiveData<String> getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(MutableLiveData<String> publishTime) {
        this.publishTime = publishTime;
    }

    public MutableLiveData<String> getLongTime() {
        return longTime;
    }

    public void setLongTime(MutableLiveData<String> longTime) {
        this.longTime = longTime;
    }
}
