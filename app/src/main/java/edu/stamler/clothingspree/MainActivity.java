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
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.widget.Toolbar;


// Class definition header
public class MainActivity extends AppCompatActivity {

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);
        // loads the activity layout XML to display on the app
        setContentView(R.layout.activity_main);

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
            }
        });

        // set variable to find the start button
        Button startButton = findViewById(R.id.start_button);

        // set an onClickListener on the start button for when a user clicks on the start button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an intent during onClick to start the ListActivity java class
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                // start ListActivity java class
                startActivity(intent);
            }
        });
    }


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
    }



} // end of MainActivity class