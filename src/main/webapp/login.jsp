<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="Header.jsp" %>
	<h2 style="color:#6c757d">Login</h2>
	<form action="LoginServlet" method="POST" style="width:60%;margin-left:20%;margin-top:1%;padding-bottom:6.55%" >
  		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">User name</label>
    		<input type="text" class="form-control" name="lid">
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputPassword1" class="form-label">Password</label>
    		<input type="password" class="form-control" name="password">
  		</div>
  		<input type="submit" value="submit" class="btn btn-primary" style="margin-left:45%"><br><br>
	</form>
<%@include file="footer.jsp" %>
</body>
</html>