/*
 * Login.java created on Wed Jun 29 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Session;

public class Login extends DatabaseConnection {

    
    /**
     * @param strUsername
     * @param strPassword
     * @param intLevel
     * @return
     */
    public boolean login(String strUsername, String strPassword, int intLevel) {

        PreparedStatement ps;
        ResultSet rs;

        String query = "SELECT * FROM `users` WHERE `user_name` =? AND `user_password` =? AND `user_level` =?";

        try {
            ps = connectToDatabase().prepareStatement(query);
            ps.setString(1, strUsername);
            ps.setString(2, strPassword);
            ps.setInt(3, intLevel);

            rs = ps.executeQuery();

            while (rs.next()) {
                Session.strUsername = rs.getString("user_name");
                Session.intLevel = rs.getInt("user_level");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

}
