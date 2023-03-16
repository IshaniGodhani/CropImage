package com.example.logo_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class logo_activity extends AppCompatActivity {
//    int[] logo_l1={R.drawable.facebook,R.drawable.starbucks,R.drawable.intel,R.drawable.audi,
//            R.drawable.barbie,R.drawable.dropbox,R.drawable.adidas,R.drawable.louis_vuitton,R.drawable.mcdonalds,
//            R.drawable.mercedes,R.drawable.nbc,R.drawable.pizzahut,R.drawable.redbull,R.drawable.shell,
//            R.drawable.toyota,R.drawable.twitter,R.drawable.visa,R.drawable.volkswagen,R.drawable.wikipedia,};
    RecyclerView recyclerView;
    Logo_Adapter logo_adapter;
    TextView levelnum;
    int[] temp;
    int numOfImage;
    ArrayList<String> imgList=new ArrayList<>();
    String[] levels;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        recyclerView=findViewById(R.id.gridview);
        levelnum=findViewById(R.id.levelnum);
        pos=getIntent().getIntExtra("pos",0);
        levels=getIntent().getStringArrayExtra("Levels");
        levelnum.setText(levels[pos]);

        String[] images = new String[0];
        if (pos==0)
        {
            try {
                images = getAssets().list("pre_logo/level1");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (pos==2)
        {
            try {
                images = getAssets().list("pre_logo/level2");
                imgList = new ArrayList<String>(Arrays.asList(images));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        logo_adapter=new Logo_Adapter(this,imgList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(logo_activity.this,3);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(logo_adapter);


    }
}