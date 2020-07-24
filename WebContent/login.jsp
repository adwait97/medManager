<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
		body {background-color: powderblue;}
		p    {color: red;}
		h1	 {color: grey}
		h2	 {color:grey}
	</style>
</head>
<body>
    <div class="container">
<div>
  <h1>Manager Login</h1><br>
  <form action="validate" method="post">
  <div class="form-group">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
  <p>New manager? Set up your account <a href="registration.jsp">here</a> today!</p>
</form>
    

</div>

 

</body>
</html>