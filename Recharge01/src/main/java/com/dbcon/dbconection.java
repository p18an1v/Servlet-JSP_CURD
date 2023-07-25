package com.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconection {

	static String driver="oracle.jdbc.OracleDriver";
	static String url= "jdbc:thin:oracle:@localhost:1521:XE";
	static String username="system";
	static String pass="root";
	
	public static Connection getconnection()
	{
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
