package com.osi.creasol.viewmodel;

import com.google.gson.Gson;
import com.osi.creasol.adapter.ListOfHolidayAdapter;
import com.osi.creasol.api.ApiCallback;
import com.osi.creasol.api.HolidayApi;
import com.osi.creasol.data.HolidayData;
import com.osi.creasol.fragment.ListOfHolidaysFragment;
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

public class ListOfHolidaysViewModel {
    ArrayList<RowHolidayViewmodel> viewModels;
    public ListOfHolidayAdapter listOfHolidayAdapter;

    Session session;
    HashMap<String, String> header = new HashMap<>();
    String branchId, schoolId, token;
    ListOfHolidaysFragment listOfHolidaysFragment;

    public ListOfHolidaysViewModel(ListOfHolidaysFragment listOfHolidaysFragment) {
        this.listOfHolidaysFragment = listOfHolidaysFragment;
        listOfHolidayAdapter = new ListOfHolidayAdapter(new ArrayList<RowHolidayViewmodel>());
        getHoliday();
    }

    public void getHoliday() {
        session = new Session(listOfHolidaysFragment.getContext());
        branchId = session.getLoginDetails().getTeacherDetails().getBranchId().toString();
        schoolId = session.getLoginDetails().getTeacherDetails().getSchoolId().toString();
        token = session.getLoginDetails().getToken();
        header.put("header-token", token);
        HolidayApi holidayApi = new HolidayApi(schoolId, branchId, header);
        holidayApi.call(listOfHolidaysFragment.getActivity(), new ApiCallback() {
            @Override
            public void onResponse(Object o) {
                JSONObject jsonObject = (JSONObject) o;
                try {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    HolidayData[] holidayData = new Gson().fromJson(jsonArray.toString(), HolidayData[].class);
                    fillHoliday(holidayData);
                } catch (JSONException | ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private void fillHoliday(HolidayData[] holidayData) throws ParseException {
        viewModels = new ArrayList<>();
        for (int i = 0; i < holidayData.length; i++) {
            RowHolidayViewmodel viewModel = new RowHolidayViewmodel();
            DateFormat outputMonthFormat = new SimpleDateFormat("MMM", Locale.US);
            DateFormat outputDateFormat = new SimpleDateFormat("dd", Locale.US);
            DateFormat outputYearFormat = new SimpleDateFormat("yyyy", Locale.US);
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            Date date = inputFormat.parse(holidayData[i].getDate());
            String monthString = outputMonthFormat.format(date);
            String dateString = outputDateFormat.format(date);
            String yearString = outputYearFormat.format(date);
            viewModel.holidayDate.set(dateString);
            viewModel.holidayMonth.set(monthString);
            viewModel.holidayYear.set(yearString);
            viewModel.holidayName.set(holidayData[i].getHolidayName());
            viewModels.add(viewModel);
        }
        listOfHolidayAdapter.addAll(viewModels);

    }
    // TODO: Implement the ViewModel
}
