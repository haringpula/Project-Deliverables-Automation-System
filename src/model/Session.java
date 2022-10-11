/*
 * Session.java created on Wed Sep 28 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import controller.DatabaseConnection;

public record Session(
        int intAction,
        int intUser,
        String strDetail,
        String strName) {

    /**
     * 
     */
    public void logSession() {
        // Test
        PreparedStatement sqlStatement;
        int intResult;

        String query = "INSERT INTO `sessions`(`user_id`, `action_id`, `session_date`, `session_detail`) VALUES (?,?,NOW(),?)";
        try {
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);

            sqlStatement.setInt(1, intUser);
            sqlStatement.setInt(2, intAction);
            sqlStatement.setString(3, strDetail);

            intResult = sqlStatement.executeUpdate();

            if (intResult > 0) {
                // ;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return DefaultTableModel
     */
    public static String[][] fetchSessionData() {
        String[] columnNames = { "Date", "Details" };
        PreparedStatement sqlStatement;
        ResultSet sqlResult;

        int intSessionCount = 0;
        int i;

        String query = "SELECT COUNT(session_id) AS session_count FROM sessions";

        try {
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);
            sqlResult = sqlStatement.executeQuery();

            if (sqlResult.next()) {
                intSessionCount = sqlResult.getInt("session_count");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String[][] mtxSessions = new String[intSessionCount][2];

        query = "SELECT session_date,session_detail FROM sessions";

        try {
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);
            sqlResult = sqlStatement.executeQuery();

            i = 0;
            while (sqlResult.next()) {
                mtxSessions[i][0] = sqlResult.getString("session_date");
                mtxSessions[i][1] = sqlResult.getString("session_detail");
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mtxSessions;
    }

}
