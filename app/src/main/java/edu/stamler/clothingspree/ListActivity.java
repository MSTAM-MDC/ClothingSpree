package edu.stamler.clothingspree;

/*
 *  Created by Michael Stamler on 6/2/24
 */

// Import libraries
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

// Class definition header
public class ListActivity extends AppCompatActivity {

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);
        // loads the activity layout XML to display on the app
        setContentView(R.layout.activity_list);

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
                    startActivity(new Intent(ListActivity.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_list) {
                    // Stay on ListActivity
                    return true;
                } else if (itemId == R.id.navigation_help) {
                    // Start HelpActivity
                    startActivity(new Intent(ListActivity.this, HelpActivity.class));
                    return true;
                }
                return false;
            }
        });

        // set variable to find the clothing list view
        ListView clothingListView = findViewById(R.id.clothing_list);

        // set variable to find the back button
        Button backButton = findViewById(R.id.back_button);

        // create a list of clothing items which is put in an array list with the drawable, name, and content description
        ArrayList<ClothingItem> clothingItems = new ArrayList<>();
        clothingItems.add(new ClothingItem(R.drawable.lacedress, "Lace Maxi Dress", "Button-embellished leather-trimmed lace maxi dress. It's belted at the waist and has a flowing maxi-length skirt."));
        clothingItems.add(new ClothingItem(R.drawable.silkdress, "Silk Maxi Dress", "Open-back asymmetric silk crepe de chine maxi dress. This maxi dress turns to reveal a skin-baring open back."));
        clothingItems.add(new ClothingItem(R.drawable.silktop, "Silk Sequined Top", "Silk and ponte-trimmed sequined stretch-jersey top. This top is made from sequined stretch-jersey that's paneled with stretch-ponte across the collar - the supple, scuba-like textile creates a comfortable glove-like fit."));
        clothingItems.add(new ClothingItem(R.drawable.velvetblazer, "Velvet Blazer", "Tailored from cotton-velvet, the blazer is embellished with gold-tone 'GG' hardware at the pockets and has sharp peak lapels."));
        clothingItems.add(new ClothingItem(R.drawable.woolcoat, "Wool and Silk-blend Coat", "Reversible wool and silk-blend coat. This coat can be worn on the solid or logo patterned side."));

        // create an adapter to display the clothing items in the ListView
        ClothingItemAdapter adapter = new ClothingItemAdapter(this, clothingItems);
        clothingListView.setAdapter(adapter);

        // set an item click listener on the ListView for when a user clicks
        clothingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the clicked item
                ClothingItem clickedItem = (ClothingItem) parent.getItemAtPosition(position);

                // create an intent to start DetailActivity java class
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);

                // pass the item details to DetailActivity
                intent.putExtra("imageResource", clickedItem.getImageResource());
                intent.putExtra("name", clickedItem.getName());
                intent.putExtra("description", clickedItem.getDescription());

                // start ListActivity java class
                startActivity(intent);
            }

        });
        // set an onClickListener on the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // user can tap the back button to finish the current activity and go back to the previous activity
                finish();
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
            // Start on MainActivity
            startActivity(new Intent(ListActivity.this, MainActivity.class));
            return true;
        } else if (itemId == R.id.navigation_list) {
            // Stay on ListActivity
            return true;
        } else if (itemId == R.id.navigation_help) {
            // Start HelpActivity
            startActivity(new Intent(ListActivity.this, HelpActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

} // end of ListActivity class
