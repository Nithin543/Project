package cartfactorypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConnectionFactory {
    
    
    public static Connection getConnection(){
      try {
    	  
    	  JDBCSingleton x = JDBCSingleton.getInstance();
    	  String URL = x.getProperty("URL");
    	  String USER = x.getProperty("USER");
    	  String PASS = x.getProperty("PASS");
    	 
    	  DriverManager.registerDriver(new Driver());
    	  
          return DriverManager.getConnection(URL, USER, PASS);
          
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
    
    public static void main(String[] args) {
    	
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(connection);
    }
}
