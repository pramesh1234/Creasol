package com.osi.creasol.adapter;

import com.osi.creasol.R;
import com.osi.creasol.base.recycler.RecyclerBaseAdapter;
import com.osi.creasol.viewmodel.RowFeesViewModel;

import java.util.ArrayList;

public class FeesAdapter extends RecyclerBaseAdapter {
    ArrayList<RowFeesViewModel> viewModels;

    public FeesAdapter(ArrayList<RowFeesViewModel> viewModels) {
        this.viewModels = viewModels;
    }

    @Override
    protected Object getObjForPosition(int position) {
        return viewModels.get(position);
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return R.layout.row_fees;
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

    public void addAll(ArrayList<RowFeesViewModel> viewModels) {
        this.viewModels.clear();
        this.viewModels.addAll(viewModels);
        notifyDataSetChanged();
    }
}
