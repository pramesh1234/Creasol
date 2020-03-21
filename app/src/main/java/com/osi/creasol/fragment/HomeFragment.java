package com.osi.creasol.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.base.fragment.BaseFragment;
import com.osi.creasol.databinding.FragmentHomeBinding;
import com.osi.creasol.viewmodel.HomeViewModel;

public class HomeFragment extends BaseFragment {
    FragmentHomeBinding binding;
    HomeViewModel vm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new HomeViewModel(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false);
        binding.setVm(vm);
        ((BaseActivity) getActivity()).setToolbarVisibility(true);
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity) {
        activity.replaceFragment(new HomeFragment(), false);
    }
}
