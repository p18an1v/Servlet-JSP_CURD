package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.RegisterDao;
import com.model.Recharge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

/**
 * Servlet implementation class InsertUserServlet
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

	
		String requestMethod = request.getMethod();

		if (requestMethod != "GET") {
		    throw new ServletException("The request method is not GET.");
		}
		
//		int otp=Integer.parseInt(request.getParameter("inputotp"));
//		
//		if(otp==2222)
//		{
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//			Date date=new Date();
//			String dat=formatter.format(date);
//			
//			HttpSession sess=request.getSession();
//			
//			String plan=null;
//			
//			String name=request.getParameter("username");
//			String mobno=request.getParameter("mobno");
//			String operator = request.getParameter("operator");
//	        String state = request.getParameter("state");
//	        
//	        if(operator.equals("airtel"))
//	        	plan=request.getParameter("airtelplan");
//	        else if(operator.equals("jio"))
//	        	plan=request.getParameter("jioplan");
//	        else if(operator.equals("V!"))
//	        	plan=request.getParameter("viplan");
//	        else if(operator.equals("bsnl"))
//	        	plan=request.getParameter("bsnlplan");
//	        
//	        
//	        Recharge r = new Recharge(name,mobno,operator,state,dat,plan);
//	        RegisterDao rechargedao=new RegisterDao();
//	        rechargedao.rechargeinfo(r);
//	        
//	        sess.setAttribute("recharge",r);
//	        
//	        response.sendRedirect("RechargeHistory.jsp");
//		}
//		else
//		{
//			PrintWriter pw=response.getWriter();
//			pw.println("<html><body><script> alert('I am an alert box!');</script></body></html>");
//		}
//           
//        RequestDispatcher rd=request.getRequestDispatcher("RechargePlan.jsp");  
//        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
