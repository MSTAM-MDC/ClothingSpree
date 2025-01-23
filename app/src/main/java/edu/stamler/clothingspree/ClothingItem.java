package edu.stamler.clothingspree;

// import classes needed
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
import androidx.annotation.NonNull;

// class representing a clothing item
@Entity(tableName = "clothing_items")
public class ClothingItem {

    // Primary Key with auto generation
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "clothing_id")
    private long clothingId;

    // Additional fields with the column info
    @NonNull
    @ColumnInfo(name = "image_resource")
    private int imageResource;

    @NonNull
    @ColumnInfo(name ="name")
    private String name;

    @ColumnInfo(name ="description")
    private String description;

    // constructor to initialize the clothing item without the auto-generated primary key
    public ClothingItem(int imageResource, @NonNull String name, String description) {
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
    } // end ClothingItem

    // get method for the getClothingId
    public long getClothingId() {
        return clothingId;
    } // end getClothingId

    // set method for the setClothingId
    public void setClothingId(long clothingId) {
        this.clothingId = clothingId;
    } // end setClothingId

    // get method for the ImageResource
    public int getImageResource() {

        return imageResource;
    } // end getImageResource

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    } // end setImageResource

    // get method for the Name of the clothing article
    @NonNull
    public String getName() {

        return name;
    } // end getName

    // set method for the name of the clothing article
    public void setName(@NonNull String name) {
        this.name = name;
    } // end setName

    // get method for the Name of the content description for the clothing article
    public String getDescription() {

        return description;
    } // end getDescription

    // set method for the description of the content description for the clothing article
    public void setDescription(String description) {
        this.description = description;
    } // end setDescription

} // end of ClothingItem class
