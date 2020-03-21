package com.osi.creasol.viewmodel;

import android.util.Log;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.osi.creasol.adapter.TeacherAttendanceAdapter;
import com.osi.creasol.data.CcDivision;
import com.osi.creasol.data.CcTeacherClass;
import com.osi.creasol.fragment.TeachersAttendanceFragment;
import com.osi.creasol.sharedpreference.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeachersAttendanceViewModel {
    public TeacherAttendanceAdapter teacherAttendanceAdapter;
    TeachersAttendanceFragment teachersAttendanceFragment;
    Session session;
    CcTeacherClass[] ccTeacherClasses;
    CcDivision[] divisionClass;
    ArrayList<RowClassAttendanceViewmodel> attendanceViewmodelArrayList;
    public static final String TAG = "TeachersAttendanceViewModel";

    public TeachersAttendanceViewModel(TeachersAttendanceFragment teachersAttendanceFragment) {
        this.teachersAttendanceFragment = teachersAttendanceFragment;
        teacherAttendanceAdapter = new TeacherAttendanceAdapter(new ArrayList<RowClassAttendanceViewmodel>());
        addClassDiv(teachersAttendanceFragment);
    }

    public void addClassDiv(Fragment fragment) {
        session = new Session(teachersAttendanceFragment.getContext());

        String jsonResponse = session.getLoginDetailsInString();
        try {
            attendanceViewmodelArrayList = new ArrayList<>();

            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject jsonObjectData = jsonObject.getJSONObject("data");
            JSONObject jsonObjectTeacher = jsonObjectData.getJSONObject("teacher_details");
            JSONArray jsonArrayClasses = jsonObjectTeacher.getJSONArray("cc_teacher_classes");
            ccTeacherClasses = new Gson().fromJson(jsonArrayClasses.toString(), CcTeacherClass[].class);


            for (int i = 0; i < ccTeacherClasses.length; i++) {
                JSONObject jsonObjDivision = jsonArrayClasses.getJSONObject(i);
                JSONObject jsonObj = jsonObjDivision.getJSONObject("cc_class");


                JSONArray jsonArrayDivision = jsonObj.getJSONArray("cc_divisions");
                divisionClass = new Gson().fromJson(jsonArrayDivision.toString(), CcDivision[].class);

                for (int j = 0; j < divisionClass.length; j++) {

                    RowClassAttendanceViewmodel rowClassAttendanceViewmodel = new RowClassAttendanceViewmodel(fragment);
                    rowClassAttendanceViewmodel.divisionName.set(divisionClass[j].getName());
                    rowClassAttendanceViewmodel.className.set(jsonObj.getString("name"));


                    attendanceViewmodelArrayList.add(rowClassAttendanceViewmodel);


                }

            }


            teacherAttendanceAdapter.addAll(attendanceViewmodelArrayList);


        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "onResponse: " + e.toString());
        }
    }
    // TODO: Implement the ViewModel
}
