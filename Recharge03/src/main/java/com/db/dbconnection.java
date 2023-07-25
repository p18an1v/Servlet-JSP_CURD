package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
	public static Connection getconnection() {
		 Connection con = null;   
      try{    
          Class.forName("oracle.jdbc.driver.OracleDriver");   
          con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","root");      
      }   
      catch(Exception e1) 
      {   
          System.out.println(e1); 
      }   
      return con; 
		
	  }
}
