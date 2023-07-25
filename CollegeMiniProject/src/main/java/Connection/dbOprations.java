package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Connection.dbConnection;
import entity.account;
import entity.Login;
import entity.Book;
import entity.Books_Transfer;

public class dbOprations {

	public int create_db(List<account> lstacc) {
		Connection con=dbConnection.getDbConnection();
		int flag=0;
		for(account a: lstacc) {
			try {
				PreparedStatement pstate=con.prepareStatement("insert into account values(?,?,?,?,?,?)");
				pstate.setString(1,a.getCustName());
				pstate.setString(2,a.getUserName());
				pstate.setInt(3,a.getAccNo());
				pstate.setString(4,a.getPassword());
				pstate.setString(5,a.getPhoneNo());
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

	
	public List<Book> display_db(int accno) {
		Connection con=dbConnection.getDbConnection();
		List<Book> lstrec=new LinkedList();
		java.sql.Statement stat=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from account where acc_no=?");
			pstate.setInt(1,accno);
			ResultSet rs=pstate.executeQuery();
			while(rs.next())
			{
				Book mr=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5));
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

	
	public int search_db(Login l) {
		Connection con=dbConnection.getDbConnection();
		account acc=null;
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from account where acc_no=? and password=?");
			pstate.setInt(1,l.getAccNo());
			pstate.setString(2,l.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				acc=new account(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
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
		Connection con=dbConnection.getDbConnection();
		List<account> lstacc=new LinkedList<>();
		try {
			PreparedStatement pstate=con.prepareStatement("delete from account where acc_no=?");
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

	
	/*public int update_db(Book mr) {
		Connection con=dbConnection.getDbConnection();
		account acc=search(mr.getBookId());
	    String password=acc.getPassword();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("update  set acc_bal=? where acc_no=?");
			pstate.setString(1,acc.getPassword());
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
	*/
	public int recharge(Book mr) {
		Connection con=dbConnection.getDbConnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Book values(?,?,?,?,?)");
			pstate.setInt(1, mr.getBookId());
			pstate.setString(2, mr.getTitle());
			pstate.setString(3,mr.getAuthor());
			pstate.setString(4,mr.getPublication());
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
	public account  search(int bookId) {
		Connection con=dbConnection.getDbConnection();
		account acc=null;
		Book bk=null;
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from Book where bookId=?");
			pstate.setInt(1,bookId);
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				bk=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5));
				i=1;
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acc;
		
	}
}
