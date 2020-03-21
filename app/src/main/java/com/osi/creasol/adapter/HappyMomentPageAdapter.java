package com.osi.creasol.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.osi.creasol.tab.ImageTabFragment;
import com.osi.creasol.tab.VideoTabFragment;

public class HappyMomentPageAdapter extends FragmentStatePagerAdapter {
    public HappyMomentPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    String title;

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new ImageTabFragment();
        }
        else if (position == 1) {
            fragment = new VideoTabFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
    if (position == 0)
    {
        title = "Images";
    }
        else if (position == 1)
    {
        title = "Videos";
    }
        return title;
    }
}
