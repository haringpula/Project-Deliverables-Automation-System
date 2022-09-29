/*
 * Register.java created on Tue Sep 27 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register extends DatabaseConnection {
    /*
     * 
     */
    public static void register() {
        // HACK: Command line register
        Scanner in = new Scanner(System.in);
        System.out.print("Enter username: ");
        String strUsername = in.nextLine();
        System.out.print("Enter password: ");
        String strPassword = in.nextLine();
        System.out.print("Enter level: ");
        String strLevel = in.nextLine();

        PreparedStatement ps;
        String query = "INSERT INTO `users`(`user_name`, `user_password`, `user_level`) VALUES (?,?,?)";

        try {
            ps = connectToDatabase().prepareStatement(query);

            ps.setString(1, strUsername);
            ps.setString(2, strPassword);
            ps.setString(3, strLevel);

            if (ps.executeUpdate() > 0) {
                System.out.println("New user added");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // in.close();
    }

}
