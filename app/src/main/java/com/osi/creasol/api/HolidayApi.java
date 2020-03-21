package com.osi.creasol.api;

import android.content.Context;

import com.osi.creasol.util.JSONKeys;
import com.osi.creasol.util.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class HolidayApi {
    JSONObject param=new JSONObject();
    HashMap<String ,String> header=new HashMap<>();
    public HolidayApi(String school_id,String branch_id,HashMap header) {
        try {
            param.put(JSONKeys.SCHOOL_ID, school_id);
            param.put(JSONKeys.BRANCH_ID, branch_id);
            this.header=header;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void call(Context context, ApiCallback callback) {
        ApiHelper.getInstance(context).doPostRequest(URLs.LIST_OF_HOLIDAY, header, param, callback);
    }
}
