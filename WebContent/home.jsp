<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<%
	Security feature ~ non-registered users/managers may not access this page
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
	<link rel="stylesheet" href="Styling/style.css">
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
	
	<div class="containerLong">
		<div align="center">
			<h1>Med Manager Fill Order Form</h1><br><br>
			<h2>
				Manager on duty: <u>
					<%
						out.print(session.getAttribute("m_onduty"));
					%>
				</u>
			</h2>
			
			<form action="addOrder" method="post">
				<div class ="orderForm">
				<input type="text" class="form-control mb-2 mr-sm-2"
					name="customername" placeholder="Customer Name" size="30" /><br>
				<input type="text" class="form-control mb-2 mr-sm-2" name="email"
					placeholder="Customer Email" size="30" /><br> 
					<select class="form-control" name="ndc">
						<option value="">Medicine<value>

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
				</select> <br>
				<input type="number" class="form-control mb-2 mr-sm-2"
					name="quantity" placeholder="Quantity" min="1" max="99"><br><br>
				</div>

				<button type="submit" class="btn btn-primary mb-2">Create
					Order</button>

			</form>
		</div>
	</div>


</body>
</html>