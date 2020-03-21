package com.osi.creasol.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.databinding.FragmentReportCardBinding;
import com.osi.creasol.viewmodel.ReportCardViewModel;

public class ReportCardFragment extends Fragment {

    ReportCardViewModel mViewModel;
    FragmentReportCardBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ReportCardViewModel(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_report_card, container, false);
        binding.setVm(mViewModel);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity) {
        activity.replaceFragment(new ReportCardFragment(), true);
    }
}
