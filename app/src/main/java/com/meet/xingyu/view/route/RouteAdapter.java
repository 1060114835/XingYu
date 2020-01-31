package com.meet.xingyu.view.route;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.meet.xingyu.BR;
import com.meet.xingyu.R;
import com.meet.xingyu.common.adapter.BaseAdapter;
import com.meet.xingyu.common.adapter.SingleTypeAdapter;
import com.meet.xingyu.common.utils.LogUtil;
import com.meet.xingyu.model.route.AllBean;
import com.meet.xingyu.model.route.MyAndApplyBean;

import java.util.ArrayList;
import java.util.List;


public class RouteAdapter extends BaseAdapter {

    private Context mContext;

    private static final int TYPE_Apply = 0;
    private static final int TYPE_My = 1;
    private static final int TYPE_All = 2;

    private SingleTypeAdapter<MutableLiveData<MyAndApplyBean>> mApplyAdapter;
    private SingleTypeAdapter<MutableLiveData<MyAndApplyBean>> mMyAdapter;
    private SingleTypeAdapter<MutableLiveData<AllBean>> mAllAdapter;
    private SingleTypeAdapter<MutableLiveData<MyAndApplyBean>> mMyApplyAdapter;

    private List<MutableLiveData<MyAndApplyBean>> mApplyList;
    private List<MutableLiveData<MyAndApplyBean>> mMyList;
    private List<MutableLiveData<MyAndApplyBean>> mMyApplyList;
    private List<MutableLiveData<AllBean>> mAllList;

    public RouteAdapter(Context context) {
            mContext = context;
        initItemList();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_Apply) {
            View apply = LayoutInflater.from(mContext).inflate(R.layout.fragment_route_apply,
                    parent, false);
            return new ApplyViewHolder(apply);
        }else if (viewType == TYPE_My) {
            View my = LayoutInflater.from(mContext).inflate(R.layout.fragment_route_my,
                    parent, false);
            return new MyViewHolder(my);
        }else {
            View all = LayoutInflater.from(mContext).inflate(R.layout.fragment_route_all,
                    parent, false);
            return new AllViewHolder(all);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ApplyViewHolder) {
            mApplyAdapter = new SingleTypeAdapter<MutableLiveData<MyAndApplyBean>>(mContext,
                    BR.routeApplyVM, R.layout.item_route_apply, BR.routeApplyPresenter);
            mApplyAdapter.addAll(mApplyList);
            ((ApplyViewHolder) holder).recyclerView.setAdapter(mApplyAdapter);
            ((ApplyViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(
                    mContext, RecyclerView.VERTICAL, false));
        } else if (holder instanceof MyViewHolder) {
            //parent
            mMyAdapter = new SingleTypeAdapter<MutableLiveData<MyAndApplyBean>>(mContext,
                    BR.routeMyVM, R.layout.item_route_my, BR.routeMyPresenter);
            mMyAdapter.addAll(mMyList);
            ((MyViewHolder) holder).parentRecyclerView.setAdapter(mMyAdapter);
            ((MyViewHolder) holder).parentRecyclerView.setLayoutManager(new LinearLayoutManager(
                    mContext, RecyclerView.VERTICAL, false));
            ((MyViewHolder) holder).parentRecyclerView.addItemDecoration(
                    new ItemDecoration(60));
            //child，注释部分会出现空指针，78行那里，调用setAdapter的时候，recyclerView是null
//            mMyApplyAdapter = new SingleTypeAdapter<MutableLiveData<MyAndApplyBean>>(mContext,
//                    BR.routeMyApplyBean, R.layout.item_route_my_apply, BR.routeMyApplyPresenter);
//            mMyApplyAdapter.addAll(mMyApplyList);
//            ((MyViewHolder) holder).childRecyclerView.setAdapter(mMyApplyAdapter);
//            ((MyViewHolder) holder).childRecyclerView.setLayoutManager(new LinearLayoutManager(
//                    mContext, RecyclerView.VERTICAL, false));
//            ((MyViewHolder) holder).childRecyclerView.addItemDecoration(
//                    new ItemDecoration(20));
//            ((MyViewHolder) holder).childRecyclerView.addOnItemTouchListener(
//                    new RecyclerView.OnItemTouchListener() {
//                @Override
//                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv,
//                                                     @NonNull MotionEvent e) {
//                    if (e.getAction() == MotionEvent.ACTION_DOWN || e.getAction() ==
//                            MotionEvent.ACTION_MOVE) {
//                        rv.getParent().requestDisallowInterceptTouchEvent(true);
//                    } else if (e.getAction() == MotionEvent.ACTION_UP){
//                        rv.getParent().requestDisallowInterceptTouchEvent(false);
//                    }
//                    return false;
//                }
//
//                @Override
//                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
//
//                }
//
//                @Override
//                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//                }
//            });
        } else if (holder instanceof AllViewHolder){
            mAllAdapter = new SingleTypeAdapter<MutableLiveData<AllBean>>(mContext,
                    BR.routeAllVM, R.layout.item_route_all, BR.routeAllPresenter);
            mAllAdapter.addAll(mAllList);
            ((AllViewHolder) holder).recyclerView.setAdapter(mAllAdapter);
            ((AllViewHolder) holder).recyclerView.setLayoutManager(new LinearLayoutManager(
                    mContext, RecyclerView.VERTICAL, false));
            ((AllViewHolder) holder).recyclerView.addItemDecoration(new ItemDecoration(65));
        }
    }

    private void initItemList() {
        mApplyList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mApplyList.add(new MutableLiveData<>());
        }
        mMyList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mMyList.add(new MutableLiveData<>());
        }
        mMyApplyList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mMyApplyList.add(new MutableLiveData<>());
        }
        mAllList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            mAllList.add(new MutableLiveData<>());
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ApplyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        public ApplyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_route_apply_list);
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView parentRecyclerView;
        private RecyclerView childRecyclerView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            parentRecyclerView = itemView.findViewById(R.id.rcv_route_my);
            childRecyclerView = parentRecyclerView.findViewById(R.id.rcv_route_my_apply);
        }
    }

    class AllViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        public AllViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rcv_route_all);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_Apply;
        } else if (position == 1) {
            return TYPE_My;
        } else {
            return TYPE_All;
        }
    }
}
