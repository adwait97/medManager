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

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
	<style>
body {background-color: powderblue;}
h1   {color: blue;}
p    {color: red;}
</style>
	
</head>

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



<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="select * from medications";

resultSet = statement.executeQuery(sql);

%>
<center>
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
</center>



<% 


} catch (Exception e) {
e.printStackTrace();
}
%>
</table>

</html>
