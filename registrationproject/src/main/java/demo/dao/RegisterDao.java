package demo.dao;

import java.util.List;

import demo.model.Login;
import demo.model.Register;

public interface RegisterDao {

	public int create(List<Register> lst);
	//public List<Register> retrive(int regNo);
	public boolean ValidateUser(Login l);
	public List<Register> retrive(int regNo);
	public int delete(int regNo);
	public List<Register> displayall()
}
