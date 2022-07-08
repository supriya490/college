package com.example.swaroopapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.swaroopapp.R;

import java.util.ArrayList;
import java.util.List;


public class aboutfragment extends Fragment {

    private ViewPager viewPager;
    private brachadapter adapter;
    private List<branchmodel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aboutfragment, container, false);
        list = new ArrayList<>();
        list.add(new branchmodel(R.drawable.ic_computer, "Computer Science", "computer science is one of the highest placement giving branch of the college."));

        list.add(new branchmodel(R.drawable.ic_mechanical, "Mechanical Engineering", "Mechanical Engineering is one of the finest branch of our college."));
        adapter=new brachadapter(getContext(),list);
        viewPager=view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        ImageView imageView=view.findViewById(R.id.college_image);
        Glide.with(getContext())
        .load(R.drawable.srm).into(imageView);
        return view;



    }
}
