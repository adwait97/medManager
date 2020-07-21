<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="Styling/style.css">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Med Manager Login</h2>
			<form action="validate" method="post">
				<input type="text" placeholder="Enter Email" name="email" size="30" /><br><br>
				<input type="password" placeholder="Enter Password" name="password" size="30" /><br><br>
				<button type="submit" class="btn btn-primary mb-2">Sign-in</button><br><br>
				<p>New manager? Set up your account <a href="registration.jsp">here</a>today!</p>
			</form>
		</div>
	</div>
</body>
</html>