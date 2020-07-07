<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Add Medication</title>
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

<center>
<h1>Add to Inventory</h1>
 <FORM action="addMeds" method="post">
 <div class="form-group">
    <TABLE>
         <TR>
	      <TH width="50%">Name</TH>
		  <TD width="50%"><INPUT TYPE="text" Name="Name"></TD>
	  </tr>
      <tr>
	     <TH width="50%">NDC</TH>
		 <TD width="50%"><INPUT TYPE="text" NAME="NDC"></TD>
	  </tr>   
	  <tr>
	     <TH width="50%">Strength</TH>
		 <TD width="50%"><INPUT TYPE="text" NAME="Strength"></TD>
	  </tr>  
	  <tr>
	     <TH width="50%">Schedule</TH>
		 <TD width="50%"><INPUT TYPE="text" NAME="Schedule"></TD>
	  </tr>
	  <tr>
	     <TH width="50%">Quantity</TH>
		 <TD width="50%"><INPUT TYPE="text" NAME="Quantity"></TD>
	  </tr>
	  	  <TR>
	      <TH></TH>
		  <TD width="50%"><INPUT TYPE="submit" VALUE="submit"></TD>
	  </tr>
	  
   </TABLE>
   </div>
</FORM>
</center>
</body>
</html>