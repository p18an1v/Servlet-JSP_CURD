package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Getconnection {

	static String driver="oracle.jdbc.OracleDriver";
	static String url= "jdbc:oracle:thin:@localhost:1521:XE";
	static String username="system";
	static String password="root";
	
	public static Connection con;
	public static Connection getconnection()
	{
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
			System.out.println("connection established");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		getconnection();
	}
	
}

