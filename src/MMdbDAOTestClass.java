import static org.junit.jupiter.api.Assertions.*;



import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;

class MMdbDAOTestClass {


	private MMdbDAO test;
	@Test
	void searchByCodeTest() throws Exception {
		assertNotNull(test.searchbyCode(10));
		assertNull(test.searchbyCode(-45));
	}
	
	@Test
	void updateMedsTest() throws Exception{
		long ndc = 10;
		int quantity = 25;
		assertNotNull(test.updateMeds(ndc, quantity));
		assertNull(test.updateMeds(-1234, 10));
		
	}

	@Test
	void populateOrdersTest() throws Exception {
		assertNotNull(test.populateOrders());
	}

	@Test
	void addMedsTest() {
		HttpServletRequest request;
		HttpServletResponse response;
		assertNotNull(MMdbDAO.addMeds(request, response));
		
	}
	@Test
	void addManagerTest() {
		HttpServletRequest request;
		HttpServletResponse response;
		assertNotNull(MMdbDAO.addManager(request, response));
	}

	@Test
	void insertOrderTest() throws Exception {
		String cname="John Smith";
		long ndc=10;
		String email="johnsmith@yahoo.com";
		int quantity = 25;
		assertNotNull(test.insertOrder(cname, ndc, email, quantity));
		assertNull(test.insertOrder(cname, -1234, email, quantity))
	}


}