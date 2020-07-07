import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/addMeds")
public class addMeds extends HttpServlet {
	/**
	 * @see HttpSevlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
	
	public addMeds() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
		MMdbDAO.addMeds(request,response);
		
		response.sendRedirect("inventory.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

