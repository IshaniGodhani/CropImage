package com.example.logo_quiz;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Win_Adapter extends PagerAdapter {
    Activity activity;
    ArrayList<String> imgList;
    ImageView imageView;
    int pos;
    int lelvelno;
    SharedPreferences sharedPreferences;
    public Win_Adapter(Activity activity, ArrayList<String> imgList, int levelno, int pos) {
        this.activity=activity;
        this.imgList=imgList;
        this.pos=pos;
        this.lelvelno=levelno;
        sharedPreferences = activity.getSharedPreferences("myPref", Context.MODE_PRIVATE);
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(activity).inflate(R.layout.win_item, container, false);
        int index=sharedPreferences.getInt("image",0);
        String str=sharedPreferences.getString("matched"+index,"true");
        imageView=view.findViewById(R.id.win_img);
        InputStream inputstream = null;

        System.out.println("Position");
        if(lelvelno==1) {

                try {
                    inputstream = activity.getAssets().open("post_logo/level1/" + imgList.get(pos));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            if(lelvelno==2) {

                try {
                    inputstream = activity.getAssets().open("post_logo/level2/" + imgList.get(pos));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }





        Drawable drawable = Drawable.createFromStream(inputstream, null);
        imageView.setImageDrawable(drawable);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
