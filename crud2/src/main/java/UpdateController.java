

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studId=request.getParameter("sid");
		String studUname=request.getParameter("uname");
		String studPass=request.getParameter("pass");
		System.out.println("Values fetched");
		StudentImpl sdao=new StudentImpl();
		List<Student> lst=sdao.search(Integer.parseInt(studId));
		Student stud=lst.get(0);
		System.out.println("searched object added to list");
		stud.setUserName(studUname);
		stud.setPassword(studPass);
		System.out.println("new values set");
		int i=sdao.update(stud);
		System.out.println("database updated.");
		if(i==1) {
			response.setContentType("text/html");  
			PrintWriter pw=response.getWriter();    
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
