package com.osi.creasol.adapter;

import com.osi.creasol.R;
import com.osi.creasol.base.recycler.RecyclerBaseAdapter;
import com.osi.creasol.fragment.HappyMomentFragment;
import com.osi.creasol.viewmodel.RowHappyMomentViewModel;

import java.util.ArrayList;

public class HappyMomentsAdapter extends RecyclerBaseAdapter {
    ArrayList<RowHappyMomentViewModel> happyMomentArrayList;
    public HappyMomentsAdapter(ArrayList<RowHappyMomentViewModel> happyMomentArrayList) {
        this.happyMomentArrayList = happyMomentArrayList;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return happyMomentArrayList.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.row_happy_moment;
    }

    @Override
    public int getItemCount() {
        return happyMomentArrayList.size();
    }

    public void addAll(ArrayList<RowHappyMomentViewModel> happyMomentArrayList) {
        this.happyMomentArrayList.addAll(happyMomentArrayList);
        notifyDataSetChanged();
    }
}
