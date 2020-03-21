package com.osi.creasol.viewmodel;

import com.osi.creasol.adapter.HappyMomentPageAdapter;
import com.osi.creasol.fragment.HappyMomentDetailFragment;

public class HappyMomentDetailViewModel {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    HappyMomentDetailFragment happyMomentDetailFragment;
    public HappyMomentPageAdapter mViewPagerAdapter;

    public HappyMomentDetailViewModel(HappyMomentDetailFragment happyMomentDetailFragment) {
        this.happyMomentDetailFragment = happyMomentDetailFragment;
        mViewPagerAdapter = new HappyMomentPageAdapter(happyMomentDetailFragment.getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }
}
