package com.osi.creasol.tab;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.databinding.FragmentActivitiesTabBinding;
import com.osi.creasol.fragment.AttendenceFragment;
import com.osi.creasol.viewmodel.ActivitiesTabViewmodel;

public class ActivitiesTabFragment extends Fragment {
FragmentActivitiesTabBinding binding;
ActivitiesTabViewmodel activitiesTabViewmodel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitiesTabViewmodel=new ActivitiesTabViewmodel(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_activities_tab, container, false);
        binding.setVm(activitiesTabViewmodel);
        ((BaseActivity)getActivity()).setToolbarVisibility(false);
        return binding.getRoot();
    }
    public static void addFragment(BaseActivity activity) {
        activity.replaceFragment(new ActivitiesTabFragment(), true);
    }
}
