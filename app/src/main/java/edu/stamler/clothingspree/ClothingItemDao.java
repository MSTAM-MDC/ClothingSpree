package edu.stamler.clothingspree;

// import classes needed
import androidx.room.*;
import java.util.List;
import edu.stamler.clothingspree.ClothingItem;

/**
 * Created by Michael Stamler on 11/03/24
 */

@Dao
public interface ClothingItemDao {

    // Query to retrieve a single item by ID
    @Query("SELECT * FROM clothing_items WHERE clothing_id = :id")
    ClothingItem getClothingItemById(long id);

    // Query to retrieve all items and order by name
    @Query("SELECT * FROM clothing_items ORDER BY name COLLATE NOCASE")
    List<ClothingItem> getAllClothingItems();

    // Insert method with replace strategy in case of conflict
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addClothingItem(ClothingItem clothingItem);

    // Delete duplicates by clearing existing data
    @Query("DELETE FROM clothing_items")
    void deleteAll();

} // end of ClothingItemDao
