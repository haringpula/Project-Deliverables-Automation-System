/*
 * Start.java created on Tue Sep 27 2022 by King Red Sanchez
 * Copyright (c) 2022 
 * ~~~~~~~~~~~██████████████████████████REMOVE██████████████████████████~~~~~~~~~~~
 * Author Naming Conventions: █ Package names are in lowercase
 * Class/Interfaces names are in PascalCase █ Method/Instances names are in camelCase
 * Variable names are in camelCase (typeName) █ Constants are in SNAKE_CASE
 * Temporary variables names: i,j,k,m,n for int; c,d,e for char (else follow var names)
 * Author Code Conventions: █ TODO pending completion █ NOTE notes on implementation 
 * BUG valid / broken code █ XXX bogus / working code █ FIXME bogus / broken code
 * SEE valid / working / spaghetti code █ HACK valid / working / temporary
 * ~~~~~~~~~~███████████REMOVE IN FINAL VERSION ██ SAPERE AUDE███████████~~~~~~~~~~
 */

import view.LoginFrame;
import view.StartFrame;

public class Start {
    Start() {
        super();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO: Set Splash Screen
        // new StartFrame();
        new LoginFrame();
    }

}