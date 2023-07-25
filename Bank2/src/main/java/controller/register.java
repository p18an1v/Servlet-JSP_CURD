package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.db_operations;
import entity.account;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custName=request.getParameter("cname");
		String userName=request.getParameter("uname");
		String password=request.getParameter("pass");
		String phoneno=request.getParameter("phoneno");
		String accbal=request.getParameter("accbal");
		String accno=request.getParameter("accno");
		System.out.println("Values retrived");
		//accno_generator a=new accno_generator();
		//int accno=a.accNo();
		//System.out.println("Account no generated");
		List<account> lst=new ArrayList<>();
		account aobj=new account(custName, userName, Integer.parseInt(accno), password,phoneno,Float.parseFloat(accbal));
		lst.add(aobj);
		db_operations dbo=new db_operations();
		int flag=dbo.create_db(lst);
		System.out.println("Value added to database");
		if(flag==1) {
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
