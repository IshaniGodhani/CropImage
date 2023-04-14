package com.example.new_demo;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.View_holder> {
    public Recycler_Adapter(Object listener, DataModel model) {

    }

    @NonNull
    @Override
    public Recycler_Adapter.View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter.View_holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class View_holder extends RecyclerView.ViewHolder {
        public View_holder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
