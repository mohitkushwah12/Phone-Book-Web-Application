package com.dollop.app.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dollop.app.conn.DbConnection;
import com.dollop.app.dao.ContactDao;
import com.dollop.app.entity.Contact;

@WebServlet("/addcontact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddContactServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int userId = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phono = request.getParameter("phono");
		String about = request.getParameter("about");
		
		
		Contact c = new Contact(name, email, phono, about,userId);
		
		ContactDao dao = new ContactDao(DbConnection.getConnection());
		
		HttpSession session = request.getSession();
		
		boolean f = dao.saveContact(c);
		
		if(f)
		{
			session.setAttribute("succmsg", "Contact Saved Successfully...");
			response.sendRedirect("addContact.jsp");
		}
		else
		{
			session.setAttribute("failedMsg", "Something Went Wrong In Server...");
			response.sendRedirect("addContact.jsp");
		}
	}
}
