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
    Connection connection = null;
	Secrets secrets = new Secrets();
    Statement statement = null;
    
    /** 
     * @return Connection
     */
    public Connection connectToDatabase() {
        try {
            Secrets.getCredentials();
            connection = DriverManager.getConnection(
                secrets.getURLString(), secrets.getUsernameString(), secrets.getPasswordString());
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
