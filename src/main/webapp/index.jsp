<%@page import="com.dollop.app.entity.User"%>
<%@page import="com.dollop.app.conn.DbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book App</title>
<%@include file="component/allCss.jsp" %>

<style type="text/css">
.back-img
{
	background: url("img/phone.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}

h1
{
	text-align: center;
}

</style>

</head>
<body>
	<%@include file="component/navbar.jsp" %>
	
	<div class="container-fluid back-img">
		<h1>Hello Welcome to the Phone Book Application</h1> 
	</div>
	<%@include file="component/footer.jsp" %>
</body>
</html>