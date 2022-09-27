/*
 * Login.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import view.LoginFrame;

public class Login{
    // HACK: Login implementation without view
    //LoginFrame loginFrame = new LoginFrame();

    /** 
     * 
     */
    public static void login() {
        // HACK: Command line login
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String strUsername = in.nextLine();
        System.out.print("Enter password: ");
        String strPassword = in.nextLine();
        
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM `users` WHERE `user_name` =? AND `user_password` =?";
        
        try {
            ps = DatabaseConnection.connectToDatabase().prepareStatement(query);
            ps.setString(1, strUsername);
            ps.setString(2, strPassword);
            
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                System.out.println("Login Succesfully");
            } else {
                System.out.println("Invalid username or password");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //in.close();
        
    }


}
