package com.osi.creasol.sharedpreference;

import android.content.Context;

import com.google.gson.Gson;
import com.osi.creasol.data.Data;
import com.osi.creasol.data.User;
import com.osi.creasol.util.SharedPreferenceHelper;

public class Session {
    Context context;

    public Session(Context context) {
        this.context = context;
    }

    public Data getLoginDetails() {
        String loginDetails = SharedPreferenceHelper.getSharedPreferenceString(context, SharedPreferenceHelper.KEY_LOGIN_DETAILS, null);
        User user = new Gson().fromJson(loginDetails, User.class);
        Data data = user.getData();
        return data;
    }

    public void save(String loginDetails) {
        SharedPreferenceHelper.setSharedPreferenceString(context, SharedPreferenceHelper.KEY_LOGIN_DETAILS, loginDetails);
    }

    public String getLoginDetailsInString() {
        String loginDetails = SharedPreferenceHelper.getSharedPreferenceString(context, SharedPreferenceHelper.KEY_LOGIN_DETAILS, null);
        return loginDetails;
    }
}
