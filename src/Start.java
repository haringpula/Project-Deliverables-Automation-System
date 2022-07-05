
/*
 * Start.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
import java.sql.*;

import javax.swing.JOptionPane;

import controller.DatabaseConnection;

public class Start extends controller.Login{
    Start() {
        super();
        // TODO: Auto-generated constructor stub
    }

    public static void main(String[] args) {
        
        
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase();
        new Start();

    }

    

}