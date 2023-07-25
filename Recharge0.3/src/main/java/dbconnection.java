import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {

	static String driver="oracle.jdbc.driver.OracleDriver";
	static String url="jdbc:oracle:thin:@localhost:1521:XE";
	static String user="system";
	static String pass="root";
	
	public static Connection getconnection() {
		 Connection con = null;   
     try{    
         Class.forName(driver);   
         con=DriverManager.getConnection(url,user,pass);      
     }   
     catch(Exception e1) 
     {   
         System.out.println(e1); 
     }   
     return con; 
		
	  }

}
