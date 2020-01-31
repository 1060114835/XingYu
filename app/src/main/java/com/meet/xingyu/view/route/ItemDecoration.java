package com.meet.xingyu.view.route;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Richard
 * @time 2020/1/21
 * @describe 给行程页 队长发布页的 RecyclerView 的 Adapter
 */
public class ItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public ItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = space;
        if (parent.getChildLayoutPosition(view) == 0)
            outRect.top = 0;
    }
}
