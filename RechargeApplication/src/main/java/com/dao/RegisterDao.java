package com.dao;

import com.connection.*;
import com.model.RechargeUser;
import com.model.Register;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegisterDao {

	Connection con = null;
	dbConnection db = new dbConnection();
	PreparedStatement pst;
	ResultSet rs;
	
	public int createCustomer(Register reg)
	{
		int i=0;
		con = db.getConnection();
		try {
			
			pst=con.prepareStatement("insert into userInfo values(?,?,?,?)");
			pst.setString(1, reg.getName());
			pst.setString(2, reg.getMobno());
			pst.setString(3, reg.getGmail());
			pst.setString(4, reg.getPassword());
			
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("Account is Succesfully created");
			}
		}catch(Exception e){

			System.out.println(e);
		}
		return i;
		
	}

	public Register displayRecord(String mobno)
	{
		Register reg = null;
		con = db.getConnection();
		try {
			pst=con.prepareStatement("select * from userinfo where mobno=?");
			pst.setString(1, mobno);
			rs=pst.executeQuery();
			
			if(rs.next())
			{
				reg=new Register();
				reg.setName(rs.getString(1));
				reg.setMobno(rs.getString(2));
				reg.setGmail(rs.getString(3));
				reg.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reg;
		
	}
	
public boolean validateuser(Register reg) {
		
		boolean b=false;
		con=db.getConnection();
		System.out.println("validating");
		try {
			
			pst=con.prepareStatement("select mobno,password from userinfo where mobno=? and password=?");
			pst.setString(1,reg.getMobno());
			pst.setString(2,reg.getPassword());
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) 
			{
				
				b=true;
			}
			
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		return b;
	}


public int rechargeinfo(RechargeUser user )
{
	con=db.getConnection();
	try {
		
		pst=con.prepareStatement("insert into rechargehistory values(?,?,?,?,?,?)");
		pst.setString(1,user.getName());
		pst.setString(2, user.getMobno());
		pst.setString(3,user.getState());
		pst.setDate(4,(Date) user.getDate());
		pst.setString(5,user.getPlan());
		pst.setString(6,user.getOperator());
		pst.executeUpdate();
		System.out.println("rechagehistory inserted");
		
		}catch(Exception e)
	{
			e.printStackTrace();
	}
	return 0;
}

public List <RechargeUser> selectAllUsers() {

    // using try-with-resources to avoid closing resources (boiler plate code)
    List <RechargeUser> user = null;
    // Step 1: Establishing a Connection
    try (Connection connection = db.getConnection();

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement("select * from rechargehistory");) {
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();

        // Step 4: Process the ResultSet object.
        while (rs.next()) {
        	String name = rs.getString("name");
            String mobno = rs.getString("mobno");
            String state = rs.getString("state");
            String operator = rs.getString("operator");
          user.add(new RechargeUser(name,mobno,state,operator, null, operator));
        }
    } catch (SQLException e) {
    	e.printStackTrace();	      
    	}
    return user;
}

}
