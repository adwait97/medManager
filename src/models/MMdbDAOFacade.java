package models;

import java.sql.SQLException;
import java.util.List;

public interface MMdbDAOFacade {

	void con_func() throws SQLException;
	void disconnect()throws SQLException;
	boolean validate() throws SQLException;
	Managers getManager();
	void updateMeds();
	boolean insertOrder() throws SQLException;
	List<Orders> populateOrders() throws SQLException;
	List<Medications> populateInventory() throws SQLException;

}

