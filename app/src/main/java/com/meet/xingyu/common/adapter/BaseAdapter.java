package com.meet.xingyu.common.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.meet.xingyu.common.mvvm.BasePresenter;

import java.util.List;

public abstract class BaseAdapter<T extends MutableLiveData> extends RecyclerView.Adapter<BaseAdapter.BindingViewHolder> {
    protected List<T> mList;
    protected int mBRData;
    protected Context mContext;
    public static final int NO_NEED = -1001;
    protected BasePresenter.OnItemClickListener<T> mListener;
    protected int mBRPresenter;

    public BaseAdapter() {
    }

    public BaseAdapter(Context context, int iBRData, int iBRPresenter) {
        super();
        mContext = context;
        mBRData = iBRData;
        mBRPresenter = iBRPresenter;
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder holder, int position) {
        holder.binding.setVariable(mBRData, mList.get(position));
        if (mBRPresenter != NO_NEED)
            holder.binding.setVariable(mBRPresenter,mListener);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void remove(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

    public Context getmContext() {
        return mContext;
    }



    public static class BindingViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            if (binding != null) {
                binding.setLifecycleOwner((LifecycleOwner) itemView.getContext());
            }
        }
    }

    public BasePresenter.OnItemClickListener<T> getmListener() {
        return mListener;
    }

    public void setmListener(BasePresenter.OnItemClickListener<T> mListener) {
        this.mListener = mListener;
    }

}
