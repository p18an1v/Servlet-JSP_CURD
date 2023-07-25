package com.db;
import com.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class dboprations {

public int create_Acc(account a) {
	    int flag=0;
		String sql="insert into account values(?,?,?,?,?)";
		Connection con=dbconnection.getconnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getUsername());
			ps.setLong(2, a.getPhoneNo());
			ps.setInt(3, a.getAccNo());
			ps.setInt(4, a.getAccBal());
			ps.setInt(5, a.getPassword());
			
			System.out.println("record inserting");
			
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Record save");
				flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

public int search_Acc(login l) {
	// TODO Auto-generated method stub
	Connection con=dbconnection.getconnection();
	String qtwo= "SELECT * FROM account WHERE accNo = ? AND password = ?";
	int flag=0;
	try {
		PreparedStatement ps=con.prepareStatement(qtwo);
	   //  ps.setString(1, l.getUsername());
		account a=null;
	     ps.setInt(1, l.getAccNo());
	     ps.setInt(2, l.getPassword());
	     ResultSet rs=ps.executeQuery();
	     if(rs.next()) {
				a=new account(rs.getString(1),rs.getLong(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
				flag=1;
			}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return flag;
}
public int update_Acc(account a)
{
	Connection con=dbconnection.getconnection();
	String sqlFour="UPDATE account SET username=?, phoneNo=?, accBal=?, password=? WHERE accNo=?";
	int status = 0;
	try {
		PreparedStatement ps=con.prepareStatement(sqlFour);
		ps.setString(1,a.getUsername() );
		ps.setLong(2, a.getPhoneNo());
		ps.setInt(3, a.getAccBal());
		ps.setInt(4, a.getPassword());
		ps.setInt(5, a.getAccNo());
		
		int i=ps.executeUpdate();
		if(i>0)
		{
			System.out.println("Update Succesfully");
			status=1;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return status;
	
}
public int delete_Acc(login l)
{
	Connection con=dbconnection.getconnection();
	String qthree= "delete from account where accNo = ? and password=? ";
	int status=0;
	try {
		PreparedStatement ps=con.prepareStatement(qthree);
		ps.setInt(1, l.getAccNo());
		ps.setInt(2, l.getPassword());
		int i=ps.executeUpdate();
		if(i>0)
		{
		   System.out.println("Your account is Deleted");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return status;		
}

public List<mob_recharge> display_db(int accNo) {
	Connection con=dbconnection.getconnection();
	List<mob_recharge> lstrec=new LinkedList();
	java.sql.Statement stat=null;
	try {
		PreparedStatement ps=con.prepareStatement("select * from bank_MobRecharge where acc_no=?");
		ps.setInt(1,accNo);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			mob_recharge mr=new mob_recharge(rs.getInt(1),rs.getLong(2),rs.getInt(3),rs.getString(4));
			lstrec.add(mr);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return lstrec;
}

public account  search(int accNo) {
	Connection con=dbconnection.getconnection();
	account acc=null;
	int i=0;
	try {
		PreparedStatement pstate=con.prepareStatement("select * from account where acc_no=?");
		pstate.setInt(1,accNo);
		ResultSet rs=pstate.executeQuery();
		if(rs.next()) {
			acc=new account(rs.getString(1),rs.getLong(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			i=1;
		}	
	}catch (SQLException e) {
		e.printStackTrace();
	}
	
	return acc;
	
}
public int update_db(mob_recharge mr) {
	Connection con=dbconnection.getconnection();
	account acc=search(mr.getAccNo());
	double bal=acc.getAccBal()-mr.getRecAmt();
	int i=0;
	try {
		PreparedStatement pstate=con.prepareStatement("update account set acc_bal=? where acc_no=?");
		pstate.setDouble(1,bal);
		pstate.setInt(2,acc.getAccNo());
		i=pstate.executeUpdate();
		if(i>0) {
			System.out.println("Record Updated.");
			i=1;
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return i;
}



public int recharge(mob_recharge mr) {
	Connection con=dbconnection.getconnection();
	int i=0;
	try {
		PreparedStatement pstate=con.prepareStatement("insert into MobRecharge values(?,?,?,?)");
		pstate.setInt(1, mr.getAccNo());
		pstate.setLong(2, mr.getPhoneNo());
		pstate.setString(3,mr.getService_provider());
		pstate.setFloat(4,mr.getRecAmt());
		i=pstate.executeUpdate();
		if(i>0){
			System.out.println("Record Saved.");
			i=1;
		}
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return i;
	
}


}
