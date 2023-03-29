package com.example.crickbuzz;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class fragment_one extends Fragment {

    ImageView imageView;
    Pager_Adapter adapter;
    ViewPager pager;

    public fragment_one(ViewPager pager) {
        this.pager=pager;
    }

//    public fragment_one newInstance(String param1, String param2) {
//        fragment_one fragment = new fragment_one(ViewPager pager);
//
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_one, container, false);
        imageView=view.findViewById(R.id.arrow);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             pager.setCurrentItem(4);
            }

        });

        return view;

    }


}