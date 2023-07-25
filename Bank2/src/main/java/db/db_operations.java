package db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.account;
import entity.login;
import entity.mobile_recharge;

public class db_operations {
	
	public int create_db(List<account> lstacc) {
		Connection con=DbConnection.getDbConnection();
		int flag=0;
		for(account a: lstacc) {
			try {
				PreparedStatement pstate=con.prepareStatement("insert into bank_account values(?,?,?,?,?,?)");
				pstate.setString(1,a.getCustName());
				pstate.setString(2,a.getUserName());
				pstate.setInt(3,a.getAccNo());
				pstate.setString(4,a.getPassword());
				pstate.setString(5,a.getPhoneNo());
				pstate.setFloat(6,a.getAccBal());
				int i=pstate.executeUpdate();
				if(i>0){
					System.out.println("Record Saved.");
					flag=1;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	
	public List<mobile_recharge> display_db(int accno) {
		Connection con=DbConnection.getDbConnection();
		List<mobile_recharge> lstrec=new LinkedList();
		java.sql.Statement stat=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from bank_MobRecharge where acc_no=?");
			pstate.setInt(1,accno);
			ResultSet rs=pstate.executeQuery();
			while(rs.next())
			{
				mobile_recharge mr=new mobile_recharge(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5));
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

	
	public int search_db(login l) {
		Connection con=DbConnection.getDbConnection();
		account acc=null;
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from bank_account where acc_no=? and password=?");
			pstate.setInt(1,l.getAccNo());
			pstate.setString(2,l.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				acc=new account(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
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

	
	public List<account> delete_db(int accNo) {
		Connection con=DbConnection.getDbConnection();
		List<account> lstacc=new LinkedList<>();
		try {
			PreparedStatement pstate=con.prepareStatement("delete from bank_account where acc_no=?");
			pstate.setInt(1,accNo);
			int i=pstate.executeUpdate();
			if(i>0) {
				System.out.println("Record deleted.");
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
		return lstacc;
	}

	
	public int update_db(mobile_recharge mr) {
		Connection con=DbConnection.getDbConnection();
		account acc=search(mr.getAccNo());
		double bal=acc.getAccBal()-mr.getRecAmt();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("update bank_account set acc_bal=? where acc_no=?");
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
	
	public int recharge(mobile_recharge mr) {
		Connection con=DbConnection.getDbConnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("insert into bank_MobRecharge values(?,?,?,?,?)");
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
	public account  search(int accno) {
		Connection con=DbConnection.getDbConnection();
		account acc=null;
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from bank_account where acc_no=?");
			pstate.setInt(1,accno);
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				acc=new account(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getFloat(6));
				i=1;
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
		
	}

}