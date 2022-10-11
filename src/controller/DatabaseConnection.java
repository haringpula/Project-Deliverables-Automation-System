/*
 * Connection.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

import model.Secrets;
import model.Session;

public class DatabaseConnection {
    private static Session session;
    private static int intAction;
    private static int intUser;
    private static String strDetail = "User ";
    private static String strName = "";
    private static Connection connection = null;
    private static Secrets secrets = new Secrets();

    /**
     * @return Connection
     */
    public static Connection connectToDatabase() {
        try {
            secrets.getCredentials();
            connection = DriverManager.getConnection(
                    secrets.getURLString(), secrets.getUsernameString(), secrets.getPasswordString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }

    /**
     * @param chrPassword
     * @return
     */
    public static String encryptPassword(char[] chrPassword) {
        return Secrets.encryption(String.valueOf(chrPassword));
    }

    /**
     * @param strInputHash
     * @return boolean
     */
    public static boolean csvHashVerifier(String strInputHash) {
        int intInputHash = strInputHash.hashCode();
        String strHash = secrets.getHash();
        int intHash = strHash.hashCode();
        if (intInputHash != intHash) {
            return false;
        }
        return true;
    }

    /**
     * @param chrPassword
     * @return
     */
    public static char[] passwordRezero(char[] chrPassword) {
        for (int i = 0; i < chrPassword.length; i++) {
            chrPassword[i] = '0';
        }
        return chrPassword;
    }

    /**
     * @return Session
     */
    public static Session passSession() {
        session = new Session(intAction, intUser, strDetail, strName);
        return session;
    }
}
