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
<title>Inventory report</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<style>
	body {background-color: powderblue;}
	p    {color: red;}
	</style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="showHome">Home</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="showAccount">Account</a>
    </li>
  </ul>
  <ul align="right" class="navbar-nav"><a class="navbar-brand" href="logout">Logout</a></ul>
</nav><hr><br>

<div align="center">
	<h1>Stocked Inventory</h1><br>
	<c:forEach var="m" items="${populatedInventory}" >
		<table border=2>
			<tr>
            	<th>Drug Name: </th>
                	<td>
                    	${m.name}
                	</td>
            </tr>
            <tr>
            	<th>National Drug Code (NDC): </th>
                	<td>
                    	${m.ndc}
                	</td>
            </tr>
            <tr>
            	<th>Drug strength: </th>
                	<td>
                    	${m.strength}
                	</td>
            </tr>
             <tr>
            	<th>Drug schedule: </th>
                	<td>
                    	${m.schedule}
                	</td>
            </tr>
            <tr>
            	<th>Quantity in stock: </th>
                	<td>
                    	${m.quantity}
                	</td>
            </tr>
		</table><br>
	</c:forEach>
</div>

</body>
</html>