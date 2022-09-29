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
    public static boolean register(String strUsername, char[] chrPassword, int intLevel) {
        PreparedStatement sqlStatement;
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
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

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
            if (!Character.isDigit(chrPassword[i]) && !Character.isLetter(chrPassword[i]) && !Character.isSpaceChar(chrPassword[i])) {
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
