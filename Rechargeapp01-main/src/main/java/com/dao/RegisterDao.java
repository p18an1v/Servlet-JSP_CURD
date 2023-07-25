package com.dao;

import com.connection.oracleconnection;
import com.model.Register;
import com.model.Recharge;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.*;

public class RegisterDao {
	
	Connection con=null;
	oracleconnection m=new oracleconnection();
	PreparedStatement pst,ps2,ps;
	ResultSet rs;
	
	public int createCustomert(Register register) {
	int i=0;
		con=m.getConnection();
		try {
			
			pst=con.prepareStatement("insert into userinfo values(?,?,?,?,?)");
			pst.setString(1, register.getName());
			pst.setString(2, register.getMobno());
			pst.setString(3, register.getGmail());
			pst.setString(4, register.getCity());
			pst.setString(5,register.getPassword());
			
			 i=pst.executeUpdate();
			if(i>0) {
				System.out.println("Account created...");
			}

			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return i;
		
	}
	
	public boolean validateuser(Register l1) {
		
		boolean b=false;
		con=m.getConnection();
		System.out.println("validating");
		try {
			
			ps2=con.prepareStatement("select mobno,password from userinfo where mobno=? and password=?");
			ps2.setString(1,l1.getMobno());
			ps2.setString(2,l1.getPassword());
			ResultSet rs2=ps2.executeQuery();
			
			if(rs2.next()) 
			{
				
				b=true;
			}
			
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		return b;
		
		
	}
	
	public Register displayRecord(String mobno)
	{
		Register r=null;
		con=m.getConnection();
		try {
			
			ps=con.prepareStatement("select * from userinfo where mobno=?");
			ps.setString(1,mobno);
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				r=new Register();
				r.setName(rs.getString(1));
				r.setMobno(rs.getString(2));
				r.setGmail(rs.getString(3));
				r.setCity(rs.getString(4));
				r.setPassword(rs.getString(5));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	
	
	
	public int rechargeinfo(Recharge user)
	{
		con=m.getConnection();
		try {
			
			pst=con.prepareStatement("insert into rechargehistory values(?,?,?,?,?,?)");
			pst.setString(1,user.getName());
			pst.setString(2, user.getMobno());
			pst.setString(3,user.getState());
			pst.setString(4,user.getDate());
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
	
	public List <Recharge> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List <Recharge> user = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = m.getConnection();

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
                String date = rs.getString("datee");
                String plan = rs.getString("plan");
                String operator = rs.getString("operator");
                user.add(new Recharge(name,mobno,state,date,plan,operator));
            }
        } catch (SQLException e) {
        	e.printStackTrace();	      
        	}
        return user;
    }

	
	
	
	

}
