package com.osi.creasol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.osi.creasol.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeworkPagerAdapter extends PagerAdapter {
    Context context;
    List<String> sliderImg;

    public HomeworkPagerAdapter(List sliderImg, Context context) {
        this.sliderImg = sliderImg;
        this.context = context;
    }
    @Override
    public int getCount() {
        return sliderImg.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.homework_image,null);
        ((ViewPager) container).addView(view);
        final ImageView img = (ImageView) view.findViewById(R.id.homewor_image);
        Picasso.get()
                .load(sliderImg.get(position))
                .into(img);
        return view;
    }
}
