package com.example.psg_itech;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private List<ModelClass> userList;
    RequestOptions option;

    public Adapter(Context mContext,List<ModelClass> userList)
    {
        this.mContext=mContext;
        this.userList=userList;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.bg_round).error(R.drawable.bg_round);
    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        ModelClass modelClass = userList.get(position);

        Glide.with(mContext).load(userList.get(position).getImageView1()).apply(option).into(holder.c_image);

        holder.c_name.setText(modelClass.getTextview1());
        holder.c_qualification.setText(modelClass.getTextview2());
        holder.c_designation.setText(modelClass.getTextview3());
        holder.c_department.setText(modelClass.getTextview4());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,Third_Activity.class);
                intent.putExtra("image",userList.get(position).getImageView1());
                intent.putExtra("name",userList.get(position).getTextview1());
                intent.putExtra("qualification",userList.get(position).getTextview2());
                intent.putExtra("designation",userList.get(position).getTextview3());
                intent.putExtra("department",userList.get(position).getTextview4());
                intent.putExtra("contact",userList.get(position).getTextview5());
                intent.putExtra("email",userList.get(position).getTextview6());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setFilter(List<ModelClass> newList){
        userList = new ArrayList<>();
        userList.addAll(newList);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView c_image;
        private TextView c_name;
        private TextView c_qualification;
        private TextView c_designation;
        private TextView c_department;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            c_image=itemView.findViewById(R.id.imageview1);
            c_name=itemView.findViewById(R.id.textview);
            c_qualification=itemView.findViewById(R.id.textview1);
            c_designation=itemView.findViewById(R.id.textview2);
            c_department=itemView.findViewById(R.id.textview3);
            cardView=(CardView) itemView.findViewById(R.id.cardview_id);

        }
    }
}
