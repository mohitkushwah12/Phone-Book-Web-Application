package com.dollop.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.app.conn.DbConnection;
import com.dollop.app.dao.UserDao;
import com.dollop.app.entity.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public RegisterServlet() {
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User(name, email, password);
		
		UserDao dao = new UserDao(DbConnection.getConnection());
		boolean f = dao.userRegister(u);
		
		HttpSession session = request.getSession();
		
		if(f)
		{
			session.setAttribute("succmsg", "User Register Successfully...");
			response.sendRedirect("register.jsp");
			//System.out.println("User Register Successfully...");
		}
		else
		{
			session.setAttribute("errormsg", "User Register UnSuccessfully...");
			response.sendRedirect("register.jsp");
			//System.out.println("User Register UnSuccessfully...");
		}
		//doGet(request, response);
	}
}
