
package com.example.androiddevelopment.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androiddevelopment.R;
import com.example.androiddevelopment.adapters.MyObjectAdapter;
import com.example.androiddevelopment.models.MyObject;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Initialize RecyclerView
        recyclerView = root.findViewById(R.id.recycler_view);

        // Set GridLayoutManager with 2 columns
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Set up the adapter with sample data
        MyObjectAdapter adapter = new MyObjectAdapter(getSampleData(), getContext());
        recyclerView.setAdapter(adapter);

        return root;
    }

    /**
     * Create sample data for the RecyclerView
     */
    private List<MyObject> getSampleData() {
        List<MyObject> objectList = new ArrayList<>();
        objectList.add(new MyObject("Tutorials", "Contains Full Syllabus & Tutorials", R.drawable.book));
        objectList.add(new MyObject("Examples", "Contains many programs and examples", R.drawable.code));
        objectList.add(new MyObject("Advanced", "Contains advanced programs", R.drawable.developer));
        objectList.add(new MyObject("Quiz", "Test your knowledge and Skill", R.drawable.network));
        objectList.add(new MyObject("Interview Q/A", "Contains interview questions and answers", R.drawable.factory));
        objectList.add(new MyObject("Tips & Tricks", "Improve your skills and Knowledge with Tips", R.drawable.bulb));
        objectList.add(new MyObject("Developer", "Developer Details & Message for you", R.drawable.person));
        objectList.add(new MyObject("Remove Ads", "Upgrade Now  Premium to Remove all Ads", R.drawable.block));


        return objectList;
    }
}
