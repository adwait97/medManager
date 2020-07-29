/* This file tests the implementation of six methods from the MMdbDAO class
 * which acts as the data service tier. I have used the Mockito dependency to
 * prevent the unit test methods from disturbing the state or altering the 
 * actual database.
 * 
 * @author Adwait Wadekar
 */
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MMdbDAOtest {
	
	// Using mock objects so testing over server is possible
	// and actual database is not affected
	@InjectMocks private MMdbDAO tDAO;
	
	// initializes mocks and validates usage
	@Rule
    public MockitoRule rule = MockitoJUnit.rule(); 

	// tests connection to dummy database over server
	@Test
	public void testOpenConnection() throws Exception {
		assertFalse(tDAO.con_func());
		tDAO.disconnect();
		System.out.println("DB test connection successfull");
	}
	
	// method to test user validation
	@Test
	public void testUserValidation() throws Exception {
		String email = "jd2@email.com";
		assertTrue(tDAO.validate(email, "jd12345"));
		assertFalse(tDAO.validate(email, "wrong password"));// to demonstrate a successful 'failure' case
	}
	
	// test manager info retrieval
	@Test
	public void testgetManager() throws Exception{
		String email = "jd@email.com";
		assertNotNull(tDAO.getManager(email, "jd1234"));
		assertNull(tDAO.getManager(email, "wrong password")); 
		assertEquals("John", tDAO.getManager(email, "jd1234").getFirstname());
	}
	
	// test searching reports by schedule type of drug
	@Test
	public void testSearchBySchedule() throws Exception{
		assertNotNull(tDAO.searchbySchedule("c-v"));
		assertNull(tDAO.searchbySchedule("baloney"));
	}
	
	// method to test search reports by customer name
	@Test
	public void testSearchByCustomerName() throws Exception{
		assertNotNull(tDAO.searchbyName("frank underwood"));
		assertNull(tDAO.searchbyName("pIzZa"));
	}
	
	// test for the method responsible for displaying current stock inventory 
	@Test
	public void testPopulateInventory() throws Exception{
		assertNotNull(tDAO.populateInventory());
		
	}
}
