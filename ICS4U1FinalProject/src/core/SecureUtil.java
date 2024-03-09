package core;

//File IO related
import java.io.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.util.*;
//JCA library
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * Helper functions related to encrypting and decrypting data
 * @author amy
 */
public abstract class SecureUtil {
    
    /**
     * Computes hash of input
     * @param in The data to be hashed
     * @return The hashed data
     */
    public static byte[] hash(byte[] in) {
        //Documentation: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/security/MessageDigest.html
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(in); //completes hash computation
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Computes hash of username and password hashed
     * @param username The username to be hashed
     * @param password The password to be hashed
     * @return The hashed data
     */
    public static byte[] hashPassword(String username, char[] password) {
        try {
            // Converting string to btye array
            byte[] usernameBytes = username.getBytes("UTF-8");
            // Converting char array to byte array: https://stackoverflow.com/questions/5513144/converting-char-to-byte
            CharBuffer charBuffer = CharBuffer.wrap(password);
            ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
            byte[] passwordBytes = hash(Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
            
            //hash both arrays together
            return hash(ByteBuffer
                    .allocate(usernameBytes.length + passwordBytes.length) //size of btye array
                    .put(usernameBytes)
                    .put(passwordBytes)
                    .array()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Computes the hash of a user's username and password
     * @param username The username of the user, first part of hashed text
     * @param password The Password of the user, second part of hashed text
     * @return The hash of both parts
     */
    public static byte[] hashUsernamePassword(String username, char[] password) {
        try {
            // Converting string to btye array
            byte[] usernameBytes = username.getBytes("UTF-8");
            // Converting char array to byte array: https://stackoverflow.com/questions/5513144/converting-char-to-byte
            CharBuffer charBuffer = CharBuffer.wrap(password);
            ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
            byte[] passwordBytes = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
            
            //hash both arrays together
            return hash(ByteBuffer
                    .allocate(usernameBytes.length + passwordBytes.length) //size of btye array
                    .put(usernameBytes)
                    .put(passwordBytes)
                    .array()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Makes an encryption cipher used to encrypt files
     * @param key The key containing hash of the password
     * @param iv The initialization vector, random put at start of file
     * @return The cipher used to encrypt data
     */
    public static Cipher makeEncryptCipher(byte[] key, byte[] iv) {
        //Converting btye to SecretKey: https://stackoverflow.com/questions/14204437/convert-byte-array-to-secret-key
        SecretKey secret = new SecretKeySpec(key, "AES");
        Cipher cipher;
        new SecureRandom().nextBytes(iv);  // prevent same plaintext from outputting same ciphertext
        //Creates Cipher
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret, new IvParameterSpec(iv));
            return cipher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Makes a decryption cipher used to encrypt files
     * @param key The key containing hash of the password
     * @param iv The initialization vector, random put at start of file
     * @return The cipher used to decrypt data
     */
    public static Cipher makeDecryptCipher(byte[] key, byte[] iv) {
        //Converting btye to SecretKey: https://stackoverflow.com/questions/14204437/convert-byte-array-to-secret-key
        SecretKey secret = new SecretKeySpec(key, "AES");
        Cipher cipher;
        //Creates Cipher
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
            return cipher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Encrypts the file name of a file or plain text
     * @param key The passwordKey used to encrypt text, known by user
     * @param plainText The text to be encrypted
     * @return The encrypted text
     */
    public static byte[] encryptFileName(byte[] key, byte[] plainText) {
        byte[] iv = new byte[16]; //creates iv to be stored at start of file
        Cipher cipher = makeEncryptCipher(key, iv);
        //Encrypting text
        try {
            byte[] ciphertext = cipher.doFinal(plainText);
            return ByteBuffer.allocate(iv.length + ciphertext.length)
                    .put(iv) //not encrypted, used to decrypt
                    .put(ciphertext) //encrypted text
                    .array();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Decrypts the file name of a file or cipher text
     * @param key The passwordKey used during encryption, known by user
     * @param cipherText The text that is ciphered
     * @return The decrypted text
     */
    public static byte[] decryptFileName(byte[] key, byte[] cipherText) {
        byte[] iv = Arrays.copyOfRange(cipherText, 0, 16); //copies first 16 bytes which is the iv
        Cipher cipher = makeDecryptCipher(key, iv);
        cipherText = Arrays.copyOfRange(cipherText, 16, cipherText.length); //rest is ciphertext
        //Decrypting text
        try {
            return cipher.doFinal(cipherText);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Encrypts the contents of a file
     * @param input The file to be encrypted
     * @param output The destination of the encrypted contents
     * @param key The passwordKey used to  encrypt, known by user 
     */
    public static void encryptFile(File input, File output, byte[] key) {
        byte[] iv = new byte[16]; //creates iv to be stored at start of file
        Cipher cipher = SecureUtil.makeEncryptCipher(key, iv);
        //Encrypting text
        try (
            FileInputStream fis = new FileInputStream(input); 
            FileOutputStream fos = new FileOutputStream(output); 
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);
        ) {
            fos.write(iv); //Writes iv into file unencrypted, used for decryption
            while (fis.available() != 0) {
                cos.write(fis.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decrypts the contents of a file
     * @param input The file to be decrypted
     * @param output The destination of the decrypted contents
     * @param key The passwordKey used to decrypt, known by user 
     */
    public static void decryptFile(File input, File output, byte[] key) {
        try (FileInputStream fis = new FileInputStream(input)) {
            byte[] iv = new byte[16]; 
            fis.read(iv); //reads first 16 bytes which is the iv
            Cipher cipher = SecureUtil.makeDecryptCipher(key, iv);
            //Decrypting text
            try (
                FileOutputStream fos = new FileOutputStream(output); 
                CipherInputStream cos = new CipherInputStream(fis, cipher);
            ) {
                int bit;
                while ((bit = cos.read()) != -1) {
                    fos.write(bit);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Converts a Hex string to btye array
     * @param s The String to be converted
     * @return The bytes of the converted string
     */
    public static byte[] fromHexString(String s) {
        //Source: https://stackoverflow.com/a/4581156
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    } 
    
}
