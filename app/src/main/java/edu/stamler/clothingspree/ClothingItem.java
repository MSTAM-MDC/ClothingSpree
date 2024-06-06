package edu.stamler.clothingspree;

// class representing a clothing item
public class ClothingItem {
    private int imageResource;
    private String name;
    private String description;

    // constructor to initialize the clothing item
    public ClothingItem(int imageResource, String name, String description) {
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
    }

    // get method for the ImageResource
    public int getImageResource() {

        return imageResource;
    }

    // get method for the Name of the clothing article
    public String getName() {

        return name;
    }

    // get method for the Name of the content description for the clothing article
    public String getDescription() {

        return description;
    }

} // end of ClothingItem class
