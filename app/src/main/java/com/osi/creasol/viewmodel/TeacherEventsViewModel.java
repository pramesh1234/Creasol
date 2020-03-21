package com.osi.creasol.viewmodel;

import android.view.View;

import com.osi.creasol.fragment.TeacherEventsFragment;
import com.osi.creasol.sharedpreference.Session;

import java.util.HashMap;

public class TeacherEventsViewModel {
    TeacherEventsFragment teacherEventsFragment;
    Session session;
    HashMap<String, String> header = new HashMap<>();
    String branch_id, school_id, class_id, division_id;

    public TeacherEventsViewModel(TeacherEventsFragment teacherEventsFragment) {
        this.teacherEventsFragment = teacherEventsFragment;
    }

    public void onGoClick(View view) {

    }
}
