package com.osi.creasol.sharedpreference;

import android.content.Context;

import com.osi.creasol.util.SharedPreferenceHelper;
public class EventSharedPreference {
    Context context;
    public EventSharedPreference(Context context) {
        this.context = context;
    }
    public void saveClassId(String classId){
        SharedPreferenceHelper.setSharedPreferenceString(context, SharedPreferenceHelper.CLASS_ID, classId);
    }
    public void saveDivisionId(String divisionId){
        SharedPreferenceHelper.setSharedPreferenceString(context, SharedPreferenceHelper.DIVISION_ID, divisionId);
    }
    public String getClassId(){
        String classId = SharedPreferenceHelper.getSharedPreferenceString(context, SharedPreferenceHelper.CLASS_ID, null);
        return classId;
    }
    public String getDivisionId(){
        String divisionId=SharedPreferenceHelper.getSharedPreferenceString(context,SharedPreferenceHelper.DIVISION_ID,null);
        return divisionId;
    }
}
