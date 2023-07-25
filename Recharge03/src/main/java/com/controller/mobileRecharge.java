package com.controller;
import com.entity.*;
import com.db.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class mobileRecharge
 */
@WebServlet("/mobileRecharge")
public class mobileRecharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mobileRecharge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("check");
	/*	long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
		String service_provider = request.getParameter("service_provider");
		int recAmt=Integer.parseInt(request.getParameter("recAmt"));
		
		System.out.println("Parameters fetched");
		
		int accNo=Integer.parseInt(request.getParameter("accNo"));
		
		System.out.println("object fetched");
		
		mob_recharge mr=new mob_recharge(accNo,phoneNo, recAmt,service_provider);
		dboprations dbo=new dboprations();
		
		int i=dbo.recharge(mr);
		i=dbo.update_db(mr);
		
		response.sendRedirect("success.jsp");*/
		 try {
			    int accNo = Integer.parseInt(request.getParameter("accNo"));
	            long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
	            int recAmt = Integer.parseInt(request.getParameter("recAmt"));
	            String service_provider = request.getParameter("service_provider");
	           
	            System.out.println("Parameters fetched");
	            
	            mob_recharge mr = new mob_recharge(accNo, phoneNo, recAmt, service_provider);
	            dboprations dbo = new dboprations();
	            
	            int i = dbo.recharge(mr);
	            i = dbo.update_db(mr);
	            
	            response.sendRedirect("success.jsp");
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp"); // Handle the error appropriately.
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
