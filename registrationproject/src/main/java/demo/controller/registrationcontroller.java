package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import demo.dao.RegisterDao;
import demo.dao.RegisterDaoImpl;
import demo.model.Register;

/**
 * Servlet implementation class registrationcontroller
 */
@WebServlet("/registrationcontroller")
public class registrationcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regNo=(Integer.parseInt(request.getParameter("regNo")));
		String custName=request.getParameter("custName");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		float accBal=Float.parseFloat(request.getParameter("accBal"));
		//set value to model class
		Register regObj=new Register(regNo, custName, userName, password, accBal);
		ArrayList<Register> lstreg=new ArrayList<Register>();
		lstreg.add(regObj);
		PrintWriter pw=response.getWriter();
		//Dao connection
		RegisterDao rdao=new RegisterDaoImpl();
		int i=rdao.create(lstreg);
		if(i>0) {
			pw.print("<h1>Record Save..go to login page</h1>");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
