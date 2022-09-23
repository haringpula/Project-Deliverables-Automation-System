

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