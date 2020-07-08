<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
	//Security feature ~ non-registered users/managers may not access this page
	if(session.getAttribute("currentManagersObject")== null){
	out.print("<script>alert('Please log-in first!'); window.location='login.jsp' </script>");
	}
%>

<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "mmdb";
String userId = "admin";
String password = "admin1234";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medication</title>
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

<center><br>
<h1>Medications in stock</h1>
<a href="addin.jsp" class="btn btn-primary" role="button">Add to Inventory</a>
 <table class="table table-dark table-hover">
<thead class="thead-dark">
<tr>

</tr>
<tr>
<td><b>Medication ID</b></td>
<td><b>Name</b></td>
<td><b>NDC</b></td>
<td><b>Strength</b></td>
<td><b>Schedule</b></td>
<td><b>Quantity</b></td>
</tr>
</thead>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM medication";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>

<td><%=resultSet.getInt("medicationID") %></td>
<td><%=resultSet.getString("Name") %></td>
<td><%=resultSet.getString("NDC") %></td>
<td><%=resultSet.getString("Strength") %></td>
<td><%=resultSet.getString("Schedule") %></td>
<td><%=resultSet.getString("Quantity") %></td>

</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</center>

</body>
</html>