import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements StudentInterface {

	@Override
	public int create(List<Student> lststud) {
		// TODO Auto-generated method stub
		int c=0;
		dbConnection db=new dbConnection();
		Connection con=db.getDbConnection();
		try {
			Student stud=lststud.get(0);
			PreparedStatement pstate=con.prepareStatement("insert into crud values(?,?,?,?)");
			pstate.setInt(1,stud.getStudId());
			pstate.setString(2,stud.getStudName());
			pstate.setLong(3,stud.getStudMob());
			pstate.setString(4,stud.getStudPass());
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
	public List<Student> display() {
		// TODO Auto-generated method stub
		dbConnection db=new dbConnection();
		Connection con=db.getDbConnection();
		List<Student> lst=null;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from crud");
			ResultSet rs=pstate.executeQuery();
			while(rs.next()) {
				Student stud=new Student(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4));
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

}
