package com.osi.creasol.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.fragment.EventDetailFragment;
import com.osi.creasol.util.BindableString;

public class RowEventViewModel {
    int type;
    Fragment fragment;
    int position;
    String day;
    public BindableString eventName = new BindableString();
    public BindableString eventDescription = new BindableString();
    public BindableString eventStartTime = new BindableString();
    public BindableString eventEndTime = new BindableString();
    public BindableString eventLocation = new BindableString();
    public BindableString eventDate = new BindableString();
    public BindableString eventYear = new BindableString();
    public BindableString eventMonth = new BindableString();

    public RowEventViewModel(Fragment fragment, int position, String day, int type) {
        this.fragment = fragment;
        this.position = position;
        this.day = day;
        this.type = type;
    }

    public void onEventRowClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);
        bundle.putString("eventName", eventName.get());
        bundle.putString("eventDescription", eventDescription.get());
        bundle.putString("eventStartTime", eventStartTime.get());
        bundle.putString("eventEndTime", eventEndTime.get());
        bundle.putString("eventLocation", eventLocation.get());
        bundle.putString("eventDate", eventDate.get());
        bundle.putString("eventMonth", eventMonth.get());
        bundle.putString("eventYear", eventYear.get());
        bundle.putString("day", day);
        bundle.putInt("type", type);

        EventDetailFragment fragmentEvent = new EventDetailFragment();
        fragmentEvent.setArguments(bundle);

        fragmentEvent.addFragment((BaseActivity) fragment.getActivity(), fragmentEvent);

    }
}

