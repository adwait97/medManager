import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Managers;

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
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public MMdbDAO() {}

    protected void con_func() throws SQLException {
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
    
    
    
	/*
	 * public List<People> listAllPeople() throws SQLException { List<People>
	 * listPeople = new ArrayList<People>(); String sql = "SELECT * FROM student";
	 * con_func(); statement = (Statement) con.createStatement(); ResultSet
	 * rs = statement.executeQuery(sql);
	 * 
	 * while (rs.next()) { int id = rs.getInt("id"); String name =
	 * rs.getString("name"); String address = rs.getString("address");
	 * String status = rs.getString("status");
	 * 
	 * People people = new People(id,name, address, status); listPeople.add(people);
	 * } rs.close(); statement.close(); disconnect(); return listPeople; }
	 * 
	 * 
	 * 
	 * public boolean insert(People people) throws SQLException { con_func(); String
	 * sql = "insert into  student(Name, Address, Status) values (?, ?, ?)"; ps =
	 * (PreparedStatement) con.prepareStatement(sql); ps.setString(1, people.name);
	 * ps.setString(2, people.address); ps.setString(3, people.status); //
	 * ps.executeUpdate();
	 * 
	 * boolean rowInserted = ps.executeUpdate() > 0; ps.close(); // disconnect();
	 * return rowInserted; }
	 * 
	 * public boolean delete(int peopleid) throws SQLException { String sql =
	 * "DELETE FROM student WHERE id = ?"; con_func();
	 * 
	 * ps = (PreparedStatement) con.prepareStatement(sql); ps.setInt(1, peopleid);
	 * 
	 * boolean rowDeleted = ps.executeUpdate() > 0; ps.close(); // disconnect();
	 * return rowDeleted; }
	 * 
	 * public boolean update(People people) throws SQLException { String sql =
	 * "update student set Name=?, Address =?,Status = ? where id = ?"; con_func();
	 * 
	 * ps = (PreparedStatement) con.prepareStatement(sql); ps.setString(1,
	 * people.name); ps.setString(2, people.address); ps.setString(3,
	 * people.status); ps.setInt(4, people.id);
	 * 
	 * boolean rowUpdated = ps.executeUpdate() > 0; ps.close(); // disconnect();
	 * return rowUpdated; }
	 * 
	 * public People getPeople(int id) throws SQLException { People people = null;
	 * String sql = "SELECT * FROM student WHERE id = ?";
	 * 
	 * con_func();
	 * 
	 * ps = (PreparedStatement) con.prepareStatement(sql); ps.setInt(1, id);
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * if (rs.next()) { String name = rs.getString("name"); String
	 * address = rs.getString("address"); String status =
	 * rs.getString("status");
	 * 
	 * people = new People(id, name, address, status); }
	 * 
	 * rs.close(); statement.close();
	 * 
	 * return people; }
	 */
}
