package com.osi.creasol.adapter;

import com.osi.creasol.R;
import com.osi.creasol.base.recycler.RecyclerBaseAdapter;
import com.osi.creasol.viewmodel.RowEventViewModel;

import java.util.ArrayList;

public class EventAdapter extends RecyclerBaseAdapter {
    ArrayList<RowEventViewModel> eventArraylist;

    public EventAdapter(ArrayList<RowEventViewModel> eventArraylist) {
        this.eventArraylist = eventArraylist;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return eventArraylist.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {

        return R.layout.row_events;
    }

    @Override
    public int getItemCount() {
        return eventArraylist.size();
    }

    public void addAll(ArrayList<RowEventViewModel> eventArraylist) {
        this.eventArraylist.addAll(eventArraylist);
        notifyDataSetChanged();
    }
}
