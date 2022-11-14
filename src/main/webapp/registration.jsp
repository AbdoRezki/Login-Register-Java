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

<!-- registration form -->
	<h2 style="color:#6c757d"> User Registration</h2>
	<form action="RegisterServlet" method="POST" style="width:60%;margin-left:20%;margin-top:1%" >
  		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">First Name</label>
    		<input type="text" class="form-control" name="fname">
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputPassword1" class="form-label">Last Name</label>
    		<input type="text" class="form-control" name="lname">
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">Login Id</label>
    		<input type="text" class="form-control" name="login">
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">Password</label>
    		<input type="password" class="form-control" name="password">
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">Date Of Birth</label>
    		<input type="date" class="form-control" name="dob">
  		</div>
  		<div class="mb-3">
    		<label for="exampleInputEmail1" class="form-label">Mobile No</label>
    		<input type="text" class="form-control" name="mobile">
  		</div>
  		<input type="submit" value="submit" class="btn btn-primary" style="margin-left:45%"><br><br>
	</form>
<%@include file="footer.jsp" %>	
</body>
</html>