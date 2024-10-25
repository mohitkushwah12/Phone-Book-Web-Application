<%@page import="com.dollop.app.entity.Contact"%>
<%@page import="com.dollop.app.conn.DbConnection"%>
<%@page import="com.dollop.app.dao.ContactDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
<%@include file="component/allCss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%
	if (user == null) 
	{
		session.setAttribute("invalidMsg", "Please Login...");
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="containar-fluid">
		<div class="row p-3">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
							<h4 class="text-center text-success">Edit Contact</h4>
							<%
							//String succMsg = (String) session.getAttribute("succmsg");
							String failedMsg = (String) session.getAttribute("failedMsg");
							if (failedMsg != null) {
							%>
							<p class="text-danger text-center"><%=failedMsg%></p>
							<%
							session.removeAttribute("failedMsg");
							}
							%>
							<form action="update" method="post">
							<%
								int cid =Integer.parseInt(request.getParameter("cid"));
								ContactDao dao = new ContactDao(DbConnection.getConnection());
								Contact c = dao.getContactById(cid);
							%>
							<input type="hidden" value="<%=cid%>" name="cid">
							
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input value="<%=c.getName()%>"
									type="text" class="form-control" id="exampleInputName"
									aria-describedby="emailHelp" name="name">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input value="<%=c.getEmail()%>"
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Phone Number</label> <input value="<%=c.getPhono() %>"
									type="text" class="form-control" id="exampleInputPassword1"
									name="phono">
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1">About</label>
								<textarea type="text" class="form-control"
									id="exampleInputAbout" name="about"><%=c.getAbout()%></textarea>
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update Contact</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>