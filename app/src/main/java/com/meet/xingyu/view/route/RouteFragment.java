package com.meet.xingyu.view.route;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BaseFragment;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.common.utils.LogUtil;
import com.meet.xingyu.databinding.FragmentRouteAllBinding;
import com.meet.xingyu.databinding.FragmentRouteApplyBinding;
import com.meet.xingyu.databinding.FragmentRouteBinding;
import com.meet.xingyu.databinding.FragmentRouteMyBinding;
import com.meet.xingyu.databinding.ItemRouteAllBinding;
import com.meet.xingyu.databinding.ItemRouteApplyBinding;
import com.meet.xingyu.databinding.ItemRouteMyApplyBinding;
import com.meet.xingyu.databinding.ItemRouteMyBinding;
import com.meet.xingyu.presenter.route.RouteAllPresenter;
import com.meet.xingyu.presenter.route.RouteApplyPresenter;
import com.meet.xingyu.presenter.route.RouteMyApplyPresenter;
import com.meet.xingyu.presenter.route.RouteMyPresenter;
import com.meet.xingyu.viewmodel.route.FragmentRouteViewModel;
import com.meet.xingyu.viewmodel.route.RouteAllViewModel;
import com.meet.xingyu.viewmodel.route.RouteApplyViewModel;
import com.meet.xingyu.viewmodel.route.RouteMyApplyViewModel;
import com.meet.xingyu.viewmodel.route.RouteMyViewModel;
import com.meet.xingyu.viewmodel.route.RouteViewModel;

public class RouteFragment extends BaseFragment {

    private FragmentRouteBinding routeBinding;
    private FragmentRouteApplyBinding applyBinding;
    private FragmentRouteMyBinding myBinding;
    private FragmentRouteAllBinding allBinding;
    private ItemRouteApplyBinding itemRouteApplyBinding;
    private ItemRouteMyBinding itemRouteMyBinding;
    private ItemRouteMyApplyBinding itemRouteMyApplyBinding;
    private ItemRouteAllBinding itemRouteAllBinding;

    private View view;
    private RecyclerView recyclerView;
    private CenterLayoutManager manager;
    private ImageView applyColor;
    private ImageView myColor;
    private ImageView allColor;
    private View apply;
    private View my;
    private View all;

    private static boolean mIsFirstSmooth;
    private static int temp;

    /**
     * 左滑为：手指向左滑滑动
     */
    private static boolean mIsSmoothLeft;

    public RouteFragment() {
    }

    @Override
    protected BaseViewModel configureViewModel() {
        return FragmentRouteViewModel.getInstance();
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        routeBinding = FragmentRouteBinding.inflate(getLayoutInflater());
        view = routeBinding.getRoot();
        applyBinding = FragmentRouteApplyBinding.inflate(getLayoutInflater());
        myBinding = FragmentRouteMyBinding.inflate(getLayoutInflater());
        allBinding = FragmentRouteAllBinding.inflate(getLayoutInflater());
        itemRouteApplyBinding = ItemRouteApplyBinding.inflate(getLayoutInflater());
        itemRouteMyBinding = ItemRouteMyBinding.inflate(getLayoutInflater());
        itemRouteAllBinding = ItemRouteAllBinding.inflate(getLayoutInflater());
        itemRouteMyApplyBinding = ItemRouteMyApplyBinding.inflate(getLayoutInflater());
        return routeBinding;
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    @Override
    protected void bindingVariable() {
        routeBinding.setRouteVM(RouteViewModel.getInstance());
        applyBinding.setRouteApplyVM(RouteApplyViewModel.getInstance());
        myBinding.setRouteMyVM(RouteMyViewModel.getInstance());
        allBinding.setRouteAllVM(RouteAllViewModel.getInstance());
//        itemRouteApplyBinding.setRouteApplyVM(RouteApplyViewModel.getInstance());
        itemRouteApplyBinding.setRouteApplyPresenter(RouteApplyPresenter.getInstance());
//        itemRouteMyBinding.setRouteMyVM(RouteMyViewModel.getInstance());
        itemRouteMyBinding.setRouteMyPresenter(RouteMyPresenter.getInstance());
//        itemRouteAllBinding.setRouteAllVM(RouteAllViewModel.getInstance());
        itemRouteAllBinding.setRouteAllPresenter(RouteAllPresenter.getInstance());
//        itemRouteMyApplyBinding.setRouteMyApplyVM(RouteMyApplyViewModel.getInstance());
        itemRouteMyApplyBinding.setRouteMyApplyPresenter(RouteMyApplyPresenter.getInstance());
    }

    @Override
    protected void init() {
        super.init();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LogUtil.d("RouteFragment","执行");
        recyclerView = view.findViewById(R.id.rcv_route);
        RouteAdapter adapter = new RouteAdapter(getContext());
        manager = new CenterLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(1);
        temp = recyclerView.getWidth() / 2;
        recyclerView.addItemDecoration(new RouteItemDecoration(20));
        setIndicator(view);
        initListener();
    }

    private void setIndicator(View view) {
        applyColor = view.findViewById(R.id.img_route_color_apply);
        myColor = view.findViewById(R.id.img_route_color_my);
        allColor = view.findViewById(R.id.img_route_color_all);
        myColor.setSelected(true);
    }

    private void initListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                apply = manager.findViewByPosition(0);
                my = manager.findViewByPosition(1);
                all = manager.findViewByPosition(2);

                //getChildAt(0)：第一个可见的Item
                //判断滑动距离
                //滑动完毕（状态）进行其他逻辑
                //滑动方向
                //左滑：逻辑
                //右滑：逻辑

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int smoothDistance = getSmoothDistance();
                    int width = recyclerView.getChildAt(0).getWidth();
                    int threshold = (int) (width / 2.2);
                    if (smoothDistance >= threshold) {
                        //滑到目的地
                        if (mIsSmoothLeft) {
                            //apply没有消失
                            //从apply开始，滑动到my
                            if (apply != null && my != null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                            } else if (apply == null && my != null) {
                                //apply消失
                                //从apply开始，滑动到看不见apply
                                if (smoothDistance >= width + threshold) {
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 2);
                                    setIndicatorColor(2);
                                } else if (smoothDistance >= width && smoothDistance < width +
                                        threshold){
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 1);
                                    setIndicatorColor(1);
                                } else if (smoothDistance >= threshold) {
                                    //从my开始，滑动到all
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 2);
                                    setIndicatorColor(2);
                                }
                            } else if (apply == null && my == null && all != null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 2);
                                setIndicatorColor(2);
                            }
                        } else {
                            //all到my
                            if (apply == null && my != null && all != null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                            } else if (my != null && all == null) {
                                //all消失
                                //从all开始，滑动到看不见all
                                if (smoothDistance >= width + threshold) {
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 0);
                                    setIndicatorColor(0);
                                } else if (smoothDistance >= width && smoothDistance < width +
                                        threshold) {
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 1);
                                    setIndicatorColor(1);
                                } else if (smoothDistance >= threshold) {
                                    //从my开始，滑动到apply
                                    manager.smoothScrollToPosition(recyclerView,
                                            new RecyclerView.State(), 0);
                                    setIndicatorColor(0);
                                }
                            } else if (apply != null && my == null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 0);
                                setIndicatorColor(0);
                            }
                        }
                    } else {
                        //回弹
                        if (mIsSmoothLeft) {
                            if (apply != null && my != null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 0);
                                setIndicatorColor(0);
                            } else if (my != null && all != null && apply == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                            } else if (all != null && my == null && apply == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 2);
                                setIndicatorColor(2);
                            }
                        } else {
                            if (all != null && my != null && apply == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 2);
                                setIndicatorColor(2);
                            } else if (my != null && apply != null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 1);
                                setIndicatorColor(1);
                            } else if (apply != null && my == null && all == null) {
                                manager.smoothScrollToPosition(recyclerView,
                                        new RecyclerView.State(), 0);
                                setIndicatorColor(0);
                            }
                        }
                    }
                }



            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dx > 0) {
                    mIsSmoothLeft = true;
                }else {
                    mIsSmoothLeft = false;
                }
            }

        });
    }

    private int getSmoothDistance() {
        int now = recyclerView.computeHorizontalScrollOffset();
        if (mIsFirstSmooth) {
            int ret = Math.abs(now - temp);
            temp = now;
            mIsFirstSmooth = false;
            return ret;
        } else {
            int ret = Math.abs(now - temp);
            temp = now;
            return ret;
        }
    }

    private void setIndicatorColor(int position) {
        if (position == 0) {
            applyColor.setSelected(true);
            myColor.setSelected(false);
            allColor.setSelected(false);
        } else if (position == 1) {
            applyColor.setSelected(false);
            myColor.setSelected(true);
            allColor.setSelected(false);
        } else if (position == 2) {
            applyColor.setSelected(false);
            myColor.setSelected(false);
            allColor.setSelected(true);
        }
    }
}
