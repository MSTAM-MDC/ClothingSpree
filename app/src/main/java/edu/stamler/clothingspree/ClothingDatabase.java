package edu.stamler.clothingspree;

// import classes needed
import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Michael Stamler on 11/03/24
 */

@Database(entities = {ClothingItem.class}, version = 1)
public abstract class ClothingDatabase extends RoomDatabase {

    // Abstract method to get an instance of the DAO
    public abstract ClothingItemDao clothingItemDao();

} // end of ClothingDatabase class
