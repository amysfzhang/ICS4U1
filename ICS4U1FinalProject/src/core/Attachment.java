package core;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.text.*;
import java.util.*;

/**
 * Stores information about an Attachment of an entry (connected by date)
 * @author Amy Zhang
 */
public class Attachment {
    private File file;
    private Date date;
    private User user;
    private String name;

    /**
     * Constructor to initialize an Attachment
     * @param file The locaiton of the Attachment in a User's directory
     * @param user The user the Attachment is under
     */
    public Attachment(File file, User user) {
        this.file = file;
        this.user = user;
        
        try {
            //Decrypts file name
            String fileName = new String(SecureUtil.decryptFileName(user.getPasswordKey(), SecureUtil.fromHexString(file.getName())));
            this.date = DateFormat.getDateInstance().parse(fileName.substring(0, fileName.indexOf("A!")));
            this.name = fileName.substring(fileName.indexOf("A!") + 2);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
    }
    
    /**
     * Sets the date of the attachment, renames file
     * @param date The date to be renamed to
     */
    public void setDate(Date date) {
        this.date = date;

        //newFile name contains: date, "A!" to signify it's an attachment, original file name
        String fileName = "";
        fileName += DateFormat.getDateInstance().format(date);
        fileName += "A!";
        fileName += file.getName();
        //Copies the old file to new location
        try {
            fileName = user.getDirectory() + "\\" + HexFormat.of().formatHex(SecureUtil.encryptFileName(user.getPasswordKey(), fileName.getBytes("UTF-8")));
            File newFile = new File(fileName);
            if (file.renameTo(newFile)) {
                this.file = newFile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Get the value of date
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Get the value of file
     * @return the value of file
     */
    public File getFile() {
        return file;
    }
    
    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName() {
        return name;
    }
}
