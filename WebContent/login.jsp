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
		h1	 {color: white}
	</style>
</head>
<body>
    <div class="navbar navbar-expand-sm bg-dark navbar-dark">
        <h1>Med-Manager Login</h1><hr>
    </div><br><br><br>
    <div align="center">
    	<h2><u>Enter Credentials</u></h2>
        <form action="validate" method="post">
        <table border="1">
            <tr>
                <th>ManagerID: </th>
                <td>
                    <input type="text" name="mid" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="password" name="password" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Sign-in" />
                </td>
            </tr>
        </table><br>
        <p>New manager? Set up your account <a href="new">here</a> today!</p>
        </form>
    </div>   
</body>
</html>