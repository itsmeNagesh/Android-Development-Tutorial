package com.example.androiddevelopment.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.androiddevelopment.R;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTextView, descriptionTextView;
    private ImageView backArrowIcon;
    private HashMap<String, String> titleDescriptionMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_detail);

        // Initialize views
        backArrowIcon = findViewById(R.id.arrow_icon);
        titleTextView = findViewById(R.id.detail_title);
        descriptionTextView = findViewById(R.id.detail_description);
        // for navigation
        backArrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back using the NavController
                NavController navController = Navigation.findNavController(DetailActivity.this, R.id.nav_host_fragment);
                navController.navigateUp();
            }
        });

        // Initialize the title-description map
        initializeTitleDescriptionMap();

        // Retrieve title from Intent
        String title = getIntent().getStringExtra("title");

        // Set the title
        titleTextView.setText(title);

        // Fetch and display the description with styling
        if (title != null && titleDescriptionMap.containsKey(title)) {
            String description = titleDescriptionMap.get(title);
            descriptionTextView.setText(applyStyling(description));
        } else {
            descriptionTextView.setText("Description not available for this title.");
        }
    }

    /**
     * Initialize the HashMap with titles and their descriptions.
     */
    private void initializeTitleDescriptionMap() {
        titleDescriptionMap = new HashMap<>();
        titleDescriptionMap.put("1. Introduction to Android Development",
                "Android operating system is the largest installed base among various mobile platforms across the globe. Hundreds "
                        + "of millions of mobile devices are powered by Android in more than 190 countries of the world. \n\nKey Features:\n"
                        + "1. Open-source and flexible.\n"
                        + "2. Supports a wide range of devices.\n"
                        + "3. Backed by Google and a strong community.\n"
                        + "4. Provides tools for innovative application development.\n"+"/nAndroid Development involves creating applications that run on Android devices. These applications can range" +
                        " from simple utilities to complex games and productivity tools.\n"+"\nKey Concepts in Android Development\n"
        +"\nActivities: The building blocks of an Android application. Each activity represents a single screen with a user interface."+"\nIntents:" +
                        " Messages that allow different components of an application to interact with each other or with other applications."+"\nServices: Background processes " +
                        "that can run independently of an activity.");

        titleDescriptionMap.put("2. Setting Up Android Studio",
                "Setting Up Android Studio\n\n"
                        + "Android Studio is the official Integrated Development Environment (IDE) for Android application development. "
                        + "It provides tools, an emulator, and support for building, debugging, and testing Android applications.\n\n"

                        + "Step-by-Step Guide:\n\n"

                        + "1. **Download Android Studio**\n"
                        + "   - Visit the [official Android Studio website](https://developer.android.com/studio) and download the latest version.\n"
                        + "   - Choose the appropriate version for your operating system (Windows, macOS, Linux).\n\n"

                        + "2. **Install Android Studio**\n"
                        + "   - Follow the installation wizard to install Android Studio on your system.\n"
                        + "   - During installation, ensure the required components (SDK Manager, Android Virtual Device, etc.) are selected.\n\n"

                        + "3. **Setup SDKs**\n"
                        + "   - Open Android Studio and navigate to the **SDK Manager** (via File > Settings > Appearance & Behavior > System Settings > Android SDK).\n"
                        + "   - Download and install the latest Android SDK versions, system images, and additional tools as required.\n\n"

                        + "4. **Configure an Emulator**\n"
                        + "   - Use the **AVD Manager** (Android Virtual Device) to create a virtual device for testing your applications.\n"
                        + "   - Select the desired device type, resolution, and Android version.\n"
                        + "   - Start the emulator to ensure it works correctly.\n\n"

                        + "5. **Connect a Real Device (Optional)**\n"
                        + "   - Enable **Developer Options** on your Android device:\n"
                        + "      - Go to Settings > About Phone > Tap 'Build Number' 7 times.\n"
                        + "   - Enable **USB Debugging** under Developer Options.\n"
                        + "   - Connect your device to your system via USB and ensure it is recognized by Android Studio.\n\n"

                        + "6. **Explore the Android Studio Interface**\n"
                        + "   - Familiarize yourself with key components of the interface:\n"
                        + "      - **Project Window**: Displays all files and directories in your project.\n"
                        + "      - **Editor Window**: Main area for coding and layout design.\n"
                        + "      - **Logcat**: Displays logs and system messages for debugging.\n"
                        + "      - **Toolbar**: Quick access to key actions like running or debugging your app.\n\n"

                        + "7. **Create Your First Project**\n"
                        + "   - Click **New Project** and select a project template.\n"
                        + "   - Configure the project settings (application name, package name, save location, etc.).\n"
                        + "   - Select the target Android version and finish the setup.\n"
                        + "   - Explore the auto-generated files and folders, such as 'MainActivity.java' or 'activity_main.xml.'\n\n"

                        + "Tips for Setting Up:\n"
                        + "1. Keep Android Studio updated to the latest version.\n"
                        + "2. Install device drivers for smooth real device debugging.\n"
                        + "3. Use a system with good hardware (RAM, CPU, and storage) for optimal performance.\n\n"

                        + "Once Android Studio is installed and configured, you are ready to start developing your first Android application!");


        titleDescriptionMap.put("3. Building Your First App",
                "Building Your First App\n\n"
                        + "Creating a basic Android app involves designing a user interface (UI), writing logic, and running it on a device or emulator.\n\n"

                        + "Step-by-Step Guide:\n\n"

                        + "1. **Start a New Project**\n"
                        + "   - Open Android Studio and select 'New Project'.\n"
                        + "   - Choose 'Empty Activity' as the template and configure your app name, package name, and save location.\n"
                        + "   - Select the minimum API level to target a range of devices.\n\n"

                        + "2. **Design a Simple UI**\n"
                        + "   - Open the `activity_main.xml` file in the layout editor.\n"
                        + "   - Drag and drop a **TextView** (for displaying text) and a **Button** (for user interaction) onto the layout.\n"
                        + "   - Adjust their positions and properties using the attributes panel.\n"
                        + "   - Example:\n"
                        + "      ```xml\n"
                        + "      <TextView\n"
                        + "          android:id=\"@+id/textView\"\n"
                        + "          android:layout_width=\"wrap_content\"\n"
                        + "          android:layout_height=\"wrap_content\"\n"
                        + "          android:text=\"Hello, World!\"/>\n\n"
                        + "      <Button\n"
                        + "          android:id=\"@+id/button\"\n"
                        + "          android:layout_width=\"wrap_content\"\n"
                        + "          android:layout_height=\"wrap_content\"\n"
                        + "          android:text=\"Click Me\"/>\n"
                        + "      ```\n\n"

                        + "3. **Write Code to Handle Button Clicks**\n"
                        + "   - Open `MainActivity.java` or `MainActivity.kt`.\n"
                        + "   - Reference the button and TextView in your code using their IDs.\n"
                        + "   - Add a click listener to the button to update the TextView when clicked.\n"
                        + "   - Example in Java:\n"
                        + "      ```java\n"
                        + "      Button button = findViewById(R.id.button);\n"
                        + "      TextView textView = findViewById(R.id.textView);\n\n"
                        + "      button.setOnClickListener(new View.OnClickListener() {\n"
                        + "          @Override\n"
                        + "          public void onClick(View v) {\n"
                        + "              textView.setText(\"Button Clicked!\");\n"
                        + "          }\n"
                        + "      });\n"
                        + "      ```\n\n"

                        + "4. **Run Your App**\n"
                        + "   - Click the 'Run' button in Android Studio.\n"
                        + "   - Select an emulator or connected device to run the app.\n"
                        + "   - Test the app by clicking the button and observing the behavior.\n\n"

                        + "Tips:\n"
                        + "1. Use **ConstraintLayout** for better UI flexibility.\n"
                        + "2. Explore the attributes panel to customize UI elements.\n"
                        + "3. Use meaningful IDs for your views to make your code more readable.\n\n"

                        + "Once you've completed these steps, you will have built a simple app that responds to user interaction!");

        titleDescriptionMap.put("4. Android Project Structure",
                "Android Project Structure\n\n"
                        + "An Android project is organized into multiple folders and files to ensure a modular and scalable structure. Here’s an overview:\n\n"

                        + "1. **`java/` Folder**\n"
                        + "   - Contains all Java/Kotlin source files for your application.\n"
                        + "   - Organized by package names.\n"
                        + "   - Includes files like `MainActivity.java` or `MainActivity.kt` where you define your app’s logic.\n\n"

                        + "2. **`res/` Folder**\n"
                        + "   - Contains all application resources, such as:\n"
                        + "      - **`layout/`**: XML files that define the app’s user interface (e.g., `activity_main.xml`).\n"
                        + "      - **`drawable/`**: Image files and vector assets.\n"
                        + "      - **`values/`**: Resource definitions like strings, colors, and styles (e.g., `strings.xml`, `colors.xml`).\n"
                        + "      - **`mipmap/`**: Launcher icons for various screen densities.\n\n"

                        + "3. **`AndroidManifest.xml`**\n"
                        + "   - The configuration file for your application.\n"
                        + "   - Defines app components (activities, services, broadcast receivers).\n"
                        + "   - Specifies permissions required by the app (e.g., Internet access).\n\n"

                        + "4. **Gradle Files**\n"
                        + "   - **`build.gradle (Module: app)`**: Defines app-specific configurations like dependencies, min SDK, and target SDK versions.\n"
                        + "   - **`build.gradle (Project)`**: Configures global build settings and plugins.\n"
                        + "   - **`gradle.properties`**: Contains project-wide Gradle settings.\n"
                        + "   - **`settings.gradle`**: Includes modules in the build.\n\n"

                        + "Understanding the Android project structure is essential for navigating and modifying your app effectively."
        );

        titleDescriptionMap.put("5. Working with Layouts and Views",
                "Working with Layouts and Views\n\n"
                        + "Layouts and views are the building blocks of an Android application's user interface (UI). They define how the app appears to users and how they interact with it.\n\n"

                        + "1. **Understanding Layouts**\n"
                        + "   - Layouts are containers that define the structure of the UI.\n"
                        + "   - Common types of layouts:\n"
                        + "      - **LinearLayout**: Arranges views in a vertical or horizontal sequence.\n"
                        + "      - **RelativeLayout**: Positions views relative to each other or to the parent container.\n"
                        + "      - **ConstraintLayout**: A flexible and efficient layout for positioning views using constraints.\n"
                        + "      - **FrameLayout**: A simple layout for stacking views.\n"
                        + "      - **GridLayout**: Places views in a grid-like structure.\n\n"

                        + "2. **Common Views in Android**\n"
                        + "   - **TextView**: Displays text.\n"
                        + "   - **EditText**: Provides a text input field for user input.\n"
                        + "   - **Button**: Represents a clickable button for user actions.\n"
                        + "   - **ImageView**: Displays images or icons.\n"
                        + "   - **RecyclerView**: Displays a scrollable list of items with high performance.\n"
                        + "   - **CheckBox**: Allows selection of multiple options.\n"
                        + "   - **RadioButton**: Enables selection of one option among multiple choices.\n\n"

                        + "3. **Designing the Layout**\n"
                        + "   - Use the **XML layout files** (e.g., `activity_main.xml`) to define the UI structure.\n"
                        + "   - Drag and drop elements in the **Design View** in Android Studio or directly edit the XML code.\n"
                        + "   - Example of a simple layout:\n"
                        + "      ```xml\n"
                        + "      <LinearLayout\n"
                        + "          android:layout_width=\"match_parent\"\n"
                        + "          android:layout_height=\"match_parent\"\n"
                        + "          android:orientation=\"vertical\">\n\n"
                        + "          <TextView\n"
                        + "              android:id=\"@+id/textView\"\n"
                        + "              android:layout_width=\"wrap_content\"\n"
                        + "              android:layout_height=\"wrap_content\"\n"
                        + "              android:text=\"Welcome to Android!\" />\n\n"
                        + "          <Button\n"
                        + "              android:id=\"@+id/button\"\n"
                        + "              android:layout_width=\"wrap_content\"\n"
                        + "              android:layout_height=\"wrap_content\"\n"
                        + "              android:text=\"Click Me\" />\n"
                        + "      </LinearLayout>\n"
                        + "      ```\n\n"

                        + "4. **Key Concepts**\n"
                        + "   - **Padding and Margins**: Define spacing inside and outside a view.\n"
                        + "   - **Gravity**: Aligns content inside a view (e.g., center, left, right).\n"
                        + "   - **Weight**: Distributes space among child views in a layout (especially in LinearLayout).\n"
                        + "   - **Visibility**: Controls whether a view is visible, invisible, or gone.\n\n"

                        + "5. **Tips for Effective Layouts**\n"
                        + "   - Use **ConstraintLayout** for complex layouts to improve performance.\n"
                        + "   - Avoid nesting too many layouts to reduce rendering time.\n"
                        + "   - Use **dp** (density-independent pixels) for dimensions and **sp** (scale-independent pixels) for text sizes.\n\n"

                        + "Understanding layouts and views is essential for creating an engaging and user-friendly app interface."
        );

        titleDescriptionMap.put("6. Activity Lifecycle",
                "Activity Lifecycle\n\n"
                        + "The activity lifecycle represents the stages an activity goes through from creation to destruction. "
                        + "Understanding the lifecycle is crucial for managing resources and ensuring a smooth user experience.\n\n"

                        + "1. **Lifecycle Callbacks**\n"
                        + "   - **onCreate()**: Called when the activity is first created. Used to initialize components and set up the UI.\n"
                        + "   - **onStart()**: Called when the activity becomes visible to the user.\n"
                        + "   - **onResume()**: Called when the activity starts interacting with the user.\n"
                        + "   - **onPause()**: Called when the activity loses focus but is still visible (e.g., when another activity partially covers it).\n"
                        + "   - **onStop()**: Called when the activity is no longer visible.\n"
                        + "   - **onDestroy()**: Called when the activity is about to be destroyed (e.g., when the user finishes the activity or the system reclaims memory).\n\n"

                        + "2. **Activity States**\n"
                        + "   - **Running**: The activity is visible and interacting with the user.\n"
                        + "   - **Paused**: The activity is partially visible but not in focus.\n"
                        + "   - **Stopped**: The activity is completely obscured and not visible.\n\n"

                        + "3. **Tips for Managing the Lifecycle**\n"
                        + "   - Release resources (e.g., close database connections) in `onPause()` or `onStop()`.\n"
                        + "   - Save user data or state in `onSaveInstanceState()` to handle configuration changes like screen rotations.\n"
                        + "   - Avoid heavy operations in lifecycle callbacks to ensure smooth transitions.\n\n"

                        + "Understanding the activity lifecycle helps in creating efficient and user-friendly applications."
        );

        titleDescriptionMap.put("7. Intents for Navigation",
                "Intents for Navigation\n\n"
                        + "Intents are used to navigate between activities or pass data between components in an Android application.\n\n"

                        + "1. **Types of Intents**\n"
                        + "   - **Explicit Intents**: Used to navigate to a specific activity within the app. Example:\n"
                        + "      ```java\n"
                        + "      Intent intent = new Intent(this, SecondActivity.class);\n"
                        + "      startActivity(intent);\n"
                        + "      ```\n"
                        + "   - **Implicit Intents**: Used to perform an action using an external app (e.g., open a web page, share content). Example:\n"
                        + "      ```java\n"
                        + "      Intent intent = new Intent(Intent.ACTION_VIEW);\n"
                        + "      intent.setData(Uri.parse(\"https://www.example.com\"));\n"
                        + "      startActivity(intent);\n"
                        + "      ```\n\n"

                        + "2. **Passing Data Between Activities**\n"
                        + "   - Use the `putExtra()` method to pass data to the target activity. Example:\n"
                        + "      ```java\n"
                        + "      Intent intent = new Intent(this, SecondActivity.class);\n"
                        + "      intent.putExtra(\"key\", \"value\");\n"
                        + "      startActivity(intent);\n"
                        + "      ```\n"
                        + "   - Retrieve the data in the target activity using `getIntent()`. Example:\n"
                        + "      ```java\n"
                        + "      String value = getIntent().getStringExtra(\"key\");\n"
                        + "      ```\n\n"

                        + "3. **Navigating Back**\n"
                        + "   - Use `finish()` to close the current activity and navigate back to the previous one.\n"
                        + "   - The back button is handled by the system, but custom behavior can be implemented using `onBackPressed()`.\n\n"

                        + "4. **Tips for Using Intents**\n"
                        + "   - Always validate data passed through intents to avoid crashes.\n"
                        + "   - Use Parcelable or Serializable for passing complex objects between activities.\n"
                        + "   - Use explicit intents for better control within your app.\n\n"

                        + "Intents are a powerful way to enable seamless navigation and data sharing in Android applications."
        );

        titleDescriptionMap.put("8. MVVM Architecture",
                "MVVM Architecture\n\n"
                        + "Model-View-ViewModel (MVVM) is a design pattern commonly used in Android development to improve separation of concerns and maintainability.\n\n"

                        + "1. **Components of MVVM**\n"
                        + "   - **Model**:\n"
                        + "      - Represents the data and business logic of the application.\n"
                        + "      - Fetches data from local databases or remote servers and provides it to the ViewModel.\n\n"
                        + "   - **View**:\n"
                        + "      - Represents the user interface (UI) elements such as activities, fragments, and layouts.\n"
                        + "      - Observes changes in the ViewModel and updates the UI accordingly.\n\n"
                        + "   - **ViewModel**:\n"
                        + "      - Acts as a bridge between the Model and the View.\n"
                        + "      - Contains UI-related data and logic.\n"
                        + "      - Uses **LiveData** or other observable data holders to update the View dynamically.\n\n"

                        + "2. **Advantages of MVVM**\n"
                        + "   - Separation of concerns leads to more modular code.\n"
                        + "   - Improved testability due to the decoupling of business logic from the UI.\n"
                        + "   - Easier to maintain and scale as the application grows.\n\n"

                        + "3. **Implementing MVVM in Android**\n"
                        + "   - **ViewModel**:\n"
                        + "      ```java\n"
                        + "      public class MyViewModel extends ViewModel {\n"
                        + "          private MutableLiveData<String> liveData = new MutableLiveData<>();\n\n"
                        + "          public LiveData<String> getLiveData() {\n"
                        + "              return liveData;\n"
                        + "          }\n\n"
                        + "          public void fetchData() {\n"
                        + "              liveData.setValue(\"Hello, MVVM!\");\n"
                        + "          }\n"
                        + "      }\n"
                        + "      ```\n\n"
                        + "   - **View (Activity/Fragment)**:\n"
                        + "      ```java\n"
                        + "      MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);\n"
                        + "      viewModel.getLiveData().observe(this, data -> {\n"
                        + "          textView.setText(data);\n"
                        + "      });\n"
                        + "      viewModel.fetchData();\n"
                        + "      ```\n\n"

                        + "Using MVVM ensures a clean and maintainable architecture for your Android applications."
        );

        titleDescriptionMap.put("9. Dependency Injection with Hilt",
                "Dependency Injection with Hilt\n\n"
                        + "Dependency Injection (DI) is a design pattern used to provide objects that a class depends on, making code more modular and testable.\n\n"

                        + "1. **What is Hilt?**\n"
                        + "   - Hilt is a dependency injection library built on top of Dagger, designed specifically for Android.\n"
                        + "   - Simplifies DI setup by providing pre-defined components and annotations.\n\n"

                        + "2. **Benefits of Using Hilt**\n"
                        + "   - Reduces boilerplate code compared to manual dependency injection.\n"
                        + "   - Provides scoped components for Android-specific classes like Activities, Fragments, and ViewModels.\n"
                        + "   - Integrates seamlessly with Android Jetpack components.\n\n"

                        + "3. **Setting Up Hilt**\n"
                        + "   - Add Hilt dependencies to your `build.gradle` file:\n"
                        + "      ```groovy\n"
                        + "      implementation \"com.google.dagger:hilt-android:2.44\"\n"
                        + "      kapt \"com.google.dagger:hilt-android-compiler:2.44\"\n"
                        + "      ```\n"
                        + "      Apply the Hilt plugin in your `build.gradle` file:\n"
                        + "      ```groovy\n"
                        + "      plugins {\n"
                        + "          id 'com.google.dagger.hilt.android'\n"
                        + "      }\n"
                        + "      ```\n\n"

                        + "4. **Annotating Classes with Hilt**\n"
                        + "   - Annotate the Application class:\n"
                        + "      ```java\n"
                        + "      @HiltAndroidApp\n"
                        + "      public class MyApplication extends Application {}\n"
                        + "      ```\n\n"
                        + "   - Inject dependencies in an Activity or Fragment:\n"
                        + "      ```java\n"
                        + "      @AndroidEntryPoint\n"
                        + "      public class MainActivity extends AppCompatActivity {\n"
                        + "          @Inject MyDependency myDependency;\n"
                        + "          // Use myDependency in your activity\n"
                        + "      }\n"
                        + "      ```\n\n"

                        + "5. **Defining Modules**\n"
                        + "   - Use `@Module` and `@Provides` annotations to define how dependencies are provided:\n"
                        + "      ```java\n"
                        + "      @Module\n"
                        + "      @InstallIn(SingletonComponent.class)\n"
                        + "      public class AppModule {\n\n"
                        + "          @Provides\n"
                        + "          public MyDependency provideMyDependency() {\n"
                        + "              return new MyDependency();\n"
                        + "          }\n"
                        + "      }\n"
                        + "      ```\n\n"

                        + "Hilt makes dependency injection in Android projects easier and more efficient."
        );

        titleDescriptionMap.put("10. Exploring Jetpack Components",
                "Exploring Jetpack Components\n\n"
                        + "Jetpack is a suite of libraries, tools, and architectural guidance provided by Google to help developers build high-quality Android applications. "
                        + "These components help reduce boilerplate code, handle complex tasks, and support modern app architecture.\n\n"

                        + "1. **Categories of Jetpack Components**\n"
                        + "   - **Foundation**:\n"
                        + "      - Provides backward compatibility and foundational libraries.\n"
                        + "      - Includes components like AppCompat, Android KTX, and Test.\n\n"
                        + "   - **Architecture**:\n"
                        + "      - Helps manage app architecture and UI data.\n"
                        + "      - Includes ViewModel, LiveData, Room, DataStore, and WorkManager.\n\n"
                        + "   - **Behavior**:\n"
                        + "      - Facilitates app behavior like navigation and permissions.\n"
                        + "      - Includes Navigation, Permissions, and Sharing.\n\n"
                        + "   - **UI**:\n"
                        + "      - Enhances the user interface with modern features.\n"
                        + "      - Includes components like RecyclerView, Fragment, Compose, and Animations.\n\n"

                        + "2. **Popular Jetpack Components**\n"
                        + "   - **Navigation**:\n"
                        + "      - Simplifies app navigation and supports a consistent UI flow.\n"
                        + "      - Example:\n"
                        + "         ```java\n"
                        + "         NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);\n"
                        + "         navController.navigate(R.id.action_home_to_details);\n"
                        + "         ```\n\n"
                        + "   - **ViewModel**:\n"
                        + "      - Manages UI-related data in a lifecycle-conscious way.\n"
                        + "      - Ensures data survives configuration changes like screen rotations.\n\n"
                        + "   - **LiveData**:\n"
                        + "      - An observable data holder class for updating the UI automatically when data changes.\n"
                        + "      - Example:\n"
                        + "         ```java\n"
                        + "         liveData.observe(this, data -> {\n"
                        + "             textView.setText(data);\n"
                        + "         });\n"
                        + "         ```\n\n"
                        + "   - **Room**:\n"
                        + "      - A persistence library for managing local databases.\n"
                        + "      - Simplifies database tasks with annotations like `@Entity`, `@Dao`, and `@Query`.\n\n"

                        + "3. **Benefits of Jetpack**\n"
                        + "   - Reduces boilerplate code and simplifies development.\n"
                        + "   - Provides support for modern app architecture and lifecycle management.\n"
                        + "   - Ensures backward compatibility with older Android versions.\n\n"

                        + "4. **Getting Started with Jetpack**\n"
                        + "   - Add required Jetpack dependencies to your `build.gradle` file:\n"
                        + "      ```groovy\n"
                        + "      implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0'\n"
                        + "      implementation 'androidx.navigation:navigation-fragment-ktx:2.6.0'\n"
                        + "      implementation 'androidx.room:room-runtime:2.6.0'\n"
                        + "      kapt 'androidx.room:room-compiler:2.6.0'\n"
                        + "      ```\n\n"
                        + "   - Follow Google's official documentation for more advanced use cases and examples.\n\n"

                        + "Jetpack components empower developers to build scalable, maintainable, and feature-rich Android applications."
        );

    }

    /**
     * Apply styling to the given description.
     * Highlights specific keywords, steps, and headings.
     */
    private SpannableStringBuilder applyStyling(String description) {
        SpannableStringBuilder spannable = new SpannableStringBuilder(description);

        // Highlight specific headings
        String[] headings = {
                "Android operating system",
                "Key Concepts in Android Development",
                "Key Features:",
                "Activities",
                "Services",
                "Intents",
                "Step-by-step guide to installing Android Studio:",
                "Understand how to create a basic app:",
                "Learn about the Android project structure:",
                "Setting Up Android Studio",
                "Building Your First App",
                "Working with Layouts and Views",
                "Activity Lifecycle",
                "Intents for Navigation",
                "MVVM Architecture",
                "Dependency Injection with Hilt",
                "Exploring Jetpack Components"
        };



        for (String heading : headings) {
            int start = spannable.toString().indexOf(heading);
            if (start != -1) {
                spannable.setSpan(new StyleSpan(Typeface.BOLD), start, start + heading.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }

        // Highlight numbered steps
        String[] steps = {"1.", "2.", "3.", "4."};
        for (String step : steps) {
            int start = spannable.toString().indexOf(step);
            while (start != -1) {
                spannable.setSpan(new StyleSpan(Typeface.BOLD), start, start + step.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                start = spannable.toString().indexOf(step, start + 1);
            }
        }

        return spannable;
    }
}
