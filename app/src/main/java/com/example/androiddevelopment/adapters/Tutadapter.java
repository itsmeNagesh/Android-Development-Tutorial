package com.example.androiddevelopment.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopment.R;
import com.example.androiddevelopment.models.TuteModel;

import java.util.List;


public class Tutadapter extends RecyclerView.Adapter<Tutadapter.ViewHolder> {
    private final List<TuteModel> myObjectList;
    private final Context context;
    private final OnItemClickListener clickListener;

    public interface OnItemClickListener {
        void onItemClick(String title);
    }

    public Tutadapter(List<TuteModel> myObjectList, Context context, OnItemClickListener clickListener) {
        this.myObjectList = myObjectList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlerowtutepage, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TuteModel model = myObjectList.get(position);
        holder.titleTextView.setText(model.getTopic());
        holder.itemView.setOnClickListener(v -> clickListener.onItemClick(model.getTopic()));
    }

    @Override
    public int getItemCount() {
        return myObjectList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.t1);
        }
    }
}
