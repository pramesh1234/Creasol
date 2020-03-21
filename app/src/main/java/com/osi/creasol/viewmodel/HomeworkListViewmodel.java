package com.osi.creasol.viewmodel;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.osi.creasol.adapter.HomeworkListAdapter;
import com.osi.creasol.api.ApiCallback;
import com.osi.creasol.api.HomeworkApi;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.data.HomeworkData;
import com.osi.creasol.fragment.AssignHomeworkFragment;
import com.osi.creasol.fragment.CreateAlbumFragment;
import com.osi.creasol.fragment.HomeworkListFragment;
import com.osi.creasol.sharedpreference.EventSharedPreference;
import com.osi.creasol.sharedpreference.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class HomeworkListViewmodel {
    HomeworkListFragment homeworkListFragment;
    ArrayList<RowHomeworkViewModel> viewModels;
    public HomeworkListAdapter homeworkListAdapter;

    Session session;
    HashMap<String, String> header = new HashMap<>();
    String branchId, schoolId, classId, divisionId, token;

    public HomeworkListViewmodel(HomeworkListFragment homeworkListFragment) {
        this.homeworkListFragment = homeworkListFragment;
        homeworkListAdapter = new HomeworkListAdapter(new ArrayList<RowHomeworkViewModel>());
        getHomework();
    }

    public void getHomework() {
        EventSharedPreference eventSharedPreference = new EventSharedPreference(homeworkListFragment.getContext());
        Session session = new Session(homeworkListFragment.getContext());
        token = session.getLoginDetails().getToken();
        schoolId = session.getLoginDetails().getTeacherDetails().getSchoolId().toString();
        branchId = session.getLoginDetails().getTeacherDetails().getBranchId().toString();
        classId = eventSharedPreference.getClassId();
        divisionId = eventSharedPreference.getDivisionId();
        header.put("header-token", token);
        homeworkListAdapter = new HomeworkListAdapter(new ArrayList<RowHomeworkViewModel>());
        HomeworkApi homeworkApi = new HomeworkApi(schoolId, branchId, classId, divisionId, header);
        homeworkApi.call(homeworkListFragment.getContext(), new ApiCallback() {
            @Override
            public void onResponse(Object o) {
                JSONObject jsonObject = (JSONObject) o;
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    HomeworkData[] homeworkData = new Gson().fromJson(jsonArray.toString(), HomeworkData[].class);
                    fillHomeworktData(homeworkData);
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void fillHomeworktData(HomeworkData[] homeworkData) throws ParseException {
        viewModels = new ArrayList<>();
        for (int i = 0; i < homeworkData.length; i++) {
            RowHomeworkViewModel viewmodel = new RowHomeworkViewModel(homeworkListFragment,homeworkData[i].getDescr(),i,homeworkData[i].getCcHomeworkImages());
            DateFormat dateOutput = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            Date date = inputFormat.parse(homeworkData[i].getDueDay());
            String dueDate = dateOutput.format(date);
            viewmodel.homeworkTitle.set(homeworkData[i].getTitle());
            viewmodel.subjectName.set(homeworkData[i].getSubject());
            viewmodel.dueDate.set(dueDate);
            String givenDateString = homeworkData[i].getDueDay();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date mDate = sdf.parse(givenDateString);
                long timeInMilliseconds = mDate.getTime();
                Log.e("homeelistviewmodel","Date in milli :: " + timeInMilliseconds);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            viewModels.add(viewmodel);
        }
        homeworkListAdapter.addAll(viewModels);

    }
    public void onAssignHomework(View view) {
        AssignHomeworkFragment.addFragment((BaseActivity) homeworkListFragment.getActivity());
    }
}