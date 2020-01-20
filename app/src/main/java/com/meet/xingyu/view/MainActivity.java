package com.meet.xingyu.view;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BaseActivity;
import com.meet.xingyu.common.mvvm.BaseViewModel;
import com.meet.xingyu.common.utils.CustomActionBar;
import com.meet.xingyu.databinding.ActivityMianBinding;
import com.meet.xingyu.presenter.MainPresenter;
import com.meet.xingyu.view.my.MyFragment;
import com.meet.xingyu.viewmodel.FragmentTestViewModel;
import com.meet.xingyu.viewmodel.MainViewModel;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends BaseActivity {
    private ActivityMianBinding binding;

    @Override
    protected BaseViewModel configureViewModel() {
        return MainViewModel.getInstance();
    }

    @Override
    protected void bindingVariable() {
        binding.setVm(MainViewModel.getInstance());
        binding.setPresenter(MainPresenter.getInstance());
    }

    @Override
    protected ViewDataBinding configureDataBinding() {
        binding = ActivityMianBinding.inflate(getLayoutInflater());
        return binding;
    }

    @Override
    protected void init() {
        String[] titles = {"推荐","发布","行程","我的"};
        Fragment[] fragments = {new TestFragment(),new TestFragment(),new TestFragment(),new MyFragment()};
        int[] src = {R.drawable.viewpager_icon_recommend_press,
                R.drawable.viewpager_icon_post_press,
                R.drawable.viewpager_icon_route_press,
                R.drawable.viewpager_icon_self_press};
        ImageView[] imageViews = {binding.mainIvRecommend,binding.mainIvPost,binding.mainIvRoute,binding.mainIvSelf};
        CustomActionBar.set(this,MainPresenter.getInstance(),MainViewModel.getInstance().getTitle());
        imageViews[0].setImageResource(src[0]);
        FragmentTestViewModel.getInstence().getContent().setValue("推荐");
        binding.mainVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager(),
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        binding.mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MainViewModel.getInstance().getTitle().setValue(titles[position]);
                FragmentTestViewModel.getInstence().getContent().setValue(titles[position]);
                initAllImages();
                imageViews[position].setImageResource(src[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initAllImages() {
        binding.mainIvRecommend.setImageResource(R.drawable.viewpager_icon_recommend_unpress);
        binding.mainIvPost.setImageResource(R.drawable.viewpager_icon_post_unpress);
        binding.mainIvRoute.setImageResource(R.drawable.viewpager_icon_route_unpress);
        binding.mainIvSelf.setImageResource(R.drawable.viewpager_icon_self_unpress);
    }
}
