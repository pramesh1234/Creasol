package com.osi.creasol.viewmodel;

import com.osi.creasol.fragment.EventDetailFragment;
import com.osi.creasol.util.BindableString;

public class EventDetailViewModel {
    EventDetailFragment eventDetailFragment;
    public BindableString eventName = new BindableString();
    public BindableString eventDescription = new BindableString();
    public BindableString eventStartTime = new BindableString();
    public BindableString eventEndTime = new BindableString();
    public BindableString eventLocation = new BindableString();
    public BindableString eventDate = new BindableString();
    public BindableString eventYear = new BindableString();
    public BindableString eventMonth = new BindableString();
    public BindableString eventDay = new BindableString();
    public BindableString eventHeader = new BindableString();


    public EventDetailViewModel(EventDetailFragment eventDetailFragment) {
        this.eventDetailFragment = eventDetailFragment;
    }
    // TODO: Implement the ViewModel
}
