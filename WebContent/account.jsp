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
</head>

<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  		<ul class="navbar-nav">
    		<li class="nav-item">
      			<a class="nav-link" href="home.html">Home</a>
    		</li>
    		<li class="nav-item">
      			<a class="nav-link" href="addin.html">Inventory</a>
    		</li>
    		<li class="nav-item">
      			<a class="nav-link" href="report.html">Report</a>
    		</li>
  		</ul>
  		<ul align="right" class="navbar-nav"><a class="navbar-brand" href="logout">Logout</a></ul>
	</nav>
	<br>
	<div align="center">
		<caption>
			<u>Manager Information</u><br>
		</caption><br>
		<table border=2>
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