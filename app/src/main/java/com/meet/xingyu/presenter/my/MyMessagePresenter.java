package com.meet.xingyu.presenter.my;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.lifecycle.MutableLiveData;

import com.daimajia.swipe.SwipeLayout;
import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.ToastUtil;
import com.meet.xingyu.databinding.FragmentMyMessagePagerBinding;
import com.meet.xingyu.model.my.MyBean;
import com.meet.xingyu.view.my.MyPagerMessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MyMessagePresenter extends ItemPresenter<MutableLiveData<MyBean>> {

    private static MyMessagePresenter instance;

    private SingleTypeAdapter singleTypeAdapter;

    private ArrayList<MutableLiveData<MyBean>> list;

    private FragmentMyMessagePagerBinding fragmentMyMessagePagerBinding;

    @Override
    public void onClick(View v) {
        //进入聊天页和发布信息的入口

    }

    @Override
    public void onItemClick(View view, MutableLiveData<MyBean> bean) {
        //删除指定position的消息
        switch (view.getId()){
            case R.id.delete_item:
                list.remove(bean.getValue().position);
                if (list.size() == 0){
                    fragmentMyMessagePagerBinding.messageNotImage.setVisibility(View.VISIBLE);
                }else {
                    fragmentMyMessagePagerBinding.messageNotImage.setVisibility(View.GONE);
                }
                resetPosition(list);
                singleTypeAdapter.set(list);
        }
    }

    public static MyMessagePresenter getInstance(){
        if (instance == null){
            synchronized (MyMessagePresenter.class){
                if (instance == null){
                    instance = new MyMessagePresenter();
                }
            }
        }
        return instance;
    }

    public void setSingleTypeAdapter(SingleTypeAdapter singleTypeAdapter, ArrayList<MutableLiveData<MyBean>> list){
        this.singleTypeAdapter = singleTypeAdapter;
        this.list = list;
    }

    /**
     * 重置position顺序
     */
    public void resetPosition(ArrayList<MutableLiveData<MyBean>> liveData){
        for (int i = 0;i < liveData.size();i++){
            liveData.get(i).getValue().position = i;
        }
    }

    public void setFragmentMyMessagePagerBinding(FragmentMyMessagePagerBinding fragmentMyMessagePagerBinding) {
        this.fragmentMyMessagePagerBinding = fragmentMyMessagePagerBinding;
    }
}
