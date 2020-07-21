<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

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
<html>
<head>
	<title>Item Table</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="Styling/style.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	

	
</head>
<nav role="navigation" class="primary-navigation">
 <ul>
    <li><a href="inventory">Inventory</a></li>
    <li><a href="showReports">Reports</a></li>
    <li><a href="showAccount">Account</a></li>
    <li><a href="logout">Logout</a></li>
</ul>
</nav>
<div class="container">
<div align="center">
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="select * from medications";

resultSet = statement.executeQuery(sql);

%>

<h1>Add to Inventory</h1>
 <FORM action="updateMeds" method="post">
 <div class="form-group">
    <TABLE>
      <tr>
	     <TH width="50%">NDC</TH>
		 <TD width="50%">
		 <select name ="ndc">
<%
while(resultSet.next())
{
Long fname = resultSet.getLong("ndc"); 
%>
<option value="<%=fname %>"><%=fname %> (<%=resultSet.getString("name") %>)</option>
<%
}
%>
</select>
		 </TD>
	  </tr>   
	  <tr>
	     <TH width="50%">New Quantity</TH>
		 <TD width="50%"><INPUT TYPE="text" NAME="newQuantity"></TD>
	  </tr>
	  	  <TR>
	      <TH></TH>
		  <TD width="50%"><INPUT TYPE="submit" VALUE="submit"></TD>
	  </tr>
	  
   </TABLE>
   </div>
</FORM>



<% 


} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>
</div>
</html>
