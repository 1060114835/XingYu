package com.meet.xingyu.viewmodel.my;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.daimajia.swipe.SwipeLayout;
import com.meet.xingyu.BR;
import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.model.my.MyBean;
import com.meet.xingyu.presenter.my.MyMessagePresenter;

import java.util.ArrayList;
import java.util.List;

public class FragmentMyMessageViewModel extends AdapterViewModel<MutableLiveData<MyBean>> {

    //测试用
    Context context;

    private static FragmentMyMessageViewModel instance;
    private MutableLiveData<Drawable> headImg;
    private MutableLiveData<String> nickName;
    private MutableLiveData<Integer> messageCount;
    private MutableLiveData<String> startStation;
    private MutableLiveData<String> endStation;
    private MutableLiveData<Integer> locationCount;

    private MutableLiveData<Drawable> yellowRemind;
    private MutableLiveData<Drawable> grayRemind;

    private SingleTypeAdapter<MutableLiveData<MyBean>> singleTypeAdapter;

    private FragmentMyMessageViewModel(){
        headImg = new MutableLiveData<>();
        nickName = new MutableLiveData<>();
        messageCount = new MutableLiveData<>();
        startStation = new MutableLiveData<>();
        endStation = new MutableLiveData<>();
        locationCount = new MutableLiveData<>();
    }

    @Override
    public BaseAdapter getAdapter(Context context) {
        this.context = context;
        if (singleTypeAdapter == null){
            singleTypeAdapter = new SingleTypeAdapter<>(context,BR.myBean,
                    R.layout.fragment_my_message_pager_item,BR.myMessagePresenter);
            loadData();
            singleTypeAdapter.setmListener(MyMessagePresenter.getInstance());
        }
        return singleTypeAdapter;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override
    public void loadData() {
        //测试用
        ArrayList<MutableLiveData<MyBean>> dataArrayList = new ArrayList<>();

        Activity activity = (Activity) context;

        yellowRemind = new MutableLiveData<>();
        grayRemind = new MutableLiveData<>();

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < 8;i++){
            count1 = 9 + i;
            count2 = 10 - i;
            MyBean myBean = new MyBean(activity.getDrawable(R.drawable.ic_launcher_background)
                                        ,"jeery" + i
                                        ,""+count1
                                        , "重庆邮电大学"
                                        ,"重庆西站"
                                        ,""+count2);
            if (count1 >= 10){
                myBean.setYellowRemind(activity.getDrawable(R.drawable.my_remind_rectangle_yellow));
            }else {
                myBean.setYellowRemind(activity.getDrawable(R.drawable.my_remind_yellow));
            }

            if (count2 >= 10){
                myBean.setGrayRemind(activity.getDrawable(R.drawable.my_remind_rectangle_gray));
            }else {
                myBean.setGrayRemind(activity.getDrawable(R.drawable.my_remind_gray));
            }

            MutableLiveData<MyBean> myBeanMutableLiveData = new MutableLiveData<>();
            myBeanMutableLiveData.setValue(myBean);

            dataArrayList.add(myBeanMutableLiveData);
        }

        if (singleTypeAdapter != null){
            //让presenter持有adapter，并使用其方法
            MyMessagePresenter.getInstance().setSingleTypeAdapter(singleTypeAdapter,dataArrayList);
            MyMessagePresenter.getInstance().resetPosition(dataArrayList);

            singleTypeAdapter.set(dataArrayList);
        }
    }


    public static FragmentMyMessageViewModel getInstance(){
        if (instance == null){
            synchronized (FragmentMyMessageViewModel.class){
                if (instance == null){
                    instance = new FragmentMyMessageViewModel();
                }
            }
        }
        return instance;
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

    public MutableLiveData<Integer> getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(MutableLiveData<Integer> messageCount) {
        this.messageCount = messageCount;
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

    public MutableLiveData<Integer> getLocationCount() {
        return locationCount;
    }

    public void setLocationCount(MutableLiveData<Integer> locationCount) {
        this.locationCount = locationCount;
    }

    public MutableLiveData<Drawable> getYellowRemind() {
        return yellowRemind;
    }

    public void setYellowRemind(MutableLiveData<Drawable> yellowRemind) {
        this.yellowRemind = yellowRemind;
    }

    public MutableLiveData<Drawable> getGrayRemind() {
        return grayRemind;
    }

    public void setGrayRemind(MutableLiveData<Drawable> grayRemind) {
        this.grayRemind = grayRemind;
    }
}
