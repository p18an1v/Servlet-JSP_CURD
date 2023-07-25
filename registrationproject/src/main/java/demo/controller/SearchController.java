package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.dao.RegisterDao;
import demo.dao.RegisterDaoImpl;
import demo.model.Register;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();

		String strregno=request.getParameter("regNo");
		int regNo=Integer.parseInt(strregno);
		//Dao connection
		RegisterDao rdao=new RegisterDaoImpl();
		List<Register> lsrrec=rdao.retrive(regNo);
		if(lsrrec!=null)
		{
		Register r=lsrrec.get(0);
		pw.println(r.getRegNo()+"&nbsp&nbsp"+r.getCustName()+"&nbsp&nbsp"+r.getAccBal());
		}
		else
		{
			pw.print("No record found: ");
		}
		
		
	//	System.out.println(r.getRegNo()+"\t"+r.getCustName());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
