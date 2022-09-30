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
    private static Session session;
    private static int intAction = 1;
    private static int intUser;
    private static String sqlDate = "NOW()";
    private static String strDetail = "User ";
    private static String strName = "";
    private static String strLevel;

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
                intUser = sqlResult.getInt("user_id");
                strName = sqlResult.getString("user_name");
                strLevel = String.valueOf(intLevel);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    

    public static void logSession() {
        strDetail += strName;
        strDetail += " level (";
        strDetail += strLevel;
        strDetail += ") has logged in!";
        session = new Session(intAction, intUser, sqlDate, strDetail, strName);
        session.logSession();
    }

}
