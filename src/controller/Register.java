/*
 * Register.java created on Tue Sep 27 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends DatabaseConnection {

    /**
     * @param strUsername
     * @param strPassword
     * @param intLevel
     * @return
     */
    public static boolean register(String strUsername, String strPassword, int intLevel) {

        PreparedStatement sqlStatement;
        String query = "INSERT INTO `users`(`user_name`, `user_password`, `user_level`) VALUES (?,?,?)";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlStatement.setString(1, strUsername);
            sqlStatement.setString(2, strPassword);
            sqlStatement.setInt(3, intLevel);

            // BUG: Session is changed to record, update like Login class
            while (sqlStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
