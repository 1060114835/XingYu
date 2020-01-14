package com.meet.xingyu.common.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public  class SingleTypeAdapter<T extends MutableLiveData> extends BaseAdapter<T> {
    private int mItemLayoutId;

    public SingleTypeAdapter(Context context, int iBRData, int itemLayoutId) {
        super(context, iBRData,NO_NEED);
        mList = new ArrayList<>();
        mItemLayoutId = itemLayoutId;
    }

    public SingleTypeAdapter(Context context, int iBRData, int itemLayoutId, int iBRPresenter) {
        super(context, iBRData,iBRPresenter);
        mList = new ArrayList<>();
        mItemLayoutId = itemLayoutId;
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mItemLayoutId,parent,false);
        return new BindingViewHolder(view);
    }

    public void addAll(List<T> data) {
        mList.addAll(data);
        notifyDataSetChanged();
    }

    public void add(T data) {
        mList.add(data);
        notifyItemInserted(mList.size() - 1);
    }

    public void add(int position, T data) {
        mList.add(position,data);
        notifyItemChanged(position,data);
    }

    public void set(List<T> data) {
        mList.clear();
        addAll(data);
    }
}
