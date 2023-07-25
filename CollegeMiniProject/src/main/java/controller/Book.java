package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.dbOprations;

/**
 * Servlet implementation class BookOrder
 */
@WebServlet("/BookOrder")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("check");
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		String phoneno=request.getParameter("phoneno");
		String isp=request.getParameter("isp");
		float recamt=Float.parseFloat(request.getParameter("recamt"));
		System.out.println("Parameters fetched");
		String accno=request.getParameter("accno");
		System.out.println("object fetched");
		//Book mr=new Book(Integer.parseInt(bookId), title, author,  publication,isAvailable);
		dbOprations dbo=new dbOprations();
		//int i=dbo.recharge(mr);
		//i=dbo.update_db(mr);
		response.sendRedirect("success.jsp");
	}

}
