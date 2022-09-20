
import java.sql.Connection;

import controller.DatabaseConnection;
import controller.Login;

public class Start{
    Start() {
        super();
    }
    
    /** 
     * @param args
     */
    public static void main(String[] args) {        
        Connection con = DatabaseConnection.connectToDatabase();
        new Start();
        new Login();
        Login.login();
        
    }

}