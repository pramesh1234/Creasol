package com.osi.creasol.viewmodel;

import android.util.Log;

import com.osi.creasol.adapter.EventPagerAdapter;
import com.osi.creasol.fragment.EventFragment;
import com.osi.creasol.sharedpreference.Session;

import java.util.HashMap;

public class EventViewModel {
    EventFragment eventFragment;
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    String schoolId, branchId, classId, divisionId, token;
    public EventPagerAdapter mViewPagerAdapter;
    HashMap<String, String> header = new HashMap<>();

    public EventViewModel(EventFragment eventFragment) {
        this.eventFragment = eventFragment;
        Session session = new Session(eventFragment.getContext());
        token = session.getLoginDetails().getToken();
        header.put("header-token", token);
        Log.e("eventviewmodel", "chase " + classId + " school " + schoolId + " divisionId " + token);
        mViewPagerAdapter = new EventPagerAdapter(eventFragment.getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

}
