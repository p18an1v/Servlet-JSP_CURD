package com.controller;
import com.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String StudId = request.getParameter("sid");
		String UserName = request.getParameter("uname");
		String StudPass = request.getParameter("pass");
	   System.out.println("value is getting fetch");
		studentImpl sdao = new studentImpl();
		List<Student> lst=sdao.search(Integer.parseInt(StudId));
		Student stud = lst.get(0);
		stud.setStudName(UserName);
		stud.setPassword(StudPass);
		System.out.println("Print new value is set");
		int i=sdao.update(stud);
		System.out.println("database is updated");
		if(i==0)
		{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			response.sendRedirect("Login.html");
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
