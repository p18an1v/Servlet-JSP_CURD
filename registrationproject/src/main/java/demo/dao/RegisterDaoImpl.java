package demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import demo.dao.RegisterDao;
import demo.db.DbConnection;
import demo.model.Login;
import demo.model.Register;

public class RegisterDaoImpl implements RegisterDao{
	
	@Override
	public int create(List<Register> lst) {
		int i=0;
		DbConnection db=new DbConnection();
		Connection con=db.myConnection();
		Register robj=lst.get(0);
		lst=null;
		try {
			PreparedStatement pstate=
					con.prepareStatement("insert into register values(?,?,?,?,?)");
			pstate.setInt(1,robj.getRegNo());
			pstate.setString(2,robj.getCustName());
			pstate.setString(3,robj.getUserName());
			pstate.setString(4,robj.getPassword());
			pstate.setFloat(5,robj.getAccBal());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			System.out.println("record save");
		}
		return i;
	}

	@Override
	public int delete(int regNo)
	{
		int i=0;
		DbConnection db=new DbConnection();
		Connection con=db.myConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("delete from register where regNo=?");
			pstate.setInt(1,regNo);
			 i=pstate.executeUpdate();
			
			if(i>0) {
				System.out.println("record Delete");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}

	@Override
	public List<Register> retrive(int regNo) {	
		List<Register> lsrrec=null;
		int i=0;
		ResultSet rs=null;
		DbConnection db=new DbConnection();
		Connection con=db.myConnection();
		try {
			PreparedStatement pstate=con.prepareStatement("select * from register where regNo=?");
			pstate.setInt(1,regNo);
			rs=pstate.executeQuery();
			
			if(rs.next()) {
				Register r=new Register(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
				lsrrec=new ArrayList<Register>();
				lsrrec.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lsrrec;
	}
	public List<Register> displayall() {	
		List<Register> lst=null;
		int i=0;
		ResultSet rs=null;
		DbConnection db=new DbConnection();
		Connection con=db.myConnection();
		Statement state=null;
		String str=null;
		try {
			
			state=con.createStatement();
			state.executeQuery("select *from register");
			if(rs.next()) {
				Register r=new Register(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5));
				lst=new ArrayList<Register>();
				lst.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lst;
	}
	
	public boolean ValidateUser(Login l)
	{
		boolean b=false;
		DbConnection db=new DbConnection();
		Connection con=db.myConnection();
		try {
			PreparedStatement pstate=
					con.prepareStatement("select *from Register where username=? and password=?");
			pstate.setString(1, l.getUserName());
			pstate.setString(2, l.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next())
			{
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
		
	}

}
