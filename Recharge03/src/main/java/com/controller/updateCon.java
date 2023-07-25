package com.controller;
import com.entity.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dboprations;

/**
 * Servlet implementation class updateCon
 */
@WebServlet("/updateCon")
public class updateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		long phoneNo=Long.parseLong(request.getParameter("phoneNo"));
		int accNo = Integer.parseInt(request.getParameter("accNo"));
		int accBal = Integer.parseInt(request.getParameter("accBal"));
		int password = Integer.parseInt(request.getParameter("password"));
		dboprations db = new dboprations();
		account a=new account(username,phoneNo, accNo, accBal, password);
		PrintWriter out =response.getWriter();
		int i=db.update_Acc(a);
		System.out.println("account is updating");
		if(i==1)
		{
			
			out.print("<h1>Account is updated<h1>");    
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
