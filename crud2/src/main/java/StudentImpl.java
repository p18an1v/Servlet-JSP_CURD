import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements StudDaoInterface {

	@Override
	public int create(List<Student> lststud) {
		int c=0;
		DbConnection db=new DbConnection();
		Connection con=db.getDbConnection();
		try {
			Student stud=lststud.get(0);
			PreparedStatement pstate=con.prepareStatement("insert into crud values(?,?,?,?)");
			pstate.setInt(1,stud.getStudId());
			pstate.setString(2,stud.getStudName());
			pstate.setString(3,stud.getUserName());
			pstate.setString(4,stud.getPassword());
			int i=pstate.executeUpdate();
			if(i>0) {
				System.out.println("Record saved.");
				c=1;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();	
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return c;
	}

	@Override
	public List<Student> search(int sId) {
		DbConnection db=new DbConnection();
		Connection con=db.getDbConnection();
		List<Student> lst=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from crud where studId=?");
			pstate.setInt(1, sId);
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				Student stud=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lst=new ArrayList<>();
				lst.add(stud);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();	
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
		}
		System.out.println("search done");
		return lst;
	}

	@Override
	public List<Student> display() {
		DbConnection db=new DbConnection();
		Connection con=db.getDbConnection();
		List<Student> lst=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from crud");
			ResultSet rs=pstate.executeQuery();
			while(rs.next()) {
				Student stud=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lst=new ArrayList<>();
				lst.add(stud);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();	
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
		}
		for(Student s :lst) {
			System.out.println(s);
		}
		return lst;
	}

	@Override
	public String delete(int sId) {
		DbConnection db=new DbConnection();
		Connection con=db.getDbConnection();
		String str=null;
		try {
			PreparedStatement pstate=con.prepareStatement("delete from crud where studId=?");
			pstate.setInt(1, sId);
			int i=pstate.executeUpdate();
			if(i>0) {
				str="Record Deleted.";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();	
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return str;
}

	@Override
	public int update(Student stud) {
		DbConnection db=new DbConnection();
		Connection con=db.getDbConnection();
		int i=0;
		try {
			PreparedStatement pstate=con.prepareStatement("update crud set studUname=?, pass=? where studId=?");
			pstate.setString(1, stud.getUserName());
			pstate.setString(2, stud.getPassword());
			pstate.setInt(3, stud.getStudId());
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
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return i;
	}
}
