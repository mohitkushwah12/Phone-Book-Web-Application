<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en-us">
<head>
<%@include file="component/allCss.jsp"%>
<style type="text/css">
</style>
<title>Registration Page</title>
</head>

<body style="background-color: #66e3d9">
	<%@include file="component/navbar.jsp"%>
	<div class="containar-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<form action="register" method="post">
						<h4 class="text-center text-success">Registration Form</h4>
						
						<%
							String succMsg = (String) session.getAttribute("succmsg");
							String errorMsg = (String) session.getAttribute("errormsg");
							if(succMsg != null)
							{
						%>
							<p class="text-success text-center"><%=succMsg%></p>
						<%	
							session.removeAttribute("succmsg");
							}
							
							if(errorMsg != null)
							{
						%>
								<p class="text-danger text-center"><%=errorMsg%></p>
						<%		
							session.removeAttribute("errormsg");
							}
						%>
						
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input name="name"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input name="email"
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" >
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input name="password"
									type="password" class="form-control" id="exampleInputPassword1" >
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
	<div style="margin-top: 240px">
		<%@include file="component/footer.jsp"%>
	</div>
</body>
</html>