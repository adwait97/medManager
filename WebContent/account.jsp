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
<link rel="stylesheet" href="Styling/style.css">
<link rel="stylesheet" href="style.css">
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
	<div class ="container">
		<div align="center">
		<h1>Manager Information</h1><br><br>
		<div class="accountInfo">
			 <input class ="form-control" type="text" placeholder ="First Name:  <c:out value="${currentFirstName}"/>" readonly ><br>
             <input class ="form-control" type="text" placeholder ="Last Name:  <c:out value="${currentLastName}"/>" readonly ><br> 
             <input class ="form-control" type="text" placeholder ="Manager ID:  <c:out value="${currentManagersID}"/>" readonly ><br> 
             <input class ="form-control" type="text" placeholder ="Email:  <c:out value="${currentEmail}"/>" readonly ><br> 
             </div>
		</div>
	</div>
	
</body>
	
</html>