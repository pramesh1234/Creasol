package com.osi.creasol.viewmodel;

import android.view.View;

import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.fragment.AttendenceFragment;
import com.osi.creasol.fragment.CctvFragment;
import com.osi.creasol.fragment.FeesFragment;
import com.osi.creasol.fragment.HappyMomentFragment;
import com.osi.creasol.fragment.HomeFragment;
import com.osi.creasol.fragment.HomeworkFragment;
import com.osi.creasol.fragment.ListOfHolidaysFragment;
import com.osi.creasol.fragment.ReportCardFragment;
import com.osi.creasol.fragment.TeacherEventsFragment;
import com.osi.creasol.fragment.TeachersAttendanceFragment;
import com.osi.creasol.fragment.TimeTableFragment;

public class HomeViewModel {
    HomeFragment fragment;

    public HomeViewModel(HomeFragment fragment) {
        this.fragment = fragment;
    }

    public void onCCTV(View view) {
        CctvFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onAttendance(View view) {
        TeachersAttendanceFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onTimeTable(View view) {
        TimeTableFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onHappyMoments(View view) {
        HappyMomentFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onFeesInfo(View view) {
        FeesFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onReportCard(View view) {
        ReportCardFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onHomework(View view) {
        HomeworkFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onListOfHolidays(View view) {
        ListOfHolidaysFragment.addFragment((BaseActivity) fragment.getActivity());
    }

    public void onEvents(View view) {
        TeacherEventsFragment.addFragment((BaseActivity) fragment.getActivity());
    }
}
