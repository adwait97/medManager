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
import models.medication;

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
	
	protected static void addManager(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        con_func();
        Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM managers where email = '"+email+"' ");
       
		if (rs.next()) {
	       response.sendRedirect("registration.jsp");
		}
		else {
			 Managers manager = new Managers(firstName, lastName, email, password);
		        String insertQuery = "INSERT INTO managers (firstName, lastName, email, password) VALUES (?, ?, ?, ?);";
			       PreparedStatement ps = con.prepareStatement(insertQuery); 
			       ps.setString(1, manager.getFirstname()); 
			       ps.setString(2, manager.getLastname()); 
			       ps.setString(3, manager.getEmail()); 
			       ps.setString(4, manager.getPassword()); 
			       
			       ps.execute();
			       
			       response.sendRedirect("login.jsp");
		}
			
    }
	
	protected static void addMeds(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String Name = request.getParameter("Name");
        String NDC = request.getParameter("NDC");
        String Strength = request.getParameter("Strength");
        String Schedule = request.getParameter("Schedule");
        String Quantity = request.getParameter("Quantity");
        
        HttpSession session = request.getSession(false);
        
        con_func();
        medication med = new medication(Name, NDC, Strength, Schedule, Quantity);
        String insertQuery = "insert into medication (Name, NDC, Strength, Schedule, Quantity) values(?, ?, ?,?,?)";
        
	       PreparedStatement ps = con.prepareStatement(insertQuery); 
	       ps.setString(1, med.getName()); 
	       ps.setString(2, med.getNDC()); 
	       ps.setString(3, med.getStrength()); 
	       ps.setString(4, med.getSchedule()); 
	       ps.setString(5, med.getQuantity());
	       ps.execute();
	
	       
	       response.sendRedirect("inventory.jsp");
    }

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
    
    public boolean validate(int mid, String pw) throws SQLException {
    	boolean flag = false;
    	String d_query = "select * from managers where managerid = ?"; // dynamic SQL query
    	con_func();
		ps = (PreparedStatement) con.prepareStatement(d_query);
		ps.setInt(1, mid);		  
		rs = ps.executeQuery(); 
		if (rs.next()) { // validate the sign in attempt with result-Set obtained from dynamic SQL query
			String fp = rs.getString("password"); 
			int fmid = rs.getInt("managerid");
			if (fp.equals(pw) && fmid == mid) {
				flag = true;
			}			
		}
		rs.close();
		ps.close();
    	disconnect();
    	return flag;
    }
    
    public Managers getManager(int managerid, String password) throws SQLException {
    	Managers result = null;
    	con_func();
    	String d_query = "select m.firstname, m.lastname, m.password, m.email, m.managerid from "
    			+ "managers m where m.managerid = ? and m.password = ?"; // cross verify w/ id and password
    	ps = (PreparedStatement) con.prepareStatement(d_query);
    	ps.setInt(1, managerid);
    	ps.setString(2, password);
    	rs = ps.executeQuery();
    	while(rs.next()) {
    		String fn = rs.getString("firstname");
    		String ln = rs.getString("lastname");
    		String em = rs.getString("email");
    		String pw = rs.getString("password");
    		int mid = rs.getInt("managerid");
    		result = new Managers(mid, fn, ln, pw, em);
    	}
    	rs.close();
    	ps.close();
    	disconnect();
    	return result;
    }
}
