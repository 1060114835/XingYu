package com.meet.xingyu.presenter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.meet.xingyu.R;
import com.meet.xingyu.common.mvvm.BasePresenter;
import com.meet.xingyu.viewmodel.MainViewModel;


public class MainPresenter extends BasePresenter {
    private static MainPresenter instance;

    private MainPresenter() {}

    @Override
    public void onClick(View v) {
        Activity activity = (Activity) v.getContext();
        ImageView imageView1 = activity.findViewById(R.id.main_iv_recommend);
        ImageView imageView2 = activity.findViewById(R.id.main_iv_post);
        ImageView imageView3 = activity.findViewById(R.id.main_iv_route);
        ImageView imageView4 = activity.findViewById(R.id.main_iv_self);
        ViewPager vp = activity.findViewById(R.id.main_vp);
        switch (v.getId()) {
            case R.id.left_icon:
                activity.finish();
                break;
            case R.id.main_ly_recommend:
                imageView1.setImageResource(R.drawable.viewpager_icon_recommend_press);
                imageView2.setImageResource(R.drawable.viewpager_icon_post_unpress);
                imageView3.setImageResource(R.drawable.viewpager_icon_route_unpress);
                imageView4.setImageResource(R.drawable.viewpager_icon_self_unpress);
                MainViewModel.getInstance().getTitle().setValue("推荐");
                vp.setCurrentItem(0);
                break;
            case R.id.main_ly_post:
                imageView1.setImageResource(R.drawable.viewpager_icon_recommend_unpress);
                imageView2.setImageResource(R.drawable.viewpager_icon_post_press);
                imageView3.setImageResource(R.drawable.viewpager_icon_route_unpress);
                imageView4.setImageResource(R.drawable.viewpager_icon_self_unpress);
                MainViewModel.getInstance().getTitle().setValue("发布");
                vp.setCurrentItem(1);
                break;
            case R.id.main_ly_route:
                imageView1.setImageResource(R.drawable.viewpager_icon_recommend_unpress);
                imageView2.setImageResource(R.drawable.viewpager_icon_post_unpress);
                imageView3.setImageResource(R.drawable.viewpager_icon_route_press);
                imageView4.setImageResource(R.drawable.viewpager_icon_self_unpress);
                MainViewModel.getInstance().getTitle().setValue("行程");
                vp.setCurrentItem(2);
                break;
            case R.id.main_ly_self:
                imageView1.setImageResource(R.drawable.viewpager_icon_recommend_unpress);
                imageView2.setImageResource(R.drawable.viewpager_icon_post_unpress);
                imageView3.setImageResource(R.drawable.viewpager_icon_route_unpress);
                imageView4.setImageResource(R.drawable.viewpager_icon_self_press);
                MainViewModel.getInstance().getTitle().setValue("我的");
                vp.setCurrentItem(3);
                break;
        }

    }


    public static MainPresenter getInstance() {
        if (instance == null) {
            synchronized (MainPresenter.class) {
                if (instance == null)
                    instance = new MainPresenter();
            }
        }
        return instance;
    }
}
