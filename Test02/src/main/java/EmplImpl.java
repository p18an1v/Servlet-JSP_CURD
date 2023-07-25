import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmplImpl implements EmpDao {

	@Override
	public int create(List<Employee> lstEmp) {
		int c=0;
		DbConnection db= new DbConnection();
		Connection con=db.getDbConnection();
		Employee emp=new Employee(null, c, c);
		String sql = "insert into Employee values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,emp.getEname());
			ps.setInt(2, emp.getEno());
			ps.setInt(3, emp.getEsal());
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Record saved.");
				c=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
