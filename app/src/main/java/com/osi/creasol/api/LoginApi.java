package com.osi.creasol.api;

import android.content.Context;

import com.osi.creasol.util.JSONKeys;
import com.osi.creasol.util.URLs;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginApi {
    JSONObject param = new JSONObject();

    public LoginApi(String email, String password) {
        try {
            param.put(JSONKeys.USER_NAME, email);
            param.put(JSONKeys.PASSWORD, password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void call(Context context, ApiCallback callback) {
        ApiHelper.getInstance(context).doPostRequest(URLs.LOGIN, null, param, callback);
    }
}
