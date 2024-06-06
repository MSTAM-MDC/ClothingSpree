package edu.stamler.clothingspree;

/*
 *  Created by Michael Stamler on 6/2/24
 */

// Import libraries
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

// Class definition header
public class DetailActivity extends AppCompatActivity {

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);
        // loads the activity layout XML to display on the app
        setContentView(R.layout.activity_detail);

        // find the views for the drawable, name, content description, and button to go back to the list view
        ImageView imageView = findViewById(R.id.detail_image);
        TextView nameTextView = findViewById(R.id.detail_name);
        TextView descriptionTextView = findViewById(R.id.detail_description);
        Button backToListButton = findViewById(R.id.back_to_list_button);

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
} // end of DetailActivity class



