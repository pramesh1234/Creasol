package com.osi.creasol.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.osi.creasol.R;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.data.CcDivision;
import com.osi.creasol.data.CcTeacherClass;
import com.osi.creasol.databinding.FragmentHomeworkBinding;
import com.osi.creasol.sharedpreference.EventSharedPreference;
import com.osi.creasol.sharedpreference.Session;
import com.osi.creasol.viewmodel.HomeworkViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeworkFragment extends Fragment {

    FragmentHomeworkBinding binding;
    HomeworkViewModel vm;
    ArrayList<Integer> classList;
    Spinner divisionSpinner;
    ArrayAdapter<Integer> classAdapter, divisionAdapter;
    Session session;
    JSONArray jsonArrayClasses;
    HomeworkFragment homeworkFragment;
    CcTeacherClass[] ccTeacherClasses;
    public static final String TAG = "HomeworkFragment.class";
    String branchId, schoolId, classId, divisionId;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new HomeworkViewModel(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_homework, container, false);
        binding.setVm(vm);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        classList = new ArrayList<>();
        session = new Session(getContext());
        homeworkFragment = new HomeworkFragment();
        String jsonResponse = session.getLoginDetailsInString();
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject jsonObjectData = jsonObject.getJSONObject("data");
            JSONObject jsonObjectTeacher = jsonObjectData.getJSONObject("teacher_details");
            jsonArrayClasses = jsonObjectTeacher.getJSONArray("cc_teacher_classes");
            ccTeacherClasses = new Gson().fromJson(jsonArrayClasses.toString(), CcTeacherClass[].class);
            Log.e(TAG, "onReponse: " + jsonArrayClasses.length());
            for (int i = 0; i < jsonArrayClasses.length(); i++) {
                int classid = ccTeacherClasses[i].getClassId();
                classList.add(classid);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "onResponse: " + e.toString());
        }

        classAdapter = new ArrayAdapter<Integer>(getContext(), android.R.layout.simple_spinner_item, classList);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Spinner classSpinner = (Spinner) binding.getRoot().findViewById(R.id.homework_class_spinner);
        divisionSpinner = (Spinner) binding.getRoot().findViewById(R.id.homework_division_spinner);
        classSpinner.setAdapter(classAdapter);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int selectedClassId = (Integer) adapterView.getItemAtPosition(i);
                classId = Integer.toString(selectedClassId);
                Log.e(TAG, "class id : " + selectedClassId);
                int id = ccTeacherClasses[i].getClassId();
                try {
                    JSONObject jsonArrayDivision = jsonArrayClasses.getJSONObject(i);
                    JSONObject jsonObject = jsonArrayDivision.getJSONObject("cc_class");
                    JSONArray jsonArray = jsonObject.getJSONArray("cc_divisions");
                    Log.e(TAG, "division Size " + jsonArray.length());
                    CcDivision[] ccDivision = new Gson().fromJson(jsonArray.toString(), CcDivision[].class);
                    ArrayList<Integer> divisionList = new ArrayList<>();
                    for (int k = 0; k < jsonArray.length(); k++) {
                        int divisionid = ccDivision[k].getId();
                        divisionList.add(divisionid);
                    }
                    divisionAdapter = new ArrayAdapter<Integer>(getContext(), android.R.layout.simple_spinner_item, divisionList);
                    divisionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    divisionSpinner.setAdapter(divisionAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ((BaseActivity) getActivity()).setToolbarVisibility(false);


        Button btn = (Button) binding.getRoot().findViewById(R.id.go_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schoolId = session.getLoginDetails().getTeacherDetails().getSchoolId().toString();
                branchId = session.getLoginDetails().getTeacherDetails().getBranchId().toString();
                divisionId = divisionSpinner.getSelectedItem().toString();

                EventSharedPreference eventSharedPreference = new EventSharedPreference(getContext());
                eventSharedPreference.saveClassId(classId);
                eventSharedPreference.saveDivisionId(divisionId);
                HomeworkListFragment fragment = new HomeworkListFragment();
                fragment.addFragment((BaseActivity) getActivity());

            }
        });
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity) {
        activity.replaceFragment(new HomeworkFragment(), true);
    }

}
