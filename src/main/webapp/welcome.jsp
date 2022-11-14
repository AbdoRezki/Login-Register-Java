
<%
	String login="";
	if(session.getAttribute("login")!=null)
	{
		login=session.getAttribute("login").toString();
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>
	<h1 class="text-center mt-3" style="color:#6c757d;padding-bottom:24.7%">Welcome <%= login %></h1>
<%@include file="footer.jsp" %>
</body>
</html>