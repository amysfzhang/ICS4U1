
import java.io.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Stores Items of the same category
 * @author Amy Zhang
 */
public class Category{
    protected String category; //name of the category (always uppercase)
    protected ArrayList<Item> items = new ArrayList<>(); //keeps track of items in a category

    /** 
     * Create a new Category with name
     * @param name The name to use
     */
    public Category(String name) {
        this.category = name;
    }
    
    /** 
     * Creates an item with given parameters to add to the Category
     * @param name The name of the item
     * @param quantity The amount of an item in stock
     * @param minimumQuantity Must be smaller than quantity
     * @param vendorPrice The price the item is brought for
     * @param markupPercentage The percentage the price is increase
     * @param currentDiscount The percentage the price is discounted
     */
    public void add(String name, int quantity, int minimumQuantity, double vendorPrice, double markupPercentage, double currentDiscount) throws IOException {
        items.add(new Item(name, category, quantity, minimumQuantity, vendorPrice, markupPercentage, currentDiscount, size() + 1));
    }
    
    /** 
     * Creates an item with an Object array to add to the Category
     * Specifically made to create items from a line in the file
     * @param item The array with each element in this order: sku, name, category, quantity, minimum quantity, vendor price, markup %, regular price, discount, current price
     */
    public void add(Object[] item) throws IOException {
        items.add(new Item(String.valueOf(item[1]), category, Integer.parseInt(String.valueOf(item[3])), Integer.parseInt(String.valueOf(item[4])), Double.parseDouble(String.valueOf(item[5])), Double.parseDouble(String.valueOf(item[6])), Double.parseDouble(String.valueOf(item[8])), size() + 1));
    }    
    
    /**
     * @return The String of all items in the Category separated by newlines
     */
    @Override
    public String toString() {
        String total = "";
        for (Item item : items) {
            total += item.toString() + "\n";
        }
        return total;
    }
    
    /** 
     * Gets the SKU numbers in a category also known as the total number of items in a category
     * @return The next available SKU number formatted as 4 digits with leading 0s if necessary
     * @throws IOException When the category has 9999 items, the items limit is reached
     */
    public String getSkuNums() throws IOException {
        if (items.size() == 9999) throw new IOException("Category item limit reached");
        return String.format("%04d", size() + 1);
    }
    
    /** 
     * Gets an item by searching through the category using the name
     * @param name The name of an item
     * @return The first Item with a matching name. If not found, returns null
     */
    public Item getItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }   
    
    /** 
     * Gets an item by searching through the category using the index
     * @param index The index of the item, starting with the first item at 0
     * @return The Item at given index
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * @return Name of the category 
     */
    public String getCategoryName() {
        return category;
    }
    
    /**
     * @return The first three letters in the Stock Keeping Unit
     */
    public String getSkuLetters() {
        return category.substring(0,3);
    }
    
    /**
     * @return The number of items in the category
     */
    public int size() {
        return items.size();
    }
}
