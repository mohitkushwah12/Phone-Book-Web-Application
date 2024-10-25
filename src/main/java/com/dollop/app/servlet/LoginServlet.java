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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao(DbConnection.getConnection());
		User u = dao.userLogin(email, password); 
		
		HttpSession session = request.getSession();
		
		if(u!=null)
		{
			session.setAttribute("user", u);
			//System.out.println("User Is Available"+u);
			response.sendRedirect("index.jsp");
		}
		else
		{
			session.setAttribute("invalidMsg", "Invalid Email & Password");
			//System.out.println("User Is Not Available"+u);
			response.sendRedirect("login.jsp");
		}
		//doGet(request, response);
	}

}
