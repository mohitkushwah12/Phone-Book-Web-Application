<%@page import="java.util.List"%>
<%@page import="com.dollop.app.conn.DbConnection"%>
<%@page import="com.dollop.app.dao.ContactDao"%>
<%@page import="com.dollop.app.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Contact</title>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
.crd-ho {
	background-color: #239fd9;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%
	if (user == null) {
		session.setAttribute("invalidMsg", "Please Login...");
		response.sendRedirect("login.jsp");
	}
	%>

	<%
	String succMsg = (String) session.getAttribute("succmsg");
	String failedMsg = (String) session.getAttribute("failedMsg");
	if (succMsg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=succMsg%></div>
	<%
	session.removeAttribute("succmsg");
	}
	if (failedMsg != null) {
	%>
	<p class="text-danger text-center"><%=failedMsg%></p>
	<%
	session.removeAttribute("failedMsg");
	}
	%>

	<div class="container">
		<div class="row p-4">
			<%
			if (user != null) {
				ContactDao dao = new ContactDao(DbConnection.getConnection());
				List<Contact> contact = dao.getAllContact(user.getId());

				for (Contact c : contact) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name :
							<%=c.getName()%></h5>
						<p>
							Phono :
							<%=c.getPhono()%></p>
						<p>
							Email :
							<%=c.getEmail()%></p>
						<p>
							About :
							<%=c.getAbout()%></p>
						<div class="text-center">
							<a href="editConatct.jsp?cid=<%=c.getId()%>"
								class="btn btn-success btn-sm text-white">Edit</a> <a
								href="delete?cid=<%=c.getId()%>"
								class="btn btn-danger btn-sm text-white">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>