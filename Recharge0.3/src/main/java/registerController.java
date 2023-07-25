
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int accId =Integer.parseInt(request.getParameter("accId"));
		String userName = request.getParameter("userName");
		String phoneNo = request.getParameter("phoneNo");
		int accBal =Integer.parseInt(request.getParameter("accBal"));
		int password =Integer.parseInt(request.getParameter("password"));
		
		System.out.println("Value reached to the controller and passing towards the database");
		user_account acc = new user_account(accId, userName, phoneNo, accBal, password);
		
		dbOp db = new dbOp();
		System.out.println("..out of service 1");
		
		
		int flag = db.create_Acc(acc);
		System.out.println("..out of service 2");
		System.out.println("value addeding to the database");
		PrintWriter out = response.getWriter();
		if(flag>0)
		{
			//System.out.println("text");
			response.setContentType("text/html");  
			out.println("<html><body>");
	        out.println("<h1>Your data is saved to the database</h1>");
	        out.println("</body></html>");
			// response.sendRedirect("Login.html");
	        request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			System.out.println("saving unsuccesfull");
			 request.getRequestDispatcher("failure.jsp").forward(request, response);
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
