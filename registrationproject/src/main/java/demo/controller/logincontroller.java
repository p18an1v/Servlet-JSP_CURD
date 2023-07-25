package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.RegisterDao;
import demo.dao.RegisterDaoImpl;
import demo.model.Login;

/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login l=new Login();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		//check uname and pass 
		l.setUserName(userName);
		l.setPassword(password);
		RegisterDao rdao=new RegisterDaoImpl();
		boolean b=rdao.ValidateUser(l);
		if(b)
		{
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			pw.println("Invalid username and password");
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
