package edu.stamler.clothingspree;

/*
 *  Created by Michael Stamler on 6/2/24
 */

// Import libraries
import android.app.Activity;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

// Class definition header
public class ClothingItemAdapter extends ArrayAdapter<ClothingItem> {

    // Constructor to initialize the adapter
    public ClothingItemAdapter(Activity context, ArrayList<ClothingItem> clothingItems) {
        super(context, 0, clothingItems);
    }

    // method to create and return the views for each item in the list
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            // inflate the layout for the list item
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // get the current clothing item
        ClothingItem currentItem = getItem(position);

        // find and set the ImageView of the clothing image
        ImageView imageView = listItemView.findViewById(R.id.clothing_image);
        imageView.setImageResource(currentItem.getImageResource());

        // find and set the TextView of the clothing name
        TextView nameTextView = listItemView.findViewById(R.id.clothing_name);
        nameTextView.setText(currentItem.getName());

        // return the completed list item view
        return listItemView;
    }

} // end of ClothingItemAdapter class
