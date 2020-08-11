package com.learnersacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exception.MyException;
import com.learnersacademy.bo.LearnersAcadBOImpl;

/**
 * Servlet implementation class LoginController
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		
		response.setContentType("text/html");
		if(username.equals("admin")&&password.equals("password")) {
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(30*60);
				response.sendRedirect("Dashboard.jsp");
//				rd=request.getRequestDispatcher("Dashboard.jsp");
//				rd.forward(request, response);
			}
			else {
				out.println("<h3 style='color:red'>Invalid credentials <br/>try again!</h3>");
				rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
				
			}
		
	}

}
