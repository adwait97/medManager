import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.medication;


public class addMeds extends addTemplate {
	String Name;
	String NDC;
	String Strength;
	String Schedule;
	String Quantity;

	@Override
	public void requestParameters(HttpServletRequest request) {
		Name = request.getParameter("Name");
        NDC = request.getParameter("NDC");
        Strength = request.getParameter("Strength");
        Schedule = request.getParameter("Schedule");
        Quantity = request.getParameter("Quantity");
	}

	@Override
	public void dbConnect() throws SQLException {
		// TODO Auto-generated method stub
		super.dbConnect();
	}

	@Override
	public void executeQuery(HttpServletResponse response) throws SQLException, IOException {
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
	
}

