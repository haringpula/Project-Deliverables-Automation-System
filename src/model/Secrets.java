/*
 * Secrets.java created on Tue Sep 20 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Secrets {
    
    private static String strURL;
	private static String strDriver;
	private static String strUser;
	private static String strPass;

    /**
     * 
     */
    public static void getCredentials() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/model/DB_CREDENTIALS.csv"));
			String line = reader.readLine();
            int intDiscreteCounter = 0;
			while (line != null) {
                switch (intDiscreteCounter) {
                    case 0:
                        String strFileHash = line.substring(line.lastIndexOf(",") + 1);
                        int intFileHash = strFileHash.trim().hashCode();
                        int intHash = csvHashVerifier();
                        if (intFileHash != intHash) {
                            System.out.println("File hash verification failed");
                            System.exit(2);
                        }
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
     * @return int
     */
    private static int csvHashVerifier() {
        String HASH_CODE = "k1plinG";
        return HASH_CODE.hashCode();
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
    
}
