package com.controller;
import com.entity.*;
import com.db.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class registerCon
 */
@WebServlet("/registerCon")
public class registerCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userName=request.getParameter("username");
		long phoneno=Long.parseLong(request.getParameter("phoneNo"));
		int accNo=Integer.parseInt(request.getParameter("accNo"));
		int accBal=Integer.parseInt(request.getParameter("accBal"));
		int password=Integer.parseInt(request.getParameter("password"));
		System.out.println("Values retrived");
		account a=new account( userName,phoneno,accNo,accBal,password);
		dboprations db=new dboprations();
		int flag=db.create_Acc(a);
		System.out.println("Value added to database");
		if(flag==1) {
			response.setContentType("text/html");  
			//PrintWriter pw=response.getWriter();    
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
