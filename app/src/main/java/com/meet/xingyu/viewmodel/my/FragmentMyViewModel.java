package com.meet.xingyu.viewmodel.my;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BaseViewModel;

public class FragmentMyViewModel extends BaseViewModel {

    private static FragmentMyViewModel instance;
    private MutableLiveData<Drawable> urlMyIcon;
    private MutableLiveData<Drawable> sexUrl;
    private MutableLiveData<String> myId;

    //测试用
    Context context;
    int sex;

    private FragmentMyViewModel(){
        urlMyIcon = new MutableLiveData<>();
        sexUrl = new MutableLiveData<>();
        myId = new MutableLiveData<>();
    }

    @Override
    public void loadData() {
        //测试用
        //取得微信相应的请求结果响应后，设置头像、性别、昵称
        Activity activity = (Activity)context;

        urlMyIcon.setValue(activity.getDrawable(R.drawable.my_man));

        sex = 2;
        if (sex == 1){
            sexUrl.setValue(activity.getDrawable(R.drawable.my_man));
        }else {
            sexUrl.setValue(activity.getDrawable(R.drawable.my_woman));
        }

        myId.setValue("flood");
    }

    //测试用
    public void getContext(Context context){
        this.context = context;
    }


    public static FragmentMyViewModel getInstance(){
        if (instance == null){
            synchronized (FragmentMyViewModel.class){
                if (instance == null){
                    instance = new FragmentMyViewModel();
                }
            }
        }
        return instance;
    }

    public void setUrlMyIcon(MutableLiveData<Drawable> urlMyIcon) {
        this.urlMyIcon = urlMyIcon;
    }

    public MutableLiveData<Drawable> getUrlMyIcon() {
        return urlMyIcon;
    }

    public void setSexUrl(MutableLiveData<Drawable> sex) {
        this.sexUrl = sex;
    }

    public MutableLiveData<Drawable> getSexUrl() {
        return sexUrl;
    }

    public void setMyId(MutableLiveData<String> myId) {
        this.myId = myId;
    }

    public MutableLiveData<String> getMyId() {
        return myId;
    }

}
