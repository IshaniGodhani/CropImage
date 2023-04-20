package com.example.comments_500;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.ViewHolder> {
    Context context;
    ArrayList<Datamodel> arrayList;
    public Recycler_Adapter(Context context, ArrayList<Datamodel> arrayList) {
            this.context=context;
            this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public Recycler_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_file,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter.ViewHolder holder, int position) {
        Datamodel model=arrayList.get(position);
        int pid= model.getPostId();
        int id= model.getId();
        String name= model.getName();
        String email= model.getEmail();
        String body= model.getBody();

        holder.Pid.setText(""+pid);
        holder.Id.setText(""+id);
        holder.Name.setText(""+name);
        holder.Email.setText(""+email);
        holder.Body.setText(""+body);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Pid,Id,Name,Email,Body;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Pid=itemView.findViewById(R.id.item_pid);
            Id=itemView.findViewById(R.id.item_id);
            Name=itemView.findViewById(R.id.item_name);
            Email=itemView.findViewById(R.id.item_email);
            Body=itemView.findViewById(R.id.item_body);
        }
    }
}
