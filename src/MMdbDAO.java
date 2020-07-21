import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Managers;
import models.Medications;
import models.Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/MMdbDAO")
public class MMdbDAO {     
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	private Statement statement = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public MMdbDAO() {}

    protected static void con_func() throws SQLException {
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
    }
    
    protected void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
        	con.close();
        }
    }
    
    public boolean validate(String em, String pw) throws SQLException {
    	boolean flag = false;
    	String d_query = "select * from managers where email = ?"; // dynamic SQL query
    	con_func();
		ps = (PreparedStatement) con.prepareStatement(d_query);
		ps.setString(1, em);		  
		rs = ps.executeQuery(); 
		if (rs.next()) { // validate the sign in attempt with result-Set obtained from dynamic SQL query
			String fp = rs.getString("password"); 
			String fem = rs.getString("email");
			if (fp.contentEquals(pw) && fem.contentEquals(em)) {
				flag = true;
			}			
		}
		rs.close();
		ps.close();
    	disconnect();
    	return flag;
    }
    
    public Managers getManager(String email, String password) throws SQLException {
    	Managers result = null;
    	con_func();
    	String d_query = "select m.firstname, m.lastname, m.password, m.email, m.managerid from "
    			+ "managers m where m.email = ? and m.password = ?"; // cross verify w/ id and password
    	ps = (PreparedStatement) con.prepareStatement(d_query);
    	ps.setString(1, email);
    	ps.setString(2, password);
    	rs = ps.executeQuery();
    	while(rs.next()) {
    		String fn = rs.getString("firstname");
    		String ln = rs.getString("lastname");
    		String em = rs.getString("email");
    		String pw = rs.getString("password");
    		int mid = rs.getInt("managerid");
    		result = new Managers(mid, fn, ln, em, pw);
    	}
    	rs.close();
    	ps.close();
    	disconnect();
    	return result;
    }
    
  //method to search reports by NDC
    public List<Orders> searchbySchedule(String s) throws SQLException{
    	con_func();
    	List<Orders> orders_schedule = new ArrayList<Orders>();
    	String sql = "select o.orderid, o.ndc, o.customername, o.date, o.quantity, m.strength, o.email "
    			+ "from orders o, medications m where m.schedule = ? and o.ndc = m.ndc order by date";
    	ps = (PreparedStatement) con.prepareStatement(sql);
    	ps.setString(1, s);
    	rs = ps.executeQuery();
    	while(rs.next()) {
    		int orderid = rs.getInt("orderid");
    		String cn = rs.getString("customername");
    		long ndc = rs.getLong("ndc");
    		java.util.Date d = new java.util.Date(rs.getDate("date").getTime());
    		int quantity = rs.getInt("quantity");
    		String email = rs.getString("email");
    		int strength = rs.getInt("strength");
    		Orders o = new Orders(orderid, cn, ndc, email, quantity, d, strength);
    		orders_schedule.add(o);
    	}
    	return orders_schedule;
    }
  
    //method to search reports by NDC
    public List<Orders> searchbyCode(long code) throws SQLException{
    	con_func();
    	List<Orders> orders_ndc = new ArrayList<Orders>();
    	String sql = "select o.orderid, o.ndc, o.customername, o.date, o.quantity, m.strength, o.email "
    			+ "from orders o, medications m where o.ndc = ? and o.ndc = m.ndc order by date";
    	ps = (PreparedStatement) con.prepareStatement(sql);
    	ps.setLong(1, code);
    	rs = ps.executeQuery();
    	while(rs.next()) {
    		int orderid = rs.getInt("orderid");
    		String cname = rs.getString("customername");
    		long ndc = rs.getLong("ndc");
    		java.util.Date d = new java.util.Date(rs.getDate("date").getTime()); // SQL Date -> util.Date
    		int quantity = rs.getInt("quantity");
    		String email = rs.getString("email");
    		int strength = rs.getInt("strength");
    		Orders o = new Orders(orderid, cname, ndc, email, quantity, d, strength);
    		orders_ndc.add(o);
    	}
    	return orders_ndc;
    }
    
  //method to search reports by NDC
    public List<Orders> searchbyName(String cname) throws SQLException{
    	con_func();
    	List<Orders> orders_cname = new ArrayList<Orders>();
    	String sql = "select o.orderid, o.ndc, o.customername, o.date, o.quantity, m.strength, o.email "
    			+ "from orders o, medications m where o.customername = ? and o.ndc = m.ndc order by date";
    	ps = (PreparedStatement) con.prepareStatement(sql);
    	ps.setString(1, cname);
    	rs = ps.executeQuery();
    	while(rs.next()) {
    		int orderid = rs.getInt("orderid");
    		String cn = rs.getString("customername");
    		long ndc = rs.getLong("ndc");
    		java.util.Date d = new java.util.Date(rs.getDate("date").getTime());
    		int quantity = rs.getInt("quantity");
    		String email = rs.getString("email");
    		int strength = rs.getInt("strength");
    		Orders o = new Orders(orderid, cn, ndc, email, quantity, d, strength);
    		orders_cname.add(o);
    	}
    	return orders_cname;
    }
    
    //method to update medication inventory 
    public void updateMeds(long ndc, int quantity) throws IOException, SQLException{
    	con_func();
    	String q = "update medications m set m.quantity = m.quantity - ? where m.ndc = ?";
    	ps = (PreparedStatement) con.prepareStatement(q);
    	ps.setInt(1, quantity);
    	ps.setLong(2,  ndc);
    	ps.executeUpdate();
    	ps.close();
    	disconnect();
    	System.out.println("--Med quantity updated--");
    }
    
    //entry point to db to add order
    public boolean insertOrder(String cname, long ndc, String email, int quantity) throws SQLException{
    	con_func();
    	String q = "insert into orders(customername, ndc, email, quantity, date) values (?, ?, ?, ?, curdate())";
    	ps = (PreparedStatement) con.prepareStatement(q);
    	ps.setString(1, cname);
    	ps.setLong(2, ndc);
    	ps.setString(3, email);
    	ps.setInt(4, quantity);
    	boolean tupleInserted = ps.executeUpdate() > 0;
    	ps.close();
    	disconnect();
    	System.out.println("\n--New Order Added--");
    	return tupleInserted;
    }
    
    //method to populate inventory page with 
    public List<Medications> populateInventory() throws SQLException{
    	con_func();
    	List<Medications> inv = new ArrayList<Medications>(); // TODO - identify DESIGN PATTERN
    	String sql = "select * from medications";
    	statement = (Statement) con.createStatement();
    	rs = statement.executeQuery(sql);
    	while(rs.next()) {
    		String name = rs.getString("name");
    		long ndc = rs.getLong("ndc");
    		int strength = rs.getInt("strength");
    		int quantity = rs.getInt("quantity");
    		String schedule = rs.getString("schedule");
    		Medications med = new Medications(name, ndc, strength, quantity, schedule);
    		inv.add(med);
    	}
    	rs.close();
    	statement.close();
    	disconnect();
    	return inv;
    }
    
    //TODO - replace all reports by order by schedule
    public List<Orders> populateOrders() throws SQLException{
    	con_func();
    	List<Orders> allOrders = new ArrayList<Orders>();
    	String sql = "select o.orderid, o.ndc, o.customername, o.date, o.quantity, m.strength, o.email "
    			+ "from orders o, medications m where o.ndc = m.ndc order by date";
    	statement = (Statement) con.createStatement();
    	rs = statement.executeQuery(sql);
    	while(rs.next()) {
    		int orderid = rs.getInt("orderid");
    		String cname = rs.getString("customername");
    		long ndc = rs.getLong("ndc");
    		java.util.Date d = new java.util.Date(rs.getDate("date").getTime());
    		int quantity = rs.getInt("quantity");
    		int strength = rs.getInt("strength");
    		String email = rs.getString("email");
    		Orders o = new Orders(orderid, cname, ndc, email, quantity, d, strength);
    		allOrders.add(o);
    	}
    	rs.close();
    	statement.close();
    	disconnect();
    	return allOrders;
    }
    
  //method for adding manager to database of registered managers
    protected static void addManager(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
    	int managerID = Integer.parseInt(request.getParameter("managerID"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        con_func();
        Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM managers where managerid = '"+managerID+"' or email = '"+email+"' ");
       
		if (rs.next()) {
	       response.sendRedirect("registration.jsp");
		}
		else {
			 Managers manager = new Managers(managerID, firstName, lastName, email, password);
		        String insertQuery = "INSERT INTO managers (managerid, firstname, lastname, email, password) VALUES (?, ?, ?, ?, ?);";
			       PreparedStatement ps = con.prepareStatement(insertQuery); 
			       ps.setInt(1, manager.getManagerid());
			       ps.setString(2, manager.getFirstname()); 
			       ps.setString(3, manager.getLastname()); 
			       ps.setString(4, manager.getEmail()); 
			       ps.setString(5, manager.getPassword()); 
			       
			       ps.execute();
			       
			       response.sendRedirect("login.jsp");
		}
			
    }
    
    protected static void addMeds(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String Name = request.getParameter("name");
        long NDC = Long.parseLong(request.getParameter("ndc"));
        int Strength = Integer.parseInt(request.getParameter("strength"));
        int Quantity = Integer.parseInt(request.getParameter("quantity"));
        String Schedule = request.getParameter("schedule");
        
        HttpSession session = request.getSession(false);
        
        con_func();
        Medications med = new Medications(Name, NDC, Strength, Quantity, Schedule);
        String insertQuery = "insert into medications (Name, ndc, Strength, quantity, schedule) values(?, ?, ?, ?, ?)";
        String updateHistory = " insert into updatehistory(date, description) values(CURRENT_TIMESTAMP(), \"Added new medication "+Name+" to inventory.\") ";
        
	       PreparedStatement ps = con.prepareStatement(insertQuery); 
	       ps.setString(1, med.getName()); 
	       ps.setLong(2, med.getNdc()); 
	       ps.setInt(3, med.getStrength()); 
	       ps.setInt(4, med.getQuantity());
	       ps.setString(5, med.getSchedule()); 
	       ps.execute();
	       
	       ps = con.prepareStatement(updateHistory);
	       ps.execute();
	
	       
	       response.sendRedirect("inventory");
    }
    
    protected static void updateMeds(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
    	long NDC = Long.parseLong(request.getParameter("ndc"));
        int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));
        
        HttpSession session = request.getSession(false);
        
        con_func();
        
        String updateQuery = " update medications set quantity = "+newQuantity+" where ndc = "+NDC+" ";
        String updateHistory = " insert into updatehistory(date, description) values(CURRENT_TIMESTAMP(), \"Updated quantity of medication with NDC '"+NDC+"' to "+newQuantity+".\") ";
        
        PreparedStatement ps = con.prepareStatement(updateQuery);
	    ps.execute();
	    ps = con.prepareStatement(updateHistory);
	    ps.execute();
	
	       
	       response.sendRedirect("inventory");
    }
}
