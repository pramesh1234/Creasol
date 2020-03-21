package com.osi.creasol.viewmodel;

import androidx.lifecycle.ViewModel;

import com.osi.creasol.data.AttendanceData;
import com.osi.creasol.fragment.AttendenceFragment;

import java.util.ArrayList;

public class AttendenceViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    AttendenceFragment attendenceFragment;
    ArrayList<AttendanceData> userArrayList;

    public AttendenceViewModel(AttendenceFragment attendenceFragment) {
        this.attendenceFragment = attendenceFragment;
    }

    public void populateList() {
        AttendanceData user = new AttendanceData();
        user.setMonth("Jan");
        user.setAbsent(4);
        user.setPresent(21);
        userArrayList = new ArrayList<>();
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
        userArrayList.add(user);
    }
}
