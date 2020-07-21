<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
	if(session.getAttribute("currentManagersObject")== null){
	out.print("<script>alert('Please log-in first!'); window.location='login.jsp' </script>");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	body {background-color: powderblue;}
	p    {color: red;}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                  <a class="nav-link" href="home.jsp">Home</a>
            </li>
            <li class="nav-item">
                  <a class="nav-link" href="inventory">Inventory</a>
            </li>
            <li class="nav-item">
                  <a class="nav-link" href="showReports">Report</a>
            </li>
            <li class="nav-item">
                  <a class="nav-link" href="showAccount">Account</a>
            </li>
          </ul>
          <ul align="right" class="navbar-nav"><a class="navbar-brand" href="logout">Logout</a></ul>
    </nav>
    <br><br>
	<div align="center">
		<caption>
			<u>Manager Information</u><br>
		</caption><br>
		<table border=2 class="table">
			<tr>
                <th>First Name: </th>
                <td>
                    <c:out value="${currentFirstName}"/>
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <c:out value="${currentLastName}"/>
                </td>
            </tr>
            <tr>
                <th>Manager's ID: </th>
                <td>
                    <c:out value="${currentManagersID}"/>
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <c:out value="${currentEmail}"/>
                </td>
            </tr>
		</table>
	</div>
	
	
</body>
	
</html>