package com.example.crickbuzz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.View_Holder> {
    Fragment fragment;
    String[] name;
    public RecyclerAdapter(Fragment fragment, String[] name) {
        this.fragment=fragment;
        this.name=name;
    }

    @NonNull
    @Override
    public RecyclerAdapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        View_Holder view_holder=new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.View_Holder holder, int position) {
        holder.textView.setText(name[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView textView;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.pname);
        }
    }
}
