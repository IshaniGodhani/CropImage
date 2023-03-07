package com.example.logo_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Quiz_Activity extends AppCompatActivity {
    ImageView pre_logo,back,next,cancel,remove;
    int pos;
    int[] logo_l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        pre_logo=findViewById(R.id.logo_img);
        back=findViewById(R.id.back_img);
        next=findViewById(R.id.next_img);


    }
}