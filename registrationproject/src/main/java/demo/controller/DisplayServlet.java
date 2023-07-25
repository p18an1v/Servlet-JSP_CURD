package demo.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.RegisterDao;
import demo.dao.RegisterDaoImpl;
import demo.db.DbConnection;
import demo.model.Register;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out.response.getWriter();
		out.println("<table>");
		
		RegisterDao rdao=new RegisterDaoImpl();
		List<Register> lst=rdao.displayall();
		for(Register r:lst)
		{
			out.println(r.getRegNo())
		}
	/*	type1-using servlet...
	 * pw.print("<table>");
		for(Register r:lst)
		{
	pw.print("<tr><td>"+r.getFname()+"</td><td>"+r.getRno()+"</td><tr>");
		}
		pw.println("</table>")
		*/
		
		
		
		
		/* type2---
		 * HttpSession session=request.getSession(true);
		session.setAttribute("data",lst);
		response.sendRedirect("DisplayAll.jsp");
	*/
	//type3-request dispacher
request.setAttribute("empList",lst);
RequestDispatcher view = request.getRequestDispatcher("list.jsp");
view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
