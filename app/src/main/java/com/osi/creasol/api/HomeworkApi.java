package com.osi.creasol.api;

import android.content.Context;

import com.osi.creasol.util.JSONKeys;
import com.osi.creasol.util.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class HomeworkApi {
    JSONObject param=new JSONObject();
    HashMap<String ,String> header=new HashMap<>();
    public HomeworkApi(String school_id,String branch_id,String class_id, String dvision_id,HashMap header) {
        try {
            param.put(JSONKeys.SCHOOL_ID, school_id);
            param.put(JSONKeys.BRANCH_ID, branch_id);
            param.put(JSONKeys.CLASS_ID,class_id);
            param.put(JSONKeys.DIVISION_ID,dvision_id);
            this.header=header;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void call(Context context, ApiCallback callback) {
        ApiHelper.getInstance(context).doPostRequest(URLs.GET_HOMEWORK, header, param, callback);
    }
}
