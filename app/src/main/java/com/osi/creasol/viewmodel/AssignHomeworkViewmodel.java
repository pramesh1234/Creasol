package com.osi.creasol.viewmodel;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;

import com.osi.creasol.R;
import com.osi.creasol.fragment.AssignHomeworkFragment;
import com.osi.creasol.fragment.CreateAlbumFragment;
import com.osi.creasol.util.BindableString;

import java.util.Calendar;

public class AssignHomeworkViewmodel {
    AssignHomeworkFragment assignHomeworkFragment;
    private static final int RESULT_LOAD_IMAGE = 1;
    public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public BindableString startDate = new BindableString();
    public BindableString endDate = new BindableString();
    public AssignHomeworkViewmodel(AssignHomeworkFragment assignHomeworkFragment) {
        this.assignHomeworkFragment = assignHomeworkFragment;
    }


    public void onSelectionClick(View view) {
        Intent mediaChooser = new Intent(Intent.ACTION_GET_CONTENT);
        mediaChooser.setType("image/*");
        assignHomeworkFragment.getActivity().startActivityForResult(mediaChooser, RESULT_LOAD_IMAGE);
    }

    public void onStartDateClick(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(assignHomeworkFragment.getContext(), R.style.DialogTheme,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        startDate.set("" + MONTHS[monthOfYear] + " " + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    public void onEndtDateClick(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(assignHomeworkFragment.getContext(), R.style.DialogTheme,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        endDate.set("" + MONTHS[monthOfYear] + " " + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    // TODO: Implement the ViewModel
}
