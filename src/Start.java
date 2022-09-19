
import controller.DatabaseConnection;
import controller.Login;

public class Start{
    Start() {
        super();
        // TODO: Auto-generated constructor stub
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.connectToDatabase();
        new Start();
        Login login = new Login();
        
        
        

    }

    

}