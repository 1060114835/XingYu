package com.meet.xingyu.common.adapter;

import android.view.View;

import androidx.databinding.BindingAdapter;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.common.utils.NoDoubleClickListener;

public final class ViewBindingAdapter {

    @BindingAdapter("onClick")
    public void onClick(View view, BasePresenter presenter) {
        view.setOnClickListener(new NoDoubleClickListener() {
            @Override
            public void noDoubleOnClick(View v) {
                presenter.onClick(v);
            }
        });
    }



}
