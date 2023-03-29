package com.example.crickbuzz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class fragment_four extends Fragment {
    String[] name={"Littonn das(wk)","Stirling","Shakib(c)","Tucker(wk)","Rony Taludkar","Ross adair",
    "Sahnto","Harry Tactor","shamin Hosain","Dockrail","Towhid hridoy","Delany","Mehdy Hasan Miraz",
    "Curtis campher","Nasum Ahmed","Mark Adair","Taskin Ahmed","craig Young","Mustafijur","Hume",
    "Hasan Mahmud","Benjamin White","Shoriful Islam","Matthew Humphreys","Rishad Hossain","Fionn Hand",
    "Jaker Ali","Thomas Mayes"};
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;



    public fragment_four() {

    }

    public static fragment_four newInstance(String param1, String param2) {
        fragment_four fragment = new fragment_four();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_four, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerAdapter=new RecyclerAdapter(this,name);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }
}