package core;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import java.io.*;
import java.text.*;

//Converting markdown to HTML
import com.github.rjeschke.txtmark.Processor;
import com.github.rjeschke.txtmark.Configuration;
//JCA
import javax.crypto.*;

/**
 * Stores information about the Entry of a User (cannot exist without)
 * @author Amy Zhang
 */
public class Entry {
    private Date date;
    private File file;
    private final User USER;
    private boolean bookmarked = false;
    private ArrayList<Attachment> attachments = new ArrayList();
    
    /**
     * Creates the path of an Entry
     * @param date The date that the Entry is associated with
     * @param user The user that holds the Entry
     * @return Entry The Entry that is created
     */
    public static Entry createEntry(Date date, User user) {
        //creating filepath, markdown extension
        byte[] text = (DateFormat.getDateInstance().format(date) + "0.md").getBytes();
        File file = new File(user.getDirectory() + "\\" + HexFormat.of().formatHex(SecureUtil.encryptFileName(user.getPasswordKey(), text)));
        //creates file
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return new Entry(file, user); //creates a new Entry object
    }

    /**
     * Creates an Entry that stores information about the Entry
     * @param file the text that is stored in an entry
     */
    public Entry(File file, User user) {
        this.file = file;
        this.USER = user;
        try {
            //Gets information about date and bookmark state from decrypted file name
            String fileName = new String(SecureUtil.decryptFileName(user.getPasswordKey(), SecureUtil.fromHexString(file.getName())));
            this.date = DateFormat.getDateInstance().parse(fileName.substring(0, fileName.length()-4));
            if (fileName.split("\\.")[0].endsWith("1")) this.bookmarked = true;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Gets the file of this Entry
     * @return the file 
     */
    public File getFile() {
        return file;
    }
    
    /**
     * Gets the decrypted text in the Entry
     * @return The text that is contained in the Entry
     */
    public String[] getContent() {
        ArrayList<String> lines = new ArrayList<>();
        //reads the text in the Entry
        try (FileInputStream fis = new FileInputStream(file)){
            byte[] iv = new byte[16];
            fis.read(iv); //random used to scramble text
            Cipher cipher = SecureUtil.makeDecryptCipher(USER.getPasswordKey(), iv);
            //decrypting the file
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new CipherInputStream(fis, cipher)))) {
                String line = "";
                while ((line = br.readLine()) != null) { //errpromg
                    lines.add(line);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return lines.toArray(new String[lines.size()]);
    }
    
    /**
     * Rewrites the file with the content given, then encrypts the text
     * @param lines The content that the file will be replaced with
     */
    public void setContent(String[] lines) {
        byte[] iv = new byte[16];
        Cipher cipher = SecureUtil.makeEncryptCipher(USER.getPasswordKey(), iv);
        
        // Resource: https://www.baeldung.com/java-cipher-input-output-stream
        try (
            FileOutputStream fos = new FileOutputStream(this.file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new CipherOutputStream(fos, cipher)));
        ) {
            fos.write(iv); //iv is used to decrypt afterwards
            for (String line : lines) {
                bw.write(line); //automaticly encrypted using cipherOutputStream
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Converts markdown in the Entry to HTML
     * @return The String of content in the Entry in HTML
     */
    public String toHTML() {
        //uses txtmark library
        Configuration config = Configuration.builder().forceExtentedProfile().build();
        return Processor.process(String.join("\n", getContent()), config);
    }
    
    /**
     * Gets the files of the attachments for this entry
     * @return ArrayList that contains all the files or null if no attachments
     */
    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }
    
    /**
     * Adds an attachment to the Entry
     * @param attachment the Attachment to be added
     */
    public void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }
    
    /**
     * Gets the date associated with the entry when initiated
     * @return the date of the entry
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Renames the file to a new date
     * @param date The date to be associated with the entry
     */
    public void setDate(Date date) {
        this.date = date;

        //New file path contains: date, "1" for bookmarked or "0" for not, markdown extension
        String fileName = "";
        fileName += DateFormat.getDateInstance().format(date);
        fileName += bookmarked ? "1" : "0";
        fileName += ".md";
        //Copies the old file to new location
        try {
            fileName = USER.getDirectory() + "\\" + HexFormat.of().formatHex(SecureUtil.encryptFileName(USER.getPasswordKey(), fileName.getBytes("UTF-8")));
            File newFile = new File(fileName);
            if (file.renameTo(newFile))
                this.file = newFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Changes date on attachments
        for (Attachment file : attachments) {
            file.setDate(date);
        }
    }
    
    /**
     * Checks if the Entry is bookmarked
     * @return true if bookmarked, false otherwise
     */
    public boolean isBookmarked() {
       return bookmarked; 
    }
    
    /**
     * Sets the bookmark state to the given (either true or false)
     * @param state true if the entry is bookmarked, false otherwise
     */
    public void setBookmark(boolean state) {
        if (state == bookmarked) return;
        bookmarked = state;
        
        //New file path contains: date, "1" for bookmarked or "0" for not, markdown extension
        String fileName = "";
        fileName += DateFormat.getDateInstance().format(date);
        fileName += bookmarked ? "1" : "0";
        fileName += ".md";
        //Copies the old file to new location
        try {
            fileName = USER.getDirectory() + "\\" + HexFormat.of().formatHex(SecureUtil.encryptFileName(USER.getPasswordKey(), fileName.getBytes("UTF-8")));
            File newFile = new File(fileName);
            if (file.renameTo(newFile))
                this.file = newFile;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
