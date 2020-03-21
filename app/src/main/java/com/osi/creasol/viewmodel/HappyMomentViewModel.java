package com.osi.creasol.viewmodel;

import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.osi.creasol.adapter.HappyMomentsAdapter;
import com.osi.creasol.api.ApiCallback;
import com.osi.creasol.api.HappyMomentApi;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.data.HappyMomentsImage;
import com.osi.creasol.fragment.CreateAlbumFragment;
import com.osi.creasol.fragment.HappyMomentFragment;
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

public class HappyMomentViewModel {
    private static final String TAG = "HappyMomentViewModel";
    HappyMomentFragment happyMomentFragment;
    ArrayList<RowHappyMomentViewModel> viewModels;
    public HappyMomentsAdapter happyMomentsAdapter;

    Session session;
    HashMap<String, String> header = new HashMap<>();
    String branchId, schoolId, type, token;

    public HappyMomentViewModel(HappyMomentFragment happyMomentFragment) {
        this.happyMomentFragment = happyMomentFragment;
        happyMomentsAdapter = new HappyMomentsAdapter(new ArrayList<RowHappyMomentViewModel>());
        getHappyMoments();
    }

    public void getHappyMoments() {
        session = new Session(happyMomentFragment.getContext());
        branchId = session.getLoginDetails().getTeacherDetails().getBranchId().toString();
        schoolId = session.getLoginDetails().getTeacherDetails().getSchoolId().toString();
        type = "image";
        token = session.getLoginDetails().getToken();
        header.put("header-token", token);
        HappyMomentApi happyMomentApi = new HappyMomentApi(schoolId, branchId, type, header);
        happyMomentApi.call(happyMomentFragment.getActivity(), new ApiCallback() {
            @Override
            public void onResponse(Object o) {
                JSONObject jsonObject = (JSONObject) o;
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    Log.e(TAG, "onResponse: " + jsonArray.length());
                    HappyMomentsImage[] happyMomentsImages = new Gson().fromJson(jsonArray.toString(), HappyMomentsImage[].class);
                    fillHappyMomentAlbum(happyMomentsImages);
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void fillHappyMomentAlbum(HappyMomentsImage[] happyMomentsImages) throws ParseException {
        viewModels = new ArrayList<>();
        Log.e(TAG, "fillHappyMomentAlbum: " + happyMomentsImages.length);
        for (int i = 0; i < happyMomentsImages.length; i++) {
            RowHappyMomentViewModel viewModel = new RowHappyMomentViewModel(happyMomentFragment, i);
            DateFormat outputMonthFormat = new SimpleDateFormat("MMM", Locale.US);
            DateFormat outputDateFormat = new SimpleDateFormat("dd", Locale.US);
            DateFormat outputYearFormat = new SimpleDateFormat("yyyy", Locale.US);
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            Date date = inputFormat.parse(happyMomentsImages[i].getDate());
            String monthString = outputMonthFormat.format(date);
            String dateString = outputDateFormat.format(date);
            String yearString = outputYearFormat.format(date);
            viewModel.albumDate.set(dateString);
            viewModel.albumMonth.set(monthString);
            viewModel.albumYear.set(yearString);
            viewModel.albumName.set(happyMomentsImages[i].getAlbumName());
            viewModels.add(viewModel);
        }
        happyMomentsAdapter.addAll(viewModels);
    }

    public void onCreateAlbum(View view) {
        CreateAlbumFragment.addFragment((BaseActivity) happyMomentFragment.getActivity());
    }
    // TODO: Implement the ViewModel
}
