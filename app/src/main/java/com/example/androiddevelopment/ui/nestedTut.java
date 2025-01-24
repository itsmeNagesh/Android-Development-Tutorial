package com.example.androiddevelopment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopment.R;
import com.example.androiddevelopment.adapters.Tutadapter;
import com.example.androiddevelopment.models.TuteModel;

import java.util.ArrayList;
import java.util.List;

public class nestedTut extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ImageView backArrowIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_nested_tut);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recycler_viewtut);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         // back navigation
        backArrowIcon = findViewById(R.id.arrow_icon);
        backArrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back using the NavController
                NavController navController = Navigation.findNavController(nestedTut.this, R.id.nav_host_fragment);
                navController.navigateUp();
            }
        });
        // Retrieve the title from Intent
        String title = getIntent().getStringExtra("title");

        // Set the title in the TextView
        TextView titleTextView = findViewById(R.id.title_text);
        if (title != null) {
            titleTextView.setText(title);
        }

        // Set up the RecyclerView adapter with sample data
        Tutadapter adapter = new Tutadapter(getSampleData(title), this, this::navigateToDetail); // Pass click listener
        recyclerView.setAdapter(adapter);
    }

    /**
     * Create sample data for the RecyclerView based on the title
     */
    private List<TuteModel> getSampleData(String title) {
        List<TuteModel> topicList = new ArrayList<>();
        switch (title) {
            case "Tutorials":
                int index = 1;

                // Beginner Topics
                topicList.add(new TuteModel(index++ + ". Introduction to Android Development"));
                topicList.add(new TuteModel(index++ + ". Setting Up Android Studio"));
                topicList.add(new TuteModel(index++ + ". Building Your First App"));
                topicList.add(new TuteModel(index++ + ". Android Project Structure"));

                // Intermediate Topics
                topicList.add(new TuteModel(index++ + ". Working with Layouts and Views"));
                topicList.add(new TuteModel(index++ + ". Activity Lifecycle"));
                topicList.add(new TuteModel(index++ + ". Intents for Navigation"));
//                topicList.add(new TuteModel(index++ + ". Fragments"));

                // Advanced Topics
                topicList.add(new TuteModel(index++ + ". MVVM Architecture"));
                topicList.add(new TuteModel(index++ + ". Dependency Injection with Hilt"));
                topicList.add(new TuteModel(index++ + ". Exploring Jetpack Components"));
//                topicList.add(new TuteModel(index++ + ". Publishing App On Google Play Store"));
                break;

            case "Examples":
                topicList.add(new TuteModel("Basic Examples"));
                topicList.add(new TuteModel("Intermediate Examples"));
                topicList.add(new TuteModel("Advanced Examples"));
                break;

            case "Advanced":
                topicList.add(new TuteModel("Advanced Concepts"));
                topicList.add(new TuteModel("Optimization Techniques"));
                topicList.add(new TuteModel("Advanced Tools"));
                break;

            default:
                topicList.add(new TuteModel("Quiz"));
                topicList.add(new TuteModel("Interview Q/A"));
                topicList.add(new TuteModel("Tips & Tricks"));
                break;
        }
        return topicList;
    }

    private void navigateToDetail(String title) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("title", title); // Pass the exact title
        startActivity(intent);
    }
}
