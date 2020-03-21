package com.osi.creasol.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.osi.creasol.R;
import com.osi.creasol.adapter.HomeworkPagerAdapter;
import com.osi.creasol.base.activity.BaseActivity;
import com.osi.creasol.data.CcHomeworkImage;
import com.osi.creasol.databinding.FragmentHomeworkDetailOneBinding;
import com.osi.creasol.viewmodel.HomeworkDetailOneViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeworkDetailOneFragment extends Fragment {

    HomeworkDetailOneViewModel mViewModel;
    FragmentHomeworkDetailOneBinding binding;
    String homeworkTitle,homeworkDescr,dueDate,subjectName;
    int position;
    ArrayList<CcHomeworkImage> homeworkImages;
    List<String> imagesUrl;
    ViewPager viewPager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new HomeworkDetailOneViewModel(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homework_detail_one, container, false);
        binding.setVm(mViewModel);
        ((BaseActivity) getActivity()).setToolbarVisibility(false);
        imagesUrl=new ArrayList<>();
        homeworkImages=new ArrayList<>();
        fillHomeworkDetail();
        HomeworkPagerAdapter homeworkPagerAdapter=new HomeworkPagerAdapter(imagesUrl,getContext());
         viewPager=(ViewPager) binding.getRoot().findViewById(R.id.homework_view_pager);
        viewPager.setAdapter(homeworkPagerAdapter);
        ImageView leftImage=(ImageView) binding.getRoot().findViewById(R.id.left_btn);
        ImageView rightImage=(ImageView) binding.getRoot().findViewById(R.id.right_btn);
        rightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(1), true);
            }
        });
        leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(getItem(-1), true);
            }
        });
        return binding.getRoot();
    }

    public static void addFragment(BaseActivity activity, Fragment fragment) {
        activity.replaceFragment(fragment, true);
    }
    public void fillHomeworkDetail()
    {
        position=getArguments().getInt("position");
        homeworkTitle=getArguments().getString("homeworkTitle");
        subjectName=getArguments().getString("subjectName");
        dueDate=getArguments().getString("dueDate");
        homeworkDescr=getArguments().getString("homeworkDescription");
        homeworkImages=(ArrayList<CcHomeworkImage>) getArguments().getSerializable("homeworkImages");
        Log.e("checkhomework ","homework"+homeworkImages.size());
        mViewModel.homeworkDescrption.set(homeworkDescr);
        mViewModel.homeworkTitle.set(homeworkTitle);
        mViewModel.homeworkDueDate.set(dueDate);
        mViewModel.subjectName.set(subjectName);
        for(int i=0;i<homeworkImages.size();i++){
            imagesUrl.add(homeworkImages.get(i).getImgPath());
        }


    }
    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


}
