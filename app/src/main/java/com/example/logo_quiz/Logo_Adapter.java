package com.example.logo_quiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Logo_Adapter extends RecyclerView.Adapter<Logo_Adapter.View_holder> {
    Context context;
    int[] logos_l1;

    public Logo_Adapter(Context context, int[] logo_l1) {
        this.context=context;
        this.logos_l1=logo_l1;
    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item_logo,parent,false);
        View_holder view_holder=new View_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {
        holder.logo.setImageResource(logos_l1[position]);
        holder.logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Quiz_Activity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return logos_l1.length;
    }

    public class View_holder extends RecyclerView.ViewHolder {

        ImageView logo;
        public View_holder(@NonNull View itemView) {
            super(itemView);

            logo=itemView.findViewById(R.id.logo);
        }
    }
}
