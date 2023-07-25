package com.dbcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.entity.account;
import com.entity.login;
import com.entity.mobRecharge;


public class dbOprations{

	
	public int create_Acc(account a) {
		// TODO Auto-generated method stub
		Connection con =dbconection.getconnection();
		System.out.println(con);
		int flag=0;
		String qOne="insert into bank_account values(?,?,?,?,?,?)";
		System.out.println(qOne);
		try {
			PreparedStatement ps=con.prepareStatement(qOne);
			ps.setInt(1,a.getAccNo());
			ps.setString(2, a.getUserName());
			ps.setLong(3, a.getPhoneNo());
			ps.setInt(4, a.getAccBal());
			ps.setString(5, a.getAccType());
			ps.setString(6, a.getPassword());
			System.out.println("Statement creadted");
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Record save Succesfully");
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

	
	public account search_Acc(int accNo) {
		// TODO Auto-generated method stub
		Connection con=dbconection.getconnection();
		String qtwo= "select * from bank_account where accNo = ? ";
		account a=null;
		try {
			PreparedStatement ps=con.prepareStatement(qtwo);
			ps.setInt(1, accNo);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			   a=new account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6));
			   
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
		
		return a;
	}
	
	public int search_db(login l) {
		Connection con=dbconection.getconnection();
		account a=null;
		int i = 0;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from bank_account where acc_no=? and password=?");
			pstate.setInt(1,l.getAccNo());
			pstate.setString(2,l.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				a=new account(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getInt(6));
				   
				i=1;
			}	
		}catch (SQLException e) {
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

	public account delete_Acc(int accNo)
	{
		Connection con=dbconection.getconnection();
		String qthree= "delete from bank_account where accNo = ? ";
		account a=null;
		try {
			PreparedStatement ps=con.prepareStatement(qthree);
			ps.setInt(1, accNo);
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
		
		return a;		
	}

	public account update_Acc(int accNo,int accBal)
	{
		Connection con=dbconection.getconnection();
		String sqlFour="update bank_account set accBal=? where accNo=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sqlFour);
			ps.setInt(1, accNo);
			ps.setInt(2, accBal);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Update Succesfully");
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
		return null;
		
	}
	
	public  mobRecharge displayMob(int accNo) {
		Connection con =dbconection.getconnection();
		mobRecharge mr = null;
		String sqlFive="select * from mobRecharge where acc_no=?";
		try {
			PreparedStatement pstate=con.prepareStatement(sqlFive);
			pstate.setInt(1,accNo);
			ResultSet rs=pstate.executeQuery();
			while(rs.next())
			{
				 mr=new mobRecharge(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				
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
		return mr;
		
	}
	
	public mobRecharge UpdateMob(int accNo)
	{
		String sqlSix = "update bank_account set acc_bal=? where acc_no=?";
		Connection con= dbconection.getconnection();
		mobRecharge mr=null;
		account a=search_Acc(mr.getAccNo());
		try {
			PreparedStatement ps=con.prepareStatement(sqlSix);
			ps.setInt(1, accNo);
			ps.setInt(2, a.getAccBal());
			int i =ps.executeUpdate();
			if(i>0) {
				System.out.println("Record Updated.");
				i=1;
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
		return null;
		
	}
	public int rechargeMob(mobRecharge mr) {
		Connection con=dbconection.getconnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("insert into bank_recharge values(?,?,?,?,?)");
			pstate.setInt(1, mr.getAccNo());
			pstate.setString(2, mr.getPhoneNo());
			pstate.setString(3,mr.getServiceProvider());
			pstate.setFloat(4,mr.getRecAmt());
			pstate.setString(5,mr.getDate());
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
