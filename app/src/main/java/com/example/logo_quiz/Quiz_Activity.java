package com.example.logo_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quiz_Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView,cancel,remove,back,next;
    int pos=0;
    Button[] ans_btn;
    Button[] bt=new Button[14];
    Button btn0,btn1,btn2;
    int index;
    String temp,temp1;
    ArrayList arrayList=new ArrayList();
    LinearLayout linearLayout;
    String[] ans_arr;
    String ans;
    char[] ans_charr;
    int p=0;
    ArrayList<String> imgList=new ArrayList<>();
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Quiz_Adapter quiz_adapter;

    ViewPager viewPager;
    ArrayList<String> ansList=new ArrayList<>();

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        linearLayout=findViewById(R.id.linear);
        cancel=findViewById(R.id.cancel_btn);
        remove=findViewById(R.id.remove_btn);
        viewPager=findViewById(R.id.viewpage);
        index=getIntent().getIntExtra("index",0);

        for(int i=0;i< bt.length;i++)
        {
            id=getResources().getIdentifier("button"+i,"id",getPackageName());
            bt[i]=findViewById(id);
        }

        String[] images = new String[0];
        try {
            images = getAssets().list("pre_logo/level1");
            imgList = new ArrayList<String>(Arrays.asList(images));
            for (int i=0;i<imgList.size();i++)
            {
                System.out.println("images="+imgList.get(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quiz_adapter=new Quiz_Adapter(this,imgList);
        viewPager.setAdapter(quiz_adapter);
        create(index);
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




        cancel.setOnClickListener(view -> {

            for (int i=0;i< ans_btn.length;i++)
            {
                ans_btn[i].setText("");
            }

        });
        remove.setOnClickListener(view -> {
            for (int i=0;i< ans_btn.length;i++)
            {

                temp1=temp.substring(0,temp.length()-1);
                ans_btn[i].setText(""+temp1);
            }
        });





    }
    private void create(int position)
    {
        pos=position;
        arrayList.clear();
        linearLayout.removeAllViews();
        imageView=findViewById(R.id.logo_img);
        viewPager.setCurrentItem(position);

        ans_arr=imgList.get(pos).split("\\."); //puma.png
        ans=ans_arr[0]; // puma
        ans_btn=new Button[ans.length()];
        ans_charr=ans.toCharArray();


        for (int i=0;i<ans.length();i++)
        {
            arrayList.add(ans_charr[i]);
        }
        for(int i=0;i<bt.length-ans.length();i++)
        {
            Random random=new Random();
            char c=(char)(random.nextInt(26)+'a'); // p u m a
            arrayList.add(""+c);
        }
        Collections.shuffle(arrayList);
        for(int i=0;i<bt.length;i++)
        {
            bt[i].setText(""+arrayList.get(i));
            bt[i].setOnClickListener(this);
        }
        for (int i = 0; i <ans.length(); i++) {
            ans_btn[i] = new Button(Quiz_Activity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 150, 1);
            layoutParams.setMargins(5, 5, 5, 5);
            ans_btn[i].setLayoutParams(layoutParams);
            ans_btn[i].setBackgroundColor(getResources().getColor(R.color.black));
            linearLayout.addView(ans_btn[i]);
        }


    }

    @Override
    public void onClick(View view) {
        for (int i=0;i< bt.length;i++)
        {
            if (bt[i].getId()==view.getId())
            {
                if (!bt[i].getText().toString().isEmpty())
                {
                    if (p<ans.length())
                    {

                        ans_btn[p].setText(bt[i].getText());

                        bt[i].setText("");
                        p++;

                    }

                }
            }
        }
        String ans=String.valueOf(ans_btn);
        preferences=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=preferences.edit();
        if (ans.equals(ans)) {
            editor.putString("matched"+pos,"true");
            editor.commit();

        }
        else if(!ans.equals(ans))
        {
            editor.putString("matched"+pos,"false");
            editor.commit();

        }

    }
}