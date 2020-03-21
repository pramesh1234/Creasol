package com.osi.creasol.viewmodel;

import androidx.lifecycle.ViewModel;

import com.osi.creasol.adapter.AttendanceAdapter;
import com.osi.creasol.fragment.AttendanceDetailFragment;

import java.util.ArrayList;

public class AttendanceDetailViewModel extends ViewModel {
    AttendanceDetailFragment attendanceDetailFragment;
    public AttendanceAdapter attendanceAdapter;

    public AttendanceDetailViewModel(AttendanceDetailFragment attendanceDetailFragment) {
        this.attendanceDetailFragment = attendanceDetailFragment;
        attendanceAdapter = new AttendanceAdapter(new ArrayList<RowAttendanceDetailViewModel>());
        fillAttendanceList();
    }

    public void fillAttendanceList() {
        ArrayList<RowAttendanceDetailViewModel> viewModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RowAttendanceDetailViewModel viewModel = new RowAttendanceDetailViewModel();
            viewModel.month.set("Month " + i);
            viewModels.add(viewModel);
        }
        attendanceAdapter.addAll(viewModels);
    }

    // TODO: Implement the ViewModel
}
