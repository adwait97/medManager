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
	<link rel="stylesheet" href ="Styling/style.css">
	
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
<div class="containerAdd">
<div align="center">

<h2>Add to Inventory</h2><br>
 <FORM action="addMeds" method="post">
 <div class="form-group">
    <input type="text" class="form-control mb-2 mr-sm-2" id="name" placeholder="Enter Name of Medication" name="name" size="30"><br>
  <input type="text" class="form-control mb-2 mr-sm-2" id="ndc" placeholder="Enter NDC" name="ndc" size="30"><br>
  <input type="text" class="form-control mb-2 mr-sm-2" id="strength" placeholder="Enter Strength" name="strength" size="30"><br>
<input type="text" class="form-control mb-2 mr-sm-2" id="quantity" placeholder="Enter Quantity" name="quantity" size="30"><br>
<input type="text" class="form-control mb-2 mr-sm-2" id="schedule" placeholder="Enter Schedule" name="Schedule" size="30"><br>
   
		  <button type="submit" class="btn btn-primary mb-2">Submit</button>

   </div>
   
</FORM>
</div>
</div>
</body>
</html>
