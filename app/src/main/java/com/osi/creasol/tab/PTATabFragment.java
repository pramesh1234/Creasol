package com.osi.creasol.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.databinding.FragmentPtaTabBinding;
import com.osi.creasol.viewmodel.PtaTabViewmodel;


public class PTATabFragment extends Fragment {
    FragmentPtaTabBinding binding;
    PtaTabViewmodel ptaTabViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ptaTabViewmodel = new PtaTabViewmodel(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pta_tab, container, false);
        binding.setVm(ptaTabViewmodel);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity) {
        activity.replaceFragment(new PTATabFragment(), true);
    }
}
