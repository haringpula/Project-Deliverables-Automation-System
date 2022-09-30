/*
 * Session.java created on Wed Sep 28 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.DatabaseConnection;

public record Session(
        int intAction,
        int intUser,
        String sqlDate,
        String strDetail,
        String strName) {
    public void logSession() {
        // Test
        PreparedStatement sqlStatement;
        int intResult;

        String query = "INSERT INTO `sessions`(`user_id`, `action_id`, `session_date`, `session_detail`) VALUES (?,?,"+sqlDate+",?)";
        try {
            sqlStatement = DatabaseConnection.connectToDatabase().prepareStatement(query);

            sqlStatement.setInt(1, intUser);
            sqlStatement.setInt(2, intAction);
            //sqlStatement.setString(3, sqlDate);
            sqlStatement.setString(3, strDetail);

            intResult = sqlStatement.executeUpdate();

            if (intResult > 0) {
                //;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
