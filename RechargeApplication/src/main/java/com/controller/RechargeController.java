package com.controller;
import java.time.LocalDateTime;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.model.*;
import com.dao.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String requestMethod = request.getMethod();

		if (requestMethod != "GET") {
		    throw new ServletException("The request method is not GET.");
		}
		
     	int otp=Integer.parseInt(request.getParameter("inputotp"));
			if(otp==2222)
	{			
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		        LocalDateTime localDateTime = LocalDateTime.now();
		        String formattedDateTime = localDateTime.format(formatter);
		        
		        Date date= java.util.Date.from(localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
		        
		        System.out.println("Formatted DateTime: " + formattedDateTime);
		        System.out.println("Date: " + date);
		        
		        
			HttpSession sess=request.getSession();
			
			String plan=null;
		
			String name=request.getParameter("username");
			String mobno=request.getParameter("mobno");
			String operator = request.getParameter("operator");
	        String state = request.getParameter("state");
	        
	       if(operator.equals("airtel"))
	        	plan=request.getParameter("airtelplan");
	        else if(operator.equals("jio"))
	        	plan=request.getParameter("jioplan");
	        else if(operator.equals("V!"))
	        	plan=request.getParameter("viplan");
	        else if(operator.equals("bsnl"))
	        	plan=request.getParameter("bsnlplan");	                
	      // RechargeUser user = new RechargeUser(name, mobno,  operator, state, date, plan);
        RegisterDao rechargedao=new RegisterDao();
       // rechargedao.rechargeinfo(user);
        
	      //  sess.setAttribute("recharge",user);
	        
	        response.sendRedirect("RechargeHistory.jsp");
		}
	else
	{
			PrintWriter pw=response.getWriter();
			pw.println("<html><body><script> alert('I am an alert box!');</script></body></html>");
		}
          
        RequestDispatcher rd=request.getRequestDispatcher("RechargePlan.jsp");  
       rd.forward(request, response);
       
       
       
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
