package com.meet.xingyu.view;

import androidx.databinding.ViewDataBinding;

import com.meet.xingyu.common.mvvm.BaseFragment;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.FragmentRouteBinding;

/**
 * @author Richard
 * @time 2020/1/20
 * @describe 行程页
 */
public class RouteFragment extends BaseFragment {

    private FragmentRouteBinding dataBinding;

    @Override
    protected BaseViewModel configureViewModel() {
        return null;
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        return dataBinding = FragmentRouteBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void bindingVariable() {

    }
}
