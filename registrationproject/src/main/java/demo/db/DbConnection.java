package demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import demo.model.Register;

public class DbConnection {

	public static Connection myConnection() {
		Connection con=null;
	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public List<Register> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}
}