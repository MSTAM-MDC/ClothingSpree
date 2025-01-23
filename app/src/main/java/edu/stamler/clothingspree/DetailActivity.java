package edu.stamler.clothingspree;

/*
 *  Created by Michael Stamler on 6/2/24
 */

// Import libraries
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// Class definition header
public class DetailActivity extends AppCompatActivity {

    private SoundEffects mSoundEffects;             // Manages sound effects

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);
        // loads the activity layout XML to display on the app
        setContentView(R.layout.activity_detail);

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
                    startActivity(new Intent(DetailActivity.this, MainActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_list) {
                    // Start ListActivity
                    startActivity(new Intent(DetailActivity.this, ListActivity.class));
                    return true;
                } else if (itemId == R.id.navigation_help) {
                    // Start HelpActivity
                    startActivity(new Intent(DetailActivity.this, HelpActivity.class));
                    return true;
                }
                return false;
            }
        });

        // find the views for the drawable, name, content description, and button to go back to the list view
        ImageView imageView = findViewById(R.id.detail_image);
        TextView nameTextView = findViewById(R.id.detail_name);
        TextView descriptionTextView = findViewById(R.id.detail_description);
        Button backToListButton = findViewById(R.id.back_to_list_button);

        // Apply the animation to the drawable image, name, and content description
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.detail_animation);
        imageView.startAnimation(animation);
        nameTextView.startAnimation(animation);
        descriptionTextView.startAnimation(animation);

        // get the data passed from ListActivity
        int imageResource = getIntent().getIntExtra("imageResource", 0);
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");

        // set the data to the views for the drawable, name, content description
        imageView.setImageResource(imageResource);
        nameTextView.setText(name);
        descriptionTextView.setText(description);

        // set an onclick Listener on the back button
        backToListButton.setOnClickListener(new View.OnClickListener() {
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
            // Stay on MainActivity
            startActivity(new Intent(DetailActivity.this, MainActivity.class));
            return true;
        } else if (itemId == R.id.navigation_list) {
            // Start ListActivity
            startActivity(new Intent(DetailActivity.this, ListActivity.class));
            return true;
        } else if (itemId == R.id.navigation_help) {
            // Start HelpActivity
            startActivity(new Intent(DetailActivity.this, HelpActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

} // end of DetailActivity class



