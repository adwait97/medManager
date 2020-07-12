<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   	<link rel="stylesheet" type="text/css" href="Styling/login.css">
    <style>
	
	</style>
</head>
<body>
    <div align="center">
        
    
    </div><br><br><br>
    <div class="container">
    <div align="center">
    <h1>Med Manager</h1><br><br>
    	<h2>Member login</h2>
        <form action="validate" method="post">
        <table class="table">
            <tr>
                <th>ManagerID: </th>
                <td>
                    <input type="text" name="mid" size="30"/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="30"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                <br>
                <br>
                    <input type="submit" value="Sign-in" />
                </td>
            </tr>
        </table>
        <p><a href="new">Sign Up</a></p>
        </form>
    </div>
       </div>
</body>
</html>