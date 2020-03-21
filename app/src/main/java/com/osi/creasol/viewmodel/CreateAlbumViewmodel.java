package com.osi.creasol.viewmodel;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;

import com.osi.creasol.R;
import com.osi.creasol.fragment.CreateAlbumFragment;
import com.osi.creasol.util.BindableString;

import java.util.Calendar;

public class CreateAlbumViewmodel {
    private static final int RESULT_LOAD_IMAGE = 1;
    CreateAlbumFragment createAlbumFragment;
    public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public BindableString date = new BindableString();

    public CreateAlbumViewmodel(CreateAlbumFragment createAlbumFragment) {
        this.createAlbumFragment = createAlbumFragment;
    }

    public void onSelectionClick(View view) {
        Intent mediaChooser = new Intent(Intent.ACTION_GET_CONTENT);
        mediaChooser.setType("video/*, image/*");
        createAlbumFragment.getActivity().startActivityForResult(mediaChooser, RESULT_LOAD_IMAGE);
    }

    public void onCalenderClick(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(createAlbumFragment.getContext(), R.style.DialogTheme,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        date.set("" + MONTHS[monthOfYear] + " " + dayOfMonth + "," + year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
