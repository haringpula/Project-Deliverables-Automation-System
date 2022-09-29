/*
 * Session.java created on Wed Sep 28 2022 by King Red Sanchez
 * Copyright (c) 2022 
 */
package model;

import controller.DatabaseConnection;

public record Session(
        int intAction,
        int intUsername,
        int intLevel0,
        String sqlDate,
        String strDetail) {
    public static void logSession() {
        // TODO: Log session, only take a few things and do sql statement here with the now()
    }
}
