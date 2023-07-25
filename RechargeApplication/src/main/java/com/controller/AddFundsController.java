package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.dbConnection;

/**
 * Servlet implementation class AddFundsController
 */
@WebServlet("/AddFundsController")
public class AddFundsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFundsController() {
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
		
		 String amountStr = request.getParameter("amount");
	        if (amountStr == null || amountStr.isEmpty()) {
	            response.sendRedirect("addfunds.jsp?error=Amount is required");
	            return;
	        }
	        
	        double amount = Double.parseDouble(amountStr);
	        if (amount <= 0) {
	            response.sendRedirect("addfunds.jsp?error=Amount must be positive");
	            return;
	        }
	        
	        HttpSession session = request.getSession();
	        String userId = (String) session.getAttribute("userId");
	        
	        try (Connection con = new dbConnection().getConnection()) {
	            con.setAutoCommit(false);
	            
	            // Update user's balance in the database
	            String sql = "UPDATE users SET balance = balance + ? WHERE user_id = ?";
	            try (PreparedStatement stmt = con.prepareStatement(sql)) {
	                stmt.setDouble(1, amount);
	                stmt.setString(2, userId);
	                int rowsUpdated = stmt.executeUpdate();
	                if (rowsUpdated != 1) {
	                    con.rollback();
	                    throw new SQLException("Failed to update balance");
	                }
	            }
	            
	            // Update session attribute with new balance
	            double balance = (Double) session.getAttribute("balance") + amount;
	            session.setAttribute("balance", balance);
	            
	            con.commit();
	            
	            response.sendRedirect("wallet.jsp");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            response.sendRedirect("addfunds.jsp?error=Failed to add funds");
	        }
	}

}
