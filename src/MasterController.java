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
import models.Medications;
import models.Orders;

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
            case "/addOrder":
            	addOrder(request, response);
            	break;
            case "/searchReports":
            	searchReports(request, response);
            	break;
            case "/showHome":
            	showHome(request, response);
            	break;
            case "/showReports":
            	showReports(request, response);
            	break;
            case "/new":
            	addManager(request, response);
            	break;
            case "/inventory":
            	showInventory(request, response);
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
    	String em = "";
    	try {
    		em = request.getParameter("email");
    	}
    	catch (NumberFormatException e) {
    		System.out.println("NumFrmtEx caught");
    	}
    	String pw = request.getParameter("password");
    	boolean ans = mmdbDAO.validate(em, pw);
    	if(ans) {
			 Managers manager = mmdbDAO.getManager(em, pw); 
			 session = request.getSession(); 
			 session.setAttribute("currentManagersObject", manager);
			 session.setAttribute("m_onduty", manager.getFirstname());
			 response.sendRedirect("home.jsp");
    	}
    	else {
    		out.print("<script>alert('--Log-in failed. Try again.--'); window.location='login.jsp' </script>");
    	}
    	out.flush();out.close();
    }
    
    private void showHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	response.sendRedirect("home.jsp");
    }
    
    //method to search reports according to user input
    private void searchReports(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
    	String cname = request.getParameter("customername");
    	String schedule = request.getParameter("schedule");
    	long ndc = Long.parseLong((String) request.getParameter("ndc"));
    	if(cname.contentEquals("") && schedule.contentEquals("")) { //search by drug
    		if(ndc != -99) {
    			System.out.println("search based on drugcode ->"+ndc);
    			List<Orders> order_list = mmdbDAO.searchbyCode(ndc);
    			request.setAttribute("orderResults", order_list);
    		}
    	}
    	else if(ndc == -99 && schedule.contentEquals("")) { //search by customer name
    		if(!(cname.contentEquals(""))) {
    			System.out.println("search based on name ->"+cname);
    			List<Orders> order_list = mmdbDAO.searchbyName(cname);
    			request.setAttribute("orderResults", order_list);
    		}
    	}
    	else if(cname.contentEquals("") && ndc == -99) { // search by schedule
    		if(!(schedule.contentEquals(""))) {
    			System.out.println("search based on schedule ->"+schedule);
    			List<Orders> order_list = mmdbDAO.searchbySchedule(schedule);
    			request.setAttribute("orderResults", order_list);
    		}
    	}
    	else {
    		System.out.println("Trying to search by more than one parameter");
    		PrintWriter out = response.getWriter();
    		out.print("<script>alert('Search parameter violated'); window.location='orderReports.jsp' </script>");
    		out.flush();out.close();
    	}
    	request.setAttribute("testVar", "some search has been made");
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/orderReports.jsp");
    	rd.forward(request,  response);
    }
    
    //method to add order to respective table in db
    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
    	String c_name = (String) request.getParameter("customername");
    	long ndc = Long.parseLong((String) request.getParameter("ndc"));
    	int q = Integer.parseInt((String) request.getParameter("quantity"));
    	String em = (String) request.getParameter("email");
    	PrintWriter out = response.getWriter();
    	mmdbDAO.updateMeds(ndc, q);
    	if(mmdbDAO.insertOrder(c_name, ndc, em, q)) {
    		out.print("<script>alert('--Order inserted successfully--'); window.location='home.jsp' </script>");
    	}
    	else
    		out.print("<script>alert('--Order insert failed. Try again.--'); window.location='home.jsp' </script>");
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
    
    private void showReports(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
    	List<Orders> order_list = mmdbDAO.populateOrders();
    	request.setAttribute("allOrders", order_list);
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/orderReports.jsp");
    	rd.forward(request,  response);
    }
    
    private void showInventory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
    	List<Medications> inventory = mmdbDAO.populateInventory();
    	request.setAttribute("populatedInventory", inventory);
    	RequestDispatcher rd = getServletContext().getRequestDispatcher("/inventory.jsp"); // getServletContext required
    	rd.forward(request,  response);
    }
    
    //method for adding manager to database of registered managers
    private void addManager(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException{
    	//response.sendRedirect("newManagerForm.jsp");
    }

}