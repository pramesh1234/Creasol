package com.osi.creasol.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.databinding.FragmentEventDetailBinding;
import com.osi.creasol.util.AppUtil;
import com.osi.creasol.viewmodel.EventDetailViewModel;

public class EventDetailFragment extends Fragment {

    EventDetailViewModel mViewModel;
    FragmentEventDetailBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new EventDetailViewModel(this);
        int postion = getArguments().getInt("position");
        String eventName = getArguments().getString("eventName");
        String eventDescription = getArguments().getString("eventDescription");
        String eventStartTime = getArguments().getString("eventStartTime");
        String eventEndTime = getArguments().getString("eventEndTime");
        String eventLocation = getArguments().getString("eventLocation");
        String eventDate = getArguments().getString("eventDate");
        String eventMonth = getArguments().getString("eventMonth");
        String eventYear = getArguments().getString("eventYear");
        String eventDay = getArguments().getString("day");
        int type = getArguments().getInt("type");
        if (type == 1) {
            mViewModel.eventHeader.set("Celebration");
        } else if (type == 2) {
            mViewModel.eventHeader.set("Activites");
        } else if (type == 3) {
            mViewModel.eventHeader.set("PTA");
        }
        mViewModel = new EventDetailViewModel(this);
        if (type == 1) {
            mViewModel.eventHeader.set("Celebration");
        } else if (type == 2) {
            mViewModel.eventHeader.set("Activites");
        } else if (type == 3) {
            mViewModel.eventHeader.set("PTA");
        }
        mViewModel.eventName.set(eventName);
        mViewModel.eventDescription.set(eventDescription);
        mViewModel.eventStartTime.set(eventStartTime);
        mViewModel.eventEndTime.set(eventEndTime);
        mViewModel.eventLocation.set(eventLocation);
        mViewModel.eventDate.set(eventDate);
        mViewModel.eventMonth.set(eventMonth);
        mViewModel.eventYear.set(eventYear);
        mViewModel.eventDay.set(eventDay + ",");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_detail, container, false);
        binding.setVm(mViewModel);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity, Fragment fragment) {
        activity.replaceFragment(fragment, true);
    }
}
