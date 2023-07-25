import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class dbOp {
	public int create_Acc(user_account acc) {
		int flag=0;
	    String insert_Query="insert into user_account values(?,?,?,?,?)";
		Connection con = dbconnection.getconnection();
		try {
			PreparedStatement ps =con.prepareStatement(insert_Query);
			
			ps.setInt(1, acc.getAccId());
			ps.setString(2, acc.getUserName());
			ps.setString(3, acc.getPhoneNo());
			ps.setInt(4, acc.getAccBal());
			ps.setInt(5, acc.getPassword());
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("record inserting...");
				flag=1;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public int search_Acc(Login l) {
		int flag=0;
		user_account acc;
		Connection con = dbconnection.getconnection();
		String search_Query = "select * from user_account where accId =? and password=?";
		try {
			PreparedStatement ps =con.prepareStatement(search_Query);
			ps.setInt(1,l.getAccId());
			ps.setInt(2, l.getPassword());
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				acc=new user_account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				flag=1;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
		
	}
	
	public user_account display(int accId) {
		user_account acc = null;
		Connection con = dbconnection.getconnection();
		String Third_Query = "select * from user_account where accId =?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(Third_Query);
			ps.setInt(1, accId);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
	            accId = rs.getInt("accId");
	            String userName = rs.getString("userName");
	            String phoneNo = rs.getString("phoneNo");
	            int accBal = rs.getInt("accBal");
	            int password=rs.getInt("password");
	            
	         // Create the user_account object with the retrieved data
	             acc = new user_account(accId, userName, phoneNo, accBal, password);
	                         } 
		    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		                             }
		
            return acc;
                       }
	
	     public int updae_Acc(int accId,String userName, String phoneNo,int accBal,int password) {
	    	 int flag = 0;
	    	 Connection con = dbconnection.getconnection();
	    	 String update_Query = "update user_account set userName=?, accBal=?,phoneNo=?,password=? where accId=?";
	    	 
	    	 try {
				PreparedStatement ps = con.prepareStatement(update_Query);
				ps.setString(1, userName);
				ps.setInt(2, accBal);
				ps.setString(3, phoneNo);
				ps.setInt(4, password);
				ps.setInt(5, accId);
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					System.out.println("update Succesfully");
					flag=1;
				}
				else 
				{
					System.out.println("unsuccesfull");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 
	    	 
	    	 return flag;
	     }

	     
	 public int delete_Acc(int accId,int password) {    
		 int flag =0;
		 String delete_Query ="DELETE FROM user_account WHERE accId = ? AND password = ?";
		 Connection con = dbconnection.getconnection();
		 try {
			PreparedStatement ps = con.prepareStatement(delete_Query);
			ps.setInt(1, accId);
			ps.setInt(2, password);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Account deleted");
				flag=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return flag;
	 }
	     
	/* public List<user_account> display_All() {
		 List<user_account> list=new ArrayList<user_account>();  
		 Connection con = dbconnection.getconnection();
		 String display_All = "select * from user_account";
		 user_account acc;
		 try {
			PreparedStatement ps = con.prepareStatement(display_All);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				acc=new user_account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
				list.add(acc);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return list;
	 }*/
}
	
        
