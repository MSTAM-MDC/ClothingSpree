package edu.stamler.clothingspree;
// Author:  Michael Stamler
// Date:    6/2/2024
// Purpose: Create an application that contains a main activity, list of items, and item list.

// Import libraries
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Class definition header
public class MainActivity extends AppCompatActivity {

    @Override // call back method
    protected void onCreate(Bundle savedInstanceState) {
        // call the parent onCreate method
        super.onCreate(savedInstanceState);
        // loads the activity layout XML to display on the app
        setContentView(R.layout.activity_main);

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
} // end of MainActivity class