package com.osi.creasol.tab;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.databinding.FragmentCelebrationTabBinding;
import com.osi.creasol.viewmodel.CelebrationTabViewmodel;

public class CelebrationTabFragment extends Fragment {

FragmentCelebrationTabBinding binding;
 CelebrationTabViewmodel celebrationTabViewmodel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        celebrationTabViewmodel=new CelebrationTabViewmodel(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_celebration_tab, container, false);
        binding.setVm(celebrationTabViewmodel);
        ((BaseActivity)getActivity()).setToolbarVisibility(false);
        return binding.getRoot();
    }
    public static void addFragment(BaseActivity activity) {
        activity.replaceFragment(new CelebrationTabFragment(), true);
    }
}
