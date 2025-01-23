package edu.stamler.clothingspree;

// import classes needed
import android.content.Context;
import androidx.room.Room;
import java.util.List;

/**
 * Created by Michael Stamler on 11/03/24
 */

public class ManageClothing {

    //Singleton instance
    private static ManageClothing repo;
    private final ClothingItemDao clothingItemDao;

    // Private constructor for singleton pattern
    private ManageClothing(Context context) {
        // Initialize the database and DAO
        ClothingDatabase database = Room.databaseBuilder(context, ClothingDatabase.class, "clothing.db")
                .allowMainThreadQueries()
                .build();

        clothingItemDao = database.clothingItemDao();

        // Add default / starter data
        addDefaultData();
    } // end ManageClothing

    // Singleton instance getter
    public static ManageClothing getInstance(Context context) {
        if (repo == null){
            repo = new ManageClothing(context);
        }
        return repo;
    } // end ManageClothing getInstance

    // Method to get all clothing items
    public List<ClothingItem> getAllClothingItems() {
        return clothingItemDao.getAllClothingItems();
    } // end List<ClothingItem> getAllClothingItems

    // Method to get a single clothing item by ID
    public ClothingItem getClothingItemById(long id) {
        return clothingItemDao.getClothingItemById(id);
    } // end ClothingItem

    // Method to add a single clothing item
    public void addClothingItem(ClothingItem clothingItem) {
        clothingItemDao.addClothingItem(clothingItem);
    } // end addClothingItem

    // Method to add default starter data if database is empty
    private void addDefaultData() {
        // Clear existing data to avoid duplicates
        clothingItemDao.deleteAll();

        // Add default starter data clothing items with drawable resource
        ClothingItem hoodedJacket = new ClothingItem(R.drawable.hoodedjacket, "Cropped Hooded Jacket", "Stay snug through cool transitions with Gucci's fluffy shearling jacket. Featuring a generous hood for windy days and a leather chest patch debossed with the brand's moniker.");
        ClothingItem leatherJacket = new ClothingItem(R.drawable.leatherjacket, "Paneled Leather Jacket", "Iconic 'GG' monogram, a flattering waist, and leather panels in 'Ancorra,'. Neat collar, four flap pockets, and streamlined covered buttons. Perfectly crafted.");
        ClothingItem laceMaxiDress = new ClothingItem(R.drawable.lacedress, "Lace Maxi Dress", "Button-embellished leather-trimmed lace maxi dress. It's belted at the waist and has a flowing maxi-length skirt.");
        ClothingItem silkMaxiDress = new ClothingItem(R.drawable.silkdress, "Silk Maxi Dress", "Open-back asymmetric silk crepe de chine maxi dress. This maxi dress turns to reveal a skin-baring open back.");
        ClothingItem silkTop = new ClothingItem(R.drawable.silktop, "Silk Sequined Top", "Silk and ponte-trimmed sequined stretch-jersey top. This top is made from sequined stretch-jersey that's paneled with stretch-ponte across the collar - the supple, scuba-like textile creates a comfortable glove-like fit.");
        ClothingItem velvetBlazer = new ClothingItem(R.drawable.velvetblazer, "Velvet Blazer", "Tailored from cotton-velvet, the blazer is embellished with gold-tone 'GG' hardware at the pockets and has sharp peak lapels.");
        ClothingItem woolCoat = new ClothingItem(R.drawable.woolcoat, "Wool and Silk-blend Coat", "Reversible wool and silk-blend coat. This coat can be worn on the solid or logo patterned side.");

        // Insert each clothing item into the database
        clothingItemDao.addClothingItem(hoodedJacket);
        clothingItemDao.addClothingItem(leatherJacket);
        clothingItemDao.addClothingItem(laceMaxiDress);
        clothingItemDao.addClothingItem(silkMaxiDress);
        clothingItemDao.addClothingItem(silkTop);
        clothingItemDao.addClothingItem(velvetBlazer);
        clothingItemDao.addClothingItem(woolCoat);
    } // end addDefaultData
} // end of ManageClothing class
