package com.connection;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class oracleconnection {
	
	Connection con;
	public Connection getConnection() {
		
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");
			
			System.out.println("Connection to DB...");
		}
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
	}

}
