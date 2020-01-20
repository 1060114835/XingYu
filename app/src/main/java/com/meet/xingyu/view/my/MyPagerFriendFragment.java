package com.meet.xingyu.view.my;

import androidx.databinding.ViewDataBinding;

import com.meet.xingyu.common.mvvm.BaseFragment;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.FragmentMyFriendPagerBinding;
import com.meet.xingyu.viewmodel.my.FragmentMyFriendViewModel;

public class MyPagerFriendFragment extends BaseFragment {

    FragmentMyFriendPagerBinding myFriendPagerBinding;

    @Override
    protected BaseViewModel configureViewModel() {
        return FragmentMyFriendViewModel.getInstance();
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        myFriendPagerBinding = FragmentMyFriendPagerBinding.inflate(getLayoutInflater());
        return myFriendPagerBinding;
    }

    @Override
    protected void bindingVariable() {
        myFriendPagerBinding.setMyFriVM(FragmentMyFriendViewModel.getInstance());
    }
}
