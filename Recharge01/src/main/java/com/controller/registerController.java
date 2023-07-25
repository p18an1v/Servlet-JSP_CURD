package com.controller;
import com.entity.*;
import com.dbcon.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int accNo =Integer.parseInt(request.getParameter("accNo"));
		String accType=request.getParameter("accType");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int phoneNo=Integer.parseInt(request.getParameter("phoneNo"));
		int accBal=Integer.parseInt(request.getParameter("accBal"));
		System.out.println("Values recieved");
		
		account a=new account(accNo, userName, accType, phoneNo, password, accBal);
		
		dbOprations dbo=new dbOprations();
		int flag=dbo.create_Acc(a);
		System.out.println("Value added to database");
		if(flag==1) 
		{
			
		response.setContentType("text/html");  
		   PrintWriter pw=response.getWriter(); 
		   pw.print("value saved");
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
