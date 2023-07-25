package com.dao;
import com.connection.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Student;

public class studentImpl implements StudDaoInterface{

	@Override
	public int create(List<Student> lststud) {
		// TODO Auto-generated method stub
		int c=0;
		String sql="insert into student values(?,?,?,?)";
		dbConnection db=new dbConnection();
		Connection con=db.getConnection();
		
		Student stud =lststud.get(0);
		try {
			PreparedStatement ps=con.prepareStatement("sql");
			ps.setInt(1, stud.getStudId());
			ps.setString(2, stud.getStudName());
			ps.setString(3, stud.getUserName());
			ps.setString(4, stud.getPassword());
			int i =ps.executeUpdate();
			if( i>0)
			{
				System.out.println("Record Save");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		String sql="select * from crud where studId=?";
		dbConnection db=new dbConnection();
		Connection con=db.getConnection();
		List<Student> lst=null;
		try {
			PreparedStatement ps=con.prepareStatement("sql");
			ps.setInt(1, sId);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Student stud=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lst=new ArrayList<>();
				lst.add(stud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		return lst;
	
		
	}

	@Override
	public List<Student> display() {
		// TODO Auto-generated method stub
		String sql="select * from student ";
		dbConnection db=new dbConnection();
		Connection con=db.getConnection();
		List<Student> lst=null;
		try {
			PreparedStatement ps=con.prepareStatement("sql");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Student stud=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				lst=new ArrayList<>();
				lst.add(stud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		String sql="delete from student where studId=? ";
		dbConnection db=new dbConnection();
		Connection con=db.getConnection();
		String str=null;
		try {
			PreparedStatement ps=con.prepareStatement("sql");
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				str="Rrecord Deleted";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		// TODO Auto-generated method stub
		int i=0;
		String sql="update student set studUname=?, pass=? where studId=?";
		dbConnection db=new dbConnection();
		Connection con=db.getConnection();
		
		
		try {
			PreparedStatement ps=con.prepareStatement("sql");
			ps.setInt(1, stud.getStudId());
			ps.setString(2, stud.getStudName());
			ps.setString(3, stud.getUserName());
			ps.setString(4, stud.getPassword());
			 i =ps.executeUpdate();
			if( i>0)
			{
				System.out.println("Record Save");
				i=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
