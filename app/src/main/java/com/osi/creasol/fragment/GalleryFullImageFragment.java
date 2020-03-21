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
import com.osi.creasol.databinding.FragmentGalleryFullImageBinding;
import com.osi.creasol.viewmodel.GalleryFullImageViewModel;

public class GalleryFullImageFragment extends Fragment {

    GalleryFullImageViewModel mViewModel;
    FragmentGalleryFullImageBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new GalleryFullImageViewModel(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery_full_image, container, false);
        binding.setVm(mViewModel);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        return binding.getRoot();
    }


}
