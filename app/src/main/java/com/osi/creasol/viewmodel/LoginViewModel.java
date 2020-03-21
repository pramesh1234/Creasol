package com.osi.creasol.viewmodel;

import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.osi.creasol.api.ApiCallback;
import com.osi.creasol.api.ForgetPasswordApi;
import com.osi.creasol.api.LoginApi;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.data.ForgetPassword;
import com.osi.creasol.data.User;
import com.osi.creasol.fragment.LoginFragment;
import com.osi.creasol.fragment.SelectChildFragment;
import com.osi.creasol.sharedpreference.Session;
import com.osi.creasol.util.AppUtil;
import com.osi.creasol.util.BindableBoolean;
import com.osi.creasol.util.BindableString;

import org.json.JSONObject;

public class LoginViewModel {
    LoginFragment fragment;
    public BindableString email = new BindableString();
    public BindableString password = new BindableString();
    public BindableBoolean isAppRunning = new BindableBoolean(false);
    Session session;

    public LoginViewModel(LoginFragment fragment) {
        this.fragment = fragment;
    }

    public void onLogin(View view) {
        if (!AppUtil.isValidEmail(email.get())) {
            Toast.makeText(fragment.getContext(), "The entered email is invalid", Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(fragment.getContext(), "The password is empty", Toast.LENGTH_SHORT).show();
        } else {
            LoginApi loginApi = new LoginApi(email.get(), password.get());
            isAppRunning.set(true);
            loginApi.call(fragment.getContext(), new ApiCallback() {
                @Override
                public void onResponse(Object o) {
                    if (o == null) {
                        return;
                    }
                    JSONObject jsonObject = (JSONObject) o;
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    User user = gson.fromJson(jsonObject.toString(), User.class);
                    if (user.getMsg().equals("Login Successfully")) {
                        isAppRunning.set(false);
                        session = new Session(fragment.getActivity());
                        session.save(jsonObject.toString());


                        SelectChildFragment.addFragment((BaseActivity) fragment.getActivity());
                    } else {
                        AppUtil.showToast(fragment.getActivity(), user.getMsg());
                        isAppRunning.set(false);
                    }
                }

                @Override
                public void onError(String error) {
                    AppUtil.showToast(fragment.getActivity(), error);
                    isAppRunning.set(false);
                }
            });
        }
    }

    public void onForgetPassword(View view) {
        ForgetPasswordApi api = new ForgetPasswordApi(email.get());
        api.call(fragment.getContext(), new ApiCallback() {
            @Override
            public void onResponse(Object o) {
                JSONObject jsonObject = (JSONObject) o;
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();

                AppUtil.showToast(fragment.getActivity(), ((JSONObject) o).toString());
                ForgetPassword forgetPassword = gson.fromJson(jsonObject.toString(), ForgetPassword.class);
                if (forgetPassword.getMsg() != null) {
                    AppUtil.showToast(fragment.getActivity(), forgetPassword.getMsg());
                }

            }

            @Override
            public void onError(String error) {

            }
        });
    }
}
