package com.dao;

import java.util.List;

import com.model.Student;

public interface StudDaoInterface {
	public int create(List<Student> lststud);
	public List<Student> search(int sId);
	public List<Student> display();
	public String delete(int sId);
	public int update(Student stud);
	
}
