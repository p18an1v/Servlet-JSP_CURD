package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
 
	private static String driver = "oracle.jdbc.oracleDriver ";
	private static String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private static String pass ="root";
	private static String uname = "system ";
	
	public static Connection getConnection()
	{
		
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,uname,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

	
}
