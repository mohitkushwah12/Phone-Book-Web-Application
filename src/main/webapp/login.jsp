<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
</style>
<title>Login Page</title>
</head>

<body style="background-color: #66e3d9">
	<%@include file="component/navbar.jsp"%>
	<div class="containar-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<form action="login" method="post">
						<h4 class="text-center text-success">Login Form</h4>
						<%
							String invalidMsg = (String) session.getAttribute("invalidMsg");
							if(invalidMsg != null)
							{
						%>
							<p class="text-danger text-center"><%=invalidMsg%></p>
						<%	
							session.removeAttribute("invalidMsg");
							}
						%>
						<%
							String logOut = (String) session.getAttribute("logOut");
							if(logOut != null)
							{
						%>
							<p class="text-success text-center"><%=logOut%></p>
						<%	
							session.removeAttribute("logOut");
							}
						%>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1" name="password">
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>
	<div style="margin-top: 320px">
		<%@include file="component/footer.jsp"%>
	</div>

</body>
</html>