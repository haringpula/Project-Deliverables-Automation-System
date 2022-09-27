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
import java.util.Scanner;

import controller.Login;
import controller.Register;

public class Start{
    Start() {
        super();
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {        
        new Start();
        Scanner in = new Scanner(System.in);
        int intMenu = -1;
        System.out.println("Welcome\n0. Exit\n1. Login\n2. Register");
        while (true){
            System.out.print("Enter: ");
            intMenu = in.nextInt();
            switch (intMenu) {
                case 0:
                    System.out.println("Exiting now");
                    in.close();
                    System.exit(0);
                    break;
                case 1:
                    Login.login();
                    System.out.println();
                    break;
                case 2:
                    Register.register();
                    System.out.println();
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
                
    }

}