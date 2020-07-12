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
<link rel="stylesheet" href="Styling/account.css">
<style>
	
</style>
</head>

<body>
	
<nav role="navigation" class="primary-navigation">
 <ul>
    <li><a href="inventory">Inventory</a></li>
    <li><a href="showReports">Reports</a></li>
    <li><a href="showAccount">Account</a></li>
    <li><a href="logout">Logout</a></li>
</ul>
</nav>

<br>
	<div class ="container" align="center">
		
		<h2>Manager Information</h2><br>
		<br>
		<table >
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