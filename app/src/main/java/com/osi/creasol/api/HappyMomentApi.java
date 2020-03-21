package com.osi.creasol.api;

import android.content.Context;

import com.osi.creasol.util.JSONKeys;
import com.osi.creasol.util.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class HappyMomentApi {
    JSONObject param=new JSONObject();
    HashMap<String ,String> header=new HashMap<>();
    public HappyMomentApi(String school_id,String branch_id,String type,HashMap header) {
        try {
            param.put(JSONKeys.SCHOOL_ID, school_id);
            param.put(JSONKeys.BRANCH_ID, branch_id);
            param.put(JSONKeys.TYPE,type);
            this.header=header;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void call(Context context, ApiCallback callback) {
        ApiHelper.getInstance(context).doPostRequest(URLs.GET_HAPPY_MOMENTS, header, param, callback);
    }
}
