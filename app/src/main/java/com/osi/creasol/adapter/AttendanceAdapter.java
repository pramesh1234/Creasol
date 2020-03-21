package com.osi.creasol.adapter;

import com.osi.creasol.R;
import com.osi.creasol.base.recycler.RecyclerBaseAdapter;
import com.osi.creasol.viewmodel.RowAttendanceDetailViewModel;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerBaseAdapter {

    ArrayList<RowAttendanceDetailViewModel> attendanceViewModels;

    public AttendanceAdapter(ArrayList<RowAttendanceDetailViewModel> attendanceViewModels) {
        this.attendanceViewModels = attendanceViewModels;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return attendanceViewModels.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.row_attendance_detail;
    }

    @Override
    public int getItemCount() {
        return attendanceViewModels.size();
    }
    public void addAll(ArrayList<RowAttendanceDetailViewModel> viewModels) {
        this.attendanceViewModels.clear();
        this.attendanceViewModels.addAll(viewModels);
        notifyDataSetChanged();
    }
}
