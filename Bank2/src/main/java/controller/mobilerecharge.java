package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.db_operations;
import entity.mobile_recharge;

/**
 * Servlet implementation class mobilerecharge
 */
@WebServlet("/mobilerecharge")
public class mobilerecharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mobilerecharge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String phoneno=request.getParameter("phoneno");
		String isp=request.getParameter("isp");
		float recamt=Float.parseFloat(request.getParameter("recamt"));
		System.out.println("Parameters fetched");
		String accno=request.getParameter("accno");
		System.out.println("object fetched");
		mobile_recharge mr=new mobile_recharge(Integer.parseInt(accno), phoneno, isp, recamt, dtf.format(now));
		db_operations dbo=new db_operations();
		int i=dbo.recharge(mr);
		i=dbo.update_db(mr);
		response.sendRedirect("success.jsp");
	}

}
