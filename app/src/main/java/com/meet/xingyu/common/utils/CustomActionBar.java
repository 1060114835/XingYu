package com.meet.xingyu.common.utils;



import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;

import com.meet.xingyu.BR;
import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.utils.UnitTranstormUtil;


public class CustomActionBar {

    public static void set(AppCompatActivity activity, BasePresenter presenter, MutableLiveData<String> title) {
        set(activity, presenter, title, "", 0, "#FFFFFF", "#333333");
    }


    /**
     * 自定义顶部ActionBar
     *
     * @param activity     上下文
     * @param title        中间标题
     * @param rightText    右边文字
     * @param rightColor 右边文字颜色
     */
    public static void set(AppCompatActivity activity, BasePresenter presenter, MutableLiveData<String> title,
                           String rightText, int rightImg, String backgroundColor, String rightColor) {

        ViewDataBinding binding = DataBindingUtil.inflate(activity.getLayoutInflater(),
                R.layout.actionbar, null, false);
        binding.setLifecycleOwner(activity);

        activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding.setVariable(com.meet.xingyu.BR.presenter, presenter);
        binding.setVariable(BR.title, title);
        binding.executePendingBindings();

        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View actionBarView = binding.getRoot();
        TextView textM = actionBarView.findViewById(R.id.title);
        TextView textR = actionBarView.findViewById(R.id.right_icon);
        actionBarView.setBackgroundColor(Color.parseColor(backgroundColor));
        actionBarView.setZ(0);
        textR.setText(rightText);
        if (rightImg != 0){
            textR.setBackgroundResource(rightImg);
        }
        textM.setTextColor(Color.parseColor("#333333"));
        textR.setTextColor(Color.parseColor(rightColor));
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(actionBarView, lp);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }


}
