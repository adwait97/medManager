<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%
	if(session.getAttribute("currentManagersObject")== null){
	out.print("<script>alert('Please log-in first!'); window.location='login.jsp' </script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
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

<div class ="container">
<div align="center">
		<h3><u>-Reports<c:if test="${allOrders==null}"> will appear here</c:if>-</u></h3><br>
		<c:forEach var="o" items="${allOrders}" >

		<h3><u>-Reports-</u></h3><br>
		<table border="1">
		<form action="searchReports" method="post">
			<input type="text" name="customername" placeholder="Search by customer name. . ."><br><br>
			
			<select name="ndc">
					<option value="-99" selected>Search by drug name. . .</option>
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
                    	code = rs.getLong("ndc");
                    %>
                    <option value="<%=code%>"><%=name%></option>
                    <%
                    }
                    rs.close();
                    ps.close();
                    con.close();
                   	%>
           </select><br><br>
           
           <select name="schedule">
					<option value="" selected>Search by available schedule types. . .</option>
                 <%
                    Connection con2 = null;
                    if (con2 == null || con2.isClosed()) {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                        } catch (ClassNotFoundException e) {
                            throw new SQLException(e);
                        }
                        con2 = (Connection) DriverManager
              			      .getConnection("jdbc:mysql://127.0.0.1:3306/mmdb?"
              	  			          + "useSSL=false&user=admin&password=admin1234");
                    }
                    Statement s = (Statement) con2.createStatement();
                    ResultSet rs2 = s.executeQuery("select distinct schedule from medications");                    
                    String schedule;
                    while(rs2.next()){
                    	schedule = rs2.getString("schedule");
                    %>
                    <option value="<%=schedule%>"><%=schedule%></option>
                    <%
                    }
                    rs2.close();
                    con2.close();
                   	%>
           </select><br><br>
           
           <button type="submit">Search</button><br><br><br>
	   </form><br><br><hr><br>
	   </table>

		<c:if test="${orderResults!=null}">
			
			<c:forEach var="o" items="${orderResults}" >
			<table border="2" width="500">
	 			<tr>
                	<th>Customer name: </th>
                	<td>
                    	${o.customername}
                	</td>
            	</tr>
            	<tr>
                	<th>Order ID: </th>
                	<td>
                    	${o.orderid}
                	</td>
            	</tr>
            	<tr>
                	<th>Order date: </th>
                	<td>
                    	${o.getDate()}
                	</td>
            	</tr>
            	<tr>
                	<th>Quantity dispensed: </th>
                	<td>
                    	${o.quantity}
                	</td>
            	</tr>
            	<tr>
                	<th>Drug code: </th>
                	<td>
                    	${o.ndc}
                	</td>
            	</tr>
            	<tr>
                	<th>Drug strength: </th>
                	<td>
                    	${o.strength} Mg
                	</td>
            	</tr>
			</table><br>
			</c:forEach>
	
		</c:if>
		</c:forEach>
		</div>
	</div>
	
	</div>
</body>
</html>