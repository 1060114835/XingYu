package com.meet.xingyu.common.mvvm;

import android.view.View;


/**
 * presenter层专门用来处理点击事件
 */
public abstract class BasePresenter {


    /**
     * 用来处理的页面的点击事件
     * @param v
     */
    public abstract void onClick(View v);



    public interface OnItemClickListener<T> {
        void onItemClick(View view, T bean);
    }

}
