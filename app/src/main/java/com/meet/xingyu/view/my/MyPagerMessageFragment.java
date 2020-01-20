package com.meet.xingyu.view.my;


import androidx.databinding.ViewDataBinding;

import com.daimajia.swipe.SwipeLayout;
import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BaseFragment;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.FragmentMyMessagePagerBinding;
import com.meet.xingyu.presenter.my.MyMessagePresenter;
import com.meet.xingyu.viewmodel.my.FragmentMyMessageViewModel;

public class MyPagerMessageFragment extends BaseFragment {

    FragmentMyMessagePagerBinding myMessagePagerBinding;

    @Override
    protected BaseViewModel configureViewModel() {
        return FragmentMyMessageViewModel.getInstance();
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        myMessagePagerBinding = FragmentMyMessagePagerBinding.inflate(getLayoutInflater());
        return myMessagePagerBinding;
    }

    @Override
    protected void bindingVariable() {
        myMessagePagerBinding.setMyMesVM(FragmentMyMessageViewModel.getInstance());

        //将Binding实例传递给Presenter
        MyMessagePresenter.getInstance().setFragmentMyMessagePagerBinding(myMessagePagerBinding);
    }


}
