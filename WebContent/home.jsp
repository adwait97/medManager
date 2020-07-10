<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*" %>
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
<title>Dash-board</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="Styling/home.css">
	<style>
	body {background-color: powderblue;}
	p    {color: red;}
	</style>
</head>

<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="inventory">Inventory</a>
    </li>
    <li class="nav-item">
      	<a class="nav-link" href="showReports">Reports</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="showAccount">Account</a>
    </li>
  </ul>
  <ul align="right" class="navbar-nav"><a class="navbar-brand" href="logout">Logout</a></ul>
</nav><hr><br>

	<div align="center">
	<h1>
       Manager on duty: <u><%out.print(session.getAttribute("m_onduty")); %></u>
    </h1><br><br>
    <h2><b>Fill Order</b></h2>
        <form action="addOrder" method="post">
        <table border="1">    
            <tr>
                <th>Customer Name: </th>
                <td>
                    <input type="text" name="customername" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Medicine: </th>
                <td>
                    <select name="ndc">
                    <%
                    Connection con = null;
                    PreparedStatement ps = null;
                    if (con == null || con.isClosed()) {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                        } catch (ClassNotFoundException e) {
                            throw new SQLException(e);
                        }
                        con = (Connection) DriverManager
              			      .getConnection("jdbc:mysql://127.0.0.1:3306/mmdb?"
              	  			          + "useSSL=false&user=admin&password=admin1234");
                    }
                    String sql = "select m.name, m.ndc from medications m";
                    ps = (PreparedStatement) con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    
                    String name; long code;
                    while(rs.next()){
                    	name = rs.getString("name");
                    	code = rs.getLong("ndc"); // MURKY embedded Java ?
                    %>
                    	<option value="<%=code%>"><%=name%></option>
                    <%
                    }
                    rs.close();
                    ps.close();
                    con.close();
                   	%>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer E-mail: </th>
                <td>
                    <input type="text" name="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Quantity: </th>
                <td>
                    <input type="number" name="quantity" min="1" max="99">
                </td>
            </tr>
            
        </table><br>
        <tr>
            <td align="center">
                <input type="submit" value="Create Order" />
            </td>
        </tr>
        </form>
    </div>


	
</body>
</html>