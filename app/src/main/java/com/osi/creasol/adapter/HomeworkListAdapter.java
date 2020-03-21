package com.osi.creasol.adapter;

import com.osi.creasol.R;
import com.osi.creasol.base.recycler.RecyclerBaseAdapter;
import com.osi.creasol.viewmodel.RowEventViewModel;
import com.osi.creasol.viewmodel.RowHomeworkViewModel;

import java.util.ArrayList;

public class HomeworkListAdapter extends RecyclerBaseAdapter {
    ArrayList<RowHomeworkViewModel> homeworkArrayList;

    public HomeworkListAdapter(ArrayList<RowHomeworkViewModel> homeworkArrayList) {
        this.homeworkArrayList = homeworkArrayList;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return homeworkArrayList.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.row_homework;
    }

    @Override
    public int getItemCount() {
        return homeworkArrayList.size();
    }
    public void addAll(ArrayList<RowHomeworkViewModel> homeworkArrayList) {
        this.homeworkArrayList.addAll(homeworkArrayList);
        notifyDataSetChanged();
    }
}
