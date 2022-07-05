/*
 * Connection.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.*;

import model.Secrets;


public class DatabaseConnection {
    public Connection connectToDatabase() {
        Connection connection = null;
	    Secrets secrets = new Secrets();
        Statement statement = null;
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
