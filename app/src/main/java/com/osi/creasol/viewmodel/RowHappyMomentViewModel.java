package com.osi.creasol.viewmodel;

import android.os.Bundle;
import android.view.View;

import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.fragment.HappyMomentDetailFragment;
import com.osi.creasol.fragment.HappyMomentFragment;
import com.osi.creasol.util.BindableString;

import java.util.ArrayList;

public class RowHappyMomentViewModel {
    public BindableString albumName = new BindableString();
    public BindableString albumDate = new BindableString();
    public BindableString albumYear = new BindableString();
    public BindableString albumMonth = new BindableString();
    int position;
    HappyMomentFragment happyMomentFragment;
    ArrayList<RowHappyMomentViewModel> arrayList;
    public static String TAG = "RowHappyMomentViewModel";

    public RowHappyMomentViewModel(HappyMomentFragment happyMomentFragment, int position) {
        this.happyMomentFragment = happyMomentFragment;
        this.position = position;
    }

    public void onRowClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);
        HappyMomentDetailFragment fragment = new HappyMomentDetailFragment();
        fragment.setArguments(bundle);

        fragment.addFragment((BaseActivity) happyMomentFragment.getActivity(), fragment);
    }

}
