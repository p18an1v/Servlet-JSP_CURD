package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;

/**
 * Servlet implementation class RegisterConteoller
 */
@WebServlet("/RegisterConteoller")
public class RegisterConteoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConteoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String studId = request.getParameter("sid");
		String studName = request.getParameter("sname");
		String studUser = request.getParameter("uname");
		String studPass= request.getParameter("pass");
		Student stud=new Student(Integer.parseInt(studId), studName, studUser, studPass);
		List<Student> lststud=new ArrayList();
		lststud.add(stud);
		studentImpl sdao=new studentImpl();
		int c=sdao.create(lststud);
		PrintWriter out=response.getWriter();
		if(c==1) {
			response.setContentType("text/html");  
			//PrintWriter pw=response.getWriter();    
			response.sendRedirect("login.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
