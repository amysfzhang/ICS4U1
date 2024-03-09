package core;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.text.*;

/**
 * Stores and accesses Entries of each user
 * @author amy
 */
public class User {
    //maximum amount of user possible. Folders are named random generated integers within this range
    private static final int USERMAX = 10000; 
    
    private String username;
    private final byte[] PASSWORDKEY;
    private final File DIRECTORY;
    private ArrayList<Entry> entries = new ArrayList<>();
    
    /**
     * Constructor to create instance of User
     * @param passwordKey the hash of the User's password, used to encrypt and decrypt
     */
    public static User createUser(byte[] passwordKey) {
        Random rand = new Random(); //directory name of this user
        File dir;
        //creates folder if not previously existing
        while (true) {
            dir = new File("users\\" + String.valueOf((int) (rand.nextDouble()* USERMAX)));
            if (!dir.exists()) {
                dir.mkdirs();
                break;
            }
        }
        return new User(passwordKey, dir);
    }
    
    /**
     * Constructor to create instance of User
     * @param passwordKey The hash of the User's password
     * @param directory The User's folder
     */
    public User(byte[] passwordKey, File directory) {
        this.username = username;
        this.PASSWORDKEY = passwordKey;
        this.DIRECTORY = directory;
        //Loops through all files in user DIRECTORY to add as Entry. Checks if contains A! when decrypted
        for (File file : this.getDirectory().listFiles()) {
            if (!new String(SecureUtil.decryptFileName(passwordKey, SecureUtil.fromHexString(file.getName()))).contains("A!")) {
                this.addEntry(file);
            }
        }
        //Loops through all files in user DIRECTORY to add as Attachment. Checks if contains A! when decrypted
        for (File file : this.getDirectory().listFiles()) {
            if (new String(SecureUtil.decryptFileName(passwordKey, SecureUtil.fromHexString(file.getName()))).contains("A!")) {
                Attachment attachment = new Attachment(file, this);
                this.getEntry(attachment.getDate()).addAttachment(attachment);
            }
        }

    }
    
    /**
     * Creates an new Entry object in User's entries
     * @param file the date that the entry will be stored at
     */
    public void addEntry(File file) {
        entries.add(new Entry(file, this));
    }
    
    /**
     * Adds an existing Entry object in User's entries
     * @param entry The existing Entry to be stored
     */
    public void addEntry(Entry entry) {
        entries.add(entry);
    }
        
    /**
     * Removes the Entry object in User's entries
     * @param entry The entry to be removed
     */
    public void removeEntry(Entry entry) {
        entries.remove(entry);
    }
    
    /**
     * Gets the all entries from this user
     * @return The entries ArrayList
     */
    public ArrayList<Entry> getEntries() {
        return entries;
    }
        
    /**
     * Gets the Entry in the User with the corresponding date
     * @param date the date associated with the entry
     * @return the Entry if found or null if none match the date
     */
    public Entry getEntry(Date date) {
        try {
            return entries.stream()
                //checks if the dates are equal using the 
                .filter(e -> DateFormat.getDateInstance().format(e.getDate()).equals(DateFormat.getDateInstance().format(date)))
                .collect(Collectors.toList())
                .getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    
    /**
     * Gets the DIRECTORY of the User
     * @return the File object with the DIRECTORY of User
     */
    public File getDirectory() {
        return DIRECTORY;
    }
    
    /**
     * Gets the passwordKey of the User. Used to encrypt and decrypt all files
     * @return the PASSWORDKEY of the User
     */
    public byte[] getPasswordKey() {
        return PASSWORDKEY;
    }

}
