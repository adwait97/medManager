package models;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacadeTest {

	protected MMdbDAOFacade facade;
	protected MasterControlFacade controlFacade;
	
	public void con_func() throws SQLException{
		facade.con_func();
	};
	public void disconnect()throws SQLException{
		facade.disconnect();
	};
	public boolean validate() throws SQLException{
		return facade.validate();
	};
	public Managers getManager() {
		return facade.getManager();
	};
	public void updateMeds() {
		facade.updateMeds();
	};
	public boolean insertOrder() throws SQLException{
		return facade.insertOrder();
	};
	List<Orders> populateOrders() throws SQLException{
		return facade.populateOrders();
	};
	List<Medications> populateInventory() throws SQLException{
		return facade.populateInventory();
	};
	
	public void init() {
		controlFacade.init();
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 controlFacade.doPost(request, response);
	 }
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		  controlFacade.doGet(request, response);
	  }
	 private void validateManager(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException, NumberFormatException{
		 controlFacade.validateManager(request, response);
	 }
	 private void showHome(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		 controlFacade.showHome(request, response);
	 }
	 private void addOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		 controlFacade.addOrder(request, response);
	 }
	private  void logoutManager(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		controlFacade.logoutManager(request, response);
	}
	 private void accountInfo(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		 controlFacade.accountInfo(request, response);
	 }
	 private void showReports(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		 controlFacade.showReports(request, response);
	 }
	 private void showInventory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		 controlFacade.showInventory(request, response);
	 }
	 private void addManager(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException{
		 controlFacade.addManager(request, response);
	 }
}
