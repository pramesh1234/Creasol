package com.osi.creasol.viewmodel;

import android.view.View;

import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.fragment.HomeFragment;
import com.osi.creasol.fragment.SelectChildFragment;

public class SelectChildViewModel {
    SelectChildFragment fragment;

    public SelectChildViewModel(SelectChildFragment fragment) {
        this.fragment = fragment;
    }

    public void onSelectChild(View view) {
        HomeFragment.addFragment((BaseActivity) fragment.getActivity());
    }
}
