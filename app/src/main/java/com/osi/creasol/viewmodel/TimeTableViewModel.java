package com.osi.creasol.viewmodel;

import androidx.lifecycle.ViewModel;

import com.osi.creasol.fragment.TimeTableFragment;

public class TimeTableViewModel extends ViewModel {
    TimeTableFragment timeTableFragment;

    public TimeTableViewModel(TimeTableFragment timeTableFragment) {
        this.timeTableFragment = timeTableFragment;
    }
    // TODO: Implement the ViewModel
}
