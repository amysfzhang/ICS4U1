
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Stores information about a type of item in a grocery store
 * @author Amy
 */
public class Item {
    private String sku; //The Stock Keeping Unit (SKU) consists of 3 letters (upper-case), followed by a dash, followed by 4 numbers
    private String name; //The name of the item, unqiue to each item
    private String category; //The category the item belongs too, should be in all caps
    
    private int quantity; //On hand quantity currently available in the inventory
    private int minimumQuantity; //Minimum Quantity must always be smaller than the quantity
    
    private double vendorPrice; //Price the Item is bought from the vendor for
    private double markupPercentage; //Percentage increase that the store is selling the item for compared to the vendor price
    private double regularPrice; //Price calculated by multiplying in the vendor price and markup percentage
    private double currentDiscount; //The percentage the item is discounted for by the store comapred to the regular price
    private double currentPrice; //The Price caluclated (100-discounted percent-off) multipled by the regular price
    
    /**
     * Creates an Item with the given parameters
     * @param name
     * @param category
     * @param quantity
     * @param minimumQuantity
     * @param vendorPrice
     * @param markupPercentage
     * @param currentDiscount
     * @param totalItems 
     */
    public Item(String name, String category, int quantity, int minimumQuantity, double vendorPrice, double markupPercentage, double currentDiscount, int totalItems) throws IOException {
        this.sku = category.substring(0,3) + "-" + String.format("%03d", totalItems);
        this.name = name;
        this.category = category;
        
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        
        this.vendorPrice = vendorPrice;
        this.markupPercentage = markupPercentage;
        this.regularPrice = Math.round((vendorPrice * (1 + markupPercentage / 100.0)) * 100) / 100.0;
        this.currentDiscount = currentDiscount;
        this.currentPrice = Math.round(regularPrice * (100 - currentDiscount)) / 100.0;
        if (currentPrice < 0) throw new IOException("Current Price is negative");
    }
    
    /**
     * Creates an item with an Object array. Specifically added to ease reading from file.
     * @param item
     * @param totalItems 
     */
    public Item(Object[] item, int totalItems) {
        this.sku = category.substring(0,3) + "-" + String.format("%03d", totalItems);
        this.name = String.valueOf(item[1]);
        this.category = String.valueOf(item[2]);
        
        this.quantity = Integer.parseInt(String.valueOf(item[3]));
        this.minimumQuantity = Integer.parseInt(String.valueOf(item[4]));
        
        this.vendorPrice = Double.parseDouble(String.valueOf(item[5]));
        this.markupPercentage = Double.parseDouble(String.valueOf(item[6]));
        this.regularPrice = Double.parseDouble(String.valueOf(item[7]));        
        this.currentDiscount = Double.parseDouble(String.valueOf(item[8]));
        this.currentPrice = Double.parseDouble(String.valueOf(item[9]));
    }
    
    /**
     * @return the values of the item separated by commas
     */
    @Override
    public String toString() {
        return getSku() + "," + name + "," + category + "," + quantity + "," + minimumQuantity + "," + vendorPrice + "," + markupPercentage + "," + getRegularPrice() + "," + currentDiscount + "," + getCurrentPrice();
    }

    /**
     * @returns The name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * @returns The category name of the item in all uppercase
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * @returns The Stock Keeping Unit of the item in this format: XXX-0000
     */
    public String getSku() {
        return sku;
    }

    /**
     * @returns The quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @returns The minimum quantity of the item
     */
    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
     * @returns The vendor price of the item
     */
    public double getVendorPrice() {
        return vendorPrice;
    }

    /**
     * @returns The markup percentage of the item
     */
    public double getMarkupPercentage() {
        return markupPercentage;
    }

    /**
     * @returns The regular price of the item
     */
    public double getRegularPrice() {
        return regularPrice;
    }
    
    /**
     * @returns The current discount of the item
     */
    public double getCurrentDiscount() {
        return currentDiscount;
    }
    
    /**
     * @returns The current price of the item
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * @param sku The Stock Keeping Unit to change into
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * @param name The name to change into
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param category The category to change into
     */
    public void setCategory(String category) {
        category = category;
    }

    /**
     * @param quantity The quantity to change into
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param minimum quantity The minimum quantity to change into
     */
    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    /**
     * @param vendorPrice The vendor price to change into
     */
    public void setVendorPrice(double vendorPrice) {
        this.vendorPrice = vendorPrice;
    }

    /**
     * @param markupPercentage The markup percentage to change into
     */
    public void setMarkupPercentage(double markupPercentage) {
        this.markupPercentage = markupPercentage;
    }
    
    /**
     * @param regularPrice The regular price to change into
     */
    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    /**
     * @param currentDiscount The current discount to change into
     */
    public void setCurrentDiscount(double currentDiscount) {
        this.currentDiscount = currentDiscount;
    }
    
    /**
     * @param currentPrice The current price to change into
     */
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
