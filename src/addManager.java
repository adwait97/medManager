import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/addManager")
public class addManager extends HttpServlet {
	/**
	 * @see HttpSevlet#HttpServlet()
	 */
	private static final long serialVersionUID = 1L;
	
	public addManager() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
		MMdbDAO.addManager(request,response);
		
		response.sendRedirect("login.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}