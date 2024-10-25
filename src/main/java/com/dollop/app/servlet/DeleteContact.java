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

@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int cid = Integer.parseInt(request.getParameter("cid"));
		ContactDao dao = new ContactDao(DbConnection.getConnection());
		
		boolean f = dao.deleteContact(cid);
		
		//System.out.println(cid);
		
		HttpSession session = request.getSession();
		if(f)
		{
			session.setAttribute("succmsg", "Contact Delete Successfully...");
			response.sendRedirect("viewContact.jsp");
		}
		else
		{
			session.setAttribute("failedMsg", "Something Wrong On Server...");
			response.sendRedirect("viewContact.jsp");
		}
	}
}
