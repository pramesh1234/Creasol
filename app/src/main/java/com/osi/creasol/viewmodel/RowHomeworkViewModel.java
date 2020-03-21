package com.osi.creasol.viewmodel;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;

import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.data.CcHomeworkImage;
import com.osi.creasol.fragment.HomeworkDetailOneFragment;
import com.osi.creasol.fragment.HomeworkListFragment;
import com.osi.creasol.util.BindableString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RowHomeworkViewModel {
    public BindableString homeworkTitle = new BindableString();
    public BindableString subjectName = new BindableString();
    public BindableString dueDate = new BindableString();
    public BindableString dueTime = new BindableString();
    int position;
    List<CcHomeworkImage> ccHomeworkImages;
    String homeworkDescription;
    private HomeworkListFragment fragment;


    public  RowHomeworkViewModel(HomeworkListFragment fragment, String homeworkDescription, int position, List<CcHomeworkImage> ccHomeworkImages) {
        this.fragment = fragment;
        this.homeworkDescription = homeworkDescription;
        this.position = position;
        this.ccHomeworkImages=ccHomeworkImages;
    }

    public void onHomeworkRowClicked(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("homeworkTitle", homeworkTitle.get());
        bundle.putString("subjectName", subjectName.get());
        bundle.putString("dueDate", dueDate.get());
        bundle.putString("homeworkDescription", homeworkDescription);
        bundle.putInt("position", position);
        bundle.putSerializable("homeworkImages",(Serializable)ccHomeworkImages);
        HomeworkDetailOneFragment homeworkDetailOneFragment = new HomeworkDetailOneFragment();
        homeworkDetailOneFragment.setArguments(bundle);
        homeworkDetailOneFragment.addFragment((BaseActivity) fragment.getActivity(), homeworkDetailOneFragment);
    }
}

