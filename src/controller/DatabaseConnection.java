/*
 * Connection.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.Secrets;

public class DatabaseConnection {
    static Connection connection = null;
    static Secrets secrets = new Secrets();
    Statement statement = null;

    /**
     * @return Connection
     */
    public static Connection connectToDatabase() {
        try {
            Secrets.getCredentials();
            connection = DriverManager.getConnection(
                    secrets.getURLString(), secrets.getUsernameString(), secrets.getPasswordString());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }
    
    public static String encryptPassword(char[] chrPassword) {
        return Secrets.encryption(String.valueOf(chrPassword));
    }
    
}
