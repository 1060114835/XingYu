package com.meet.xingyu.viewmodel.route;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.meet.xingyu.BR;
import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.model.route.AllBean;

public class RouteAllViewModel extends AdapterViewModel<MutableLiveData<AllBean>> {

    public MutableLiveData<String> data;
    public MutableLiveData<String> time;
    public MutableLiveData<String> week;
    public MutableLiveData<String> start;
    public MutableLiveData<String> end;

    /**
     * 性别：男：5D34F4，女：ED2FFC
     */
    public MutableLiveData<Integer> captainSexColor;
    public MutableLiveData<String> captain;
    public MutableLiveData<Integer> teammateSexColor;
    public MutableLiveData<String> teammate;

    private static RouteAllViewModel instance;
    private SingleTypeAdapter<MutableLiveData<AllBean>> singleTypeAdapter;


    private RouteAllViewModel() {
    }

    @Override
    public BaseAdapter getAdapter(Context context) {
        if (singleTypeAdapter == null) {
            singleTypeAdapter = new SingleTypeAdapter<MutableLiveData<AllBean>>(context,
                    BR.routeAllVM, R.layout.item_route_all, BR.routeAllPresenter);
        }
        loadData();
        return singleTypeAdapter;
    }

    @Override
    public LinearLayoutManager getLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Override
    public void loadData() {

    }

    public static RouteAllViewModel getInstance() {
        if (instance == null) {
            synchronized (RouteAllViewModel.class) {
                if(instance == null) {
                    instance = new RouteAllViewModel();
                }
            }
        }
        return instance;
    }

    public MutableLiveData<String> getData() {
        return data;
    }

    public void setData(MutableLiveData<String> data) {
        this.data = data;
    }

    public MutableLiveData<String> getTime() {
        return time;
    }

    public void setTime(MutableLiveData<String> time) {
        this.time = time;
    }

    public MutableLiveData<String> getWeek() {
        return week;
    }

    public void setWeek(MutableLiveData<String> week) {
        this.week = week;
    }

    public MutableLiveData<String> getStart() {
        return start;
    }

    public void setStart(MutableLiveData<String> start) {
        this.start = start;
    }

    public MutableLiveData<String> getEnd() {
        return end;
    }

    public void setEnd(MutableLiveData<String> end) {
        this.end = end;
    }

    public MutableLiveData<Integer> getCaptainSexColor() {
        return captainSexColor;
    }

    public void setCaptainSexColor(MutableLiveData<Integer> captainSexColor) {
        this.captainSexColor = captainSexColor;
    }

    public MutableLiveData<String> getCaptain() {
        return captain;
    }

    public void setCaptain(MutableLiveData<String> captain) {
        this.captain = captain;
    }

    public MutableLiveData<Integer> getTeammateSexColor() {
        return teammateSexColor;
    }

    public void setTeammateSexColor(MutableLiveData<Integer> teammateSexColor) {
        this.teammateSexColor = teammateSexColor;
    }

    public MutableLiveData<String> getTeammate() {
        return teammate;
    }

    public void setTeammate(MutableLiveData<String> teammate) {
        this.teammate = teammate;
    }
}
