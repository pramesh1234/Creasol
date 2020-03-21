package com.osi.creasol.api;

import android.content.Context;

import com.osi.creasol.util.JSONKeys;
import com.osi.creasol.util.URLs;

import org.json.JSONException;
import org.json.JSONObject;

public class ForgetPasswordApi {
    private JSONObject param = new JSONObject();

    public ForgetPasswordApi(String email) {
        try {
            param.put(JSONKeys.USER_NAME, email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void call(Context context, ApiCallback callback) {
        ApiHelper.getInstance(context).doPostRequest(URLs.LOGIN, null, param, callback);
    }
}
