package com.osi.creasol.adapter;

import com.osi.creasol.R;
import com.osi.creasol.base.recycler.RecyclerBaseAdapter;
import com.osi.creasol.viewmodel.RowHappyMomentViewModel;
import com.osi.creasol.viewmodel.RowHolidayViewmodel;

import java.util.ArrayList;

public class ListOfHolidayAdapter extends RecyclerBaseAdapter {
    ArrayList<RowHolidayViewmodel> holidayViewmodelArrayList;

    public ListOfHolidayAdapter(ArrayList<RowHolidayViewmodel> holidayViewmodelArrayList) {
        this.holidayViewmodelArrayList = holidayViewmodelArrayList;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return holidayViewmodelArrayList.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.row_holiday;
    }

    @Override
    public int getItemCount() {
        return holidayViewmodelArrayList.size();
    }
    public void addAll(ArrayList<RowHolidayViewmodel> holidayViewmodelArrayList) {
        this.holidayViewmodelArrayList.addAll(holidayViewmodelArrayList);
        notifyDataSetChanged();
    }
}
