<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//Security feature ~ non-registered users/managers may not access this page
	if(session.getAttribute("currentManagersObject")== null){
	out.print("<script>alert('Please log-in first!'); window.location='login.jsp' </script>");
	}
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<style>
	body {background-color: powderblue;}
	p    {color: red;}
	</style>
</head>

<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="login.jsp">Logout</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="home.jsp">Home</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="inventory.jsp">Inventory</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="report.jsp">Report</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="showAccount">Account</a>
    </li>
  </ul>
</nav>

<div class="jumbotron">
  <h1>Welcome to Med Manager</h1>
  <p>Manage your pharmacy all in one place!</p>
</div>
	
</body>
</html>