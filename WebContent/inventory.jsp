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
<link rel="stylesheet" href="Styling/home.css">
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

<div class="container" align="center">
	<h2>Stocked Inventory</h2><br>
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