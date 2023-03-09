package com.example.logo_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    ImageView pre_logo,back,next,cancel,remove;
    int pos=0;
    Button[] ans_btn=new Button[4];
    Button[] btn=new Button[14];
    String temp,temp1;
    ArrayList arrayList=new ArrayList();
    LinearLayout linearLayout;
    String[] ans_arr;
    String ans;
    char[] ans_charr;
    int p=0;
    ArrayList<String> imgList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        pre_logo=findViewById(R.id.logo_img);
        back=findViewById(R.id.back_img);
        next=findViewById(R.id.next_img);
        linearLayout=findViewById(R.id.linear);
        cancel=findViewById(R.id.cancel_btn);
        remove=findViewById(R.id.remove_btn);

            for(int i=0;i< ans_btn.length;i++)
            {
                int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
                ans_btn[i]=findViewById(id);

            }



        String[] images = new String[0];
        try {
            images = getAssets().list("pre_logo");
            imgList = new ArrayList<String>(Arrays.asList(images));
            for (int i=0;i<imgList.size();i++)
            {
                System.out.println("images="+imgList.get(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        InputStream inputstream = null;
        try
        {
            inputstream = getAssets().open("pre_logo/"+imgList.get(pos++));
            System.out.println("No of Images="+imgList.size());
            System.out.println("imgList Position="+imgList.get(pos++));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Drawable drawable = Drawable.createFromStream(inputstream, null);
        pre_logo.setImageDrawable(drawable);



//        cancel.setOnClickListener(view -> {
//
//            for (int i=0;i< ans_btn.length;i++)
//            {
//                ans_btn[i].setText("");
//            }
//
//        });
//        remove.setOnClickListener(view -> {
//            for (int i=0;i< ans_btn.length;i++)
//            {
//                temp1=temp.substring(0,temp.length()-1);
//                ans_btn[i].setText(""+temp1);
//            }
//        });





    }
    void create(int position)
    {
        pos=position;
        arrayList.clear();
        linearLayout.removeAllViews();
        ans_arr=imgList.get(pos).split("\\.");
        ans=ans_arr[0];
        ans_btn=new Button[ans.length()];
        ans_charr=ans.toCharArray();

        for(int i=0;i<btn.length;i++)
        {
            int id=getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i]=findViewById(id);
        }
        for (int i=0;i<ans.length();i++)
        {
            arrayList.add(ans_charr[i]);
        }
        for(int i=0;i<btn.length-ans.length();i++)
        {
            Random random=new Random();
            char c=(char)(random.nextInt(26)+'a');
            arrayList.add(""+c);
        }
        Collections.shuffle(arrayList);
        for(int i=0;i<btn.length;i++)
        {
            btn[i].setText(""+arrayList.get(i));
            btn[i].setOnClickListener(this);
        }
        arrayList.clear();

    }

    @Override
    public void onClick(View view) {
        for (int i=0;i< btn.length;i++)
        {
            if (btn[i].getId()==view.getId())
            {
                if (!btn[i].getText().toString().isEmpty())
                {
                    if (p<ans.length())
                    {
                        ans_btn[p].setText(btn[i].getText());
                        btn[i].setText("");
                        p++;
                    }
                }
            }
        }
    }
}