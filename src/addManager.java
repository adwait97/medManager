import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Managers;


public class addManager extends addTemplate {
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	@Override
	public void requestParameters(HttpServletRequest request) {
		firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        email = request.getParameter("email");
        password = request.getParameter("password");
	}

	@Override
	public void executeQuery(HttpServletResponse response) throws SQLException, IOException {
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
