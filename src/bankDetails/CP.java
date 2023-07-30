package bankDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CP {
	
	static Connection con;
	
	public static Connection createC() throws SQLException {
       
        try {
 
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create the connection
           
            String url = "jdbc:mysql://localhost:3306/bankapp";
            String user = "root";
            String password = "root";
           
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            e.printStackTrace();
        }
        return con;
	}
	}
