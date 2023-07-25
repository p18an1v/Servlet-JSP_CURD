package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	private static String driver="oracle.jdbc.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static String username="system";
	private static String password="root";
	
	public static Connection getDbConnection()
	{
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
