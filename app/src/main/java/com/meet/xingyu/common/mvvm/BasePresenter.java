package com.meet.xingyu.common.mvvm;

import android.view.MotionEvent;
import android.view.View;


/**
 * presenter层专门用来处理点击事件
 */
public abstract class BasePresenter {


    /**
     * 用来处理页面的点击事件
     * @param v
     */
    public abstract void onClick(View v);

    /**
     * 用来处理页面的触摸时间
     */
    public boolean onFocus(View v, MotionEvent event) {
        return false;
    }


    public interface OnItemClickListener<T> {
        void onItemClick(View view, T bean);
    }

}
