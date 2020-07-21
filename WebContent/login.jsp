<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
		body {background-color: powderblue;}
		p    {color: red;}
		h1	 {color: grey}
		h2	 {color:grey}
	</style>
</head>
<body>
    <div class="navbar navbar-expand-sm bg-dark navbar-dark">
        <h1>Med-Manager Login</h1><hr>
    </div><br><br><br>
    <div align="center">
    	<h2><u>Enter Credentials</u></h2>
        
        <form class="form-horizontal" action="validate">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" placeholder="Enter email" name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" placeholder="Enter password" name="password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary mb-2">Submit</button>
      </div>
   <div align="center">
    <p>New manager? Set up your account <a href="registration.jsp">here</a> today!</p>
  </form>
    </div>   
</body>
</html>