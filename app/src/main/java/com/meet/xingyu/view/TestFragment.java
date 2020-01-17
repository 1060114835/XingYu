package com.meet.xingyu.view;

import androidx.databinding.ViewDataBinding;

import com.meet.xingyu.common.mvvm.BaseFragment;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.FragmentTestBinding;
import com.meet.xingyu.viewmodel.FragmentTestViewModel;

public class TestFragment extends BaseFragment {
    private FragmentTestBinding binding;

    @Override
    protected BaseViewModel configureViewModel() {
        return FragmentTestViewModel.getInstence();
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        binding = FragmentTestBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    protected void bindingVariable() {
        binding.setVm(FragmentTestViewModel.getInstence());
    }
}
