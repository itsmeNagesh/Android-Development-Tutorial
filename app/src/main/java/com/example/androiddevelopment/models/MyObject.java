
package com.example.androiddevelopment.models;

import androidx.annotation.NonNull;

public class MyObject {
    private String title;       // Title for the card
    private String description; // Description for the card
    private int iconResId;      // Resource ID for the icon

    // Constructor
    public MyObject(String title, String description, int iconResId) {
        this.title = title;
        this.description = description;
        this.iconResId = iconResId;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Setter for Title (Optional if needed for updating)
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for Description
    public String getDescription() {
        return description;
    }

    // Setter for Description (Optional if needed for updating)
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for Icon Resource ID
    public int getIconResId() {
        return iconResId;
    }

    // Setter for Icon Resource ID (Optional if needed for updating)
    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    // Overriding toString() for debugging/logging purposes
    @NonNull
    @Override
    public String toString() {
        return "MyObject{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", iconResId=" + iconResId +
                '}';
    }
}
