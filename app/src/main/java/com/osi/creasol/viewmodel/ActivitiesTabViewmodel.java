package com.osi.creasol.viewmodel;

import android.util.Log;

import com.google.gson.Gson;
import com.osi.creasol.adapter.EventAdapter;
import com.osi.creasol.api.ApiCallback;
import com.osi.creasol.api.EventApi;
import com.osi.creasol.data.EventData;
import com.osi.creasol.sharedpreference.EventSharedPreference;
import com.osi.creasol.sharedpreference.Session;
import com.osi.creasol.tab.ActivitiesTabFragment;

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

public class ActivitiesTabViewmodel {
    ActivitiesTabFragment activitiesTabFragment;
    String schoolId, branchId, classId, divisionId, token;
    HashMap<String, String> header = new HashMap<>();
    public EventAdapter eventActivitiesAdapter;
    ArrayList<RowEventViewModel> viewModels;

    public ActivitiesTabViewmodel(ActivitiesTabFragment activitiesTabFragment) {
        this.activitiesTabFragment = activitiesTabFragment;
        getEventData();
    }

    private void getEventData() {
        EventSharedPreference eventSharedPreference = new EventSharedPreference(activitiesTabFragment.getContext());
        Session session = new Session(activitiesTabFragment.getContext());
        token = session.getLoginDetails().getToken();
        schoolId = session.getLoginDetails().getTeacherDetails().getSchoolId().toString();
        branchId = session.getLoginDetails().getTeacherDetails().getBranchId().toString();
        classId = eventSharedPreference.getClassId();
        divisionId = eventSharedPreference.getDivisionId();
        header.put("header-token", token);
        eventActivitiesAdapter = new EventAdapter(new ArrayList<RowEventViewModel>());
        EventApi eventApi = new EventApi(schoolId, branchId, classId, divisionId, header);
        eventApi.call(activitiesTabFragment.getContext(), new ApiCallback() {
            @Override
            public void onResponse(Object o) throws JSONException {
                JSONObject jsonObject = (JSONObject) o;
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    Log.e("CelebrationTabViewmodel", "onResponse: " + jsonArray.length());
                    EventData[] eventData = new Gson().fromJson(jsonArray.toString(), EventData[].class);
                    fillEventData(eventData);
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void fillEventData(EventData[] eventData) throws ParseException {
        viewModels = new ArrayList<>();
        Log.e("clecl ", "lenght " + eventData.length);
        for (int i = 0; i < eventData.length; i++) {
            if (eventData[i].getType() == 2) {
                DateFormat outputDayFormat = new SimpleDateFormat("yyyy", Locale.US);
                DateFormat inputDayFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                Date dayDate = inputDayFormat.parse(eventData[i].getCreatedAt());
                String day = outputDayFormat.format(dayDate);
                RowEventViewModel viewModel = new RowEventViewModel(activitiesTabFragment, i, day, eventData[i].getType());
                DateFormat outputMonthFormat = new SimpleDateFormat("MMM", Locale.US);
                DateFormat outputDateFormat = new SimpleDateFormat("dd", Locale.US);
                DateFormat outputYearFormat = new SimpleDateFormat("yyyy", Locale.US);
                DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                SimpleDateFormat hhmmFormat = new SimpleDateFormat("hh:mm", Locale.US);
                SimpleDateFormat hhmmampmFormat = new SimpleDateFormat("hh:mm a", Locale.US);
                Date startTimeDate = hhmmFormat.parse(eventData[i].getStartTime());
                Date endTimeDate = hhmmFormat.parse(eventData[i].getEndTime());
                String startTime = hhmmampmFormat.format(startTimeDate);
                String endTime = hhmmampmFormat.format(endTimeDate);
                Date date = inputFormat.parse(eventData[i].getCreatedAt());
                String monthString = outputMonthFormat.format(date);
                String dateString = outputDateFormat.format(date);
                String yearString = outputYearFormat.format(date);
                viewModel.eventDate.set(dateString);
                viewModel.eventMonth.set(monthString);
                viewModel.eventYear.set(yearString);
                viewModel.eventName.set(eventData[i].getName());
                viewModel.eventDescription.set(eventData[i].getDescr());
                viewModel.eventStartTime.set(startTime);
                viewModel.eventEndTime.set(" - " + endTime);
                viewModel.eventLocation.set(eventData[i].getLocation());
                viewModels.add(viewModel);
            }
        }
        eventActivitiesAdapter.addAll(viewModels);
    }
}
