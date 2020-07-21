<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}
</script>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="Styling/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Registration Page</title>

<style type="text/css">
input[type="submit"]{
cursor: pointer;
}
</style>
</head>
<body>



<div class="containerLong">
	<div align="center">
		<h2>Med Manager Registration</h2>
		<p>If redirected back to this page, Manager ID/email already exists</p>


  <form action="addManager" method ="post">
  
  <div class="row">
  <div class="col">
      <label for="firstName">First Name: </label>
      <input type="text" class="form-control mb-2 mr-sm-2" id="firstName" placeholder="Enter first name" name="firstName" size="30">
    </div>
    <div class="col">
      <label for="lastName">Last Name: </label>
      <input type="text" class="form-control mb-2 mr-sm-2" id="lastName" placeholder="Enter last name" name="lastName" size="30">
    </div>
    </div>
    
    <div class="row">
    <div class="col">
      <label for="email">Manager ID: </label>
      <input type="text" class="form-control mb-2 mr-sm-2" id="managerID" placeholder="Enter ID" name="managerID" size="30">
    </div>
    <div class="col">
      <label for="email">Email: </label>
      <input type="email" class="form-control mb-2 mr-sm-2" id="email" placeholder="Enter email" name="email" size="30">
    </div>
    </div>
    <div class="row">
    <div class="col">
      <label for="password">Password: </label>
      <input type="password" class="form-control mb-2 mr-sm-2" id="password" placeholder="Enter password" name="password" size="30" onkeyup='check();' />
    </div>
    <div class="col">
      <label for="confirm password">Confirm Password: </label>
      <input type="password" class="form-control mb-2 mr-sm-2" id="confirm_password" placeholder="Confirm password" name="confirm_password" size="30" onkeyup='check();' />
      <span id='message'></span>
    </div>
    </div>
    
    
    
    <br><br>
    <button type="submit" class="btn btn-primary mb-2">Register</button><br><br>
    Already registered? <a href="login.jsp">Login here</a>
  </form>
</div>
</div>
</body>
</html>