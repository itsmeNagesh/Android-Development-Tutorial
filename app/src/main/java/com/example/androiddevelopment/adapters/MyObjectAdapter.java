
package com.example.androiddevelopment.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopment.R;
import com.example.androiddevelopment.models.MyObject;
import com.example.androiddevelopment.ui.DetailActivity;
import com.example.androiddevelopment.ui.nestedTut;

import java.util.List;

public class MyObjectAdapter extends RecyclerView.Adapter<MyObjectAdapter.ViewHolder> {

    private final List<MyObject> myObjectList;
    private final Context context;

    // Constructor
    public MyObjectAdapter(List<MyObject> myObjectList, Context context) {
        this.myObjectList = myObjectList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyObject myObject = myObjectList.get(position);

        // Bind data to views
        holder.titleTextView.setText(myObject.getTitle());
        holder.descriptionTextView.setText(myObject.getDescription());
        holder.iconImageView.setImageResource(myObject.getIconResId());

        // Set onClickListener for the title
        holder.titleTextView.setOnClickListener(v -> {
            Intent intent;
            switch (myObject.getTitle()) {
                case "Tutorials": // Example title
                    intent = new Intent(context, nestedTut.class);
                    intent.putExtra("title", "Tutorials");
                    break;

                case "Title 2": // Example title
                    intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("title", "Title 2");
                    break;

                case "Title 3": // Example title
                    intent = new Intent(context, nestedTut.class);
                    intent.putExtra("title", "Title 1");
                    break;

                default:
                    intent = new Intent(context, nestedTut.class);
                    intent.putExtra("title", "Title 1");
                    break;
            }

            // Start the appropriate activity
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return myObjectList.size();
    }

    // ViewHolder Class
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView;
        ImageView iconImageView;

        ViewHolder(View itemView) {
            super(itemView);

            // Initialize views
            titleTextView = itemView.findViewById(R.id.card_title);
            descriptionTextView = itemView.findViewById(R.id.card_description);
            iconImageView = itemView.findViewById(R.id.card_icon);
        }
    }
}
