/*
 * Register.java created on Tue Sep 27 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Session;

public class Register extends DatabaseConnection {
    private static Session session;
    private static int intAction = 5;
    private static int intUser;
    private static String sqlDate = "NOW()";
    private static String strDetail = "User (id ";
    private static String strName = "";
    private static String strLevel;
    private static String strId;

    /**
     * @param strUsername
     * @param strPassword
     * @param intLevel
     * @return
     */
    public static boolean register(String strUsername, char[] chrPassword, int intLevel) {
        PreparedStatement sqlStatement;
        ResultSet sqlResult;
        int intResult;
        String strPassword = encryptPassword(chrPassword);

        String query = "INSERT INTO `users`(`user_name`, `user_password`, `user_level`) VALUES (?,?,?)";

        try {
            sqlStatement = connectToDatabase().prepareStatement(query);

            sqlStatement.setString(1, strUsername);
            sqlStatement.setString(2, strPassword);
            sqlStatement.setInt(3, intLevel);

            intResult = sqlStatement.executeUpdate();

            // BUG: Session is changed to record, update like Login class
            if (intResult > 0) {
                query = "SELECT `user_id` FROM `users` WHERE `user_name` =?";
                try {
                    sqlStatement = connectToDatabase().prepareStatement(query);
                    sqlStatement.setString(1, strUsername);

                    sqlResult = sqlStatement.executeQuery();

                    while (sqlResult.next()) {
                        intUser = sqlResult.getInt("user_id");
                        strId = String.valueOf(intUser);
                        strLevel = String.valueOf(intLevel);
                        strName = strUsername;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void logSessionRegister() {
        strDetail += strId;
        strDetail += ") ";
        strDetail += strName;
        strDetail += " has been registered with level (";
        strDetail += strLevel;
        strDetail += ")!";
        session = new Session(intAction, intUser, sqlDate, strDetail, strName);
        session.logSession();

    }

    /**
     * @param strUsername
     * @param chrPassword
     * @param chrPassword2
     * @return String
     */
    public static String credentialValidator(String strUsername, char[] chrPassword, char[] chrPassword2) {
        String strError = "";
        String strHash = encryptPassword(chrPassword);
        String strHash2 = encryptPassword(chrPassword2);
        boolean boolUpperCase = false;
        boolean boolNumber = false;
        boolean boolSymbol = false;
        if (strUsername.isBlank() || chrPassword.length == 0 || chrPassword2.length == 0) {
            strError += "Please fill out empty fields";
            return strError;
        }
        if (!strHash.equals(strHash2)) {
            strError += "Password mismatch\n";
        }
        if (chrPassword.length < 8) {
            strError += "Password must be at least 8 characters long\n";
        }
        for (int i = 0; i < chrPassword.length; i++) {
            if (Character.isUpperCase(chrPassword[i])) {
                boolUpperCase = true;
            }
            if (Character.isDigit(chrPassword[i])) {
                boolNumber = true;
            }
            if (!Character.isDigit(chrPassword[i]) && !Character.isLetter(chrPassword[i])
                    && !Character.isSpaceChar(chrPassword[i])) {
                boolSymbol = true;
            }
        }
        if (!boolUpperCase) {
            strError += "Must contain an Uppercase letter\n";
        }
        if (!boolNumber) {
            strError += "Must contain a digit\n";
        }
        if (!boolSymbol) {
            strError += "Must contain a special character\n";
        }
        return strError;
    }

}
