package com.meet.xingyu.view.route;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Richard
 * @time 2020/1/21
 * @describe 给总的 RecyclerView Item 设置间距
 */
public class RouteItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public RouteItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = space;
        outRect.right = space;
    }
}