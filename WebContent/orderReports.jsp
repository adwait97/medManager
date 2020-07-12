<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	if(session.getAttribute("currentManagersObject")== null){
	out.print("<script>alert('Please log-in first!'); window.location='login.jsp' </script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="Styling/reports.css">
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
		<h3><u>-Reports<c:if test="${allOrders==null}"> will appear here</c:if>-</u></h3><br>
		<c:forEach var="o" items="${allOrders}" >
			<table border="2" width="500">
	 			<tr>
                	<th>Customer name: </th>
                	<td>
                    	${o.customername}
                	</td>
            	</tr>
            	<tr>
                	<th>Order ID: </th>
                	<td>
                    	${o.orderid}
                	</td>
            	</tr>
            	<tr>
                	<th>Order date: </th>
                	<td>
                    	${o.getDate()}
                	</td>
            	</tr>
            	<tr>
                	<th>Quantity dispensed: </th>
                	<td>
                    	${o.quantity}
                	</td>
            	</tr>
            	<tr>
                	<th>Drug code: </th>
                	<td>
                    	${o.ndc}
                	</td>
            	</tr>
            	<tr>
                	<th>Drug strength: </th>
                	<td>
                    	${o.strength} Mg
                	</td>
            	</tr>
			</table><br>
		</c:forEach>
	</div>
	
	
</body>
</html>