package com.osi.creasol.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.osi.creasol.tab.ActivitiesTabFragment;
import com.osi.creasol.tab.CelebrationTabFragment;
import com.osi.creasol.tab.PTATabFragment;

public class EventPagerAdapter extends FragmentStatePagerAdapter {
    String title;

    public EventPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new CelebrationTabFragment();
        } else if (position == 1) {
            fragment = new ActivitiesTabFragment();
        } else if (position == 2) {
            fragment = new PTATabFragment();
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            title = "Celebration";
        } else if (position == 1) {
            title = "Activities";
        } else if (position == 2) {
            title = "PTA";

        }
        return title;
    }
}
