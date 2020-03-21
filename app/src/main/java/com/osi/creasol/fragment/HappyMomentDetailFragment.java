package com.osi.creasol.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.databinding.FragmentHappyMomentDetailBinding;
import com.osi.creasol.viewmodel.HappyMomentDetailViewModel;

public class HappyMomentDetailFragment extends Fragment {

    HappyMomentDetailViewModel mViewModel;
    FragmentHappyMomentDetailBinding binding;
    public final String TAG = "HappyMomentDetailFragment";
    int position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new HappyMomentDetailViewModel(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Bundle args = getArguments();
        position = args.getInt("Position");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_happy_moment_detail, container, false);
        binding.setVm(mViewModel);
        ViewPager viewPager = binding.getRoot().findViewById(R.id.view_pager);
        TabLayout tabLayout = binding.getRoot().findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        Log.e(TAG, "position " + position);
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity, Fragment fragment) {
        activity.replaceFragment(fragment, true);
    }

}
