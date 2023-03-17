package com.example.logo_quiz;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Level_Adapter extends RecyclerView.Adapter<Level_Adapter.View_HOlder> {
    Activity activity;
    int[] imgs;
    String[] levels;
    public Level_Adapter(Activity activity, int[] imgs, String[] levels) {
        this.activity=activity;
        this.imgs=imgs;
        this.levels=levels;
    }

    @NonNull
    @Override
    public Level_Adapter.View_HOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.levels_category,parent,false);
        View_HOlder view_hOlder=new View_HOlder(view);
        return view_hOlder;
    }

    @Override
    public void onBindViewHolder(@NonNull Level_Adapter.View_HOlder holder, int position) {
        holder.levelimg.setImageResource(imgs[position]);
        holder.level.setText(levels[position]);
        holder.level.setOnClickListener(v -> {
            Intent intent=new Intent(activity,logo_activity.class);
            intent.putExtra("pos",(holder.getAdapterPosition()+1));
            System.out.println("Position="+(holder.getAdapterPosition()+1));
            activity.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class View_HOlder extends RecyclerView.ViewHolder {
        TextView level;
        ImageView levelimg;
        public View_HOlder(@NonNull View itemView) {
            super(itemView);
            level=itemView.findViewById(R.id.leveltxt);
            levelimg=itemView.findViewById(R.id.levelimg);
        }
    }
}
