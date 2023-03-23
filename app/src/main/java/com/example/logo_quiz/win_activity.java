package com.example.logo_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.prefs.Preferences;

public class win_activity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button next;
    ViewPager viewPager;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    int index;
    int p=0;
    int pos=0;
    String ans;
    int temp;
    Win_Adapter win_adapter;
    int levelno;
    LinearLayout linear;
    ImageView winimg;
    ArrayList<String> imgList=new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        viewPager=findViewById(R.id.win_viewpage);
        linear=findViewById(R.id.linearlayout);
        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=preferences.edit();
        next=findViewById(R.id.next);
        textView=findViewById(R.id.ans);
        levelno=getIntent().getIntExtra("levelno",0);
        index=getIntent().getIntExtra("pos",0);
        ans=getIntent().getStringExtra("ans");
        textView.setText(ans);

        String[] images = new String[0];
        if(levelno==1)
        {
            try {
                images = getAssets().list("post_logo/level1");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for(int i=0;i<imgList.size();i++)
            {
                System.out.println("List of imgs="+imgList.get(i));
            }
        }
        if(levelno==2)
        {
            try {
                images = getAssets().list("post_logo/level2");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        win_adapter=new Win_Adapter(this,imgList,levelno,index);
        viewPager.setAdapter(win_adapter);
        create(index-1);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                p=0;
                create(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void create(int position)
    {
       // pos=position;
        viewPager.setCurrentItem(position);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (next.getId()==view.getId())
        {
            Intent intent=new Intent(win_activity.this,Quiz_Activity.class);
            intent.putExtra("s",index++);
            startActivity(intent);
        }

    }
}