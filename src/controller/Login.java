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
     * @param chrPassword
     * @param intLevel
     * @return
     */
    public static boolean login(String strUsername, char[] chrPassword, int intLevel) {
        PreparedStatement sqlStatement;
        ResultSet sqlResult;
        String strPassword = encryptPassword(chrPassword);

        String query = "SELECT * FROM `users` WHERE `user_name` =? AND `user_password` =? AND `user_level` =?";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);
            sqlStatement.setString(1, strUsername);
            sqlStatement.setString(2, strPassword);
            sqlStatement.setInt(3, intLevel);

            sqlResult = sqlStatement.executeQuery();

            while (sqlResult.next()) {
                // BUG: Session is changed to record
                //Session.strUsername = sqlResult.getString("user_name");
                //Session.intLevel = sqlResult.getInt("user_level");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }


    

}
