package com.meet.xingyu.view.my;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BaseFragment;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.databinding.FragmentMyBinding;
import com.meet.xingyu.viewmodel.my.FragmentMyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends BaseFragment {

    FragmentMyBinding binding;

    private ViewPager pagerTwo;
    private TabLayout tabLayout;
    private ArrayList<String> titleList;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<Fragment> fragmentList;

    @Override
    protected BaseViewModel configureViewModel() {
        FragmentMyViewModel.getInstance().getContext(getContext());
        return FragmentMyViewModel.getInstance();
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        binding = FragmentMyBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    protected void bindingVariable() {
        binding.setFragmentMyVM(FragmentMyViewModel.getInstance());
    }

    @Override
    public void onStart() {
        super.onStart();

        tabLayout = (TabLayout)getActivity().findViewById(R.id.my_tabs);
        pagerTwo = (ViewPager)getActivity().findViewById(R.id.my_view_pagers);

        fragmentList = new ArrayList<>();

        fragmentList.add(new MyPagerMessageFragment());
        fragmentList.add(new MyPagerFriendFragment());

        titleList = new ArrayList<String>();
        titleList.add("      消息      ");
        titleList.add("      好友      ");

        myPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager(),fragmentList,titleList);
        pagerTwo.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(pagerTwo);
    }

    @Override
    protected void init() {

//        binding.myViewPagers.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
//            @NonNull
//            @Override
//            public Fragment getItem(int position) {
//                return fragmentList.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return 2;
//            }
//        });
//
//        binding.myViewPagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
    }

}
