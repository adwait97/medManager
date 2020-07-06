import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * MasterController.java
 * This servlet controller class acts as the root controller 
 * for the application, handling all requests from the user.
 * @author Adwait Wadekar
 */

public class MasterController extends HttpServlet {
	
    private static final long serialVersionUID = 1L; // unique identifier for serializable class
    private MMdbDAO mmdbDAO;
    private HttpSession session = null;
    //dependency injection for Model objects is done in respective related methods
 
    public void init() {
        mmdbDAO = new MMdbDAO(); // enable access to database upon initialization
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case "/validate":
            	validateManager(request, response);
            	break;
            case "/logout":
            	logoutManager(request, response);
            	break;
            case "/showAccount":
            	accountInfo(request, response);
            	break;
//            default:          	
//              break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void validateManager(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException, NumberFormatException {
    	PrintWriter out = response.getWriter();
    	int managerid = -99;
    	try {
    		managerid = Integer.parseInt(request.getParameter("mid"));
    	}
    	catch (NumberFormatException e) {
    		System.out.println("NumFrmtEx caught");
    	}
    	String pword = request.getParameter("password");
    	boolean ans = mmdbDAO.validate(managerid, pword);
    	if(ans) {
    		Managers manager = mmdbDAO.getManager(managerid, pword);
    		session = request.getSession();
    		session.setAttribute("currentManagersObject", manager);
    		response.sendRedirect("home.jsp");
    	}
    	else {
    		out.print("<script>alert('--Log-in failed. Try again.--'); window.location='login.jsp' </script>");
    	}
    	out.flush();out.close();
    }
    
    //method to log current user out
    private void logoutManager(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
    	session = request.getSession();
    	session.invalidate();// releasing resources related to current user for authentication
    	response.sendRedirect("login.jsp");
    }
    
    //method to navigate to and display current users account information
    private void accountInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
    	Managers m = (Managers) session.getAttribute("currentManagersObject");
    	
    	request.setAttribute("currentFirstName", m.getFirstname());
    	request.setAttribute("currentLastName", m.getLastname());
    	request.setAttribute("currentEmail", m.getEmail());
    	request.setAttribute("currentManagersID", m.getManagerid());
    	
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/account.jsp"); // getServletContext required
    	rd.forward(request,  response);
    }
    
    
    
    
    
	/*
	 * private void listPeople(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException, ServletException { List<People>
	 * listPeople = mmdbDAO.listAllPeople(); request.setAttribute("listPeople",
	 * listPeople); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("PeopleList.jsp"); dispatcher.forward(request,
	 * response); }
	 * 
	 * // to insert a people private void showNewForm(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("InsertPeopleForm.jsp");
	 * dispatcher.forward(request, response); }
	 * 
	 * // to present an update form to update an existing Student private void
	 * showEditForm(HttpServletRequest request, HttpServletResponse response) throws
	 * SQLException, ServletException, IOException { int id =
	 * Integer.parseInt(request.getParameter("id")); People existingPeople =
	 * mmdbDAO.getPeople(id); RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("EditPeopleForm.jsp");
	 * request.setAttribute("people", existingPeople); dispatcher.forward(request,
	 * response); // The forward() method works at server side, and It sends the
	 * same request and response objects to another servlet.
	 * 
	 * }
	 * 
	 * // after the data of a people are inserted, this method will be called to
	 * insert the new people into the DB // private void
	 * insertPeople(HttpServletRequest request, HttpServletResponse response) throws
	 * SQLException, IOException { String name = request.getParameter("name");
	 * String address = request.getParameter("address"); String status =
	 * request.getParameter("status"); People newPeople = new People(name, address,
	 * status); mmdbDAO.insert(newPeople); response.sendRedirect("list"); // The
	 * sendRedirect() method works at client side and sends a new request }
	 * 
	 * private void updatePeople(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException { int id =
	 * Integer.parseInt(request.getParameter("id"));
	 * 
	 * System.out.println(id); String name = request.getParameter("name"); String
	 * address = request.getParameter("address"); String status =
	 * request.getParameter("status");
	 * 
	 * System.out.println(name);
	 * 
	 * People people = new People(id,name, address, status); mmdbDAO.update(people);
	 * response.sendRedirect("list"); }
	 * 
	 * private void deletePeople(HttpServletRequest request, HttpServletResponse
	 * response) throws SQLException, IOException { int id =
	 * Integer.parseInt(request.getParameter("id")); //People people = new
	 * People(id); mmdbDAO.delete(id); response.sendRedirect("list"); }
	 */

}