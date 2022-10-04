/*
 * Secrets.java created on Tue Sep 20 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Secrets {

    private static String HASH_CODE = "k1plinG";;
    private static String strFileHash;
    private static String strURL;
    private static String strDriver;
    private static String strUser;
    private static String strPass;

    /**
     * 
     */
    public void getCredentials() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/model/DB_CREDENTIALS.csv"));
            String line = reader.readLine();
            int intDiscreteCounter = 0;
            while (line != null) {
                switch (intDiscreteCounter) {
                    case 0:
                        strFileHash = line.substring(line.lastIndexOf(",") + 1);
                        break;
                    case 1:
                        strURL = line.substring(line.lastIndexOf(",") + 1);
                        break;
                    case 2:
                        strDriver = line.substring(line.lastIndexOf(",") + 1);
                        break;
                    case 3:
                        strUser = line.substring(line.lastIndexOf(",") + 1);
                        break;
                    case 4:
                        strPass = line.substring(line.lastIndexOf(",") + 1);
                        break;
                    default:
                        break;
                }
                line = reader.readLine();
                intDiscreteCounter++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return boolean
     */
    public boolean csvHashVerifier() {
        int intFileHash = strFileHash.hashCode();
        int intHash = HASH_CODE.hashCode();
        if (intFileHash != intHash) {
            return false;
        }
        return true;
    }

    /**
     * @return String
     */
    public String getHash() {
        return HASH_CODE;
    }

    /**
     * @return String
     */
    public String getURLString() {
        return strURL;
    }

    /**
     * @return String
     */
    public String getDriverString() {
        return strDriver;
    }

    /**
     * @return String
     */
    public String getUsernameString() {
        return strUser;
    }

    /**
     * @return String
     */
    public String getPasswordString() {
        return strPass;
    }

    /**
     * from:
     * https://medium.com/javarevisited/handling-passwords-in-java-swing-and-sql-f0e52002a04c
     * 
     * @param password
     * @return
     */
    public static String encryption(String password) {
        try {
            // retrieve instance of the encryptor of SHA-256
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");// retrieve bytes to encrypt
            byte[] encodedhash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodedhash.length);// perform encryption
            for (int i = 0; i < encodedhash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodedhash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            } // return encrypted value
            return encryptionValue.toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

}
