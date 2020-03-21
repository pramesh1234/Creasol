package com.osi.creasol.viewmodel;

import com.osi.creasol.fragment.HomeworkDetailOneFragment;
import com.osi.creasol.util.BindableString;

public class HomeworkDetailOneViewModel {
    HomeworkDetailOneFragment homeworkDetailOneFragment;
    public BindableString homeworkTitle=new BindableString();
    public BindableString homeworkDescrption=new BindableString();
    public BindableString homeworkDueDate=new BindableString();
    public BindableString subjectName=new BindableString();

    public HomeworkDetailOneViewModel(HomeworkDetailOneFragment homeworkDetailOneFragment) {
        this.homeworkDetailOneFragment = homeworkDetailOneFragment;
    }
    // TODO: Implement the ViewModel
}
