package com.example.logo_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class win_activity extends AppCompatActivity {
    TextView textView;
    Button btn;
    ViewPager viewPager;
    int index;
    String ans;
    Win_Adapter win_adapter;
    ArrayList<String> imgList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        viewPager=findViewById(R.id.win_viewpage);
        btn=findViewById(R.id.next);
        textView=findViewById(R.id.ans);
        index=getIntent().getIntExtra("image",0);
        ans=getIntent().getStringExtra("ans");
        textView.setText(ans);
        String[] images = new String[0];
        if(index==0)
        {
            try {
                images = getAssets().list("post_logo/level1");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(index==1)
        {
            try {
                images = getAssets().list("post_logo/level2");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        win_adapter=new Win_Adapter(this,imgList,index);
        viewPager.setAdapter(win_adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(win_activity.this,Quiz_Activity.class);
                startActivity(intent);
            }
        });
    }
}