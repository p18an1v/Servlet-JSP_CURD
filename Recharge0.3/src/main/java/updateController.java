

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int accId = Integer.parseInt(request.getParameter("accId"));
		String userName = request.getParameter("userName");
		String phoneNo = request.getParameter("phoneNo");
		int accBal = Integer.parseInt(request.getParameter("accBal"));
		int password = Integer.parseInt(request.getParameter("password"));
		PrintWriter out = response.getWriter();
		dbOp db = new dbOp();
		int i=db.updae_Acc(accId, userName, phoneNo, accBal, password);
		if(i==1)
		{
			System.out.println("succesfull");
			//System.out.println("text");
			response.setContentType("text/html");  
			out.println("<html><body>");
	        out.println("<h1>Your data is saved to the database</h1>");
	        out.println("</body></html>");
	        request.getRequestDispatcher("success.jsp").forward(request, response);
		}
		else {
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
