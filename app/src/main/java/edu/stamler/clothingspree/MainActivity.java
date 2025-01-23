package edu.stamler.clothingspree;
// Author:  Michael Stamler
// Date:    6/2/2024
// Purpose: Create an application that contains a main activity, list of items, and item list.

// Import libraries
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.widget.Toolbar;


// Class definition header
public class MainActivity extends AppCompatActivity {

    private SoundEffects mSoundEffects;             // Manages sound effects

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);
        // loads the activity layout XML to display on the app
        setContentView(R.layout.activity_main);

        // initialize sound effects
        mSoundEffects = SoundEffects.getInstance(getApplicationContext());

        // loads the toolbar by its ID
        Toolbar toolbar = findViewById(R.id.toolbar);
        // sets the action bar
        setSupportActionBar(toolbar);

        // Find the BottomNavigationView by ID
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        // Set an item selected listener for the BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks
                int itemId = item.getItemId();

                // Play a sound effect
                mSoundEffects.playToneNavigation();

                if (itemId == R.id.navigation_home) {
                    // Stay on MainActivity
                    return true;
                } else if (itemId == R.id.navigation_list) {
                    // Start ListActivity
                    startActivity(new Intent(MainActivity.this, ListActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_help) {
                    // Start HelpActivity
                    startActivity(new Intent(MainActivity.this, HelpActivity.class));
                    return true;
                }
                return false;
            } // end onNavigationItemSelected
        });

        // set variable to find the start button
        Button startButton = findViewById(R.id.start_button);

        // set an onClickListener on the start button for when a user clicks on the start button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play a sound effect
                mSoundEffects.playToneStart();
                // create an intent during onClick to start the ListActivity java class
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                // start ListActivity java class
                startActivity(intent);
            } // end onClick
        });
    } // end onCreate

    // Trigger the intro sound effect and animation with the focus of the activity window
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            if (mSoundEffects != null) {
                mSoundEffects.playIntro();
                // Play animation
                ImageView logo = findViewById(R.id.imageView2);
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
                logo.startAnimation(animation);
            }
        }
    } // end onWindowFocusChanged

    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate toolbar menu
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return true;
    } // end onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle toolbar menu item clicks
        int itemId = item.getItemId();
        if (itemId == R.id.navigation_home) {
            // Stay on MainActivity
            return true;
        } else if (itemId == R.id.navigation_list) {
            // Start List Activity
            startActivity(new Intent(MainActivity.this, ListActivity.class));
            return true;
        } else if (itemId == R.id.navigation_help) {
            // Start HelpActivity
            startActivity(new Intent(MainActivity.this, HelpActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    } // onOptionsItemSelected

    // Method called when the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();          // Call to superclass
        mSoundEffects.release();    // Release sound effects resources
    } // end onDestroy

} // end of MainActivity class