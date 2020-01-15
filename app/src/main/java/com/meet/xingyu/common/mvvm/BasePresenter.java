package com.meet.xingyu.common.mvvm;

import android.view.View;


/**
 * presenter层专门用来处理点击事件
 */
public abstract class BasePresenter {

    /**
     * 如果需要在页面加载的时候做一些初始化操作，则覆写这个方法
     */
    void init(){
    }


    public abstract void onClick(View v);



    public interface OnItemClickListener<T> {
        void onItemClick(View view, T bean);
    }

}
