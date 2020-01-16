package com.meet.xingyu.common.adapter;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.AdapterViewModel;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.common.mvvm.ItemPresenter;
import com.meet.xingyu.common.utils.NoDoubleOnClickListener;

public final class ViewBindingAdapter {

    @BindingAdapter("onClick")
    public static void onClick(View view, BasePresenter presenter) {
        view.setOnClickListener(new NoDoubleOnClickListener() {
            @Override
            public void noDoubleOnClick(View v) {
                presenter.onClick(v);
            }
        });
    }


    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }


    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, AdapterViewModel viewModel) {
        recyclerView.setAdapter(viewModel.getAdapter(recyclerView.getContext()));
        recyclerView.setLayoutManager(viewModel.getLayoutManager(recyclerView.getContext()));
    }

    @BindingAdapter(value = {"clickItemPresenter", "clickItemBean"})
    public static <T extends MutableLiveData> void onItemClick(View view
            , ItemPresenter<T> presenter, T bean) {
        view.setOnClickListener(v -> presenter.onItemClick(view,bean));
    }


    @SuppressLint("ClickableViewAccessibility")
    @BindingAdapter("onTouch")
    public static void onTouch(View view, BasePresenter presenter) {
        view.setOnTouchListener((v, event) -> {
            presenter.onFocus(v,event);
            return true;
        });
    }
}
