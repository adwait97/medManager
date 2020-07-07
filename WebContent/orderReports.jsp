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
      <a class="nav-link" href="inventory">Inventory</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="showAccount">Account</a>
    </li>
  </ul>
  <ul align="right" class="navbar-nav"><a class="navbar-brand" href="logout">Logout</a></ul>
</nav><hr><br>

<div align="center">
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