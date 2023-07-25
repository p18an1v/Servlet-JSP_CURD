package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.model.Register;


@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("name");
	String mobno=request.getParameter("mobno");
	String gmail=request.getParameter("gmail");
	String city=request.getParameter("city");
	String password=request.getParameter("password");
	
	Register reg=new Register(name,mobno,gmail,city,password); 
	
	//PrintWriter pw=response.getWriter();
	//pw.print("<tr><td>"+reg.getAccno()+"</td><td>"+reg.getCustomername()+"</td><td>"+reg.getAccbal()+"</td></tr>");
	
	RegisterDao dao=new RegisterDao();
	int i=dao.rechargeinfo(null);
	
	if(i>0) {
		//pw.print("<h1>Account Created..</h1>");
		response.sendRedirect("Login.jsp");
	}
	//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
