package com.osi.creasol.viewmodel;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.fragment.AttendanceRegisterFragment;
import com.osi.creasol.util.BindableString;

public class RowClassAttendanceViewmodel {
    public BindableString className = new BindableString();
    public BindableString divisionName = new BindableString();
    Fragment fragment;

    public RowClassAttendanceViewmodel(Fragment fragment) {
        this.fragment = fragment;
    }

    public void onClickAttendance(View view){
        AttendanceRegisterFragment attendanceRegisterFragment=new AttendanceRegisterFragment();
        attendanceRegisterFragment.addFragment((BaseActivity) fragment.getActivity(),attendanceRegisterFragment);
    }
}
