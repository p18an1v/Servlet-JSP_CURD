

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studId=request.getParameter("sid");
		String studName=request.getParameter("name");
		String studUname=request.getParameter("uname");
		String studPass=request.getParameter("pass");
		Student stud=new Student(Integer.parseInt(studId), studName, studUname, studPass);
		List<Student> lststud=new ArrayList();
		lststud.add(stud);
		StudentImpl sdao=new StudentImpl();
		int c=sdao.create(lststud);
		PrintWriter out=response.getWriter();
		if(c==1) {
			response.setContentType("text/html");  
			//PrintWriter pw=response.getWriter(); 
			System.out.println("Redirect sent.");
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
