package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button blink,clockwise,fade,move,slide,zoom,stop_anim;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blink=findViewById(R.id.BTNblink);
        clockwise=findViewById(R.id.BTNrotate);
        fade=findViewById(R.id.BTNfade);
        move=findViewById(R.id.BTNmove);
        slide=findViewById(R.id.BTNslide);
        zoom=findViewById(R.id.BTNzoom);
        stop_anim=findViewById(R.id.BTNstop);
        imageView=findViewById(R.id.imageview);
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_animation);
                imageView.startAnimation(animation);

            }
        });
        clockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise_animation);
                imageView.startAnimation(animation);
            }
        });
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_animation);
                imageView.startAnimation(animation);
            }
        });
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation);
                imageView.startAnimation(animation);
            }
        });
        slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_animation);
                imageView.startAnimation(animation);
            }
        });
        stop_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.clearAnimation();
            }
        });
    }
}