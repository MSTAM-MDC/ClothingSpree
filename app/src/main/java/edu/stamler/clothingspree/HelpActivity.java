package edu.stamler.clothingspree;

/*
    Author: Michael Stamler
    Date:   07/11/2024
 */

// import libraries
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

// class definition header
public class HelpActivity extends AppCompatActivity {

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);

        // loads the activity_help layout XML to display on the app
        setContentView(R.layout.activity_help);

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
                if (itemId == R.id.navigation_home) {
                    // Start on MainActivity
                    startActivity(new Intent(HelpActivity.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_list) {
                    // Start on ListActivity
                    startActivity(new Intent(HelpActivity.this, ListActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_help) {
                    // Stay on HelpActivity
                    return true;
                }
                return false;
            }
        });


    } // end onCreate

    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate toolbar menu
        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle toolbar menu item clicks
        int itemId = item.getItemId();
        if (itemId == R.id.navigation_home) {
            // Start on MainActivity
            startActivity(new Intent(HelpActivity.this, MainActivity.class));
            return true;
        } else if (itemId == R.id.navigation_list) {
            // Start on ListActivity
            startActivity(new Intent(HelpActivity.this, ListActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

} // end class